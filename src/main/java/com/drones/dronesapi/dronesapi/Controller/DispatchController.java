package com.drones.dronesapi.dronesapi.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drones.dronesapi.dronesapi.Common.GenericResponseDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Request.Deliver.CreateDeliverLoadRequestDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Request.Deliver.LoadDroneRequestDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver.CreateDeliverLoadResponseDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver.DeliverResponseDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver.LoadDroneResponseDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Drone.DroneResponseDTO;
import com.drones.dronesapi.dronesapi.Common.Mappers.MapStructMapper;
import com.drones.dronesapi.dronesapi.Services.DeliverLoadService;
import com.drones.dronesapi.dronesapi.Services.DroneService;
import com.drones.dronesapi.dronesapi.Services.LocationService;
import com.drones.dronesapi.dronesapi.Services.MedicationService;
import com.drones.dronesapi.dronesapi.Services.DeliverItemService;
import com.drones.dronesapi.dronesapi.Services.DeliverStatusService;
import com.drones.dronesapi.dronesapi.Services.DeliverService;
import com.drones.dronesapi.dronesapi.Services.DroneStateService;

import com.drones.dronesapi.dronesapi.Model.Medication;
import com.drones.dronesapi.dronesapi.Model.DeliverItem;
import com.drones.dronesapi.dronesapi.Model.DeliverLoad;
import com.drones.dronesapi.dronesapi.Model.Drone;
import com.drones.dronesapi.dronesapi.Model.DroneState;
import com.drones.dronesapi.dronesapi.Model.Location;
import com.drones.dronesapi.dronesapi.Model.DeliverStatus;
import com.drones.dronesapi.dronesapi.Model.Deliver;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {
	
	@Autowired
	private DeliverLoadService deliverLoadService;
	
	@Autowired
	private MedicationService medicationService;
	
	@Autowired
	private DeliverItemService deliverItemService;
	
	@Autowired
	private DroneService droneService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private DeliverStatusService deliverStatusService;
	
	@Autowired
	private DeliverService deliverService;
	
	@Autowired
	private DroneStateService droneStateService;
	
	@Autowired
	MapStructMapper mapper;
	
	@RequestMapping(value = "/createDeliverLoad",method = RequestMethod.POST)
	public ResponseEntity<?> createDeliverLoad(@RequestBody CreateDeliverLoadRequestDTO request) {
        DeliverLoad load = new DeliverLoad();
        List<DeliverItem> items = new LinkedList<DeliverItem>();
        boolean success = true;
        for(int i = 0 ; i < request.getDeliverItems().size(); ++i) {
        	try {
        		Medication medication = medicationService.getById(request.getDeliverItems().get(i).getMedicationId());
        		DeliverItem item = new DeliverItem(0,medication,request.getDeliverItems().get(i).getAmount());
        		deliverItemService.save(item);
        		items.add(item);
        	}        	
        	catch (Exception e) {        		
        		success = false;
        		for(int j = 0 ;j < items.size(); ++j)
        			deliverItemService.delete(items.get(j));
				break;
        	}
			
        }
        CreateDeliverLoadResponseDTO response = new CreateDeliverLoadResponseDTO(-1);
        if(success) {
        	load.setDeliverItems(items);
        	deliverLoadService.save(load);
        	response.setId(load.getId());
        }
        	
		return new ResponseEntity<CreateDeliverLoadResponseDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadDrone",method = RequestMethod.POST)
	public ResponseEntity<?> loadDrone(@RequestBody LoadDroneRequestDTO request) {
		LoadDroneResponseDTO response = new LoadDroneResponseDTO();
		try {			
			Drone drone = droneService.getById(request.getDroneId());
			Location location = locationService.getById(request.getLocationId());
			DeliverLoad load = deliverLoadService.getById(request.getDeliverLoadId());
			DroneState state;
			if(drone.getState().getId() == 1 && drone.getBatteryCapacity() > 25) {				
				if(drone.getWeightLimit() >= load.calculateWeight()) {
					state = droneStateService.getById(2);
					drone.setState(state);
					droneService.save(drone);
					DeliverStatus deliverStatus = deliverStatusService.getById(1);
					Deliver deliver = new Deliver();
					deliver.setDrone(drone);
					deliver.setDeliverStatus(deliverStatus);
					deliver.setDeliverLoad(load);
					deliver.setLocation(location);
					deliverService.save(deliver);
					state = droneStateService.getById(3);
					drone.setState(state);
					droneService.save(drone);
					response.setId(deliver.getId());
				}
				else {
					GenericResponseDTO res = new GenericResponseDTO(12,"The Load is to heavy for the drone");
					return new ResponseEntity<GenericResponseDTO>(res,HttpStatus.OK);
				}
			}
			else {
				GenericResponseDTO res = new GenericResponseDTO(13,"The drone is not in IDLE state");
				return new ResponseEntity<GenericResponseDTO>(res,HttpStatus.OK);
			}
		}
		catch (Exception e) {
			response.setId(-1);
			return new ResponseEntity<Exception>(e,HttpStatus.OK);
		}
		return new ResponseEntity<LoadDroneResponseDTO>(response,HttpStatus.OK);
	}
	@RequestMapping(value = "/getLoadedItemsForDrone/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getLoadedItemsForDrone(@PathVariable("id") long id) {
		
		ResponseEntity<?> response;
		try {
			Drone drone = droneService.getById(id);
			if(drone.getState().getId() == 3) {
				List<Deliver> delivers = deliverService.getByStatusIdAndDroneId(deliverStatusService.getById(1), drone);
				if(!delivers.isEmpty()) {
					DeliverResponseDTO responseData = mapper.deliverToDeliverResponseDTO(delivers.get(0));
					response = new ResponseEntity<DeliverResponseDTO>(responseData,HttpStatus.OK);
				}
				else {
					GenericResponseDTO res = new GenericResponseDTO(10,"The Drone has not delivers in WAITING_TO_DELIVER Status");
					response = new ResponseEntity<GenericResponseDTO>(res,HttpStatus.OK);
				}
				
			}
			else {
				GenericResponseDTO res = new GenericResponseDTO(11,"The Drone is not loaded");
				response = new ResponseEntity<GenericResponseDTO>(res,HttpStatus.OK);
			}
				
			
		}
		catch (Exception e) {
			response = new ResponseEntity<Exception>(e,HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
