package com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDroneResponseDTO {
	
	@JsonProperty("id")
	private long id;

	public LoadDroneResponseDTO() {
		
	}

	public LoadDroneResponseDTO(long id) {
		
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoadDroneResponseDTO [id=" + id + "]";
	}	
	
}
