package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;
@Entity
@Table(name = "drone_model")
@Getter
@Setter
public class DroneModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "drone_model")
	private String droneModel;


	public DroneModel() {

	}

	public DroneModel(String _droneModel ) {
		this.droneModel = _droneModel;
	}
	
	@Override
	public String toString() {
		return "DroneModel [id=" + id + ", drone_model=" + droneModel + "]";
	}

}
