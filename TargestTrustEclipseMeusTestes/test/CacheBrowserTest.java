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

import com.core.BaseTest;
import com.core.DriverFactory;

public class CacheBrowserTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao");
	}

	@Test
	public void testNavigationCache() {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement menuCalculadora = getDriver().findElement(By.linkText("Calculadora"));
		menuCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement menuTable = getDriver().findElement(By.linkText("Localizar Table"));
		menuTable.click();		
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		
	}

}
