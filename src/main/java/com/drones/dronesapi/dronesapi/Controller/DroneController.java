package com.drones.dronesapi.dronesapi.Controller;


import java.util.LinkedList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.drones.dronesapi.dronesapi.Services.DroneService;
import com.drones.dronesapi.dronesapi.Model.Drone;
import com.drones.dronesapi.dronesapi.Common.Mappers.MapStructMapper;
import com.drones.dronesapi.dronesapi.Common.DTO.Request.Drone.*;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Drone.*;



@RestController
@RequestMapping("/drone")
public class DroneController {

	@Autowired
    private DroneService droneService;    
	@Autowired
    private MapStructMapper mapper;
    
    
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public ResponseEntity<List<DroneResponseDTO>> getAll() {
        List<Drone> drones = droneService.getAll();
        List<DroneResponseDTO> responseDrones = new LinkedList<DroneResponseDTO>();
        for(int i = 0 ; i < drones.size() ;++i ) {
        	responseDrones.add(mapper.droneToDroneResponseDTO(drones.get(i)));
        }
		return new ResponseEntity<List<DroneResponseDTO>>(responseDrones,HttpStatus.OK);
	}
	@RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
	public ResponseEntity<DroneResponseDTO> getById(@PathVariable("id") long id) {
		
		ResponseEntity<DroneResponseDTO> response;
		try {
			Drone drone = droneService.getById(id);
			response = new ResponseEntity<DroneResponseDTO>(mapper.droneToDroneResponseDTO(drone),HttpStatus.OK);
		}
		catch (Exception e) {
			response = new ResponseEntity<DroneResponseDTO>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
    
	@RequestMapping(value = "/addDrone",method = RequestMethod.PUT)
	public ResponseEntity<?> addDrone(@RequestBody AddDroneRequestDTO request) {
        Drone drone = mapper.addDroneRequestDTOToDrone(request);
        droneService.save(drone);
        AddDroneResponseDTO response = mapper.droneToAddDroneResponseDTO(drone);
		return new ResponseEntity<AddDroneResponseDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteDrone",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDrone(@RequestBody DeleteDroneRequestDTO request) {
        Drone drone = mapper.deleteDroneRequestDTOToDrone(request);
        droneService.delete(drone);
        DeleteDroneResponseDTO response = mapper.droneToDeleteDroneResponseDTO(drone);
		return new ResponseEntity<DeleteDroneResponseDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifyDrone",method = RequestMethod.POST)
	public ResponseEntity<?> modifyDrone(@RequestBody ModifyDroneRequestDTO request) {
        Drone drone = mapper.modifyDroneRequestDTOToDrone(request);
        droneService.save(drone);
        ModifyDroneResponseDTO response = mapper.droneToModifyDroneResponseDTO(drone);
		return new ResponseEntity<ModifyDroneResponseDTO>(response,HttpStatus.OK);
	}

}