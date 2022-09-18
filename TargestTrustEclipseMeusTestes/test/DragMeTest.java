package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.core.BaseTest;
import com.core.DriverFactory;

public class DragMeTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
		
		getDriver().get("http://sahitest.com/demo/dragDropMooTools.htm");
	}
	@Test 
	public void testValidateDragMe() {
		
		    WebElement source = getDriver().findElement(By.id("dragger"));		    
			WebElement item1= getDriver().findElement(By.cssSelector("body > div:nth-child(4)"));		
			WebElement item4 = getDriver().findElement(By.cssSelector("body > div:nth-child(7)"));
			
			assertEquals("Item 1", item1.getText());
			assertEquals("Item 4", item4.getText());
			
			new Actions(getDriver()).dragAndDrop(source, item1).perform();
			assertEquals("dropped", item1.getText());	
			
			new Actions(getDriver()).dragAndDrop(source, item4).perform();
			assertEquals("dropped", item4.getText());	
}
	
}
