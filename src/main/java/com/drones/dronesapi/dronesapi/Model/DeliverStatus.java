package com.drones.dronesapi.dronesapi.Model;
import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@Entity
@Table(name = "deliver_status")
public class DeliverStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "deliver_status")
	private String deliverStatus;

	public DeliverStatus() {
		
	}

	public DeliverStatus(long id, String deliverStatus) {
		
		this.id = id;
		this.deliverStatus = deliverStatus;
	}

	@Override
	public String toString() {
		return "DeliverStatus [id=" + id + ", deliverStatus=" + deliverStatus + "]";
	}	
}
