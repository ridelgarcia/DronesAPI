package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.DroneState;
import com.drones.dronesapi.dronesapi.Repository.DroneStateRepository;



@Service
public class DroneStateService {

	@Autowired
	private DroneStateRepository rep;	
	
	public DroneState save(DroneState entity) {
		return rep.save(entity);
	}
	
	public DroneState getById(long id) {
		return rep.findById(id).get();
	}
	public List<DroneState> getAll() {
		return rep.findAll();
	}	
	public void delete(DroneState droneState) {
		rep.delete(droneState);
	}
}
