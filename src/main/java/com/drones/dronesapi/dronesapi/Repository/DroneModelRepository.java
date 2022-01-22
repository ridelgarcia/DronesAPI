package com.drones.dronesapi.dronesapi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.DroneModel;

public interface DroneModelRepository extends JpaRepository<DroneModel, Long> {
  
}