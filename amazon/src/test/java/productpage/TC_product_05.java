package productpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_product_05 
{
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="Product page is visible to user")     
	     
	 void checkProduct(){
		 cDriver.get("https://www.amazon.in/");
		 WebElement productElement=cDriver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-relative']"));
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 Boolean b_productElement= productElement.isDisplayed();
 	     if(b_productElement)
 		  {
 	 		System.out.println("Test cases passed");
 	 		System.out.println("Product page is visible");
 		  }
 		 else 
 		  {
 			System.out.println("test is failed");	
 		  }
		
	 }

	 @AfterMethod
	 void tearDown()
	 {
	cDriver.close();
}
}

