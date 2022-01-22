package com.drones.dronesapi.dronesapi.Common.DTO.Request.Drone;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.drones.dronesapi.dronesapi.Common.DroneModelDTO;
import com.drones.dronesapi.dronesapi.Common.DroneStateDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDroneRequestDTO {	
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("serialNumber")
	private String serialNumber;
	
	@JsonProperty("model")
	private DroneModelDTO model;
	
	@JsonProperty("weightLimit")
	private int weightLimit;
	
	@JsonProperty("batteryCapacity")
	private int batteryCapacity;
	
	@JsonProperty("state")
	private DroneStateDTO state;

	

	public AddDroneRequestDTO() {
		
	}



	public AddDroneRequestDTO(long id, String serialNumber, DroneModelDTO model, int weightLimit, int batteryCapacity,
			DroneStateDTO state) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
	}



	@Override
	public String toString() {
		return "AddDroneRequestDTO [id=" + id + ", serial_number=" + serialNumber + ", model=" + model
				+ ", weight_limit=" + weightLimit + ", battery_capacity=" + batteryCapacity + ", state=" + state
				+ "]";
	}

	
}
