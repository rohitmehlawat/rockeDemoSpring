package com.laas.resources;

import org.springframework.stereotype.Component;

import com.laas.model.RequestModel;

@Component
public class ProductCode implements LAASChain {

	private LAASChain laasChain;
	
	@Override
	public void nextChain(LAASChain laasChain) {
		// TODO Auto-generated method stub
		this.laasChain=laasChain;
	}

	@Override
	public void processRequest(RequestModel request) {
		// TODO Auto-generated method stub
		System.out.println("I am inside ProductCode");
		
		laasChain.processRequest(request);
	}

}
