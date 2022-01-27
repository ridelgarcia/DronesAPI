package com.drones.dronesapi.dronesapi.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deliver")
@Getter
@Setter
public class Deliver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private Drone drone;
	
	
	@OneToOne
	private DeliverLoad deliverLoad;


	@ManyToOne
	private DeliverStatus deliverStatus;


	public Deliver() {
		
	}


	public Deliver(long id, Location location, Drone drone, DeliverLoad deliverLoad, DeliverStatus deliverStatus) {
		
		this.id = id;
		this.location = location;
		this.drone = drone;
		this.deliverLoad = deliverLoad;
		this.deliverStatus = deliverStatus;
	}
	@Override
	public String toString() {
		return "Deliver [id=" + id + ", location=" + location + ", drone=" + drone + ", deliverLoad=" + deliverLoad
				+ ", deliverStatus=" + deliverStatus + "]";
	}
}
