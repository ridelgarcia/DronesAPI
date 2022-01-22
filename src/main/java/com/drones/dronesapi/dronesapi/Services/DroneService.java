package com.drones.dronesapi.dronesapi.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.model.Drone;
import com.drones.dronesapi.dronesapi.repository.DroneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {

	@Autowired
	private DroneRepository rep;	
	
	public Drone save(Drone _entity) {
		return rep.save(_entity);
	}
	
	public Drone getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<Drone> getAll() {
		return rep.findAll();
	}	
	public void delete(Drone _drone) {
		rep.delete(_drone);
	}
}