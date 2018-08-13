import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;


public class BaseClassNew {
	public WebDriver driver;
	
	@BeforeClass
	public void configBC() throws IOException {
		 driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.get("https://www.gmail.com");
		
		
		
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		
		driver.findElement(By.id("identifierId")).sendKeys("pammyarupi");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("PPammyasuni@090425");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		File desfile =  new File("‪C:\\Users\\user\\Desktop\\sample resumes.png");
		FileUtils.copyFile(srcfile, desfile);
	}
	
	@AfterMethod
	public void configAM() {
		driver.findElement(By.xpath("//span[@class='gb_8a gbii']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
	}
	
	@AfterClass
	public void configAC() {
		
	
		driver.close();
		
	}


}
