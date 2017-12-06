package com.remp.work.model.dto;

import java.io.Serializable;

public class Item implements Serializable {
	private String id;
	private String name;
	private String code;
	private int price;
	private int acquisition;
	private int period;//기간
	private String manufacturer;//제조사
	private String content;//설명
	private String image;
	
	/**
	 * 
	 */
	public Item() {
		super();
	}

	public Item(String id, String name, String code, int price, int acquisition, int period, String manufacturer,
			String content, String image) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.acquisition = acquisition;
		this.period = period;
		this.manufacturer = manufacturer;
		this.content = content;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the acquisition
	 */
	public int getAcquisition() {
		return acquisition;
	}

	/**
	 * @param acquisition the acquisition to set
	 */
	public void setAcquisition(int acquisition) {
		this.acquisition = acquisition;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(code);
		builder.append(", price=");
		builder.append(price);
		builder.append(", acquisition=");
		builder.append(acquisition);
		builder.append(", image=");
		builder.append(image);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
}
