package com.drones.dronesapi.dronesapi.Common.DTO.Response.Deliver;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeliverLoadResponseDTO {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("deliverItems")
	private List<DeliverItemResponseDTO> deliverItems;
	
	

	public DeliverLoadResponseDTO() {
		
	}



	public DeliverLoadResponseDTO(long id, List<DeliverItemResponseDTO> deliverItems) {
		
		this.id = id;
		this.deliverItems = deliverItems;
	}



	@Override
	public String toString() {
		return "DeliverLoadResponseDTO [id=" + id + ", deliverItems=" + deliverItems + "]";
	}
	
	
}
