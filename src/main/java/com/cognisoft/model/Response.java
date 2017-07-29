package com.cognisoft.model;

import java.util.List;

import com.cognisoft.employee.model.Employee;
import com.cognisoft.login.model.Member;

public class Response {
	private Status status;
    private Member member;
    private Employee employee;
    private List<Employee> employeeList;
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
