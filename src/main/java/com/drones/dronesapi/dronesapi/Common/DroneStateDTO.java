package com.drones.dronesapi.dronesapi.Common;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneStateDTO {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("droneState")
	private String droneState;
	
	

	public DroneStateDTO() {
		
	}

	public DroneStateDTO(long _id, String _droneState) {
		
		this.id = _id;
		this.droneState = _droneState;
	}

	@Override
	public String toString() {
		return "DroneStateDTO [id=" + id + ", droneState=" + droneState + "]";
	}
	
	
}
