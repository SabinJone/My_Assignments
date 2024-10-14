package dayy;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;


public class LegalEnitity {
	
	public static void main(String[] args) throws InterruptedException {

	//1. Launch the browser
	
		// Now create a new instance with notification disabled
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
			ChromeDriver driver= new ChromeDriver(options);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//2. Load the URL
			driver.get("https://login.salesforce.com/");
			
			//3.Enter the username as dilip@testleaf.com
			driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
			
			//4.Enter the password as leaf@2024
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
			
			//5.Click on the Login button.
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			
			//6.Click on the toggle menu button in the left corner 
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//7.Click on "View All" and click Legal Entities from App Launcher
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
			
			WebElement dd=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", dd);
			
			//8.Click on the Dropdown icon in the legal Entities tab
			Thread.sleep(2000);	
			WebElement ee=driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
			executor.executeScript("arguments[0].click();", ee);
					//div[@class='slds-context-bar__label-action slds-p-left_none']//span/lightning-primitive-icon)[14]
	
			//9.Click on New Legal Entity
			WebElement ff=driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
			executor.executeScript("arguments[0].click();", ff);

			//10.Enter Name as 'Salesforce Automation by Your Name'
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sabin Jone");
	
			//11.Click save and verify Legal Entity Name"
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

			//String verify=driver.findElement(By.xpath("//div[@class='header-right-content']")).getText();
			String verify=driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
			
	
if(verify.contains("Salesforce Automation by Sabin Jone"))
		{			
			System.out.println("Legal Entity Name verified successfully");
		
				}
else
		{			
			System.out.println("Legal Entity Name Not Found");
				}

					
	}	
}
