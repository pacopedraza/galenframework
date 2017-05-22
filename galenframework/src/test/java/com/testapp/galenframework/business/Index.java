
package com.testapp.galenframework.business;

import org.openqa.selenium.WebDriver;

import com.testapp.galenframework.page.Index_;

public class Index extends Index_{

	public Index(WebDriver driver) {
		super(driver);
	}
	
	public void welcomepage(String loginButtonId)
	{
		getclicks().click();
	}
	public void formFillUp(String username, String psw)
	{
		getusername().clear();
		getusername().sendKeys(username);
		getpsw().clear();
		getpsw().sendKeys(psw);
	}
	public void login(String loginButtonId)
	{
		getclick_login().click();
	}
}
