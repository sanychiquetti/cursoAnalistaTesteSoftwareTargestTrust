package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
	
	public String geth1Text() {
		//elemento da pagina 
		WebElement titleH1 = getDriver().findElement(By.xpath("//h1[@id='firstHeading']/span"));
		
		return titleH1.getText();
		
	}
	
}
