package com.laas.resources;


import com.laas.model.RequestModel;

public interface LAASChain {

	void nextChain(LAASChain laasChain);
	
	void processRequest(RequestModel request);
}
