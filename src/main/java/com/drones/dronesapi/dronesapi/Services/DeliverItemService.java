package com.drones.dronesapi.dronesapi.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.dronesapi.dronesapi.Model.DeliverItem;
import com.drones.dronesapi.dronesapi.Repository.DeliverItemRepository;



@Service
public class DeliverItemService {

	@Autowired
	private DeliverItemRepository rep;	
	
	public DeliverItem save(DeliverItem entity) {
		return rep.save(entity);
	}
	
	public DeliverItem getById(Serializable id) {
		return rep.findById((Long)id).get();
	}
	public List<DeliverItem> getAll() {
		return rep.findAll();
	}	
	public void delete(DeliverItem deliverItem) {
		rep.delete(deliverItem);
	}
}
