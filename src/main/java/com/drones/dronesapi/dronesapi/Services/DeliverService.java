package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.Deliver;
import com.drones.dronesapi.dronesapi.Repository.DeliverRepository;



@Service
public class DeliverService {

	@Autowired
	private DeliverRepository rep;	
	
	public Deliver save(Deliver entity) {
		return rep.save(entity);
	}
	
	public Deliver getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<Deliver> getAll() {
		return rep.findAll();
	}	
	public void delete(Deliver deliver) {
		rep.delete(deliver);
	}
}
