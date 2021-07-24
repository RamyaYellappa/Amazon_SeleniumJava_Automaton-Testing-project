package payment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_payment_12{
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="User can able click Procced to pay button")
   
	 void checkPaymentOption() throws InterruptedException {
		 
		 cDriver.get("https://www.amazon.in/");
		 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
		 emailidElement1.sendKeys("ramyacsc21199@gmail.com");	
		 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 WebElement passwordElement2= cDriver.findElement(By.xpath("//input[@id='ap_password']"));
         passwordElement2.sendKeys("abcdef");	
         cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("ladies watches");
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		 cDriver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[3]")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 Set<String> ids = cDriver.getWindowHandles();
		 Iterator<String> it = ids.iterator();
		 String parentId = it.next();
		 String childId = it.next();
		 cDriver.switchTo().window(childId);
		 cDriver.findElement(By.id("add-to-cart-button")).click();
		 cDriver.findElement(By.id("hlb-ptc-btn-native")).click();
		 cDriver.findElement(By.xpath("//*[@id=\"address-book-entry-0\"]/div[2]/span/a")).click();
	     cDriver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']//div[@class='a-box-inner']")).click();
	     cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
	     System.out.println("Test Cases passed");
	     System.out.println("proceed to pay button is clicked");
	          
	 }
	 @AfterMethod
	 void tearDown()
	 {
	 cDriver.close();
	 }
	 }