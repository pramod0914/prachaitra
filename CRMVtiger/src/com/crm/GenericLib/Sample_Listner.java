package com.crm.GenericLib;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Sample_Listner extends BaseClass implements ITestListener{

	

	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		String failedTestName=arg0.getMethod().getMethodName();
		System.out.println("test fail ==> " + failedTestName);
EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.driver);
File srcFile=edriver.getScreenshotAs(OutputType.FILE);
File dstFile= new File("./Screenshot/" +failedTestName+".png");
try {
	FileUtils.copyFile(srcFile, dstFile);
	
} catch (Exception e) {
	// TODO: handle exception
}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
}
