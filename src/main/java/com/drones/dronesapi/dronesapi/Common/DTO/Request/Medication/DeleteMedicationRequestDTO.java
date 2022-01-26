package com.drones.dronesapi.dronesapi.Common.DTO.Request.Medication;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class DeleteMedicationRequestDTO {
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

	public DeleteMedicationRequestDTO() {
		
	}

	public DeleteMedicationRequestDTO(long id, String name, int weight, String code, String imagePath) {
		
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "DeleteMedicationRequestDTO [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code
				+ ", imagePath=" + imagePath + "]";
	}

}
