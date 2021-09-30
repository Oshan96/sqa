package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//a[contains(@class,'userProfileLink username')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(@class,'content users')]")
	WebElement usersLink;
	
	@FindBy(id = "addTaskButtonId")
	WebElement addTaskButton;
	

	@FindBy(xpath = "//a[contains(@class,'content report')]")
	WebElement reportsLink;
	
	@FindBy(xpath = "//*[contains(@class,'emptySelection')]")
	WebElement customerBox;

	//@FindBy(xpath = "//*[contains(text,'selectedItem')]")
	//WebElement customerBox;

	//@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	//WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public UsersPage clickOnUsersLink(){
		usersLink.click();
		return new UsersPage();
	}
	
	public ReportsPage clickOnReportsLink(){
		reportsLink.click();
		return new ReportsPage();
	}
	
	//public TasksPage clickOnTasksLink(){
		//tasksLink.click();
		//return new TasksPage();
	//}
	
	public void clickOnaddTaskButton(){
		
		addTaskButton.click();
		
	}
	
	public void createNewTask(String customer, String project, String task){
		//Select select = new Select(department);
		//select.selectByVisibleText(dpt);
		
		//department.click();
		//prod.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'selectedItem')]")));
		driver.findElement(By.xpath("//*[contains(@class,'emptySelection')]")).sendKeys(customer);
		//customerBox.sendKeys(customer);
		//lastName.sendKeys(ltName);
		//Email.sendKeys(email);
		//saveBtn.click();
		
	}
	
	public void clickOnNewTaskLink(){
		Actions action = new Actions(driver);
		action.moveToElement(addTaskButton).build().perform();
		addTaskButton.click();
		
	}

}
