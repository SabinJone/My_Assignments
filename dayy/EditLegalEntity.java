package dayy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLegalEntity {
	
	public static void main(String[]args) throws InterruptedException {

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
	WebElement zz=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	driver.executeScript("arguments[0].click();", zz);
	Thread.sleep(2000);
	

	//7.Click on "View All" and select "Legal Enitities" from the App Launcher 
	WebElement yy=driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")); 
	driver.executeScript("arguments[0].click();", yy);
	Thread.sleep(2000);

	
	WebElement aa = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
	driver.executeScript("arguments[0].click();", aa);
	Thread.sleep(2000);
	
	//8.Search the Legal Entity 'Salesforce Automation by Your Name'
	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Salesforce Automation by Sabin Jone"+Keys.ENTER);
	Thread.sleep(500);
	
	//9.Click on the Dropdown icon and Select Edit
	WebElement bb = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
	driver.executeScript("arguments[0].click();", bb);
	
	driver.findElement(By.xpath("//a[@title='Edit']")).click(); 
	
	//10.Enter the Company name as 'Tetsleaf'
	driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
	
	//11.Enter Description as 'SalesForce'
	driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforce");

	//12.Select Status as 'Active'
	WebElement cc=driver.findElement(By.xpath("//button[@id='combobox-button-212']")); 
	driver.executeScript("arguments[0].click();", cc);

	driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]")).click(); 

	//13.Click on Save and Verify Status as 'Active'
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click(); 
	
	WebElement dd=driver.findElement(By.xpath("//a[text()='Salesforce Automation by Sabin Jone']")); 
	driver.executeScript("arguments[0].click();", dd);

	
	String status=	driver.findElement(By.xpath("(//p[@class='fieldComponent slds-text-body--regular slds-show_inline-block slds-truncate'])[2]")).getText(); 
if(status.contains("Active"))
{
	System.out.println("Active Status Verified sucessfully");
}
else
{		System.out.println("Status Not Active");

	}

	}
}