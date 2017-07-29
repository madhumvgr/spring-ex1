package com.cognisoft.employee.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class TimeSheet implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	private int id;
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	private int hours;
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}

}
