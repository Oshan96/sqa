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
import com.app.qa.util.TestUtil;

public class UserPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	
	String sheetName = "contacts";
	
	   
	public UserPageTest(){
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
		usersPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority=1)
	public void verifyworkLabel(){
		Assert.assertTrue(usersPage.verifyworkLabel(), "departments label is missing on the page");
	}
	
	//@Test(priority=2)
	//public void selectSingleContactsTest(){
		//contactsPage.selectContactsByName("test2 test2");
	//}
	
	//@Test(priority=3)
	//public void selectMultipleContactsTest(){
		//contactsPage.selectContactsByName("test2 test2");
		//contactsPage.selectContactsByName("ui uiii");

	//}
	
	//@DataProvider
	//public Object[][] getCRMTestData(){
		//Object data[][] = TestUtil.getTestData(sheetName);
		//return data;
	//}
	
	
	@Test(priority=2)
	public void validateCreateNewUser(){
		usersPage.clickOnNewUserLink();
		usersPage.createNewUser("Tom", "Peter", "abc@gmail.com");
		//contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
