package com.drones.dronesapi.dronesapi.Common;

import lombok.Setter;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class DroneModelDTO {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("droneModel")
	private String droneModel;
	
	

	public DroneModelDTO() {
		
	}

	public DroneModelDTO(long id, String _droneModel) {
		
		this.id = id;
		this.droneModel = _droneModel;
	}

	@Override
	public String toString() {
		return "DroneModelDTO [id=" + id + ", drone_model=" + droneModel + "]";
	}
	
	
}
