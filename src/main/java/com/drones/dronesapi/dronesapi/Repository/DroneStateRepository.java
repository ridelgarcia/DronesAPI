package com.drones.dronesapi.dronesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.model.DroneState;

public interface DroneStateRepository extends JpaRepository<DroneState, Long> {
  
}