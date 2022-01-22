package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.Medication;
import com.drones.dronesapi.dronesapi.Repository.MedicationRepository;



@Service
public class MedicationService {

	@Autowired
	private MedicationRepository rep;	
	
	public Medication save(Medication _entity) {
		return rep.save(_entity);
	}
	
	public Medication getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<Medication> getAll() {
		return rep.findAll();
	}	
	public void delete(Medication _drone) {
		rep.delete(_drone);
	}
}