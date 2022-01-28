package com.drones.dronesapi.dronesapi.Common.DTO.Request.Deliver;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import com.drones.dronesapi.dronesapi.Common.DeliverItemDTO;


@Getter
@Setter
public class CreateDeliverLoadRequestDTO {
	
	@JsonProperty("deliverLoadItems")
	private List<DeliverItemDTO> deliverItems;

	public CreateDeliverLoadRequestDTO() {
		
	}

	public CreateDeliverLoadRequestDTO(List<DeliverItemDTO> deliverItems) {
		
		this.deliverItems = deliverItems;
	}

	@Override
	public String toString() {
		return "CreateDeliverLoadRequestDTO [deliverItems=" + deliverItems + "]";
	}
	
	
}
