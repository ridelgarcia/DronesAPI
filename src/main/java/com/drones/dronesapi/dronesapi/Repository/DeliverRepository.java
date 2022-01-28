package com.drones.dronesapi.dronesapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.drones.dronesapi.dronesapi.Model.Deliver;
import com.drones.dronesapi.dronesapi.Model.DeliverStatus;
import com.drones.dronesapi.dronesapi.Model.Drone;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
  
	List<Deliver> findByDeliverStatusAndDrone(DeliverStatus status,Drone drone);
}