package com.drones.dronesapi.dronesapi.Common.DTO.Response.Medication;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class DeleteMedicationResponseDTO {
	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("weight")
	private String weight;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("imagePath")
	private String imagePath;

	public DeleteMedicationResponseDTO() {
		
	}

	public DeleteMedicationResponseDTO(long id, String name, String weight, String code, String imagePath) {
		
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "DeleteMedicationResponseDTO [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code
				+ ", imagePath=" + imagePath + "]";
	}
	
	
	
}
