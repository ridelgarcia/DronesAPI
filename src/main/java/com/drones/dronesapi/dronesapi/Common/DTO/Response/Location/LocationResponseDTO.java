package com.drones.dronesapi.dronesapi.Common.DTO.Response.Location;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponseDTO {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("location_coordinates")
	private String locationcoordinates;

	public LocationResponseDTO() {
		
	}

	public LocationResponseDTO(long id, String locationcoordinates) {
		
		this.id = id;
		this.locationcoordinates = locationcoordinates;
	}

	@Override
	public String toString() {
		return "LocationResponseDTO [id=" + id + ", locationcoordinates=" + locationcoordinates + "]";
	}
	
	
}
