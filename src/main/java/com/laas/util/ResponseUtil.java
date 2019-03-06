package com.laas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.laas.model.ResponseModel;

public class ResponseUtil {

	private static final HashMap<String,String> responseCode=new HashMap<>();
	
	public ResponseModel createResponse(String status,String code,String txnNo,String customMessage){
		ResponseModel responseModel=new ResponseModel();
		
		if(code.indexOf('D')>-1){
	        responseModel.setMessages(new ArrayList<String>(Arrays.asList(customMessage)));	        
	    }
	    else{
	        if(!customMessage.equals("")){
	            customMessage='<'+customMessage+'>';
	        }
	        String message = responseCode.get(code);
	        message+=' '+customMessage;
	        responseModel.setMessages(new ArrayList<String>(Arrays.asList(message)));
	    }
		responseModel.setCode(code);
		responseModel.setStatus(status);
		responseModel.setTxnno(txnNo);
		
		return responseModel;
	}
	

		
	static {
		responseCode.put("S00001", "Transaction posted successfully to Finance System for Ledger Posting");
		responseCode.put("E00001", "Request does not contain value for a field that is mandatory");
		responseCode.put("E00002", "Request does not contain value for a field that is mandatory");
		responseCode.put("E00003", "Value specified for a field is not recognized");
		responseCode.put("E00004", "Value specified for a field does not comply with a particular format");
		responseCode.put("E00005", "Length of value of a field less than minimum or more than allowed length");
		
	}

	
		
	
	
}
