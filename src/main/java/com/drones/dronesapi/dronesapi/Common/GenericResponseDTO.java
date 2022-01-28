package com.drones.dronesapi.dronesapi.Common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponseDTO {

	@JsonProperty("responseCode")
	private int responseCode;
	
	@JsonProperty("responseMessage")
	private String responseMessage;
	
	

	public GenericResponseDTO() {
		
	}



	public GenericResponseDTO(int responseCode, String responseMessage) {
		
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}



	@Override
	public String toString() {
		return "GenericResponseDTO [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
	
	
}
