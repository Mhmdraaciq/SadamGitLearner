package com.runner;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LumaRunner {
	public static WebDriver driver;
	@BeforeTest
	public static void browserLaunch() {
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = -4)
	public void homePageValidation() {



		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {

			System.out.println(link.getText() + "Link Is: " + link.getAttribute("href"));

		}

		System.out.println("Number Of link Is: " + allLinks.size());


		List<WebElement> findElements = driver.findElements(By.xpath("//li[@class='product-item']"));
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());

		}
		System.out.println("Coun : " + findElements.size());

	}
	@Test(priority = -3)
	public void productSearch() throws InterruptedException {
		WebElement gears = driver.findElement(By.xpath("//*[text()='Gear']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(gears).perform();
		Thread.sleep(3000);
		WebElement watches = driver.findElement(By.xpath("//*[text()='Watches']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", watches);
		WebElement ddwatch = driver.findElement(By.xpath("//a[contains(text(),'Didi Sport Watch ')]"));
		ddwatch.click();
		WebElement addcart = driver.findElement(By.xpath("//*[text()='Add to Cart']"));
		addcart.click();
		WebElement cartsymb = driver.findElement(By.xpath("//a[@class='action showcart']"));
		js.executeScript("arguments[0].click();", cartsymb);
		Thread.sleep(3000);
		WebElement text = driver.findElement(By.xpath("//div[@role='alert']"));
		System.out.println(text.getText());

	}

	@Test(priority = -2)
	public void adressPage() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement procedtocheckout = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", procedtocheckout);

		Thread.sleep(3000);
		WebElement emailbox = driver.findElement(By.xpath("(//input[@id='customer-email'])[1]"));
		emailbox.sendKeys("google@gmail.com");

		WebElement firstname1 = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname1.sendKeys("hello");
		WebElement lastname2 = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname2.sendKeys("google");
		WebElement phonenumber = driver.findElement(By.xpath("//input[@name='telephone']"));
		phonenumber.sendKeys("123456789");
		WebElement country = driver.findElement(By.xpath("(//select[@class='select'])[2]"));
		Select sc2 = new Select(country);
		sc2.selectByVisibleText("India");
		WebElement state = driver.findElement(By.xpath("(//select[@class='select'])[1]"));
		Select sc3 = new Select(state);
		sc3.selectByVisibleText("Tamil Nadu");
		Thread.sleep(3000);
		WebElement city = driver.findElement(By.xpath("(//input[@class='input-text'])[10]"));
		city.sendKeys("Madurai"); 
		WebElement pincode = driver.findElement(By.xpath("(//input[@class='input-text'])[12]"));
		pincode.sendKeys("624703");
		WebElement street = driver.findElement(By.xpath("(//input[@class='input-text'])[7]"));
		Thread.sleep(3000);
		street.sendKeys("madurai");
		Thread.sleep(3000);


	}

	@Test(priority = -1)
	public void orderPage() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement nextbtn = driver.findElement(By.xpath("//*[text()='Next']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", nextbtn);
		Thread.sleep(5000);
		WebElement order = driver.findElement(By.xpath("//*[text()='Place Order']"));
		js.executeScript("arguments[0].click();", order);

	}


	@AfterTest
	private void terminateBrowser() {
		driver.quit();

	}


}
}
