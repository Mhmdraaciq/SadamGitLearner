package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseStudy1 {

	static WebDriver driver;
	 
		@Test
		public void test() throws InterruptedException {String url = "https://www.saucedemo.com/";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VC\\eclipse-workspace\\Whandle\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		 //WebElement dropdown = driver.findElement(By.className("product_sort_container"));
		//Select select = new Select(dropdown);
		//select.selectByVisibleText("Price (high to low)");
		driver.findElement(By.className("inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Mohamed");
		driver.findElement(By.id("last-name")).sendKeys("Raciq");
		driver.findElement(By.id("postal-code")).sendKeys("52140942");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
		//driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.className("bm-item menu-item")).click();
		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
		logoutLink.click();
		}}
	 