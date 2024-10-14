package dayy;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class EditWorkTypeGroup {

	
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
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//3.Click on "View All" and Work Type Groups from App Launcher
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
			
			//Mousehover to Groups and click using Actions class
			//4.Click on the Dropdown icon in the Work Type Groups tab	
			Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(By.xpath("//p[text()='Work Type Groups']"))).click().perform();
			
		
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        WebElement svgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slds-button slds-button_reset'])[7]")));  
			//5.Search the Work Type Group 'Salesforce Automation by Your Name'
			driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("Salesforce Automation by Sabin Jone");
			Thread.sleep(2000);

			//6.Click on the Dropdown icon and Select Edit
			WebElement dropdown=driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]/span/div/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", dropdown);
			//Thread.sleep(2000);
			
			//driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]/span/div")).click();

			
			driver.findElement(By.xpath("//a[@title='Edit']")).click();

			//7.Enter Description as 'Automation' 
			driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");

			//8.Select Group Type as 'Capacity'
			driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
			driver.findElement(By.xpath("//span[@title='Capacity']")).click();

			//9.Click on Save
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			
			//10.Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'"
			WebElement cli = driver.findElement(By.xpath("//a[text()='Salesforce Automation by Sabin Jone']"));
			executor.executeScript("arguments[0].click();", cli);
			
			String text = driver.findElement(By.xpath("(//slot[@name='outputField']/lightning-formatted-text)[2]")).getText();
			if (text.contains("Auto")) {
				System.out.println("The Workgroup Name is Verified");
			}else {
				System.out.println("The Workgroup Name is not Verified");
			}
		}
}
