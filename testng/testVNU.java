package testng;

import org.testng.annotations.Test;

import org.testng.Assert;	

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class testVNU {
  
	WebDriver driver = new ChromeDriver();
	
  	@BeforeTest
	public void launchBrowser() {
		driver.get("https://daotao.vnu.edu.vn/");
		String url = driver.getCurrentUrl();
	    Assert.assertEquals(url, "https://daotao.vnu.edu.vn/dkmh/login.asp");
	}
  	
  	@Test
	public void logIn() throws InterruptedException {
		// fill in id and password
		WebElement idBox = driver.findElement(By.id("txtLoginId"));
		idBox.sendKeys("19021299");
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys("abcxyz");
        Thread.sleep(2000);
		// select log in mode
		Select selectByValue = new Select(driver.findElement(By.id("txtSel")));
        selectByValue.selectByValue("2");
        Thread.sleep(2000);
        idBox.submit();  
        Thread.sleep(5000);
    }
	
	@AfterTest
	public void closeDriver() {
		driver.close();
		System.exit(0);
	}
  

}
