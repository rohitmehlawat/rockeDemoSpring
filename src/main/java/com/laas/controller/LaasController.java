package com.laas.controller;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.laas.model.RequestModel;
import com.laas.resources.AuthenticateUser;
import com.laas.resources.CheckParameter;
import com.laas.resources.InstrumentParam;
import com.laas.resources.InvokeSPParameter;
import com.laas.resources.LAASChain;
import com.laas.resources.Parameters;
import com.laas.resources.PaymentMode;
import com.laas.resources.ProductCode;
import com.laas.resources.SPName;
import com.laas.resources.SPParameters;
import com.laas.resources.ValidateIP;
import com.laas.resources.ValidateSourceKey;




@RestController
public class LaasController {

	@Autowired
	@Qualifier("validateSchema")
	private LAASChain laasChain;
	
	@Autowired
	private ValidateSourceKey validateSourceKey;
	
	@Autowired
	private ValidateIP validateIP;
	
	@Autowired
	private AuthenticateUser authenticateUser;
	
	@Autowired
	private ProductCode productCode;
	
	@Autowired
	private SPName spName;
	
	@Autowired
	private Parameters parameters;
	
	@Autowired
	private SPParameters spParameters;
	
	@Autowired
	private CheckParameter checkParameter;
	
	@Autowired
	private InstrumentParam instrumentParam;
	
	@Autowired
	private PaymentMode paymentMode;
	
	@Autowired
	private InvokeSPParameter invokeSPParameter;
	
	
	
	@PostMapping(value="/txnpush",consumes="application/json",produces="application/json")
	public void getTransactionPush(@RequestBody String data, @RequestHeader HttpHeaders headers,HttpServletRequest request,HttpServletResponse response ) {
		RequestModel requestModel=new RequestModel();
		requestModel.setResponse(response);
		requestModel.setHeaderData(headers);
		requestModel.setRequest(request);
		requestModel.setRequestData(new JSONObject(data));	
		this.laasChain.processRequest(requestModel);
		
		
	}
	
	@PostConstruct
	private void constructResponsiblilities() {
		this.laasChain.nextChain(validateSourceKey);
		validateSourceKey.nextChain(validateIP);
		validateIP.nextChain(authenticateUser);
		authenticateUser.nextChain(productCode);
		productCode.nextChain(spName);
		spName.nextChain(parameters);
		parameters.nextChain(spParameters);
		spParameters.nextChain(checkParameter);
		checkParameter.nextChain(instrumentParam);
		instrumentParam.nextChain(paymentMode);
		paymentMode.nextChain(invokeSPParameter);
	}

}
