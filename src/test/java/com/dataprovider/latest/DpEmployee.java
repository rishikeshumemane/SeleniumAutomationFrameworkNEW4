package com.dataprovider.latest;

import org.testng.annotations.DataProvider;

public class DpEmployee {

	@DataProvider
	public Employee[] getData5()
	{
		return new Employee[]
		{ 
			new Employee("Vedant",18, "Pune", true),
			new Employee("Rutuja",47,"CN", false),
			new Employee("Rishi",48,"Nagar", true)
		};
	}
}
