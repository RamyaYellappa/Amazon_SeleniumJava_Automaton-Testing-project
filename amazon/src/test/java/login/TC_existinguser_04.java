package login;

import java.io.IOException;
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
//import new2d.ExcelUtility;

public class TC_existinguser_04 {

	  WebDriver cDriver;
	  @BeforeMethod
	    void TC_existinguser_03()
	     {
	    	 WebDriverManager.chromedriver().setup();
	    	 cDriver=new ChromeDriver();
	     }
	     @DataProvider
	 	String[][] LoginDataInputFromExcel1() throws IOException{ 
	 		String sheetname="Sheet1";
	 		String pathOfFiles=".\\DataFiles1\\differentLogin.xlsx";
	 		ExcelUtility excelutility=new ExcelUtility(pathOfFiles);
	 		int totrows=excelutility.getRowCount(sheetname);
	 		int totcols=excelutility.getCellCount(sheetname, totrows);
	 		System.out.println("rows="+totrows+"-----"+"cols="+totcols);
	 		String userdata[][]=new String[totrows][totcols];
	 	    for(int i=0;i<totrows;i++) {
	 		for(int j=0;j<totcols;j++) {
	 			
	 			userdata[i][j]=excelutility.getCellData(sheetname, i, j);
	 			System.out.println("["+i+"]["+j+"]="+userdata[i][j]);
	 		}
	 	}
	 		
	 		return userdata;
	 	}
	 	@Test(dataProvider="LoginDataInputFromExcel1")
	     
	     void valid_Username(String username,String pass) throws InterruptedException
	     {
	    		 cDriver.get("https://www.amazon.in/");
	    		 cDriver.manage().window().fullscreen();
	    		 //Explicit wait
	    		 WebDriverWait wait=new  WebDriverWait(cDriver,30);
	    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList\"]/span")));
	    		 
	    		 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	    		 WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
	    		 emailidElement1.sendKeys(username);		
	    		 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
	    		 WebElement passwordElement2= cDriver.findElement(By.id("ap_password"));
	             passwordElement2.sendKeys(pass);
	    		 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	    		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	    	
	    		 WebElement username1=cDriver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    		 Boolean b_username=username1.isDisplayed();
	    		 
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
	void teardown() {
		
       cDriver.close();
       cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       cDriver.quit();
	}
}