package com.guru99.pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.guru99.base.BasePage;

public class LoginPage extends BasePage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;	
	}
	
	By userId = By.name("uid");
	By passWord= By.name("password");
	By loginBtn = By.name("btnLogin");
	By restBtn = By.name("btnReset");
	
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean RestButtonIsDisplayed() {
		return driver.findElement(restBtn).isDisplayed();
	}
	
	public HomePage doLogin(String Username, String pwd) {
		driver.findElement(userId).sendKeys(Username);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		return new HomePage(driver);
	}
	
	
	

}
