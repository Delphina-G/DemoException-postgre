package com.example.demoexception;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentPOJO {

	@Id
	private int id;
	private String name;
	private long mno;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
