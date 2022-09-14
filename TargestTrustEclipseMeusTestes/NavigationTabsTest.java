package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.BaseTest;
import com.core.DriverFactory;

public class NavigationTabsTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/index.html");
	}

	@Test
	public void testNavigationTabs() {
		
		//valida o titulo da página
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		//mapeia o elemento 
		WebElement linkGcpf = getDriver().findElement(By.linkText("Gerador de CPF"));
		linkGcpf.click();
		
		//cria um arraylist com as tabs abertas
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		//navega o foco do drive para a tab que se deseja interagir
		getDriver().switchTo().window(tabs.get(1));
		
		//valida o titulo da npva pagina numa nova tab
		assertEquals ("Gerador de CPF", getDriver().getTitle());
		
		//volto para a tela anterior
		getDriver().switchTo().window(tabs.get(0));
		assertEquals ("Treino Automação de Testes", getDriver().getTitle());		
	}

}
