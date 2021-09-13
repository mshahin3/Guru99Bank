package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.guru99.base.BasePage;

public class HomePage extends BasePage {
	public WebDriver driver;
	
	HomePage(WebDriver driver){
		this.driver=driver;				
	}
	
	By managerId = By.xpath("//tr[@class='heading3']/td");
	By homePageHeader = By.xpath("//*[@class='barone']");
	By welcomeMsg=By.xpath("//marquee[@class='heading3']");
	By newCustomer =By.xpath("//a[text()='New Customer']");
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public String getWelcomeMessage() {
		return driver.findElement(welcomeMsg).getText();
	}
	
	public String getHomePageHeader() {
		return driver.findElement(homePageHeader).getText();
	}
	
	public String getManagerID() {
		return driver.findElement(managerId).getText();
	}
	
	public NewCustomerPage clickNewCustomer() {
		driver.findElement(newCustomer).click();
		return new NewCustomerPage(driver);
	}
	
	
}
