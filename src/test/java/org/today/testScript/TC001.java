package org.today.testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.today.base.TestBase;
import org.today.pages.LoginPage;
import org.today.utilities.Utility;

public class TC001 extends TestBase {

	public TC001() throws IOException {
		super();
	}

	LoginPage lp;
	
	@BeforeTest
	public void setUp() throws IOException {
		initBrowser();
		lp = new LoginPage();
	}
	
	@AfterTest
	public void tearDown()
	{
		Utility.windowClose();
	}	
	
	@Test(priority = 1)
	public void validateTitle() {
		String title = lp.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority = 2)
	public void validateUrl() {
		String url = lp.getUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/v1/index.html");
	}
	
	@Test(priority = 3)
	public void validateLogin() {
	String verifyLogin = lp.verifyLogin();
	Assert.assertEquals(verifyLogin, "Swag Labs");
	}
	
	
	
	
	
}
