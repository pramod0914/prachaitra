


package com.crm.GenericLib;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.vtiger.objectrepositorylib.Logout;
import com.crm.vtiger.objectrepositorylib.Login;

public class BaseClass {
	public static WebDriver driver;
//	public ExtentReport extent;
//	@BeforSuite
	
	//@Parameters("browser")
	@BeforeClass  // (groups= {"smokeTest" , "regressionTest"})
	public void configBC() throws IOException
	{
		
	/*if(browserName.equals("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else if(browserName.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
	driver=new ChromeDriver();
	}*/
		
		/**
		 * Reading the data from the data properties file
		 * External Resources 
		 *  Get the java object of the physical file
		 */
		
		FileInputStream fis=new FileInputStream("./Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL=pobj.getProperty("url");
		
		/**
		 * 		launch the Firefox browser
		 */
				
		driver= new FirefoxDriver();
		
		/**
		 * We handle the synchronization issue by giving implicitlyWait
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	/**
	 * This method will be executed before executing @Test Annotation method in the class
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	@BeforeMethod 
	public void configBM() throws IOException, InterruptedException
	{
		
		/**
		 * Reading the data from the data properties file
		 * External Resources 
		 *  Get the java object of the physical file
		 */

		FileInputStream fis=new FileInputStream("./Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String USER=pobj.getProperty("username");
		String PASS=pobj.getProperty("password");
		Login login=PageFactory.initElements(driver, Login.class);
		login.LoginIntoApp(USER,PASS);
		Thread.sleep(2000);
	}
	
	
	
	@AfterMethod  (groups= {"smokeTest" , "regressionTest"})
	public void configAM()
	{
		Logout logout=PageFactory.initElements(driver, Logout.class);
		logout.LogoutFromApp();
		
	}
	
	/**
	 * This method will be executed before executing @Test Annotation method in the class
	 * 
	 */
	
	@AfterClass  (groups= {"smokeTest" , "regressionTest"})
	public void configAC()
	{
		/**
		 * Close all the windows
		 */
		driver.quit();
	}
	
}
