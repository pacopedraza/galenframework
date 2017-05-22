package com.testapp.galenframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver = null;
	public WebDriver getDriver()
	{
		driver = new ChromeDriver();
		return driver;
	}

}
