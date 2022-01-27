package com.drones.dronesapi.dronesapi.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deliver_load")
@Getter
@Setter
public class DeliverLoad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	private List<DeliverItem> deliverItems;

	public DeliverLoad() {
		
	}

	public DeliverLoad(long id, List<DeliverItem> deliverItems) {
	
		this.id = id;
		this.deliverItems = deliverItems;
	}

	@Override
	public String toString() {
		return "DeliverLoad [id=" + id + ", deliverItems=" + deliverItems + "]";
	}
	
	public int calculateWeight() {
		int weight = 0;
		for(int i = 0 ;i <  deliverItems.size() ; ++i)
			weight += deliverItems.get(i).calculateWeight();
		return weight;
	}
}
