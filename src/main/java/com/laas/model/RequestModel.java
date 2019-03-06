package com.laas.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;

public class RequestModel {

	private Map<String,Object> data=new HashMap();
	
	private JSONObject requestData;
	
	private HttpHeaders headerData;
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;

	

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	

	public JSONObject getRequestData() {
		return requestData;
	}

	public void setRequestData(JSONObject requestData) {
		this.requestData = requestData;
	}

	public HttpHeaders getHeaderData() {
		return headerData;
	}

	public void setHeaderData(HttpHeaders headerData) {
		this.headerData = headerData;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
