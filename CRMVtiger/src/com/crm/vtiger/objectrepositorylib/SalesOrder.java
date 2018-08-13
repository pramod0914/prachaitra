package com.crm.vtiger.objectrepositorylib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.GenericLib.BaseClass;

public class SalesOrder {
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	@FindBy(name="subject")
	private WebElement orderNameEdt;

	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookup;
	

	@FindBy(name="bill_street")
	private WebElement billstreetEdt;
	

	@FindBy(name="ship_street")
	private WebElement shipstreetEdt;
	
	
	@FindBy(id="searchIcon1")
	private WebElement itemLookup;
	
	
	@FindBy(id="qty1")
	private WebElement quantity;
	
	
	
	public void createSalesOrder(String ordereName,String newOrgName,String billAddress, String shippingAddress,String proName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	
		createSymbol.click();	
		orderNameEdt.sendKeys(ordereName);
		orgLookup.click();
		Set<String> set6=BaseClass.driver.getWindowHandles();
		Iterator<String> i6= set6.iterator();
		String pID6=i6.next();
		String cID6=i6.next();
		BaseClass.driver.switchTo().window(cID6);
		BaseClass.driver.findElement(By.linkText(newOrgName)).click();
		Alert alt1=BaseClass.driver.switchTo().alert();
		alt1.accept();
		BaseClass.driver.switchTo().window(pID6);
		billstreetEdt.sendKeys(billAddress);
		billstreetEdt.sendKeys(shippingAddress);
		itemLookup.click();
		Set<String> set7=BaseClass.driver.getWindowHandles();
		Iterator<String> i7=set7.iterator();
		String pid7=i7.next();
		String cid7=i7.next();
		BaseClass.driver.switchTo().window(cid7);
		BaseClass.driver.findElement(By.linkText(proName)).click();
		BaseClass.driver.switchTo().window(pid7);
		quantity.sendKeys("2");
		saveCamp.click();

}

}