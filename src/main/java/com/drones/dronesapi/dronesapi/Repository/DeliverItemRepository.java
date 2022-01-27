package com.drones.dronesapi.dronesapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.dronesapi.dronesapi.Model.DeliverItem;

public interface DeliverItemRepository extends JpaRepository<DeliverItem, Long> {
  
}
