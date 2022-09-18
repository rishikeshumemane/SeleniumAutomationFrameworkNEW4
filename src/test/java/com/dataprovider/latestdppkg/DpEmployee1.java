package com.dataprovider.latestdppkg;

import org.testng.annotations.DataProvider;

import com.dataprovider.latest.Employee;

public class DpEmployee1 {

	@DataProvider
	public  Employee[] getData5()
	{
		return new Employee[]
		{ 
			new Employee("Anu",7, "CN", false),
			new Employee("Swaraj",14,"CN", true),
			new Employee("Tejas",5,"CN", true)
		};
	}
}
