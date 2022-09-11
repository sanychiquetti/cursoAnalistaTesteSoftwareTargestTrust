package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionTest {
	public WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testValidateCpfWithDot() {
		WebElement cbPontos = driver.findElement(By.id("cbPontos"));
		cbPontos.click();
	
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
	
		WebElement tfCpf = driver.findElement(By.id("numero"));
				
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));
			
	}
	

	@Test
	public void testValidateCpfWithoutDot() {
	
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
	
		WebElement tfCpf = driver.findElement(By.id("numero"));
				
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{11}$"));
			
	}

}
