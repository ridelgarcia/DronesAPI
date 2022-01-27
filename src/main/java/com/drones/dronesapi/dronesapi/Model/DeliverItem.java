package com.drones.dronesapi.dronesapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deliver_item")
@Getter
@Setter
public class DeliverItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Medication medication;
	
	@Column(name = "amount")
	private int amount;

	public DeliverItem() {
		
	}

	public DeliverItem(long id, Medication medication, int amount) {
		
		this.id = id;
		this.medication = medication;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DeliverItem [id=" + id + ", medication=" + medication + ", amount=" + amount + "]";
	}
	
	public int calculateWeight() {
		return medication.getWeight()*amount;
	}
}
