package com.app.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super(); // calling super class constructor
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(); // defined in TestBase
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	//@Test(priority=2)
	//public void LogoImageTest(){
		//boolean flag = loginPage.validateLogoImage();
		//Assert.assertTrue(flag);
	//}
	
	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  //defined inside config properties
	}
	
	@Test(priority=3)
	public void invalidUsernameTest(){
		loginPage.invalidLogin("abc",prop.getProperty("password"));  // invalid username valid password
	}
	
	@Test(priority=4)
	public void invalidPasswordTest(){
		loginPage.invalidLogin(prop.getProperty("username"),"admin");  // invalid password valid password
	}
	
	@Test(priority=5)
	public void invalidLoginTest(){
		loginPage.invalidLogin("abc","xyz");  // invalid username and invalid password
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
