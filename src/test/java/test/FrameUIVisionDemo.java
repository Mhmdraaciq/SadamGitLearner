package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FrameUIVisionDemo {
	static WebDriver driver;
	static String url = "https://ui.vision/demo/webtest/frames/";
	@BeforeMethod
	public void Starting() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VC\\eclipse-workspace\\GauriTrainer\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void Testing(){
		WebElement frame3 = driver.findElement(By.xpath("/html/frameset/frameset/frame[2]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.name("mytext3")).sendKeys("Welcome to frame3");
		WebElement ifrm=driver.findElement(By.xpath("/html/body/center/iframe"));
		driver.switchTo().frame(ifrm);
		driver.findElement(By.id("i8")).click();
		driver.findElement(By.id("i22")).click();
	}
	@AfterMethod
	public void Finishing() {
		driver.manage().window().minimize();
		//dvr.quit();
	}

}

