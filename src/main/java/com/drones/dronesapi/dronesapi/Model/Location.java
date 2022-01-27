package com.drones.dronesapi.dronesapi.Model;
import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "locationcoordinates")
	private String locationcoordinates;

	public Location() {
		
	}

	public Location(long id, String locationcoordinates) {
		
		this.id = id;
		this.locationcoordinates = locationcoordinates;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", locationcoordinates=" + locationcoordinates + "]";
	}
	
	
}
