package com.remp.work.model.dto;

import java.io.Serializable;

public class Repair implements Serializable {
	private String id;
	private String name;
	private String prId;
	private String engineerId;
	private String engineerName;
	private String sort;
	private String state;
	private String day;
	private String content;
	private String parts;
	
	/**
	 * 
	 */
	public Repair() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param prId
	 * @param engineerId
	 * @param engineerName
	 * @param sort
	 * @param state
	 * @param day
	 * @param content
	 * @param parts
	 */
	public Repair(String id, String name, String prId, String engineerId, String engineerName, String sort,
			String state, String day, String content, String parts) {
		super();
		this.id = id;
		this.name = name;
		this.prId = prId;
		this.engineerId = engineerId;
		this.engineerName = engineerName;
		this.sort = sort;
		this.state = state;
		this.day = day;
		this.content = content;
		this.parts = parts;
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
	 * @return the prId
	 */
	public String getPrId() {
		return prId;
	}

	/**
	 * @param prId the prId to set
	 */
	public void setPrId(String prId) {
		this.prId = prId;
	}

	/**
	 * @return the engineerId
	 */
	public String getEngineerId() {
		return engineerId;
	}

	/**
	 * @param engineerId the engineerId to set
	 */
	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}

	/**
	 * @return the engineerName
	 */
	public String getEngineerName() {
		return engineerName;
	}

	/**
	 * @param engineerName the engineerName to set
	 */
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the parts
	 */
	public String getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(String parts) {
		this.parts = parts;
	}
	
}
