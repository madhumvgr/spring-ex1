package com.cognisoft.login.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cognisoft.employee.model.Employee;
import com.cognisoft.employee.model.TimeSheet;



@Component
public class EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Employee emp) {
		em.persist(emp);
	}

	public List<Employee> getEmployeeDetails(Employee emp) { 
		return em.createQuery("FROM Employee e WHERE e.id=:id").setParameter("id",emp.getId()).getResultList();
	}

	public boolean updateEmployeeDetails(Employee emp) {
		em.merge(emp);
		return true;
	}

	public List<Employee> getTimeSheetDetails(String fromDate,String endDate,String eId) {
		return em.createQuery("FROM Timesheet e WHERE e.id=:id").setParameter("id",eId).getResultList();
	}

	public boolean updateTimeSheetDetails(TimeSheet ts) {
		em.merge(ts);
		return true;
	}

	public void persist(TimeSheet ts) {
		em.persist(ts);
		
	}

	public List<Employee> getAllEmployeeDetails() { 
		return em.createQuery("FROM Employee e").getResultList();
	}

	public void deleteEmployee(Employee emp) {
		em.createQuery("DELETE FROM Employee e WHERE id=" + emp.getId()).executeUpdate();
		if (em.contains(emp)){
		     em.remove(emp);
		}
		
	}

}
