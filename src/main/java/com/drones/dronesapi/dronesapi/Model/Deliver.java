package com.drones.dronesapi.dronesapi.Model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	private List<DeliverItem> deliverItems;

	public Deliver() {
		
	}

	public Deliver(long id, Location location, Drone drone, List<DeliverItem> deliverItems) {
		
		this.id = id;
		this.location = location;
		this.drone = drone;
		this.deliverItems = deliverItems;
	}

	@Override
	public String toString() {
		return "Deliver [id=" + id + ", location=" + location + ", drone=" + drone + ", deliverItems=" + deliverItems
				+ "]";
	}

}
