package com.crm.vtiger.objectrepositorylib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.GenericLib.BaseClass;

public class Logout extends BaseClass{
	
	
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement LogoutImg;
	
	
	public void LogoutFromApp()
	{

		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(LogoutImg).perform();
	SignOutLink.click();
		
	}
	

}
