package com.guru99.testCases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99.base.BasePage;
import com.guru99.pages.LoginPage;
import com.guru99.utils.Constants;

public class LoginPageTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	
	@BeforeClass
	public void setUp() {
		
		 basepage = new BasePage();
		 prop = basepage.init_property();
		 driver = basepage.init_driver(prop);
		 loginpage = new LoginPage(driver);
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		String title=loginpage.loginPageTitle();
		System.out.println("Login Page Title:" + title);
		Assert.assertEquals(title, Constants.LoginPageTitle, "Login Page title is Correct");
	}
	
	@Test(priority=2)
	public void verifyLoginPageURL() {
		String url=loginpage.getLoginPageURL();
		System.out.println("Login Page URL::"+ url);
		Assert.assertEquals(url, Constants.LoginPageURL , "Login page URL is correct");
		
	}
	
	@Test(priority=3)
	public void VerifyLogin() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
		
	
}

