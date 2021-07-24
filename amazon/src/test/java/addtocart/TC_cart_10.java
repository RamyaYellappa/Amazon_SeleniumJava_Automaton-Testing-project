package addtocart;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_cart_10 {
	

	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="User can able to click Add to button successful.")
	          
	 void click_AddToCart() throws InterruptedException {
		 cDriver.get("https://www.amazon.in/");
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("ladies watches");
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		 cDriver.findElement(By.xpath("//img[@alt=\"Sponsored Ad - Giordano Analog Women's Watch - A2057\"]")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 Set<String> ids = cDriver.getWindowHandles();
		 Iterator<String> it = ids.iterator();
		 String parentId = it.next();
		 String childId = it.next();
		 cDriver.switchTo().window(childId);
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 cDriver.findElement(By.id("add-to-cart-button")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 System.out.println("Test cases passed");
		 System.out.println("AddToCart button clicked successfully");
	
		 }

	 @AfterMethod
	 void tearDown()
	 {
	 cDriver.close();
	 }
	 }
