package com.cognisoft.employee.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Employee implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phone;
	private String address1;
	private String address2;
	private String country;
	private String state;
	private String city;
	private String zipcode;
	
	private String altAddress1;
	private String altAddress2;
	private String altCountry;
	private String altState;
	private String altCity;
	private String altZipcode;
	private String employeeType; //[In-House,billalbe,benchconsultants,exitemployee]
	private Date hireDate;
	@NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAltAddress1() {
		return altAddress1;
	}
	public void setAltAddress1(String altAddress1) {
		this.altAddress1 = altAddress1;
	}
	public String getAltAddress2() {
		return altAddress2;
	}
	public void setAltAddress2(String altAddress2) {
		this.altAddress2 = altAddress2;
	}
	public String getAltCountry() {
		return altCountry;
	}
	public void setAltCountry(String altCountry) {
		this.altCountry = altCountry;
	}
	public String getAltState() {
		return altState;
	}
	public void setAltState(String altState) {
		this.altState = altState;
	}
	public String getAltCity() {
		return altCity;
	}
	public void setAltCity(String altCity) {
		this.altCity = altCity;
	}
	public String getAltZipcode() {
		return altZipcode;
	}
	public void setAltZipcode(String altZipcode) {
		this.altZipcode = altZipcode;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	@JsonSerialize(using=DateSerializer.class)
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotNull(message = "Email is compulsory")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
