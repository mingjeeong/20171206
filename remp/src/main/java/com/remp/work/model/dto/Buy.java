package com.remp.work.model.dto;

import java.io.Serializable;

public class Buy implements Serializable {
	private String id;
	private String day;
	private String cuId;
	private String emId;
	private String itId;
	private int price;
	private String start;
	private String end;
	private String post;
	private String addr;
	private String addD;
	private String method;
	private String pay;
	private String card;
	private String trancfer;
	private String account;
	private int total;
	private int stack;
	private int debt;
	private String refund;
	
	/**
	 * 
	 */
	public Buy() {
		super();
	}

	/**
	 * @param id
	 * @param day
	 * @param cuId
	 * @param emId
	 * @param itId
	 * @param price
	 * @param start
	 * @param end
	 * @param post
	 * @param addr
	 * @param addD
	 * @param method
	 * @param pay
	 * @param card
	 * @param trancfer
	 * @param account
	 * @param total
	 * @param stack
	 * @param debt
	 * @param refund
	 */
	public Buy(String id, String day, String cuId, String emId, String itId, int price, String start, String end,
			String post, String addr, String addD, String method, String pay, String card, String trancfer,
			String account, int total, int stack, int debt, String refund) {
		super();
		this.id = id;
		this.day = day;
		this.cuId = cuId;
		this.emId = emId;
		this.itId = itId;
		this.price = price;
		this.start = start;
		this.end = end;
		this.post = post;
		this.addr = addr;
		this.addD = addD;
		this.method = method;
		this.pay = pay;
		this.card = card;
		this.trancfer = trancfer;
		this.account = account;
		this.total = total;
		this.stack = stack;
		this.debt = debt;
		this.refund = refund;
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
	 * @return the itId
	 */
	public String getItId() {
		return itId;
	}

	/**
	 * @param itId the itId to set
	 */
	public void setItId(String itId) {
		this.itId = itId;
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
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
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
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the pay
	 */
	public String getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}

	/**
	 * @return the card
	 */
	public String getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(String card) {
		this.card = card;
	}

	/**
	 * @return the trancfer
	 */
	public String getTrancfer() {
		return trancfer;
	}

	/**
	 * @param trancfer the trancfer to set
	 */
	public void setTrancfer(String trancfer) {
		this.trancfer = trancfer;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the stack
	 */
	public int getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(int stack) {
		this.stack = stack;
	}

	/**
	 * @return the debt
	 */
	public int getDebt() {
		return debt;
	}

	/**
	 * @param debt the debt to set
	 */
	public void setDebt(int debt) {
		this.debt = debt;
	}

	/**
	 * @return the refund
	 */
	public String getRefund() {
		return refund;
	}

	/**
	 * @param refund the refund to set
	 */
	public void setRefund(String refund) {
		this.refund = refund;
	}
	
}
