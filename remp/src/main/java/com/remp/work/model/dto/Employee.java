package com.remp.work.model.dto;

import java.io.Serializable;

public class Employee implements Serializable{
	private String id;
	private String pw;
	private String name;
	private String mobile;
	private String work;
	private String entryDate;
	private String auId;
	private String state;
	private String update;
	
	public Employee() {

	}

	public Employee(String id, String pw, String name, String mobile, String work, String entryDate, String auId,
			String state, String update) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.work = work;
		this.entryDate = entryDate;
		this.auId = auId;
		this.state = state;
		this.update = update;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getAuId() {
		return auId;
	}

	public void setAuId(String auId) {
		this.auId = auId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(", ");
		builder.append(pw);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(work);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(auId);
		builder.append(", ");
		builder.append(state);
		builder.append(", ");
		builder.append(update);
		return builder.toString();
	}
}
