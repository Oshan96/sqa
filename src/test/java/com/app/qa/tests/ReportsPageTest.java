package com.app.qa.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.app.qa.base.TestBase;
import com.app.qa.pages.UsersPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.pages.ReportsPage;
import com.app.qa.util.TestUtil;


public class ReportsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	ReportsPage reportsPage;
	
	public ReportsPageTest(){
		super();
		
}


	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
	//testUtil.switchToFrame();
		reportsPage = homePage.clickOnReportsLink();
	}


	@Test(priority=1)
	public void verifyCreateNewReport(){
		reportsPage.clickOnNewReportLink();
		reportsPage.createNewReport(); 
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
