package com.crm.vtiger.objectrepositorylib;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.GenericLib.BaseClass;

public class CreateCampPage {
	
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(name="campaignname")
	private WebElement campNameSheet;
	
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productLookup;
	
	public void createCampaign(String campName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	
		createCampaign.click();	
		campNameSheet.sendKeys(campName);
		saveCamp.click();
	}
	public void createCampaign(String campName,String proName) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		createCampaign.click();	
		campNameSheet.sendKeys(campName);
		productLookup.click();
		Set <String> set=BaseClass.driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String pID=it.next();
		String cID=it.next();
		BaseClass.driver.switchTo().window(cID);
		Thread.sleep(2000);
		BaseClass.driver.findElement(By.linkText(proName)).click();
		Thread.sleep(2000);
		BaseClass.driver.switchTo().window(pID);
		saveCamp.click();
	}
}
