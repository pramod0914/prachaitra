package com.crm.vtiger.testscript;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.FileUtils;
import com.crm.vtiger.objectrepositorylib.CreateCampPage;
import com.crm.vtiger.objectrepositorylib.CreateContacts;
import com.crm.vtiger.objectrepositorylib.CreateInvoice;
import com.crm.vtiger.objectrepositorylib.CreateLeads;
import com.crm.vtiger.objectrepositorylib.CreateOpportunities;
import com.crm.vtiger.objectrepositorylib.CreateOrganization;
import com.crm.vtiger.objectrepositorylib.CreateProduct;
import com.crm.vtiger.objectrepositorylib.CreateQuotes;
import com.crm.vtiger.objectrepositorylib.HomePage;
import com.crm.vtiger.objectrepositorylib.SalesOrder;

public class Create_Accepted_Quote extends BaseClass {
	@Test
	public void createAcceptedQuote() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		FileUtils flib=new FileUtils();
		Random randomNum = new Random();
		int rString = randomNum.nextInt(100);
		String orgName=flib.getExcelData("sheet1", 0, 2);
		String newOrgName= (orgName+rString);
		
		//create product
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.navigateToProductsPage();
		CreateProduct crproduct= PageFactory.initElements(driver, CreateProduct.class);
		String proName=flib.getExcelData("sheet1", 3, 2);
		home.navigateToProductsPage();
		crproduct.createProduct(proName);
		
		//creating organization
		home.navigateToOrganizationsPage();
		CreateOrganization org=PageFactory.initElements(driver, CreateOrganization.class);
		org.createOrganization(newOrgName);
		
		
		//creating campaign
		home.goToMoreLink();
		home.navigateToCampaigns();
		String campName=flib.getExcelData("sheet1", 2, 2);	
		CreateCampPage createCamp= PageFactory.initElements(driver, CreateCampPage.class);
		createCamp.createCampaign(campName);
		
		
		
		//creating contacts
		String contact=flib.getExcelData("sheet1", 4, 2);
		home.navigateToContactsPage();
		CreateContacts con=PageFactory.initElements(driver, CreateContacts.class);
		con.createContacts(contact,newOrgName);
		
		
		//create leads
		String leadfrst=flib.getExcelData("sheet1", 5, 2);
		String leadLast=flib.getExcelData("sheet1", 5, 3);
		String compName=flib.getExcelData("sheet1", 5, 4);
		home.navigateToLeadPage();
		CreateLeads lead=PageFactory.initElements(driver, CreateLeads.class);
		lead.createLeads(leadfrst,leadLast,compName);
		
		
		//creating opportunity
	String oppName=flib.getExcelData("sheet1", 6,2);
	home.navigateToOpportunitiesPage();
	CreateOpportunities opp=PageFactory.initElements(driver, CreateOpportunities.class);
	opp.createOpportunities(oppName,contact);
	
	//create Quotes
	home.goToMoreLink();
	home.navigateToQuotesPage();
	String quoteName=flib.getExcelData("sheet1", 7, 2);
	String billAddress=flib.getExcelData("sheet1", 7, 3);
	String shippingAddress=flib.getExcelData("sheet1", 7, 4);
	CreateQuotes quote=PageFactory.initElements(driver, CreateQuotes.class);
	quote.createQuotes(quoteName,proName,billAddress,shippingAddress);
	
	//create sales order
	home.goToMoreLink();
	home.navigateToSalesOrderPage();
	String ordereName=flib.getExcelData("sheet1", 8, 2);
	SalesOrder SO=PageFactory.initElements(driver, SalesOrder.class);
	SO.createSalesOrder(ordereName,newOrgName,billAddress,shippingAddress,proName);
	
	//create invoice
	home.goToMoreLink();
	home.navigateToInvoicePage();
	CreateInvoice crInvoice=PageFactory.initElements(driver, CreateInvoice.class);
	String invoiceName=flib.getExcelData("sheet1", 9, 2);
	crInvoice.createInvoice(invoiceName,newOrgName,proName,billAddress,shippingAddress);
	}

}
