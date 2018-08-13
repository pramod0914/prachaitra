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



public class CreateInvoice {
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createSymbol;
	
	@FindBy(name="subject")
	private WebElement invoiceOrder;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/input[@class='crmButton small save']")
	private WebElement saveCamp;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookup;
	
	@FindBy(id="searchIcon1")
	private WebElement itemSearchLookup;
	
	@FindBy(name="bill_street")
	private WebElement billAddress;
	
	@FindBy(name="ship_street")
	private WebElement shippingAddress;	
	
	@FindBy(id="qty1")
	private WebElement quantity;
	
	
	public void createInvoice(String invoiceName,String newOrgName , String proName,String billAddress,String shippingAddress ) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		createSymbol.click();	
		invoiceOrder.sendKeys(invoiceName);
		orgLookup.click();
		Set<String> set8=BaseClass.driver.getWindowHandles();
		Iterator<String> i8= set8.iterator();
		String pID8=i8.next();
		String cID8=i8.next();
		BaseClass.driver.switchTo().window(cID8);
		BaseClass.driver.findElement(By.linkText(newOrgName)).click();
		Alert alt2=BaseClass.driver.switchTo().alert();
		alt2.accept();
		BaseClass.driver.switchTo().window(pID8);
		itemSearchLookup.click();
		Set<String> set9=BaseClass.driver.getWindowHandles();
		Iterator<String> i9=set9.iterator();
		String pid9=i9.next();
		String cid9=i9.next();
		BaseClass.driver.switchTo().window(cid9);
		BaseClass.driver.findElement(By.linkText(proName)).click();
		BaseClass.driver.switchTo().window(pid9);
		quantity.sendKeys("2");
		saveCamp.click();

}
}
