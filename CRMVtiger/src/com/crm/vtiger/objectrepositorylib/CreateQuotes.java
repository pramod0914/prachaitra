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
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLib.BaseClass;

public class CreateQuotes {
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookup;
	
	@FindBy(name="quotestage")
	private WebElement quotestageOpt;
	
	@FindBy(name="bill_street")
	private WebElement billAddressEdt;
	
	@FindBy(name="ship_street")
	private WebElement shippingAddressEdt;
	
	@FindBy(id="searchIcon1")
	private WebElement itemLookup;
	
	@FindBy(id="qty1")
	private WebElement quantity;
	
	public void createQuotes(String quoteName, String proName,String shippingAddress,String billAddress) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		createSymbol.click();	
		subjectEdt.sendKeys(quoteName);
		Select sel2=new Select(quotestageOpt);
		sel2.selectByVisibleText("Accepted");
		OrgLookup.click();
		Set<String> set3=BaseClass.driver.getWindowHandles();
		Iterator<String> i3= set3.iterator();
		String pID4=i3.next();
		String cID4=i3.next();
		BaseClass.driver.switchTo().window(cID4);
		BaseClass.driver.findElement(By.linkText(quoteName)).click();
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
		BaseClass.driver.switchTo().window(pID4);
		billAddressEdt.sendKeys(billAddress);
		shippingAddressEdt.sendKeys(shippingAddress);
		itemLookup.click();
		Set<String> set4=BaseClass.driver.getWindowHandles();
		Iterator<String> i5=set4.iterator();
		String pid5=i5.next();
		String cid5=i5.next();
		BaseClass.driver.switchTo().window(cid5);
		BaseClass.driver.findElement(By.linkText(proName)).click();
		BaseClass.driver.switchTo().window(pid5);
		quantity.sendKeys("2");	
		saveCamp.click();

}
	

}
