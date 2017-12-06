package com.remp.work.model.dto;

import java.io.Serializable;

public class Parts implements Serializable {
	private String id;
	private String model;
	private String search;
	private String itId;
	private String manufacturer;
	private int total;
	private int safety;
	
	/**
	 * 
	 */
	public Parts() {
		super();
	}

	/**
	 * @param id
	 * @param model
	 * @param search
	 * @param itId
	 * @param manufacturer
	 * @param total
	 * @param safety
	 */
	public Parts(String id, String model, String search, String itId, String manufacturer, int total, int safety) {
		super();
		this.id = id;
		this.model = model;
		this.search = search;
		this.itId = itId;
		this.manufacturer = manufacturer;
		this.total = total;
		this.safety = safety;
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
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return the itId
	 */
	public String getItId() {
		return itId;
	}

	/**
	 * @param itId the itId to set
	 */
	public void setItId(String itId) {
		this.itId = itId;
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

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the safety
	 */
	public int getSafety() {
		return safety;
	}

	/**
	 * @param safety the safety to set
	 */
	public void setSafety(int safety) {
		this.safety = safety;
	}
	
}
