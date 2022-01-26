package com.drones.dronesapi.dronesapi.Common.DTO.Request.Medication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class ModifyMedicationRequestDTO {
	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("weight")
	private int weight;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("imagePath")
	private String imagePath;
	
	

	public ModifyMedicationRequestDTO() {
		
	}



	public ModifyMedicationRequestDTO(long id, String name, int weight, String code, String imagePath) {
		
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ModifyMedicationRequestDTO [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code
				+ ", imagePath=" + imagePath + "]";
	}	
	
	

}
