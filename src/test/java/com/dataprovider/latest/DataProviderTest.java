package com.dataprovider.latest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dataprovider.latestdppkg.DpEmployee1;

public class DataProviderTest {

	@Test(dataProvider="getData5", dataProviderClass = DpEmployee1.class)
	public void test1(Employee emp) 
	{
		System.out.println(emp.getName() + " => " 
				+ emp.getAge() + " => " 
				+ emp.getCity()+ " => " 
				+ emp.isMale()
				);
	}

//	@DataProvider
	public String[] getData()
	{
		String[] a = {"Vedant","Rishi","Rutuja"};
		return a;
	}

	@DataProvider
	public String[][] getData1()
	{
		String[][] a = 
		{ 
				{"Vedant","18", "Pune", "true"},
				{"Rutuja","47","CN", "false"},
				{"Rishi","48","Nagar", "true"}
		};
		return a;
	}
	
	@DataProvider
	public Object[][] getData2()
	{
		Object[][] a = 
		{ 
				{"Vedant",18, "Pune", true},
				{"Rutuja",47,"CN", false},
				{"Rishi",48,"Nagar", true}
		};
		return a;
	}
	
	@DataProvider
	public Object[][] getData3()
	{
		return new Object[][] 
		{ 
				{"Vedant",18, "Pune", true},
				{"Rutuja",47,"CN", false},
				{"Rishi",48,"Nagar", true}
		};
	}
	
	@DataProvider
	public Employee[] getData4()
	{
		return new Employee[]
		{ 
			new Employee("Vedant",18, "Pune", true),
			new Employee("Rutuja",47,"CN", false),
			new Employee("Rishi",48,"Nagar", true)
		};
	}

}
