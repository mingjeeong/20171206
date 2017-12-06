package com.remp.work.model.dto;

import java.io.Serializable;

public class Authority implements Serializable{
	private String id;
	private String name;
	private String content;
	
	public Authority() {
	
	}

	public Authority(String id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		builder.append(name);
		builder.append(", ");
		builder.append(content);
		return builder.toString();
	}
}
