package com.remp.work.model.dto;

import java.io.Serializable;

public class Customer implements Serializable{
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String mobile;
	private String post;
	private String addr;
	private String addD;
	private String card;
	private String account;
	private String entryDate;
	private String state;
	private String update;
	
	public Customer() {
	
	}

	public Customer(String id, String pw, String name, String birth, String mobile, String post, String addr,
			String addD, String card, String account, String entryDate, String state, String update) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.mobile = mobile;
		this.post = post;
		this.addr = addr;
		this.addD = addD;
		this.card = card;
		this.account = account;
		this.entryDate = entryDate;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddD() {
		return addD;
	}

	public void setAddD(String addD) {
		this.addD = addD;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
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
		builder.append(birth);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(post);
		builder.append(", ");
		builder.append(addr);
		builder.append(", ");
		builder.append(addD);
		builder.append(", ");
		builder.append(card);
		builder.append(", ");
		builder.append(account);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(state);
		builder.append(", ");
		builder.append(update);
		return builder.toString();
	}
}
