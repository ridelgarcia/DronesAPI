package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.*;

import org.hibernate.annotations.OptimisticLocking;

import lombok.Setter;
import lombok.Getter;


@Entity
@Table(name = "drone")
@Getter
@Setter
@OptimisticLocking
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;

	@Column(name = "serialNumber")
	private String serialNumber;

	@ManyToOne
	private DroneModel model;

	@Column(name = "weightLimit")
	private int weightLimit;

    @Column(name = "batteryCapacity")
	private int batteryCapacity;

    @ManyToOne
	private DroneState state;    
    
	
	public Drone() {
		
	}
	public Drone(long id, String serialNumber, DroneModel model, int weightLimit, int batteryCapacity,
			DroneState state) {
		
		this.id = id;
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
	}





	@Override
	public String toString() {
		return "Drone [id=" + id + ", serialNumber=" + serialNumber + ", model=" + model + ", weightLimit=" + weightLimit + ", batteryCapacity=" + batteryCapacity + ", weightLimit=" + weightLimit+ ", state=" + state + "]";
	}

}
