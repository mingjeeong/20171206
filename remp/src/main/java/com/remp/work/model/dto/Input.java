package com.remp.work.model.dto;

import java.io.Serializable;

public class Input implements Serializable {
	private String id;
	private String name;
	private int count;
	private String state;
	private String day;
	private String delivery;
	private String manufacturer;
	
	/**
	 * 
	 */
	public Input() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param count
	 * @param state
	 * @param day
	 * @param delivery
	 * @param manufacturer
	 */
	public Input(String id, String name, int count, String state, String day, String delivery, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.state = state;
		this.day = day;
		this.delivery = delivery;
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the delivery
	 */
	public String getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
