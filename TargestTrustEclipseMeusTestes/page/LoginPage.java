package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage
{

	public LoginPage open()
	{
		getDriver().get("http://sahitest.com/demo/training/login.htm");
		return this;
	}

	public LoginPage enterUsername(String username) 
	{
		WebElement tfUserName = getDriver().findElement(By.name("user"));
		tfUserName.sendKeys(username);
		return this;		
	}

	public LoginPage enterPassword(String password)
	{
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(password);
		return this;
	}

	public LoginPage submitInvalid()
	{
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		return this;
		
	}

	public String getMessageError()
	{
		WebElement MessageError = getDriver().findElement(By.id("errorMessage"));
		return MessageError.getText();
	}
	
	public BooksPage submitValid() 
	{
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		return new BooksPage();
	}

}
