package com.drones.dronesapi.dronesapi.Common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliverStatusDTO {
	
	@JsonProperty("id")
	private long id;

	@JsonProperty("deliverStatus")
	private String deliverStatus;

	public DeliverStatusDTO() {
		
	}

	public DeliverStatusDTO(long id, String deliverStatus) {
		
		this.id = id;
		this.deliverStatus = deliverStatus;
	}

	@Override
	public String toString() {
		return "DeliverStatusDTO [id=" + id + ", deliverStatus=" + deliverStatus + "]";
	}
	
}
