package dayy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GroupSalesforce {
	public static void main(String[] args) throws InterruptedException {
		
		//1. Login to https://login.salesforce.com
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
			ChromeDriver driver= new ChromeDriver(options);
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://login.salesforce.com/");
	
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		//2.Click on the toggle menu button in the left corner 
		WebElement aa = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		driver.executeScript("arguments[0].click();", aa);
		Thread.sleep(2000);
		
		//3.Click on "View All" and Work Type Groups from App Launcher
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		Thread.sleep(2000);

		
		//Mousehover to Groups and click using Actions class
		// Click Work Type Groups from App Launcher	
		Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//p[text()='Work Type Groups']"))).click().perform(); 
		
        //4.Click on the Dropdown icon in the Work Type Groups tab
     WebElement dropdown=driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left_none slds-p-right_x-small']//span//lightning-primitive-icon"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		
		//5.Click on New Work Type Group
		WebElement Newwork= driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		executor.executeScript("arguments[0].click();", Newwork);
		
		//6.Enter Work Type Group Name as 'Salesforce Automation by Your Name' 
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sabin Jone");
      
		//7.Click save and verify Work Type Group Name"
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verify=driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
		if(verify.contains("Sabin Jone"))
		{System.out.println("WorkType GroupName verified successfully");
		}
		else
			System.out.println("WorkType GroupNmae Not Found");
	
	}
}
