package com.dataprovider.latest;

public class Employee {
	String name;
	int age;
	String city;
	boolean isMale;

	 
	public Employee(String name, int age, String city, boolean isMale) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.isMale = isMale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

}
