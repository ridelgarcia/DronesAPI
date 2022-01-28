package com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver;


import com.drones.dronesapi.dronesapi.Common.DeliverStatusDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Drone.DroneResponseDTO;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Location.LocationResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliverResponseDTO {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("location")
	private LocationResponseDTO location;
	
	@JsonProperty("drone")
	private DroneResponseDTO drone;
	
	
	@JsonProperty("deliverLoad")
	private DeliverLoadResponseDTO deliverLoad;


	@JsonProperty("deliverStatus")
	private DeliverStatusDTO deliverStatus;


	public DeliverResponseDTO() {
		
	}


	public DeliverResponseDTO(long id, LocationResponseDTO location, DroneResponseDTO drone,
			DeliverLoadResponseDTO deliverLoad, DeliverStatusDTO deliverStatus) {
		
		this.id = id;
		this.location = location;
		this.drone = drone;
		this.deliverLoad = deliverLoad;
		this.deliverStatus = deliverStatus;
	}


	@Override
	public String toString() {
		return "DeliverResponseDTO [id=" + id + ", location=" + location + ", drone=" + drone + ", deliverLoad="
				+ deliverLoad + ", deliverStatus=" + deliverStatus + "]";
	}	
}
