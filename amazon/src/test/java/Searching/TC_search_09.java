package Searching;

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


public class TC_search_09 {
	
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="After searching product,check product can able to move to next page")
       
	 void checkSearchNextWindow() throws InterruptedException {
		 cDriver.get("https://www.amazon.in/");
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("ladies watches");
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		 cDriver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[7]/div/span/div/div/div[2]/div/span/a/div/img")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		 Set<String> ids = cDriver.getWindowHandles();
		 Iterator<String> it = ids.iterator();
		 String parentId = it.next();
		 String childId = it.next();
		 cDriver.switchTo().window(childId); 
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 System.out.println("Product page moving to next page Succesfully");
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		
		 
	 }


	 @AfterMethod
	 void tearDown()
	 {
	cDriver.close();
}
}