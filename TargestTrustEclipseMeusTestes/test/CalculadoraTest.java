package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;
import com.core.DriverFactory;

public class CalculadoraTest extends BaseTest 
{
	private WebElement valor1;
	private WebElement valor2;
	private WebElement total;

	@Before
	public void setUp() throws Exception
	{
	
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		valor1 = getDriver().findElement(By.id("number1"));
		valor2 = getDriver().findElement(By.id("number2"));
		total = getDriver().findElement(By.id("total"));
		
	}
	@Test
	public void testSoma() throws InterruptedException 
	{
		
		//interage com os valores
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		
		//mapeia o elemento somar 
		WebElement somar = getDriver().findElement(By.id("somar"));
		somar.click();
		
	    //Espera por um texto no textField estar presente
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.textToBePresentInElementValue(total, "13"));
		
		//validar resultado
		assertEquals("13", total.getAttribute("value"));
			
	}
	
	@Test
	public void testSubtração() throws InterruptedException 
	{
				
		//interage com o elemento
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		//mapeia o elemento subtrair 
		WebElement subtrair = getDriver().findElement(By.id("subtrair"));
		subtrair.click();
		
		//validar resultado
		assertEquals("-3", total.getAttribute("value"));	
	}	
	@Test
	public void testMultiplicação() throws InterruptedException
	{
		
		//interage com o elemento
		valor1.sendKeys("5");
		valor2.sendKeys("8");
		
		//mapeia o elemento subtrair 
		WebElement multiplicar = getDriver().findElement(By.id("multiplicar"));
		multiplicar.click();
		
		//validar resultado
		assertEquals("40", total.getAttribute("value"));			
	}	
	@Test
	public void testDividir() throws InterruptedException 
	{
		//interage com o elemento
		valor1.sendKeys("10");
		valor2.sendKeys("2");
		
		//mapeia o elemento subtrair 
		WebElement dividir = getDriver().findElement(By.id("dividir"));
		dividir.click();
		
		//validar resultado
		assertEquals("5", total.getAttribute("value"));			
	}
	@Test
	public void testLimpar() throws InterruptedException 
	{
		
		//interage com o elemento
		valor1.sendKeys("10");
		valor2.sendKeys("2");
		
		//mapeia o elemento subtrair 
		WebElement dividir = getDriver().findElement(By.id("dividir"));
		dividir.click();
				
		//validar resultado
		assertEquals("5", total.getAttribute("value"));
		
		//mapeia o elemento limpar a tela
		WebElement limpar = getDriver().findElement(By.id("limpar"));
		limpar.click();
		
		//validar se escreveu no elemento
				assertEquals("", valor1.getAttribute("value"));
				assertEquals("", valor2.getAttribute("value"));
				assertEquals("", total.getAttribute("value"));
			
	}
}
