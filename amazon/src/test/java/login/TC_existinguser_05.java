/**
 * 
 */

package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_existinguser_05 {
	WebDriver cDriver;
	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		cDriver=new ChromeDriver();
	}
	
	@DataProvider
    public static Object[][] loginWrongCredential() {
        Object[][] credentials = new Object[5][2];
        //valid mail invalid pass
        credentials[0][0] = "ramyacsc21199@gmail.com"; 
        credentials[0][1] = "testss122";
        //inv mail val pass
        credentials[1][0] = "ramya@qe";
        credentials[1][1] = "abcdef";
        //inv mail pass
        credentials[2][0] = "emptypass@12"; 
        credentials[2][1] = "wrff";
       //empty
        credentials[3][0] = "";
        credentials[3][1] = "";
        //val email and pass
        credentials[4][0] = "ramyacsc21199@gmail.com";
        credentials[4][1] = "abcdef";
        return credentials;
    }
	@Test(dataProvider = "loginWrongCredential")
	void login(String username,String pass) {

		 cDriver.get("https://www.amazon.in/");
		 cDriver.manage().window().fullscreen();
		 //Explicit wait
		 WebDriverWait wait=new  WebDriverWait(cDriver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList\"]/span")));
		 
		 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
		 WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
		 emailidElement1.sendKeys(username);
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
		 WebElement passwordElement2= cDriver.findElement(By.id("ap_password"));
        passwordElement2.sendKeys(pass);
        cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	
		 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	
		
	}
	@AfterMethod
	void close() {
		cDriver.close();
	}

}
