package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.DriverFactory;

public class BooksPage 
{

	public String getTextTitle() 
	{
		WebElement label = getDriver().findElement(By.xpath("//div[@id=\'available\']/h2"));
		return label.getText();
	}

}
