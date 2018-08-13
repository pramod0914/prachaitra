package com.crm.vtiger.objectrepositorylib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLib.BaseClass;



public class CreateOpportunities {
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="potentialname")
	private WebElement potentialnameEdt;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement ContactLookup;
	
	@FindBy(id="related_to_type")
	private WebElement Contact;
	
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	
	public void createOpportunities(String oppName,String contact) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		createSymbol.click();	
		potentialnameEdt.sendKeys(oppName);
		Select sel= new Select(Contact);
		sel.selectByVisibleText("Contacts");
		ContactLookup.click();
		Set<String> st1 = BaseClass.driver.getWindowHandles();
		Iterator<String> i2 = st1.iterator();
		String PID= i2.next();
		String CID=i2.next();
		BaseClass.driver.switchTo().window(CID);
		BaseClass.driver.findElement(By.linkText(contact)).click();
		BaseClass.driver.switchTo().window(PID);
		saveCamp.click();

}

}
