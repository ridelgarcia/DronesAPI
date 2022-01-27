package com.drones.dronesapi.dronesapi.Common.DTO.Request.Deliver;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class LoadDroneRequestDTO {
	
	@JsonProperty("droneId")
	private long droneId;

	@JsonProperty("locationId")
	private long locationId;
	
	@JsonProperty("deliverLoadId")
	private long deliverLoadId;

	public LoadDroneRequestDTO() {
		
	}

	public LoadDroneRequestDTO(long droneId, long locationId, long deliverLoadId) {
		
		this.droneId = droneId;
		this.locationId = locationId;
		this.deliverLoadId = deliverLoadId;
	}

	@Override
	public String toString() {
		return "LoadDroneRequestDTO [droneId=" + droneId + ", locationId=" + locationId + ", deliverLoadId="
				+ deliverLoadId + "]";
	}	
}