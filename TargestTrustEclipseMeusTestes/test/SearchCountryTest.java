package com.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.core.BaseTest;
import com.page.ArticlePage;
import com.page.MainPage;

//parametrizando o teste
@RunWith(Parameterized.class) 
public class SearchCountryTest extends BaseTest {
		private MainPage mainPage;
		private ArticlePage articlePage;
		//criou variavél para varios nomes
		private String searchCountry; 
		private String expectedCountry; 
		
		//Construtor da classe com os dois parâmetros criados acima
		public SearchCountryTest(String searchCountry, String expectedCountry)
		{
			this.searchCountry = searchCountry;
			this.expectedCountry = expectedCountry;
		}
		
	@Test 
	public void testSearchCountry(){
		mainPage = new MainPage();
		mainPage.open();
		articlePage = mainPage.search(searchCountry);		
		assertEquals(expectedCountry, articlePage.geth1Text());
	
	}
	@Parameters
	public static Collection<Object[]> dataCountries(){
		return Arrays.asList(new Object[][] {
			{"India", "India" },
			{"Brazil", "Brazil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}
		});
		
		}
}
