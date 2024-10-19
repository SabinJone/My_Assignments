package day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;


public class Service_Now {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1.Launch ServiceNow application	
		driver.get("https://dev242606.service-now.com/");
		
		//2.Login with valid credentials username as admin and password		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("v^S8PbUx1J^k");
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		
		//3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//4.Click on  mobiles
		Shadow shadow2 = new Shadow(driver);
		
		WebElement frame1=shadow2.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		shadow2.findElementByXPath("//table[@class='drag_section_header']/tbody/tr/td/a[text()='Mobiles']").click();

		//5.Select Apple iphone13pro
		driver.findElement(By.xpath("//div[@class='sc_category_item']/table/tbody/tr/td/div/a")).click();
		
		//6.Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("(//table/tbody//div[@class='row sc-row']//div/span)[2]")).click();
////label[text()='Yes']
		
		
		//7.Enter phonenumber as 99 in original phonenumber field
			driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
	
	//8.Select Unlimited from the dropdown in Monthly data allowance
		WebElement bb=driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select cc=new Select(bb);
		cc.selectByValue("unlimited");
		
		
		
		//9.Update color field to SierraBlue and storage field to 512GB
		WebElement dd=driver.findElement(By.xpath("//label[text()='Sierra Blue']"));
		driver.executeScript("arguments[0].click();", dd);
		
		driver.findElement(By.xpath("//label[contains(text(),'512')]")).click();
		
		//10.Click on Order now option
		WebElement ee=driver.findElement(By.xpath("//button[@id='oi_order_now_button']"));
		driver.executeScript("arguments[0].click();", ee);
		
		//11.Verify order is placed and copy the request number
		String verify=driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		
		if(verify.contains("Thank you"))
		{
			System.out.println("Order status has been verified");
		}
		else
		{
			System.out.println("Order not placed");
			
		}
		
		String reqno=driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("The Request Number is "+reqno);

		//12.Take a Snapshot of order placed page
		
		File scr=driver.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Snapshots/order.png");
		FileUtils.copyFile(scr, dest);
	}

}
