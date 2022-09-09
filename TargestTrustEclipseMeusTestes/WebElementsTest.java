package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsTest {
	public WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marel-Not\\Downloads\\PROGRAMAS_SOFTWARE\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test	
	public void testValidateNameTextField() throws InterruptedException {
			//mapeia o elemento
			WebElement textFieldName = driver.findElement(By.name("txtbox1"));
			
			Thread.sleep(3000);
			//faz a interação com o elemento
			textFieldName.sendKeys("Sany Chiquetti");
			
			Thread.sleep(3000);
			//valida o resultado
			assertEquals("Sany Chiquetti", textFieldName.getAttribute("value"));
		
	}
	
	@Test 
	public void testValidadeEnableTexFields() {
		   WebElement tfBox1 = driver.findElement(By.name("txtbox1"));
		   WebElement tfBox2 = driver.findElement(By.name("txtbox2"));
		
		   assertTrue(tfBox1.isEnabled());
		   assertFalse(tfBox2.isEnabled());
	}
	
	@Ignore("Bug reportado no jira cod 456123")
	@Test 
	public void testValidateRadioGroup1() throws InterruptedException {
		
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));
		listRadio.get(2).click();
		
		Thread.sleep(5000);
		
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertTrue(listRadio.get(2).isSelected());
		assertFalse(listRadio.get(3).isSelected());
		
	}
	
	@Test 
	public void testValidateCheckBox() throws InterruptedException {
		List<WebElement> listCheck = driver.findElements(By.name("chkbox"));
		for (WebElement el : listCheck) {
			System.out.println(el.getAttribute("value"));
			
			Thread.sleep(2000);
			
			if ((el.getAttribute("value").equals("Check 3")) || (el.getAttribute("value").equals("Check 4"))) {
				el.click();
			}
					
		}
		
		assertFalse(listCheck.get(0).isSelected());
		assertFalse(listCheck.get(1).isSelected());
		assertTrue(listCheck.get(2).isSelected());
		assertTrue(listCheck.get(3).isSelected());
		
	}
	
	@Test 
	public void testValidateSelectSingle() throws InterruptedException {
		WebElement drop = driver.findElement(By.name("dropdownlist"));
		Select selDrop = new Select(drop);
		
		selDrop.selectByValue("item5");
		selDrop.selectByValue("item4");
		
		assertEquals("Item 4", selDrop.getFirstSelectedOption().getText());
		
		selDrop.selectByValue("item7");
		
		assertEquals("Item 7", selDrop.getFirstSelectedOption().getText());
		
	}
	
	@Test 
	public void testValidateSelectMulti() throws InterruptedException {
		WebElement dropMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selMulti = new Select(dropMulti);
		
		selMulti.selectByVisibleText("Item 5");
		selMulti.selectByVisibleText("Item 8");
		selMulti.selectByVisibleText("Item 9");
				
		Thread.sleep(3000);
		
		List<WebElement> listOptions = selMulti.getAllSelectedOptions();
		assertEquals(3, listOptions.size());
		
		assertEquals("Item 5", listOptions.get(0).getText());
		assertEquals("Item 8", listOptions.get(1).getText());
		assertEquals("Item 9", listOptions.get(2).getText());
		
		selMulti.deselectByVisibleText("Item 8");
		
		Thread.sleep(3000);
		
		listOptions = selMulti.getAllSelectedOptions();
		assertEquals(2, listOptions.size());
		
		assertEquals("Item 5", listOptions.get(0).getText());
		assertEquals("Item 9", listOptions.get(1).getText());
		
		
	}
	
	@Test 
	public void testValidadeIframe() throws InterruptedException {
	
		//entra no iframe
		driver.switchTo().frame("frame1");
	
		//mapeia o elemento
		WebElement tfiFrame = driver.findElement(By.id("tfiframe"));
	
		//realiza a ação com o elemento 
	
		tfiFrame.sendKeys("Teste do iframe");
		Thread.sleep(3000);
	
		//valida se o texto inserido é o texto que está no componente
		assertEquals("Teste do iframe", tfiFrame.getAttribute("value"));
	
		//retorna o driver para a página principal
		driver.switchTo().defaultContent();
	
	}
	
	@Test
	
	public void testAlert() throws InterruptedException {
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		//captura o alert que está na tela
		Alert alert = driver.switchTo().alert();
		
		//valida o texto do alert
		assertEquals("Eu sou um alerta!", alert.getText());
		
		Thread.sleep(2500);
		
		// clicar no ok do alert
		alert.accept();		
	}
	
}
