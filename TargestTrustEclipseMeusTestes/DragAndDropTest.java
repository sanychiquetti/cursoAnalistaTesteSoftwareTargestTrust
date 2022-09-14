package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.BaseTest;

public class DragAndDropTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
	
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@Test 
	public void testValidateDragAndDrop() {
			WebElement oring = getDriver().findElement(By.id("draggable"));
		
			WebElement destiny = getDriver().findElement(By.id("droppable"));
			
			new Actions(getDriver()).dragAndDrop(oring, destiny).perform();
			assertEquals("Dropped!", destiny.getText());	
	}
}
