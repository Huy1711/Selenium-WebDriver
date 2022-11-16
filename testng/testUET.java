package testng;

import org.testng.annotations.Test;

import org.testng.Assert;	

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class testUET {
  
  WebDriver driver = new ChromeDriver();
	
  	@BeforeTest
	public void launchBrowser() {
		driver.get("https://uet.vnu.edu.vn/");
		String url = driver.getCurrentUrl();
	    Assert.assertEquals(url, "https://uet.vnu.edu.vn/");
	}
	
  	@Test
	public void printTitle() {
      String title = driver.getTitle();
      System.out.print("Web title: " + title + "\n");
      
	}
  	
  	@Test
	public void navigateToAndBack() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://vnu.edu.vn/");
		Thread.sleep(2000);
		driver.navigate().back();
		String curUrl = driver.getCurrentUrl();
		Assert.assertEquals(curUrl, "https://uet.vnu.edu.vn/");
	}
	
	@Test
	public void searchContent() throws InterruptedException {
	  String content = "Thoi khoa bieu";
	  Thread.sleep(2000);
		// click on search drop down button
      driver.findElement(By.cssSelector("i.fa.fa-search")).click();
      Thread.sleep(2000);
      // fill in search text
      driver.findElement(By.cssSelector("input.form-control.search-field")).sendKeys(content);
      Thread.sleep(2000);
      // click on search button
      driver.findElement(By.cssSelector("i.fa.fa-search.fa-4x")).click();
      Thread.sleep(2000);
      String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, "https://uet.vnu.edu.vn/?s=Thoi+khoa+bieu");
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
		System.exit(0);
	}
  

}
