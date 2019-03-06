package com.laas.model;

import java.util.List;

public class ResponseModel {

	private String status;
	
	private String  code;
	
	private List<String> messages;
	
	private String txnno;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getTxnno() {
		return txnno;
	}

	public void setTxnno(String txnno) {
		this.txnno = txnno;
	}
}
