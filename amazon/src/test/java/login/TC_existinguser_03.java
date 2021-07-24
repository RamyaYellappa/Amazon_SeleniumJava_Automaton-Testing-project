package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_existinguser_03 {

	WebDriver cDriver;
	
        @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
         @Test(description="It will login successful to Amazon Page")
	     void valid_Username() throws InterruptedException
	     {
	    		 cDriver.get("https://www.amazon.in/");
	    		 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	    		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    		 WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
	    		 emailidElement1.sendKeys("ramyacsc21199@gmail.com");		
	    		 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
	    		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    		 WebElement passwordElement2= cDriver.findElement(By.xpath("//input[@id='ap_password']"));
	             passwordElement2.sendKeys("abcdef");
	    		 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	    		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    		 WebElement username=cDriver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    		 
	    		 Boolean b_username=username.isDisplayed();
	    		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    		 System.out.println(b_username);
	    	     if( b_username)
	    		  {
	    	 		System.out.println("User name is R");
	    	 		System.out.println("Test case Passed");
	    		  }
	    		 else 
	    		  {
	    			System.out.println("test is failed");	
	    		  }
	    					    
	    	     cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    	
	    	 
	     }
     
	     @AfterMethod
		 void tearDown()
		 {
		cDriver.close();
	}
	}
