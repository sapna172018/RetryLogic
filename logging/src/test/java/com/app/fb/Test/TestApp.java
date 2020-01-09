package com.app.fb.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestApp{
	
	WebDriver driver;
	//Logger log= Logger.getLogger(TestApp.class);//use to create your own log information
	
	@BeforeMethod
	public void setup(){
		//log.info("******************************************* Start Test Case Execution*************************************");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sapna\\Desktop\\New folder\\chromedriver_win32_76\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
	//log.warn("Hey this is just a warning");
	//log.fatal("Hey this is just a fatal error message");
	//log.debug("This is a error message");
	}
	
         @Test(priority=1)
	
	public void ValidateTitle() {
        	// log.info("******************************************* Start Test Case*************************************");
        	 //log.info("******************************************* Facebook Title test*************************************");
		String title=driver.getTitle();
		Assert.assertEquals(title,"Facebook - Log In or Sign Up");
		//log.info("*******************************************  Facebook Title test End*************************************");
	}
	
              @Test(priority=2)
           public void LoginTest() {
          //  	  log.info("******************************************* Start Test Case2 *************************************");
         //    	 log.info("******************************************* Facebook Login test*************************************");
	        driver.findElement(By.name("email")).sendKeys("sapna030717@gmail.com");
	        driver.findElement(By.name("pass")).sendKeys("SHIVANSH@0302");
	        driver.findElement(By.xpath("//input[@value='Log In']")).click();

       	 //log.info("******************************************* Facebook Title test End*************************************");
           }

             @AfterTest


         public void TearDown() {
	      driver.close();
	      
     	 //log.info("******************************************* Browser has been closed*************************************");
         }
	
}