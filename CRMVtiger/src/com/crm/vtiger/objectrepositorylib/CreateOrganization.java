package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrganization {

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;	
	
	@FindBy(name="accountname")
	private WebElement accountnameedt;
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveOrg;
	
	
	public void createOrganization(String newOrgName)
	{
		createSymbol.click();
		accountnameedt.sendKeys(newOrgName);
		
		saveOrg.click();
		
		
	}
	
	
	
}
