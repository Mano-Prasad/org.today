package org.today.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.today.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	public WebElement input_username_textbox;
	
	@FindBy(id = "password")
	public WebElement input_password_textbox;
	
	@FindBy(id ="login-button")
	public WebElement login_button;

	@FindBy(xpath ="//button[text()='Open Menu']")
	public WebElement button_openmenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement a_logout;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
      return driver.getCurrentUrl();	
}

	public String verifyLogin() {
		input_username_textbox.sendKeys(pro.getProperty("userName"));
		input_password_textbox.sendKeys(pro.getProperty("password"));
		login_button.click();
		String title = getTitle();
		button_openmenu.click();
		a_logout.click();
		return title;
	}
	
	
}