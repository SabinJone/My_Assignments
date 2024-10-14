package dayy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforce {


		public static void main(String[] args) {
			
			//1. Launch the browser
			ChromeDriver driver= new ChromeDriver();
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
			
			//7.Click on "View All" and select "Sales" from the App Launcher 
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click(); 
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			
			//8.Click on the "Opportunity" tab. 
			WebElement dd=driver.findElement(By.xpath("//span[text()='Opportunities']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", dd);
			
			//9.Click on the "New" button. 
			driver.findElement(By.xpath("//div[@title='New']")).click();
			
			//10.Enter the Opportunity name as 'Salesforce Automation by Your Name
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sabin Jone");
			
			//11.Enter Amount as 75,000 
			driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
			
			//12.Choose the close date as Today
			driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
			driver.findElement(By.xpath("//button[text()='Today']")).click();	
			
			//13.Select 'Stage' as 'Need Analysis'
			driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
			
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();	
			
			//14.Click on the 'Save' button and verify the Opportunity Name
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();	
			
	 String verify=driver.findElement(By.partialLinkText("Sabin Jone")).getText();
			if(verify.contains("Sabin Jone"))
			{
				System.out.println("Name verified successfully");
			}
			else
			{
				System.out.println("Name Not Found");
			}			

			
					}

}
