package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;
import com.core.DriverFactory;

public class RegularExpression2Test extends BaseTest {

	@Before
	public void setUp() throws Exception {
		getDriver().get("https://www.4devs.com.br/gerador_de_cnpj");
	}
	
	@Test
	public void testValidateCnpjWithDot() throws InterruptedException {
				
		WebElement btnGerar = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement tfGerado = getDriver().findElement(By.id("texto_cnpj"));
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("text_cnpj"), "Gerando..."));
		
		String cnpjGerado = tfGerado.getText();
	    System.out.println(cnpjGerado);
	    	    
		assertTrue(cnpjGerado.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}$"));
		 
	 }

	@Test
	public void testValidateCnpjWithoutDot() throws InterruptedException {
		
		WebElement btcheckNo = getDriver().findElement(By.id("pontuacao_nao")); 
		btcheckNo.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		Thread.sleep(2000);
		WebElement tfGerado = getDriver().findElement(By.id("texto_cnpj"));
		
		String cnpjGerado = tfGerado.getText();
		
	    System.out.println(cnpjGerado);
	    	    
	    assertTrue(cnpjGerado.matches("^[0-9]{14}$"));
		 
	 }
}
