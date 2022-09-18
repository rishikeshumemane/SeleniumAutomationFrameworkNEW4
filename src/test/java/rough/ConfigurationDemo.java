package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cs.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigurationDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[4]/a")).click();
		
		By element1 = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/label/input");
		By element2 = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/label/input");
		By element3 = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/label/input");
 
		boolean element1Selected  = driver.findElement(element1).isSelected();
		boolean element2Selected = driver.findElement(element2).isSelected();
		boolean element3Selected = driver.findElement(element3).isSelected();
		
		System.out.println("element1Selected=> " +element1Selected);
		System.out.println("element2Selected=> " +element2Selected);
		System.out.println("element3Selected=> " +element3Selected);
		
	          JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", driver.findElement(element1));
			js.executeScript("arguments[0].click();", driver.findElement(element2));
			js.executeScript("arguments[0].click();", driver.findElement(element3));
		
		 element1Selected  = driver.findElement(element1).isSelected();
		 element2Selected  = driver.findElement(element2).isSelected();
		 element3Selected  = driver.findElement(element3).isSelected();
		 
		System.out.println("element1Selected=> " +element1Selected );
		System.out.println("element2Selected=> " +element2Selected);
		System.out.println("element3Selected=> " +element3Selected);
	
		driver.quit();
		
		
		
		
		
	}
	
	
	
}
