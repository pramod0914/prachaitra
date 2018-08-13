package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.GenericLib.BaseClass;

public class HomePage {
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	public void goToMoreLink()
	{
		Actions act= new Actions(BaseClass.driver);
		act.moveToElement(moreLink).perform();
	}
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

	public void navigateToCampaigns() {
		campaignLink.click();
	}
	@FindBy(linkText="Leads")
	private WebElement leadLink;
		
public void navigateToLeadPage() {	
	leadLink.click();
	}
	
@FindBy(linkText="Organizations")
private WebElement OrganizationsLink;

public void navigateToOrganizationsPage() {
	OrganizationsLink.click();
	}
	
@FindBy(linkText="Contacts")
private WebElement ContactsLink;

public void navigateToContactsPage() {
		
	ContactsLink.click();
	}


@FindBy(linkText="Opportunities")
private WebElement OpportunitiesLink;

public void navigateToOpportunitiesPage() {
		
	OpportunitiesLink.click();
	}
@FindBy(linkText="Products")
private WebElement ProductsLink;

public void navigateToProductsPage() {
		
	OpportunitiesLink.click();
	}
@FindBy(linkText="Invoice")
private WebElement InvoiceLink;

public void navigateToInvoicePage() {
		
	InvoiceLink.click();
	}
@FindBy(linkText="Sales Order")
private WebElement SalesOrderLink;

public void navigateToSalesOrderPage() {
		
	OpportunitiesLink.click();
	}

@FindBy(linkText="Quotes")
private WebElement QuotesLink;

public void navigateToQuotesPage() {
		
	OpportunitiesLink.click();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}