package com.drones.dronesapi.dronesapi.controller;

import java.util.Arrays;
import java.util.List;
import java.lang.String;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drones.dronesapi.dronesapi.services.DroneService;
import com.drones.dronesapi.dronesapi.model.Drone;

@RestController
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    DroneService droneService;

	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public ResponseEntity<List<Drone>> getAll() {
        List<Drone> drones = droneService.getAll();
		return new ResponseEntity<List<Drone>>(drones,HttpStatus.OK);
	}
    @RequestMapping(value = "/addDrone",method = RequestMethod.POST)
	public ResponseEntity<?> addDrone() {
        List<Drone> drones = droneService.getAll();
		return new ResponseEntity<List<Drone>>(drones,HttpStatus.OK);
	}

}