package com.drones.dronesapi.dronesapi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {
  
}
