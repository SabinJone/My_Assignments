
package dayy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;


public class EditSalesforce {

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
		Thread.sleep(2000);
		
		//7.Click on "View All" and select "Sales" from the App Launcher 
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click(); 
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//8.Click on the "Opportunity" tab
		WebElement dd=driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dd);
     
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[3]")));
		
		//9.Search for the Opportunity 'Salesforce Automation by Your Name'
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys("Salesforce Automation by Sabin Jone" , Keys.ENTER);
		Thread.sleep(3000);
		
		//10.Click on the Dropdown icon and select 'Edit'		
		WebElement clickdropdown = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		executor.executeScript("arguments[0].click();", clickdropdown);
		 
		WebElement clickEdit = driver.findElement(By.xpath("//li[@class='uiMenuItem']//a"));
		executor.executeScript("arguments[0].click();", clickEdit);
	
	//11.Choose the close date as Tomorrow's date 
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='slds-day' and text()='10']")).click();
		
		
//	12.Select 'Stage' as 'Perception Analysis'
		driver.findElement(By.xpath("//button[@data-value='Needs Analysis']")).click();	
		
	driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
	
	//13.Select 'Delivery/Installation Status' as 'In Progress'
	WebElement Deliverystatus = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[4]"));
	executor.executeScript("arguments[0].click();", Deliverystatus);
	
	driver.findElement(By.xpath("//span[text()='In progress']")).click();
	
		 //14.Enter Description as 'SalesForce'
	driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		
    //15.Click on 'Save' and verify the Stage as 'Perception Analysis'
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();	
		
	String per=driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
	//System.out.println(per);
	
if(per.contains("Perception Analysis"))
{ 	System.out.println("Stage Name Verified Successfully");
	}
else
	System.out.println("Stage Name Not Found");
		
}
}