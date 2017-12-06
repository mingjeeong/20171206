package com.remp.work.model.dto;

import java.io.Serializable;

public class Fix implements Serializable {
	private String id;
	private String day;
	private String cuId;
	private String cuName;
	private String prId;
	private String state;
	private String engineerId;
	private String engineerName;
	private String sort;
	private String content;
	
	/**
	 * 
	 */
	public Fix() {
		super();
	}
	
	/**
	 * @param id
	 * @param day
	 * @param cuId
	 * @param cuName
	 * @param prId
	 * @param state
	 * @param engineerId
	 * @param engineerName
	 * @param sort
	 * @param content
	 */
	public Fix(String id, String day, String cuId, String cuName, String prId, String state, String engineerId,
			String engineerName, String sort, String content) {
		super();
		this.id = id;
		this.day = day;
		this.cuId = cuId;
		this.cuName = cuName;
		this.prId = prId;
		this.state = state;
		this.engineerId = engineerId;
		this.engineerName = engineerName;
		this.sort = sort;
		this.content = content;
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
	 * @return the cuId
	 */
	public String getCuId() {
		return cuId;
	}

	/**
	 * @param cuId the cuId to set
	 */
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	/**
	 * @return the cuName
	 */
	public String getCuName() {
		return cuName;
	}

	/**
	 * @param cuName the cuName to set
	 */
	public void setCuName(String cuName) {
		this.cuName = cuName;
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
	
}
