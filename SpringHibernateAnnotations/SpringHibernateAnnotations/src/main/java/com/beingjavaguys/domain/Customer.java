package com.beingjavaguys.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int EMPLOYEE_ID;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="BIRTDATE")
	private String bdate;
	
	@Column(name="SALARY")
	private String salary;

	public int getId() {
		return EMPLOYEE_ID;
		
		}

	public void setId(int id) {
		this.EMPLOYEE_ID = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
