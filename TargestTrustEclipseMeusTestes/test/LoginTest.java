package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.core.BaseTest;
import com.page.BooksPage;
import com.page.LoginPage;

public class LoginTest extends BaseTest
{
	
	private LoginPage loginPage;
	private BooksPage booksPage;
		
	@Test
	public void testPasswordInvalid() 
	{
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.enterUsername("test");
		loginPage.enterPassword("xptozaaa");
		loginPage.submitInvalid();
		
		assertEquals("Invalid username or password", loginPage.getMessageError());
		
	}
	
	@Test
	public void tesLoginValid() 
	{
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.enterUsername("test");
		loginPage.enterPassword("secret");
		booksPage = loginPage.submitValid();
		
		assertEquals("All available books", booksPage.getTextTitle());
		
	}

}
