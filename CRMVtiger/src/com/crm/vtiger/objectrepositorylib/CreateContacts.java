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

public class CreateContacts {

	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="lastname")
	private WebElement contactName;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookup;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	
	public void createContacts(String contact,String newOrgName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	
		createSymbol.click();	
		contactName.sendKeys(contact);
		OrgLookup.click();
		Set<String> st = BaseClass.driver.getWindowHandles();
		Iterator<String> i = st.iterator();
		String PID2 = i.next();
		String CID2=i.next();
		BaseClass.driver.switchTo().window(CID2);
		BaseClass.driver.findElement(By.linkText(newOrgName)).click();
		BaseClass.driver.switchTo().window(PID2);
		saveCamp.click();
}
	
}
