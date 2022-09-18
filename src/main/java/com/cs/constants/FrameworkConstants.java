package com.cs.constants;

import java.io.File;
import java.time.Duration;

import com.cs.enums.ConfigProperties;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.PropertyUtils;

public final class FrameworkConstants {

	private static final String RESOURCESPATH            = System.getProperty("user.dir");
	private static final String CHROMEDRIVERPATH       = RESOURCESPATH + File.separator  + "src" + File.separator + "test" + File.separator  + "resources" + File.separator  + "executables" + File.separator + "chromedriver.exe";
	private static final String FIREFOXDRIVERPATH        = RESOURCESPATH + "/src/test/resources/executables/geckodriver.exe";
	private static final String EDGEDRIVERPATH         = RESOURCESPATH + "/src/test/resources/executables/msedgedriver.exe";
	private static final String CONFIGFILEPATH           = RESOURCESPATH + "/src/test/resources/config/config.properties";
	private static final Duration EXPLICITWAIT           = Duration.ofSeconds(20);
	private static final String EXTENREPORTPATH          = RESOURCESPATH + "/extent-test-output/";
	private static final String EXCELPATH                = RESOURCESPATH + "/src/test/resources/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET          = "RUNMANAGER";
	private static final String ITERATIONDATASHEET       = "DATA";
	private static String       extentReportFilePath     = "";
	private static final String YES                      = "YES";
	private static final String NO	                     = "NO";
	private static final String LBLFLASHEDSUCCESSFULMSG = "Successfully Saved";
	private static final String LBLFLASHEDSUCCESSFULMSGFORDELETE = "Successfully Deleted";
	private static final String LBLFLASHEDUNSUCCESSFULMSGFORDELETE = "Not allowed to delete customer(s) associated with projects that have time logged against them";
	                                                                                                           
	public static String getLblFlashedSuccessfulMsg() {
		return LBLFLASHEDSUCCESSFULMSG;
	}

	public static String getLblFlashedSuccessfulMsgForDelete() {
		return LBLFLASHEDSUCCESSFULMSGFORDELETE;
	}
	
	public static String getLblFlashedUnSuccessfulMsgForDelete() {
		return LBLFLASHEDUNSUCCESSFULMSGFORDELETE;
	}
	public static String getYes() {
		return YES;
	}


	public static String getNo() {
		return NO;
	}

	
	
	public static String getEdgeDriverPath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getEdgeDriverPath() ->" + ListenerClass.executionOrdercounter++);
		return EDGEDRIVERPATH;
	}
	
	public static String getFirefoxDriverPath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getEdgeDriverPath() ->" + ListenerClass.executionOrdercounter++);
		return FIREFOXDRIVERPATH;
	}

	
	public static String getRunmanagerSheet() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getRunmanagerSheet() ->" + ListenerClass.executionOrdercounter++);
		return RUNMANAGERSHEET;
	}
	
	public static String getIterationDataSheet() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getIterationDataSheet() ->" + ListenerClass.executionOrdercounter++);
		return ITERATIONDATASHEET;
	}

	public static String getExcelpath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getExcelpath() ->" + ListenerClass.executionOrdercounter++);

		return EXCELPATH;
	}

	public static String getExtentReportFilePath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getExtentReportFilePath() ->" + ListenerClass.executionOrdercounter++);

		if(extentReportFilePath.isEmpty())
			extentReportFilePath = createReportPath();
		return extentReportFilePath;
	}
	
	private static String createReportPath()  
	{
		
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.createReportPath() ->" + ListenerClass.executionOrdercounter++);

		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
			return EXTENREPORTPATH  + System.currentTimeMillis() + "_index.html";
		else
			return EXTENREPORTPATH  + "index.html";
	}

	public static Duration getExplicitwait() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getExplicitwait() ->" + ListenerClass.executionOrdercounter++);

		return EXPLICITWAIT;
	}

	public static String getResourcespath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getResourcespath() ->" + ListenerClass.executionOrdercounter++);

		return RESOURCESPATH;
	}

	public static String getConfigFilePath() {
//		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getConfigFilePath() ->" + ListenerClass.executionOrdercounter++);
		System.out.println("Begin&End of FrameworkConstants.getConfigFilePath() ->" + ListenerClass.executionOrdercounter++);

		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		DisplayLogUtils.displayLog("Begin&End of FrameworkConstants.getChromeDriverPath() ->" + ListenerClass.executionOrdercounter++);

		return CHROMEDRIVERPATH;
	}
	
}
