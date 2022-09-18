package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.core.BaseTest;

public class WebElementsTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}
	@Test	
	public void testValidateNameTextField() throws InterruptedException {
			//mapeia o elemento
			WebElement textFieldName = getDriver().findElement(By.name("txtbox1"));
			
			Thread.sleep(3000);
			//faz a interação com o elemento
			textFieldName.sendKeys("Sany Chiquetti");
			
			Thread.sleep(3000);
			//valida o resultado
			assertEquals("Sany Chiquetti", textFieldName.getAttribute("value"));
		
	}
	
	@Test 
	public void testValidadeEnableTexFields() {
		   WebElement tfBox1 = getDriver().findElement(By.name("txtbox1"));
		   WebElement tfBox2 = getDriver().findElement(By.name("txtbox2"));
		
		   assertTrue(tfBox1.isEnabled());
		   assertFalse(tfBox2.isEnabled());
	}
	
	@Ignore("Bug reportado no jira cod 456123")
	@Test 
	public void testValidateRadioGroup1() throws InterruptedException {
		
		List<WebElement> listRadio = getDriver().findElements(By.name("radioGroup1"));
		listRadio.get(2).click();
		
		Thread.sleep(5000);
		
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertTrue(listRadio.get(2).isSelected());
		assertFalse(listRadio.get(3).isSelected());
		
	}
	
	@Test 
	public void testValidateCheckBox() throws InterruptedException {
		List<WebElement> listCheck = getDriver().findElements(By.name("chkbox"));
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
		WebElement drop = getDriver().findElement(By.name("dropdownlist"));
		Select selDrop = new Select(drop);
		
		selDrop.selectByValue("item5");
		selDrop.selectByValue("item4");
		
		assertEquals("Item 4", selDrop.getFirstSelectedOption().getText());
		
		selDrop.selectByValue("item7");
		
		assertEquals("Item 7", selDrop.getFirstSelectedOption().getText());
		
	}
	
	@Test 
	public void testValidateSelectMulti() throws InterruptedException {
		WebElement dropMulti = getDriver().findElement(By.name("multiselectdropdown"));
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
		getDriver().switchTo().frame("frame1");
	
		//mapeia o elemento
		WebElement tfiFrame = getDriver().findElement(By.id("tfiframe"));
	
		//realiza a ação com o elemento 
	
		tfiFrame.sendKeys("Teste do iframe");
		Thread.sleep(3000);
	
		//valida se o texto inserido é o texto que está no componente
		assertEquals("Teste do iframe", tfiFrame.getAttribute("value"));
	
		//retorna o getDriver() para a página principal
		getDriver().switchTo().defaultContent();
	
	}
	
	@Test
	
	public void testAlert() throws InterruptedException {
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();
		
		//captura o alert que está na tela
		Alert alert = getDriver().switchTo().alert();
		
		//valida o texto do alert
		assertEquals("Eu sou um alerta!", alert.getText());
		
		Thread.sleep(2500);
		
		// clicar no ok do alert
		alert.accept();		
	}
	
}
