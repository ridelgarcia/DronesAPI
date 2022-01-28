package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.DeliverStatus;
import com.drones.dronesapi.dronesapi.Repository.DeliverStatusRepository;



@Service
public class DeliverStatusService {

	@Autowired
	private DeliverStatusRepository rep;	
	
	public DeliverStatus save(DeliverStatus entity) {
		return rep.save(entity);
	}
	
	public DeliverStatus getById(long id) {
		return rep.findById(id).get();
	}
	public List<DeliverStatus> getAll() {
		return rep.findAll();
	}	
	public void delete(DeliverStatus deliverStatus) {
		rep.delete(deliverStatus);
	}
}

