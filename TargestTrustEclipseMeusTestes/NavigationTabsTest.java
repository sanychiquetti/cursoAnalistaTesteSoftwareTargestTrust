package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTabsTest {
	public WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/index.html");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testNavigationTabs() {
		
		//valida o titulo da página
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		//mapeia o elemento 
		WebElement linkGcpf = driver.findElement(By.linkText("Gerador de CPF"));
		linkGcpf.click();
		
		//cria um arraylist com as tabs abertas
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		//navega o foco do drive para a tab que se deseja interagir
		driver.switchTo().window(tabs.get(1));
		
		//valida o titulo da npva pagina numa nova tab
		assertEquals ("Gerador de CPF", driver.getTitle());
		
		//volto para a tela anterior
		driver.switchTo().window(tabs.get(0));
		assertEquals ("Treino Automação de Testes", driver.getTitle());		
	}

}
