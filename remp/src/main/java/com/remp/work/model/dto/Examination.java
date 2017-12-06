package com.remp.work.model.dto;

import java.io.Serializable;

public class Examination implements Serializable{
	private String id;
	private String start;
	private String end;
	private String name;
	private String code;
	private int probe;
	private int repair;
	private int rental;
	private int total;
	private int product;
	private String content;
	
	public Examination() {

	}

	public Examination(String id, String start, String end, String name, String code, int probe, int repair, int rental,
			int total, int product, String content) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.name = name;
		this.code = code;
		this.probe = probe;
		this.repair = repair;
		this.rental = rental;
		this.total = total;
		this.product = product;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getProbe() {
		return probe;
	}

	public void setProbe(int probe) {
		this.probe = probe;
	}

	public int getRepair() {
		return repair;
	}

	public void setRepair(int repair) {
		this.repair = repair;
	}

	public int getRental() {
		return rental;
	}

	public void setRental(int rental) {
		this.rental = rental;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(", ");
		builder.append(start);
		builder.append(", ");
		builder.append(end);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(code);
		builder.append(", ");
		builder.append(probe);
		builder.append(", ");
		builder.append(repair);
		builder.append(", ");
		builder.append(rental);
		builder.append(", ");
		builder.append(total);
		builder.append(", ");
		builder.append(product);
		builder.append(", ");
		builder.append(content);
		return builder.toString();
	}
}
