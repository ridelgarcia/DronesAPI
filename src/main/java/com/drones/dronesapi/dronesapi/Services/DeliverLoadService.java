package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.DeliverLoad;
import com.drones.dronesapi.dronesapi.Repository.DeliverLoadRepository;



@Service
public class DeliverLoadService {

	@Autowired
	private DeliverLoadRepository rep;	
	
	public DeliverLoad save(DeliverLoad entity) {
		return rep.save(entity);
	}
	
	public DeliverLoad getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<DeliverLoad> getAll() {
		return rep.findAll();
	}	
	public void delete(DeliverLoad deliverLoad) {
		rep.delete(deliverLoad);
	}
}