package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.Location;
import com.drones.dronesapi.dronesapi.Repository.LocationRepository;



@Service
public class LocationService {

	@Autowired
	private LocationRepository rep;	
	
	public Location save(Location entity) {
		return rep.save(entity);
	}
	
	public Location getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<Location> getAll() {
		return rep.findAll();
	}	
	public void delete(Location location) {
		rep.delete(location);
	}
}

