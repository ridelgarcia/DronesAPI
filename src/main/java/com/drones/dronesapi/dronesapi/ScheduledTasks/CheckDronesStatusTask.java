package com.drones.dronesapi.dronesapi.ScheduledTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.drones.dronesapi.dronesapi.Controller.DroneController;

@Configuration
@EnableScheduling
public class CheckDronesStatusTask {
	
	@Autowired
	private DroneController controller;
	
	public CheckDronesStatusTask() {
		
	}

	
	@Scheduled(fixedDelay = 30000)
	public void checkDronesState() {		
		controller.checkDronesState();		
	}

}
