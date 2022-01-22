package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.*;

@Entity
@Table(name = "drone_model")
public class DroneModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "drone_model")
	private String drone_model;


	public DroneModel() {

	}

	public DroneModel(String _drone_model ) {
		this.drone_model = _drone_model;
	}

	public long getId() {
		return id;
	}

	public String getDroneModel() {
		return this.drone_model;
	}

	public void setDroneModel(String _drone_model) {
		this.drone_model = _drone_model;
	}

	
	@Override
	public String toString() {
		return "DroneModel [id=" + id + ", drone_model=" + drone_model + "]";
	}

}
