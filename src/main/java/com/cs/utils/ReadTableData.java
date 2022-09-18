package com.cs.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;

public class ReadTableData {

	public static List<HashMap<String, String>> getTableData(String rowBy, String colBy, String headerByPart1,
			String headerByPart2, int startRowNum)
	{
		DisplayLogUtils.displayLog("Begin of ReadTableData.getTableData() ->" + ListenerClass.executionOrdercounter++);

		List<HashMap<String, String>> listMap = new ArrayList<>();

		List<WebElement> rows = DriverManager.getDriver().findElements(By.xpath(rowBy));

		for (int i = startRowNum; i < rows.size(); i++) /// to remove a header, start from row 1
		{
			WebElement rowElement = rows.get(i);
			List<WebElement> rowElementFields = rowElement.findElements(By.xpath(colBy));
			HashMap<String, String> map = new HashMap<>();

			for (int k = 0; k < rowElementFields.size(); k++) {
				String value = rowElementFields.get(k).getText();

				String path = headerByPart1 + String.valueOf(k + 1) + headerByPart2;
				map.put(DriverManager.getDriver().findElement(By.xpath(path)).getText(), value);
			}
			listMap.add(map);
		}

		DisplayLogUtils.displayLog("end of ReadTableData.getTableData() ->" + ListenerClass.executionOrdercounter);

		return listMap;
	}

	public static List<HashMap<String, String>> getTableDataNew(String rowBy, String colBy, String headerByPart1,
			String headerByPart2, int startRowNum) 
	{
		DisplayLogUtils.displayLog("Begin of ReadTableData.getTableData() ->" + ListenerClass.executionOrdercounter++);
		/*
		 * DisplayLogUtils.displayLog("rowBy                 ->" + rowBy);
		 * DisplayLogUtils.displayLog("colBy                   ->" + colBy);
		 * DisplayLogUtils.displayLog("headderByPart1 ->" + headerByPart1);
		 * DisplayLogUtils.displayLog("headderByPart2 ->" + headerByPart2);
		 */

		List<HashMap<String, String>> listMap = new ArrayList<>();

//		List<WebElement>  list =  DriverManager.getDriver().findElements(By.xpath(rowBy));
		List<WebElement>  list =  DriverManager.getDriver().findElements(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div"));
		DisplayLogUtils.displayLog("Total rows:         ->" + list.size());
		for(int i=0;i<list.size();i++)
		{
			WebElement row = list.get(i);
			List<WebElement> rowElementFields = row.findElements(By.xpath(colBy));
			DisplayLogUtils.displayLog("row size : " + rowElementFields .size());
			HashMap<String, String> map = new HashMap<>();
			
			for(int j=1;j<=2;j++)
				{
					System.out.print(rowElementFields.get(j).getText() + " === " );
					String value = rowElementFields.get(j).getText();
					String key =  DriverManager.getDriver().findElement(By.xpath(headerByPart1 + (j+1) + headerByPart2)).getText();
					map.put(key, value);
				}
			listMap.add(map);
		}
		DisplayLogUtils.displayLog("listMap:" + listMap);
		
		DisplayLogUtils.displayLog("end of ReadTableData.getTableData() ->" + ListenerClass.executionOrdercounter);

		return listMap;
	}
}
