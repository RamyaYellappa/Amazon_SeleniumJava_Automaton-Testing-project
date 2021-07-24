package feedback;

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


public class TC_feedback_15 {

	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
	 @Test(description="Review button is clicked")
void check_StarRatings()  {

cDriver.get("https://www.amazon.in/");
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("headset");
cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
cDriver.findElement(By.xpath("//div[10]//div[1]//span[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//h2[1]//a[1]//span[1]")).click();
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

Set<String> ids = cDriver.getWindowHandles();
Iterator<String> it = ids.iterator();
String parentId = it.next();
String childId = it.next();
cDriver.switchTo().window(childId);
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

cDriver.findElement(By.xpath("//div[@id='averageCustomerReviews_feature_div']//span[@id='acrCustomerReviewText']")).click();
System.out.println("Test Case Passed");

}

  @AfterMethod
	 void tearDown()
	 {
	cDriver.close();
}
}

