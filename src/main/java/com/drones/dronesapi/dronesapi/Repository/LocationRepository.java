package com.drones.dronesapi.dronesapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
  
}