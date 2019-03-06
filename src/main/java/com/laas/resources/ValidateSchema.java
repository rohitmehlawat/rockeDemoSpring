package com.laas.resources;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.laas.controller.LaasController;
import com.laas.model.RequestModel;

@Component
@Qualifier("validateSchema")
public class ValidateSchema implements LAASChain {

	private LAASChain laasChain;
	
	private static Schema schema;
	
	static {
		JSONObject jsonSchema = new JSONObject(
			      new JSONTokener(LaasController.class.getResourceAsStream("/static/laasSchema.json")));				     
			    schema = SchemaLoader.load(jsonSchema);
	}
	
	@Override
	public void nextChain(LAASChain laasChain) {
		// TODO Auto-generated method stub
		this.laasChain=laasChain;
	}

	@Override
	public void processRequest(RequestModel request) {
		// TODO Auto-generated method stub
		try {
			
				
				    schema.validate(request.getRequestData());
				    
			}
			catch(ValidationException e) {
				System.out.println(e.getAllMessages());
				
			}
		System.out.println("I am inside ValidateSchema");
	
		laasChain.processRequest(request);
	}

}
