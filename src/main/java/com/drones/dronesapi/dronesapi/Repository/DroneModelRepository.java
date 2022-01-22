package com.drones.dronesapi.dronesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.model.DroneModel;

public interface DroneModelRepository extends JpaRepository<DroneModel, Long> {
  
}