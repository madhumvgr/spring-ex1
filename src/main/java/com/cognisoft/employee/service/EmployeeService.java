package com.cognisoft.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognisoft.employee.model.Employee;
import com.cognisoft.employee.model.TimeSheet;
import com.cognisoft.login.dao.EmployeeDao;
@Component
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Transactional
	public void add(Employee emp) {
		empDao.persist(emp);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeDetails(Employee emp) {
		List<Employee> employee=empDao.getEmployeeDetails(emp);
		return employee;
	}

	@Transactional
	public boolean update(Employee emp) {
		return empDao.updateEmployeeDetails(emp);
		
	}

	@Transactional(readOnly = true)
	public List<Employee> getTimeSheetDetails(String fromDate,String endDate,String eId) {
		List<Employee> timesheets=empDao.getTimeSheetDetails(fromDate,endDate,eId);
		return timesheets;
	}

	@Transactional
	public boolean updateTimeSheetDetails(TimeSheet ts) {
		return empDao.updateTimeSheetDetails(ts);
		
	}
	
	@Transactional
	public void add(TimeSheet ts) {
		empDao.persist(ts);
	}

	public List<Employee> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployeeDetails();
	}
	@Transactional
	public void delete(Employee emp) {
		
		 empDao.deleteEmployee(emp);
		
	}
}
