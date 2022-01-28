package com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDeliverLoadResponseDTO {
	
	@JsonProperty("id")
	private long id;

	public CreateDeliverLoadResponseDTO() {
		
	}

	public CreateDeliverLoadResponseDTO(long id) {
		
		this.id = id;
	}

	@Override
	public String toString() {
		return "CreateDeliverLoadResponseDTO [id=" + id + "]";
	}
	
}
