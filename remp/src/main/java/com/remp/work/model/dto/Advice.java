package com.remp.work.model.dto;

import java.io.Serializable;

public class Advice implements Serializable {
	private String id;
	private String sort;
	private String sortName;
	private String content;
	private String buyId;
	private String emId;
	
	/**
	 * 
	 */
	public Advice() {
		super();
	}
	
	/**
	 * @param id
	 * @param sort
	 * @param sortName
	 * @param content
	 * @param buyId
	 * @param emId
	 */
	public Advice(String id, String sort, String sortName, String content, String buyId, String emId) {
		super();
		this.id = id;
		this.sort = sort;
		this.sortName = sortName;
		this.content = content;
		this.buyId = buyId;
		this.emId = emId;
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
	 * @return the sortName
	 */
	public String getSortName() {
		return sortName;
	}

	/**
	 * @param sortName the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
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
	 * @return the buyId
	 */
	public String getBuyId() {
		return buyId;
	}

	/**
	 * @param buyId the buyId to set
	 */
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	/**
	 * @return the emId
	 */
	public String getEmId() {
		return emId;
	}

	/**
	 * @param emId the emId to set
	 */
	public void setEmId(String emId) {
		this.emId = emId;
	}
	
}
