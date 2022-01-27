package com.drones.dronesapi.dronesapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.Deliver;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
  
}