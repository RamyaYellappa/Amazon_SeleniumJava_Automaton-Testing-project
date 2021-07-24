package productpage;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_product_06
{
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="Product description page is able to view")
	           
	 void checkProduct_features() throws InterruptedException
	 {
		  cDriver.get("https://www.amazon.in/");
		  cDriver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
		  cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 
          cDriver.findElement(By.cssSelector(".hmenu-item[data-menu-id='8']")).click();
          cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 

		  cDriver.findElement(By.xpath("//a[@class='hmenu-item'][normalize-space()='Tablets']")).click();
		  cDriver.findElement(By.xpath("//div[@class='a-row apb-browse-two-col-center-pad']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]//h2[1]")).click();
		  WebElement txt=cDriver.findElement(By.xpath("//*[@id=\"feature-bullets\"]"));
		  String s=txt.getText();
		  System.out.println(s);
		  WebElement productdetails =cDriver.findElement(By.xpath("//*[@id=\"productDetails_feature_div\"]"));
		  productdetails.click();
		  cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		  Boolean b_productimage= productdetails.isDisplayed();
 	      if(b_productimage)
 		  {
 	 		
 	 		System.out.println("Product description page is viewed successfull.");
 	 		System.out.println("Test cases passed");
 	 		
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


