package com.crm.vtiger.objectrepositorylib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProduct {

	


	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="productname")
	private WebElement productName;

	
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")
	private WebElement saveCamp;
	
	public void createProduct(String proName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		createSymbol.click();
		productName.sendKeys(proName);
		saveCamp.click();
}
	
	
}
