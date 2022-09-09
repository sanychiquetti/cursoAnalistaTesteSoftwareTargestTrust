package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTest {
	private WebDriver driver;
	private WebElement valor1;
	private WebElement valor2;
	private WebElement total;

	@Before
	public void setUp() throws Exception {
		
		//C:\\driver\\chromedriver.exe
		System.setProperty("webdriver.chrome.driver",
						   "C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		valor1 = driver.findElement(By.id("number1"));
		valor2 = driver.findElement(By.id("number2"));
		total = driver.findElement(By.id("total"));
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSoma() throws InterruptedException {
		
		//interage com os valores
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		
		//mapeia o elemento somar 
		WebElement somar = driver.findElement(By.id("somar"));
		somar.click();
		
		Thread.sleep(3000);
		
		//validar resultado
		assertEquals("13", total.getAttribute("value"));
			
	}
	
	@Test
	public void testSubtração() throws InterruptedException {
				
		//interage com o elemento
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		
		//mapeia o elemento subtrair 
		WebElement subtrair = driver.findElement(By.id("subtrair"));
		subtrair.click();
		
		//validar resultado
		assertEquals("-3", total.getAttribute("value"));
			
	}
	
	@Test
	public void testMultiplicação() throws InterruptedException {
		
		//interage com o elemento
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		//mapeia o elemento subtrair 
		WebElement multiplicar = driver.findElement(By.id("multiplicar"));
		multiplicar.click();
		
		//validar resultado
		assertEquals("40", total.getAttribute("value"));
			
	}
	
	@Test
	public void testDividir() throws InterruptedException {
		//interage com o elemento
		valor1.sendKeys("10");
		valor2.sendKeys("2");
		
		//mapeia o elemento subtrair 
		WebElement dividir = driver.findElement(By.id("dividir"));
		dividir.click();
		
		//validar resultado
		assertEquals("5", total.getAttribute("value"));
			
	}

	@Test
	public void testLimpar() throws InterruptedException {
		
		//interage com o elemento
		valor1.sendKeys("10");
		valor2.sendKeys("2");
		
		//mapeia o elemento subtrair 
		WebElement dividir = driver.findElement(By.id("dividir"));
		dividir.click();
				
		//validar resultado
		assertEquals("5", total.getAttribute("value"));
		
		//mapeia o elemento limpar a tela
		WebElement limpar = driver.findElement(By.id("limpar"));
		limpar.click();
		
		//validar se escreveu no elemento
				assertEquals("", valor1.getAttribute("value"));
				assertEquals("", valor2.getAttribute("value"));
				assertEquals("", total.getAttribute("value"));
			
	}
}
