package com.laas.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.laas.model.RequestModel;
import com.laas.model.ResponseModel;
import com.laas.util.ResponseUtil;

@Component
public class InvokeSPParameter implements LAASChain {

	private LAASChain laasChain;
	@Override
	public void nextChain(LAASChain laasChain) {
		// TODO Auto-generated method stub
		this.laasChain=laasChain;
	}

	@Override
	public void processRequest(RequestModel request) {
		// TODO Auto-generated method stub
		System.out.println("I am inside InvokeSPParameters");
		
		ResponseModel responseObject=new ResponseUtil().createResponse("success", "S00001", request.getRequestData().getString("txnno"), "");
		HttpServletResponse response=request.getResponse();
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    out.print(new Gson().toJson(responseObject));
	    out.flush();
		
	}
	
	

}
