package com.drones.dronesapi.dronesapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.DeliverStatus;

public interface DeliverStatusRepository extends JpaRepository<DeliverStatus, Long> {
  
}
