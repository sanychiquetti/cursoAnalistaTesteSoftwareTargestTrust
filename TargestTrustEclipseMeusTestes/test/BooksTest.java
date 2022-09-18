package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;
import com.core.DriverFactory;
import com.page.BooksPage;
import com.page.LoginPage;

public class BooksTest extends BaseTest
{
	
	private LoginPage loginPage;
	private BooksPage booksPage;
	
	@Test
	public void tesBooksPage() 
	{
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.enterUsername("test");
		loginPage.enterPassword("secret");
		booksPage = loginPage.submitValid();
		
		WebElement qtdCore = getDriver().findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[2]/td[4]/input"));
		qtdCore.sendKeys("2");
		
		WebElement qtdRuby = getDriver().findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[3]/td[4]/input"));
		qtdRuby.sendKeys("1");
		
		WebElement qtdPton = getDriver().findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[4]/td[4]/input"));
		qtdPton.sendKeys("2");
		
		WebElement btnAdd = getDriver().findElement(By.xpath("//*[@id=\"available\"]/input[1]"));
		btnAdd.click();
		
		WebElement total = getDriver().findElement(By.xpath("//*[@id=\"total\"]"));
		assertEquals("1500", total.getAttribute("value"));
	 }

}
