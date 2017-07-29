package com.cognisoft.employee.controller;

import java.util.List;

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
import com.cognisoft.employee.model.Employee;
import com.cognisoft.employee.model.TimeSheet;
import com.cognisoft.employee.service.EmployeeService;
import com.cognisoft.model.Response;
import com.cognisoft.model.Status;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService empservice;

	@RequestMapping(value = EmpRestURIConstants.EMPLOYEE_LIST, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response getAllEmployee() {
		logger.info("GET ALL EMPLOYEE");
		Response res=new Response();
		try
		{
			List<Employee> empList= empservice.getAllEmployeeDetails();
			res.setEmployeeList(empList);
			setSuccessResponse(res,"Retrieve All Employee Details.");
			
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
		}
		logger.info("GET ALL EMPLOYEE COMPLETED");
		return res;
	}
	
	
	@RequestMapping(value = EmpRestURIConstants.GET_EMPLOYEE, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response getEmployee(@RequestBody Employee emp) {
		logger.info("GET EMPLOYEE");
		Response res=new Response();
		try
		{
			List<Employee> empList= empservice.getEmployeeDetails(emp);
			res.setEmployee(empList.get(0));
			setSuccessResponse(res,"Retrieve Employee Details.");
			
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
		}
		logger.info("GET EMPLOYEE COMPLETED");
		return res;
	}
	
	@RequestMapping(value = EmpRestURIConstants.EMPLOYEE_INSERT, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response employeeInsert(@RequestBody Employee emp) {
		logger.info("EMPLOYEE INSERT STARTED");
		Response res=new Response();
		try
		{
			empservice.add(emp);
			setSuccessResponse(res,"Insertion Successfull");
			res.setEmployee(emp);
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
			e.printStackTrace();
		}
		logger.info("EMPLOYEE INSERT COMPLETED");
		return res;
	}
	
	@RequestMapping(value = EmpRestURIConstants.EMPLOYEE_UPDATE, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response employeeUpdate(@RequestBody Employee emp) {
		logger.info("EMPLOYEE UPDATE STARTED");
		Response res=new Response();
		try
		{
			empservice.update(emp);
			setSuccessResponse(res,"Update Successfull");
			res.setEmployee(emp);
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
			e.printStackTrace();
		}
		logger.info("EMPLOYEE Update COMPLETED");
		return res;
	}
	@RequestMapping(value = EmpRestURIConstants.EMPLOYEE_DELETE, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response employeeDelete(@RequestBody Employee emp) {
		logger.info("EMPLOYEE DELETE STARTED");
		Response res=new Response();
		try
		{
			empservice.delete(emp);
			setSuccessResponse(res,"DELETE Successfull");
			res.setEmployee(emp);
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
			e.printStackTrace();
		}
		logger.info("EMPLOYEE Update COMPLETED");
		return res;
	}


	@RequestMapping(value = EmpRestURIConstants.TIMESHEET_GET, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response getTimeSheet(@RequestBody TimeSheet ts) {
		logger.info("GET Timesheet");
		Response res=new Response();
		try
		{

			String fromDate = null,endDate = null,eId = null;
			List<Employee> empList= empservice.getTimeSheetDetails(fromDate,endDate,eId);
			res.setEmployee(empList.get(0));
			setSuccessResponse(res,"Retrieve Employee Details.");
			
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
		}
		logger.info("GET TIMESHEET COMPLETED");
		return res;
	}
	
	@RequestMapping(value = EmpRestURIConstants.TIMESHEET_INSERT, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response employeeTimesheetInsert(@RequestBody Employee emp) {
		logger.info("EMPLOYEE TIMESHEET INSERT STARTED");
		Response res=new Response();
		try
		{
			empservice.add(emp);
			setSuccessResponse(res,"Insertion Successfull");
			res.setEmployee(emp);
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
			e.printStackTrace();
		}
		logger.info("EMPLOYEE TIMESHEET INSERT COMPLETED");
		return res;
	}
	
	@RequestMapping(value = EmpRestURIConstants.TIMESHEET_UPDATE, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response employeeTimeSheetUpdate(@RequestBody TimeSheet ts) {
		logger.info("EMPLOYEE TIMESHEET UPDATE STARTED");
		Response res=new Response();
		try
		{
			empservice.updateTimeSheetDetails(ts);
			setSuccessResponse(res,"Update Successfull");
		}catch(Exception e)
		{
			logger.error("Exception occurred"+e.getMessage());
			setErrorResponse(res,e.getMessage());
			e.printStackTrace();
		}
		logger.info("EMPLOYEE TIMESHEET Update COMPLETED");
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
	
	public Response setErrorResponse(Response res,String message)
	{
		Status s=new Status();
		s.setMessage("Error Occurred"+message);
		s.setSuccess(false);
		res.setStatus(s);
		return res;
	}
}
