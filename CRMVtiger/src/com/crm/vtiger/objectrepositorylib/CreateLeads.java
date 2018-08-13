package com.crm.vtiger.objectrepositorylib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLeads {
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="lastname")
	private WebElement contactName;
	

	@FindBy(name="firstname")
	private WebElement firstnameEdt;
	

	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	@FindBy(name="company")
	private WebElement companyName;
	
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	
	public void createLeads(String leadfrst,String leadLast,String compName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		createSymbol.click();	
		firstnameEdt.sendKeys(leadfrst);
		lastnameEdt.sendKeys(leadLast);
		companyName.sendKeys(compName);
		saveCamp.click();
}
	

}
