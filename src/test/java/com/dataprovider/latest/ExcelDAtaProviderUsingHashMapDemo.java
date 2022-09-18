package com.dataprovider.latest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDAtaProviderUsingHashMapDemo {

	
	@Test(dataProvider="getData")
	public void getExcelData(HashMap<String, String> map)
	{
		System.out.println(map.get("name") + " = " + map.get("age") + " = " +map.get("city") 
		+ " = " + map.get("gender"));
	}

	@DataProvider(name="getData")
	public Object[] getData()
	{
		Object[] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/dataprovider/latest/empdata.xlsx");
			String  sheetName= "testing";
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int row = sheet.getLastRowNum();
			System.out.println("row :" + row);
			int col = sheet.getRow(0).getLastCellNum();
			System.out.println("col :" + col);
					
			data = new Object[row];
			Map<String,String> map;
			
			for(int i=1;i<=row;i++)
			{
				map = new HashMap<String,String>();
				for(int j=0;j<col;j++)
				{
					String key   = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key,value);
				}
				data[i-1] = map;
			}
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		return data;	
	}
}

























