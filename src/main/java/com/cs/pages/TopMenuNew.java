package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class TopMenuNew extends BasePage{

	private static final By adminMenuOption = By.xpath("//*[@id='app']//li[1]/a");
	private static final By pim    = By.xpath("//*[@id='app']//li[2]/a");
	private static final By leave = By.xpath("//*[@id='app']//li[3]/a");
	private static final By timeMenuOption = By.xpath("//*[@id='app']//li[4]/a");
	private static final By recruitment = By.xpath("//*[@id='app']//li[5]/a");
	private static final By myInfo = By.xpath("//*[@id='app']//li[6]/a");
	private static final By performance  = By.xpath("//*[@id='app']//li[7]/a");
	private static final By dashboard= By.xpath("//*[@id='app']//li[8]/a");
	private static final By directory  = By.xpath("//*[@id='app']//li[9]/a");
	private static final By maintenance = By.xpath("//*[@id='app']//li[10]/a");
	private static final By buzz = By.xpath("//*[@id='app']//li[11]/a");

	//todo:
	public static By getAdminMenuOption() {
		//	return new AdminPage();
		return  null;
	}
	
	//todo:	
	public static By getPim() {
//		return new PimPage() ;
		return  null;
	}
	
	//todo:	
	public static By getLeave() {
//		return new LeavePage();
		return  null;
	}
	
	public  TimePageMenu getTimeMenuOption() {
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.mouseOverMenuTime() ->"
				+ ListenerClass.executionOrdercounter++);
		mouseOver(timeMenuOption); 
		click(timeMenuOption, "Time Main Menu");
		DisplayLogUtils.displayLog("End of CustomerHomePage.mouseOverMenuTime() ->" +
				ListenerClass.executionOrdercounter);

		return new TimePageMenu();
	}
	
	//todo:
	public static By getRecruitment() {
//		return new RecruitmentPage();
		return  null;
	}
	
	//todo:
	public static By getMyinfo() {
//		return new MyInfoPage();
		return  null;
	}
	
	//todo:
	public static By getPerformance() {
//		return new PerformancePage();
		return  null;
}
	
	//todo:
	public static By getDashboard() {
//		return new DashboardPage();
		return  null;
}
	
	//todo:
	public static By getDirectory() {
//		return new DirectoryPage();
		return  null;
	}
	
	//todo:
	public static By getMaintenance() {
//		return new MaintenancePage();
		return  null;
	}
	
	//todo:
	public static By getBuzz() {
//		return new BuzzPage();
		return  null;
	}

	public TimePageMenu clickAdmin() {
 		DisplayLogUtils.displayLog("Begin of CustomerHomePage.clickOnAmdin() ->"
				+ ListenerClass.executionOrdercounter++);
		mouseOver(adminMenuOption); 
//		click(adminMenuOption, WaitStrategy.CLICKABLE,	"Time Main Menu");
		click(adminMenuOption, "Time Main Menu");
		DisplayLogUtils.displayLog("End of CustomerHomePage.clickOnAmdin() ->" +
				ListenerClass.executionOrdercounter);

		return new TimePageMenu();
	}
	
}