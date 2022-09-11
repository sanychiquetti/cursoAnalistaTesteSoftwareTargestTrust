package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpression2Test {
	public WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://www.4devs.com.br/gerador_de_cnpj");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidateCnphWithDot() throws InterruptedException {
		
		Thread.sleep(12000);
		
		WebElement btnGerar = driver.findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		Thread.sleep(1000);
		WebElement tfGerado = driver.findElement(By.id("texto_cnpj"));
		
		String cnpjGerado = tfGerado.getText();
		
	    System.out.println(cnpjGerado);
	    	    
		assertTrue(cnpjGerado.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}$"));
		 
	 }

	@Test
	public void testValidateCnphWithoutDot() throws InterruptedException {
		
		Thread.sleep(9000);
		
		WebElement btcheck = driver.findElement(By.id("pontuacao_nao")); 
		btcheck.click();
		
		WebElement btnGerar = driver.findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		Thread.sleep(1000);
		WebElement tfGerado = driver.findElement(By.id("texto_cnpj"));
		
		String cnpjGerado = tfGerado.getText();
		
	    System.out.println(cnpjGerado);
	    	    
	    assertTrue(cnpjGerado.matches("^[0-9]{14}$"));
		 
	 }
}
