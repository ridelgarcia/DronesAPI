package com.drones.dronesapi.dronesapi.Common;

import lombok.Setter;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class DeliverItemDTO {

	@JsonProperty("medicationId")
	private long medicationId;
	
	@JsonProperty("amount")
	private int amount;

	public DeliverItemDTO() {
	
	}

	public DeliverItemDTO(long medicationId, int amount) {
		
		this.medicationId = medicationId;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DeliverItemDTO [medicationId=" + medicationId + ", amount=" + amount + "]";
	}
	
	
	
}
