package com.testapp.galenframework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testapp.galenframework.Base;

public class Index_ extends Base{
	public WebDriver driver;
	public Index_(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy public By clicks = By.xpath(".//*[@id='welcome-page']/p[3]/button");
	public WebElement getclicks()
	{
		return driver.findElement(clicks);
	}
	
	@FindBy public By username = By.xpath(".//*[@id='login-page']/p[1]/input");
	public WebElement getusername()
	{
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='login-page']/p[1]/input")));
		return driver.findElement(username);
	}
	
	@FindBy public By psw = By.xpath(".//*[@id='login-page']/p[2]/input");
	public WebElement getpsw()
	{
		return driver.findElement(psw);
	}
	
	@FindBy public By click_login = By.xpath(".//*[@id='login-page']/p[3]/button[1]");
	public WebElement getclick_login()
	{
		return driver.findElement(click_login);
	}
	

}
