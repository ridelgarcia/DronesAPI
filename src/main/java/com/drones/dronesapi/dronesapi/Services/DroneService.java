package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.Drone;
import com.drones.dronesapi.dronesapi.Repository.DroneRepository;



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