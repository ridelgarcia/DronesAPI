package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@Entity
@Table(name = "drone_state")
public class DroneState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "droneState")
	private String droneState;


	public DroneState() {

	}

	public DroneState(String _droneState ) {
		this.droneState = _droneState;
	}

	
	
	@Override
	public String toString() {
		return "DroneState [id=" + id + ", drone_state=" + droneState + "]";
	}

}
