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

public class ReportsPage extends TestBase {
	
	//private static final FluentWait<WebDriver> wait = null;

	@FindBy(xpath = "//*[contains(@class,'graphicButton button createNewReportButton')]")
	WebElement NewReportButton;
	
	@FindBy(xpath = "//*[contains(@class,'staffButton reportButton pressed')]")
	WebElement type;
	
	@FindBy(xpath = "//*[contains(@class,'configureButton components_button')]")
	WebElement configure;
	
	@FindBy(xpath = "//*[contains(@class,'innerLabel')]")
	WebElement report;
	
	@FindBy(xpath = "//*[contains(@class,'addToDashboardIcon')]")
	WebElement dashBoardLink;
	
	@FindBy(xpath = "//*[contains(@class,'reportNameEdit inputFieldWithPlaceholder')]")
	WebElement reportName;
	
	
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewReportLink(){
		
		NewReportButton.click();
		
	}
	
	public ReportOutputPage createNewReport() {
		type.click();
		configure.click();
		report.click();
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'addToDashboard')]")));
		//driver.findElement(By.xpath("//*[contains(@class,'addToDashboard')]")).click();
		
		//dashBoardLink.click();
		//reportName.sendKeys("Test Report");
		return new ReportOutputPage();
		
	}
	
	//public void verifyReport() {
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'addToDashboard')]")));
		//driver.findElement(By.xpath("//*[contains(@class,'addToDashboard')]")).click();
		//dashBoardLink.click();
		//reportName.sendKeys("Test Report");
	//}

}
