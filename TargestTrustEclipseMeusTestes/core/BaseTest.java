package com.core;

import org.junit.After;

public abstract class BaseTest {
	//Executa este método após cada teste
	@After
	public void tearDown() {
		DriverFactory.killDriver();		
	}
}