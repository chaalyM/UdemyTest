package com.mdw.udemy.e2etest.automation.utils;

import org.openqa.selenium.firefox.FirefoxDriver;



public class FireFoxDriverManager extends DriverManager {

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}
}
