package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.*;

@Entity
@Table(name = "drone_state")
public class DroneState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "drone_state")
	private String drone_state;


	public DroneState() {

	}

	public DroneState(String _drone_state ) {
		this.drone_state = _drone_state;
	}

	public long getId() {
		return id;
	}

	public String getDroneState() {
		return this.drone_state;
	}

	public void setDroneState(String _drone_state) {
		this.drone_state = _drone_state;
	}

	
	@Override
	public String toString() {
		return "DroneState [id=" + id + ", drone_state=" + drone_state + "]";
	}

}
