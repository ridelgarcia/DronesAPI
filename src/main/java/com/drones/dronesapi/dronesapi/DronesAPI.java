package com.drones.dronesapi.dronesapi;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.drones.dronesapi")
public class DronesAPI {	

	public static void main(String[] args) {
		
		SpringApplication.run(DronesAPI.class, args);		
	}

}
