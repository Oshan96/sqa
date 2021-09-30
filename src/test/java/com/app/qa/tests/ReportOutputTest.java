package com.app.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.UsersPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.ReportsPage;
import com.app.qa.pages.LoginPage;

import com.app.qa.pages.ReportOutputPage;

import com.app.qa.util.TestUtil;


public class ReportOutputTest extends TestBase {
	
	ReportOutputPage reportOutputPage;
	ReportsPage reportsPage;
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	
	public ReportOutputTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reportsPage = homePage.clickOnReportsLink();
		reportsPage.clickOnNewReportLink();
		reportOutputPage = reportsPage.createNewReport();
	}
	
	@Test(priority=1)
	public void verifyReportOutputPageTitle(){
		String reportOutputPageTitle = reportOutputPage.verifyReportOutputPageTitle();
		Assert.assertEquals(reportOutputPageTitle, "actiTIME - Staff Performance Report","Report Output page title not matched");
	}
	
	@Test(priority=2)
	public void verifycreatedReport(){
		reportOutputPage.verfiyReportCreation();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
