package com.crm.vtiger.testscript;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.FileUtils;

@Listeners (com.crm.GenericLib.Sample_Listner.class)
public class FailedTestCase extends BaseClass {

	@Test
	public static void create_ProductTest() throws IOException, EncryptedDocumentException, InvalidFormatException {		
		FileUtils foo= new FileUtils();
		String proNAme=foo.getExcelData("sheet1", 3, 2);
        driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname1")).sendKeys(proNAme);
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
	}
}
