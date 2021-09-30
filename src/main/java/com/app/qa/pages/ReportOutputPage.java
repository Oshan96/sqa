package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

public class ReportOutputPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(@text,'Add to Dashboard')]")
	WebElement dashBoardLink;
	
	@FindBy(xpath = "//*[contains(@class,'reportNameEdit inputFieldWithPlaceholder')]")
	WebElement reportName;

	
	public ReportOutputPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyReportOutputPageTitle(){
		return driver.getTitle();
	}
	
	public void verfiyReportCreation() {
		dashBoardLink.click();
	}

}
