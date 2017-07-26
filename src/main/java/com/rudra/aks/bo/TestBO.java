package com.rudra.aks.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity	
@Table(name = "Sprintx_test")
@Proxy(lazy = false)
public class TestBO {
	
	@Id
	@GeneratedValue
    @Column
	int id;
	String address;
	int age;
	String department;
	String emailid;
	String name;
	int salarty;
	
	@Override
	public String toString() {
		return "TestBO [id=" + id + ", address=" + address + ", age=" + age + ", department=" + department
				+ ", emailid=" + emailid + ", name=" + name + ", salarty=" + salarty + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalarty() {
		return salarty;
	}
	public void setSalarty(int salarty) {
		this.salarty = salarty;
	}
	/*public TestBO(String address, int age, String department, String emailid, String name, int salarty) {
		super();
		this.address = address;
		this.age = age;
		this.department = department;
		this.emailid = emailid;
		this.name = name;
		this.salarty = salarty;
	}
	*/
	
}
