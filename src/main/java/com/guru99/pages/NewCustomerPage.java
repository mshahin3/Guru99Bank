package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
	public WebDriver driver;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Cname=By.name("name");
	By Cgender=By.name("rad1");
	By Cdob=By.name("dob");
	By Caddress=By.name("addr");
	By Ccity=By.name("city");
	By Cstate=By.name("state");
	By Cpin=By.name("pinno");
	By Cmobilenumber=By.name("telephoneno");
	By Cemailid=By.name("emailid");
	By Cpassword=By.name("password");
	By submitBtn = By.name("sub");
	By homebtn=By.xpath("//a[text()='Home']");
	By newCustomer =By.xpath("//a[text()='New Customer']");
	By successMsg=By.xpath("//p[@class='heading3']");
	
	public String NewAccountPageTitle() {
		return driver.getTitle();
	}
	
	public void enterCustomerData(String customername, String customerdob, String customeraddress, String customercity,
			String customerstate, String customerpin, String customermb, String customeremail, String customerpwd) {
		
		driver.findElement(Cname).sendKeys(customername);
		driver.findElement(Cgender).click();
		driver.findElement(Cdob).sendKeys(customerdob);
		driver.findElement(Caddress).sendKeys(customeraddress);
		driver.findElement(Ccity).sendKeys(customercity);
		driver.findElement(Cstate).sendKeys(customerstate);
		driver.findElement(Cpin).sendKeys(customerpin);
		driver.findElement(Cmobilenumber).sendKeys(customermb);
		driver.findElement(Cemailid).sendKeys(customeremail);
		driver.findElement(Cpassword).sendKeys(customerpwd);
		driver.findElement(submitBtn).click();
		String title=driver.findElement(successMsg).getText();
		
		System.out.println(title);
		
		driver.findElement(homebtn).click();
		driver.findElement(newCustomer).click();
		
		
		
		
	}
	
	
	
	

}
