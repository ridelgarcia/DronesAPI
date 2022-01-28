package com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver;

import com.drones.dronesapi.dronesapi.Common.DTO.Response.Medication.MedicationResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliverItemResponseDTO {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("medication")
	private MedicationResponseDTO medication;
	
	@JsonProperty("amount")
	private int amount;

	public DeliverItemResponseDTO() {
		
	}

	public DeliverItemResponseDTO(long id, MedicationResponseDTO medication, int amount) {
		
		this.id = id;
		this.medication = medication;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DeliverItemResponseDTO [id=" + id + ", medication=" + medication + ", amount=" + amount + "]";
	}
	
	
}
