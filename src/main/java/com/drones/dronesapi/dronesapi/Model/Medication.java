package com.drones.dronesapi.dronesapi.Model;
import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Entity
@Table(name = "medication")
@Getter
@Setter
public class Medication {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "imagePath")
	private String imagePath;

	public Medication() {
		
	}

	public Medication(long id, String name, int weight, String code, String imagePath) {
		
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code + ", imagePath="
				+ imagePath + "]";
	}	
}
