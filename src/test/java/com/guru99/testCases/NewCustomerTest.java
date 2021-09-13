package com.guru99.testCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.base.BasePage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.utils.ExcelUtils;

public class NewCustomerTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	NewCustomerPage newcustomerpage;

	
	@BeforeClass
	public void setUp() {
		
		 basepage = new BasePage();
		 prop = basepage.init_property();
		 driver = basepage.init_driver(prop);
		 loginpage = new LoginPage(driver);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 newcustomerpage =  homepage.clickNewCustomer();
	}
	
	
	@Test
	public void getTitle() {
		String title=newcustomerpage.NewAccountPageTitle();
		System.out.println(title);
	}
	
	
	@DataProvider
	public Object[][] getCustomerData() {
		Object[][] data=ExcelUtils.getTestData("Test Data");
		return data;
	}

	@Test(dataProvider ="getCustomerData")
	public void testCustomerCreationPage(String name, String DOB, String Address, String City, String State, String Pin, 
			String MobileNumber, String Email, String Password) {
		
		newcustomerpage.enterCustomerData(name, DOB, Address, City, State, Pin, MobileNumber, Email, Password);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
