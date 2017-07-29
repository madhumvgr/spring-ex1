package com.cognisoft.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cognisoft.constants.EmpRestURIConstants;
import com.cognisoft.login.model.Member;
import com.cognisoft.login.service.LoginService;
import com.cognisoft.model.Response;
import com.cognisoft.model.Status;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginservice;

	
	@RequestMapping(value = EmpRestURIConstants.MEMBER_INSERT, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response memberInsert(@RequestBody Member mem) {
		logger.info("MEMBER INSERT STARTED");
		Response res=new Response();
		try
		{
			loginservice.add(mem);
			setSuccessResponse(res,"Insertion Successfull");
			res.setMember(mem);
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res);
			e.printStackTrace();
		}
		logger.info("MEMBER INSERT COMPLETED");
		return res;
	}
	
	@RequestMapping(value = EmpRestURIConstants.MEMBER_VERIFY_LOGIN, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response verifyLogin(@RequestBody Member mem) {
		logger.info("VERIFY LOGIN");
		Response res=new Response();
		try
		{
			if(loginservice.verifyLogin(mem))
			setSuccessResponse(res,"Login Successfull");
			else
			setSuccessResponse(res,"Login Un Successfull");	
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res);
		}
		logger.info("VERIFY LOGIN COMPLETED");
		return res;
	}
		
	public Response setSuccessResponse(Response res,String message)
	{
		Status s=new Status();
		s.setCode(200);
		s.setMessage(message);
		s.setSuccess(true);
		res.setStatus(s);
		return res;
	}
	
	public Response setErrorResponse(Response res)
	{
		Status s=new Status();
		s.setMessage("Error Occurred");
		s.setSuccess(false);
		res.setStatus(s);
		return res;
	}
}
