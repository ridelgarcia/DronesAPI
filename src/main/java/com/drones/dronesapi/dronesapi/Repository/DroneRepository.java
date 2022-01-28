package com.drones.dronesapi.dronesapi.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {
  
	List<Drone> findByState_id(long id);
}
