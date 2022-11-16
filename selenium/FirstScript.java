import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstScript {
	WebDriver driver = new ChromeDriver();
	
	public void launchBrowser(String url) {
		driver.get(url);
	}
	
	public void printTitle() {
        String title = driver.getTitle();
        System.out.print("Web title: " + title + "\n");
	}
	
	public void searchContent(String content) throws InterruptedException {
		Thread.sleep(2000);
		// click on search drop down button
        driver.findElement(By.cssSelector("i.fa.fa-search")).click();
        Thread.sleep(2000);
        // fill in search text
        driver.findElement(By.cssSelector("input.form-control.search-field")).sendKeys(content);
        Thread.sleep(2000);
        // click on search button
        driver.findElement(By.cssSelector("i.fa.fa-search.fa-4x")).click();
	}
	
	public void searchContent2(String content) throws InterruptedException {
		Thread.sleep(2000);
		// click on search drop down button
        driver.findElement(By.cssSelector("i.fa.fa-search")).click();
        Thread.sleep(2000);
        // fill in search text
        WebElement searchBar = driver.findElement(By.cssSelector("input.form-control.search-field"));
        searchBar.sendKeys(content);
        Thread.sleep(2000);
        // click on search button
        searchBar.submit();
	}
	
	public void navigateToAndBack(String url) throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to(url);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
	public void closeDriver() {
		driver.close();
        System.exit(0);
	}
	
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
    }
	
    public static void main(String[] args) throws InterruptedException {
        
        String url = "https://daotao.vnu.edu.vn/";
        FirstScript obj = new FirstScript();
        obj.launchBrowser(url);
//        obj.printTitle();
//        obj.searchContent("Thời khóa biểu");
//        obj.navigateToAndBack("https://vnu.edu.vn/");
        obj.logIn();
//        obj.closeDriver();
    }

}

