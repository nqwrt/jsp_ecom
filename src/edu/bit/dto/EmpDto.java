package edu.bit.dto;

import java.util.Random;

public class EmpDto {
	private String ename;
	private double sal;
	
	public EmpDto() {}	
	
	public EmpDto(String ename, double sal) {
		this.ename = ename;
		this.sal = sal;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public String getPhoto() {
		Random random = new Random();
		int num = random.nextInt(6) + 1;
		return "product" + String.valueOf(num)+".jpg";
	}

}
