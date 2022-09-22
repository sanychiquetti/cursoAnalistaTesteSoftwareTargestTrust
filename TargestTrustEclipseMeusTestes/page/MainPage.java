package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

	public MainPage open() {
		getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
		return this;
	}

	public ArticlePage search(String country) {
		//textfield pesquisa - escrever no campo - o que está na pagina de teste.
		WebElement tfSearchInput = getDriver().findElement(By.id("searchInput"));
		tfSearchInput.sendKeys(country);
		//clicar no botão de lupa
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		//ira para a próxima página
		return new ArticlePage();
	}
}
