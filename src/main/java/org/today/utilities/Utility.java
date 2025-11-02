package org.today.utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.today.base.TestBase;

public class Utility extends TestBase {

	public Utility() throws IOException {
		super();
	}

	// 1. Window Maximize 
	public static void winMax() {
		driver.manage().window().maximize();
	}
	
	public static void winMin() {
		driver.manage().window().minimize();
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	} 
	

	public static void back() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}
	
	public static void to(String url) {
		driver.navigate().to(url);
	}
	
	public static void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public static String alertGetText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public static void alertSendKeys(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	
	public static void windowClose() {
		driver.close();
	}
	
	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
}
