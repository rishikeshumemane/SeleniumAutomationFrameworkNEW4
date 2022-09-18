package com.cs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cs.constants.FrameworkConstants;
import com.cs.exceptions.InvalidPathForExcelException;
import com.cs.exceptions.XSSFWorkbookCreationException;
import com.cs.listeners.ListenerClass;

public final class ExcelUtils {

	private ExcelUtils() {}
	
	public static List<Map<String, String>> getTestDetails(String sheetName)
	{
		
		DisplayLogUtils.displayLog("Begin of ExcelUtils.getTestDetails() ->" + ListenerClass.executionOrdercounter++);

		
		List<Map<String, String>> list = null;
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()))
		{
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int lastRow    = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			
			Map<String, String> map = null;
			list = new ArrayList<>();
			
			for(int i=1; i<=lastRow; i++)
			{
				map = new HashMap<>();

				for(int j=0;j<lastColNum;j++)
				{
					String key   = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key,  value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
		/*	
			StackTraceElement[] st =  e.getStackTrace();
			st[0] = new StackTraceElement("com.tmb.Utils.ExcelUtils.Rishi","getDetails","ExcelUtils.java",100);
			e.setStackTrace(st);
			throw new RuntimeException(FrameworkConstants.getConfigFilePath() + " is not found", e);
		*/
			throw new InvalidPathForExcelException(FrameworkConstants.getConfigFilePath() + " is not found 1");
		} catch (IOException e) {
			throw new XSSFWorkbookCreationException("Unable to create Workbook using Apache POI: XSSFWorkbokoclass");
		} 
		
		
		DisplayLogUtils.displayLog("End of ExcelUtils.getTestDetails() ->" + ListenerClass.executionOrdercounter);

		return list;
	}
	
}
