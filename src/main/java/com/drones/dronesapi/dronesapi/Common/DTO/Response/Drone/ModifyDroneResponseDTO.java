package com.drones.dronesapi.dronesapi.Common.DTO.Response.Drone;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.drones.dronesapi.dronesapi.Common.DroneModelDTO;
import com.drones.dronesapi.dronesapi.Common.DroneStateDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyDroneResponseDTO {
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

	public ModifyDroneResponseDTO() {
		
	}

	public ModifyDroneResponseDTO(long id, String serialNumber, DroneModelDTO model, int weightLimit,
			int batteryCapacity, DroneStateDTO state) {
		
		this.id = id;
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
	}

	@Override
	public String toString() {
		return "ModifyDroneResponseDTO [id=" + id + ", serialNumber=" + serialNumber + ", model=" + model
				+ ", weightLimit=" + weightLimit + ", batteryCapacity=" + batteryCapacity + ", state=" + state + "]";
	}
	
	
}
