package com.dataprovider.latest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDAtaProviderDemo {

	
	@Test(dataProvider="getData")
	public void getExcelData(String name, String age, String city, String isMale)
	{
		System.out.println(name + " = " + age + " = " + city + " = " + isMale);
	}

	@DataProvider(name="getData")
	public Object[][] getData()
	{
		Object[][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/dataprovider/latest/empdata.xlsx");
			String  sheetName= "testing";
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int row = sheet.getRow(0).getLastCellNum();
			int col = sheet.getRow(0).getLastCellNum();
					
			data = new Object[row][col];
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<col;j++)
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		return data;	
	}
}
 