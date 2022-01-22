package com.drones.dronesapi.dronesapi.model;

import javax.persistence.*;
import com.drones.dronesapi.dronesapi.model.DroneModel;
import com.drones.dronesapi.dronesapi.model.DroneState;
@Entity
@Table(name = "drone")
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "serial_number")
	private String serial_number;

	@ManyToOne(cascade = CascadeType.ALL)
	private DroneModel model;

	@Column(name = "weight_limit")
	private int weight_limit;

    @Column(name = "battery_capacity")
	private int battery_capacity;

    @ManyToOne(cascade = CascadeType.ALL)
	private DroneState state;


	public Drone() {

	}

	public Drone(String _serial_number,DroneModel _model , int _weight_limit,int _battery_capacity, DroneState _state ) {
		this.serial_number = _serial_number;
        this.model = _model;
        this.weight_limit = _weight_limit;
        this.battery_capacity = _battery_capacity;
        this.state = _state;
	}

	public long getId() {
		return id;
	}

	public String getSerialNumber() {
		return this.serial_number;
	}

	public void setSerialNumber(String _serial_number) {
		this.serial_number = _serial_number;
	}

	public DroneModel getModel() {
		return this.model;
	}

	public void setModel(DroneModel _model) {
		this.model = _model;
	}

	public int getWeightLimit() {
		return this.weight_limit;
	}

	public void setWeightLimit(int _weight_limit) {
		this.weight_limit = _weight_limit;
	}

    public int getBatteryCapacity() {
		return this.battery_capacity;
	}

	public void setBatteryCapacity(int _battery_capacity) {
		this.battery_capacity = _battery_capacity;
	}

    public DroneState getState() {
		return this.state;
	}

	public void setState(DroneState _state) {
		this.state = _state;
	}
	@Override
	public String toString() {
		return "Drone [id=" + id + ", serial_number=" + serial_number + ", model=" + model.getDroneModel() + ", weight_limit=" + weight_limit + ", battery_capacity=" + battery_capacity + ", weight_limit=" + weight_limit+ ", state=" + state.getDroneState() + "]";
	}

}
