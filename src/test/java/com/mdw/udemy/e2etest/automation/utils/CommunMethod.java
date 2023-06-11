package com.mdw.udemy.e2etest.automation.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class CommunMethod {
	public static WebDriver driver;
	public static Properties prop; 
	public CommunMethod() {
		driver = Setup.driver;
	}
	public void openUrlWithConfigFile(String url)throws IOException 
		{  
			prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
        prop.load(fis);
        driver.get(prop.getProperty(url));
	}
	
}


