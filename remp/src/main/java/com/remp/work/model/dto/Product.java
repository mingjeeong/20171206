package com.remp.work.model.dto;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String id;
	private String buyId;
	private String itId;
	private String itName;
	private String firstDay;
	private String inDay;
	private String outDay;
	private String outTarget;
	private String location;
	private String needs;
	private String state;
	private int count;
	private String qr;
	
	public Product() {
	
	}

	
	public Product(String id, String itName, String inDay, String state) {
		super();
		this.id = id;
		this.itName = itName;
		this.inDay = inDay;
		this.state = state;
	}


	public Product(String id, String buyId, String itId, String itName, String firstDay, String inDay, String outDay,
			String outTarget, String location, String needs, String state, int count, String qr) {
		super();
		this.id = id;
		this.buyId = buyId;
		this.itId = itId;
		this.itName = itName;
		this.firstDay = firstDay;
		this.inDay = inDay;
		this.outDay = outDay;
		this.outTarget = outTarget;
		this.location = location;
		this.needs = needs;
		this.state = state;
		this.count = count;
		this.qr = qr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getItId() {
		return itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public String getItName() {
		return itName;
	}

	public void setItName(String itName) {
		this.itName = itName;
	}

	public String getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}

	public String getInDay() {
		return inDay;
	}

	public void setInDay(String inDay) {
		this.inDay = inDay;
	}

	public String getOutDay() {
		return outDay;
	}

	public void setOutDay(String outDay) {
		this.outDay = outDay;
	}

	public String getOutTarget() {
		return outTarget;
	}

	public void setOutTarget(String outTarget) {
		this.outTarget = outTarget;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNeeds() {
		return needs;
	}

	public void setNeeds(String needs) {
		this.needs = needs;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", buyId=");
		builder.append(buyId);
		builder.append(", itId=");
		builder.append(itId);
		builder.append(", itName=");
		builder.append(itName);
		builder.append(", firstDay=");
		builder.append(firstDay);
		builder.append(", inDay=");
		builder.append(inDay);
		builder.append(", outDay=");
		builder.append(outDay);
		builder.append(", outTarget=");
		builder.append(outTarget);
		builder.append(", location=");
		builder.append(location);
		builder.append(", needs=");
		builder.append(needs);
		builder.append(", state=");
		builder.append(state);
		builder.append(", count=");
		builder.append(count);
		builder.append(", qr=");
		builder.append(qr);
		builder.append("]");
		return builder.toString();
	}

	
}