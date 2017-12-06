package com.remp.work.model.dto;

import java.io.Serializable;

public class Visit implements Serializable{
	private String id;
	private String name;
	private String day;
	private String mobile;
	private String post;
	private String addr;
	private String addD;
	private String code;
	private String cuId;
	private String emId;
	private String complete;
	
	/**
	 * 
	 */
	public Visit() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param day
	 * @param mobile
	 * @param post
	 * @param addr
	 * @param addD
	 * @param code
	 * @param cuId
	 * @param emId
	 * @param complete
	 */
	public Visit(String id, String name, String day, String mobile, String post, String addr, String addD, String code,
			String cuId, String emId, String complete) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.mobile = mobile;
		this.post = post;
		this.addr = addr;
		this.addD = addD;
		this.code = code;
		this.cuId = cuId;
		this.emId = emId;
		this.complete = complete;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the addD
	 */
	public String getAddD() {
		return addD;
	}

	/**
	 * @param addD the addD to set
	 */
	public void setAddD(String addD) {
		this.addD = addD;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

	/**
	 * @return the complete
	 */
	public String getComplete() {
		return complete;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
}
