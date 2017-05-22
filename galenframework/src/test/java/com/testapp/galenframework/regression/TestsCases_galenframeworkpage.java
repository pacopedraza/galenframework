package com.testapp.galenframework.regression;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testapp.galenframework.Base;
import com.testapp.galenframework.business.Index;

public class TestsCases_galenframeworkpage{
	 
	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception
	{
		 Base b = new Base();
		 driver = b.getDriver();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.quit();
	}
	
	/* This method will return two dimensional array
	   also, behaves as data provider for Login test. */
	@DataProvider(name="TestData")
	public Object[][] LoginCredentials(Method name)
	{
		Object[][] Cred = null;
		
		if(name.getName().equalsIgnoreCase("logincorrectUserandPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = "test123";
		}
		if(name.getName().equalsIgnoreCase("loginWrongUserandWrongPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser2@example.com";
			Cred[0][1] = "test1232";
		}
		if(name.getName().equalsIgnoreCase("loginEmptyUserandEmptyPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "";
			Cred[0][1] = "";
		}
		if(name.getName().equalsIgnoreCase("loginEmptyPasswordOnly"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = "";
		}
		
		if(name.getName().equalsIgnoreCase("loginEmptyUserdOnly"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "";
			Cred[0][1] = "test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginUserSpecialChar_CorrectPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "$#%@#%@#%$";
			Cred[0][1] = "test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginPassSpecialChar_CorrectUser"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = "@@@@@#@%@^&(*&(()_+{}PO";
		}
		
		if(name.getName().equalsIgnoreCase("loginCorrectUser_WrongPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = "test1234";
		}
		
		if(name.getName().equalsIgnoreCase("loginCorrectPass_WrongUser"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser10@example.com";
			Cred[0][1] = "test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginAlphanumerical_User"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "1234534645878797908";
			Cred[0][1] = "test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginAlphanumerical_Pass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = "0789545762651";
		}
		
		if(name.getName().equalsIgnoreCase("loginAlphanumerical_User_and_Pass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "14312412346y789";
			Cred[0][1] = "123456354787909";
		}
		
		if(name.getName().equalsIgnoreCase("loginBasic_SQLInjection"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "105 OR 1=1";
			Cred[0][1] = "105 OR 1=1";
		}
		
		if(name.getName().equalsIgnoreCase("loginBlankSpaceUser_CorrectUserandPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = " testuser@example.com";
			Cred[0][1] = "test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginBlankSpacePass_CorrectUserandPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "testuser@example.com";
			Cred[0][1] = " test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginBlankSpacePass_and_User_CorrectUserandPass"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = " testuser@example.com";
			Cred[0][1] = " test123";
		}
		
		if(name.getName().equalsIgnoreCase("loginBlankSpacesOnly"))
		{
			Cred = new Object[1][2];
			Cred[0][0] = "                      ";
			Cred[0][1] = "                      ";
		}
		
		return Cred;
	}
	
	// Below you will see the different test cases for Log In.
	@Test(dataProvider="TestData")
	public void logincorrectUserandPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp("testuser@example.com", "test123");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='my-notes-page']/h2")).isDisplayed());
		
	}
	
	@Test(dataProvider="TestData")
	public void loginWrongUserandWrongPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginEmptyUserandEmptyPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginEmptyPasswordOnly(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginEmptyUserdOnly(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginUserSpecialChar_CorrectPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginPassSpecialChar_CorrectUser(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginCorrectUser_WrongPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginCorrectPass_WrongUser(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginAlphanumerical_User(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginAlphanumerical_Pass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginAlphanumerical_User_and_Pass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginBasic_SQLInjection(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginBlankSpaceUser_CorrectUserandPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginBlankSpacePass_CorrectUserandPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginBlankSpacePass_and_User_CorrectUserandPass(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test(dataProvider="TestData")
	public void loginBlankSpacesOnly(String user, String password)
	{
		Index index = PageFactory.initElements(driver, Index.class);
		String url = "http://testapp.galenframework.com/";
		driver.get(url);
		driver.manage().window().maximize();
		index.welcomepage(".//*[@id='welcome-page']/p[3]/button");
		index.formFillUp(user, password);
		index.login(".//*[@id='login-page']/p[3]/button[1]");
		Assert.assertTrue(driver.findElement(By.id("login-error-message")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
}
