package browserCompactibility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFunction {
	 WebDriver cDriver;
	 SoftAssert softassert = new SoftAssert();
		SoftAssert softassert2 = new SoftAssert();
	 @BeforeMethod
	 void TC_browser_18 ()
	    {
	    WebDriverManager.chromedriver().setup();
	    cDriver=new ChromeDriver();
	    }
	 
	@Test   
	public void check_Browsercomp() throws Throwable { 
		cDriver.get("https://www.amazon.in/");
		WebElement logo=cDriver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
			System.out.println(logo.isDisplayed());
		WebElement Indian_flag=cDriver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-in']"));
		    System.out.println(Indian_flag.isDisplayed());
		  //Explicit wait
   		WebDriverWait wait=new  WebDriverWait(cDriver,30);
   		         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList\"]/span")));
		WebElement Sign_In=cDriver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		    System.out.println(Sign_In.isDisplayed());
		    
		WebElement Search_textbox=cDriver.findElement(By.id("twotabsearchtextbox"));
		     System.out.println(Search_textbox.isEnabled());
		     
		WebElement return_order=cDriver.findElement(By.xpath("//a[@id='nav-orders']"));
		     System.out.println(return_order.isEnabled());
		     
		WebElement location=cDriver.findElement(By.id("nav-global-location-popover-link"));
		     System.out.println(location.isDisplayed()); 
		     
		cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);    
		WebElement cart=cDriver.findElement(By.xpath("//a[@id='nav-cart']"));
		      System.out.println(cart.isEnabled());
		      
	    
		   
		      
		      
		      System.out.println(1);
		      cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		      cDriver.getTitle();
		      Thread.sleep(1000);
		      }
	
		     
		
		     
		//Soft Assertion example - with a failure test case example
		@Test
		public void verifyTitle(){
		cDriver.get("https://amazon.in");
		String ActualTitle = cDriver.getTitle();
		System.out.println("Actual Title :"+ActualTitle);
		String ExpectedTitle = "cameras, books, watches, apparel, shoes and e-Gift Cards. Free Shipping &amp; Cash on Delivery Available.";
		         
		//Soft assert applied to verify title
		softassert.assertEquals(ActualTitle, ExpectedTitle);
		 
		 
		//If failed, this line gets printed and execution is not halted
		System.out.println("Assertion 1 is executed");
		 
		softassert.assertAll();
		 cDriver.close();
		}
		 
		//Soft Assertion example - with a positive flow test case example
		@Test
		public void verifyElement(){
		cDriver.get("https://amazon.in");
		WebElement logo=cDriver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		softassert2.assertEquals (true, logo.isDisplayed());
		softassert2.assertAll();
		cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	
		System.out.println("Icon is displayed");
		System.out.println("Assertion 2 is executed");
		 cDriver.close();
		}	
	
	@AfterMethod
	void close() {
		
		
	     cDriver.quit();
		
	}
}
