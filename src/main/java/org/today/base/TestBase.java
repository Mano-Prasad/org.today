package org.today.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.today.utilities.Utility;

public class TestBase {


	public static WebDriver driver;
	File f;
	FileInputStream fis;
	public Properties pro;
	
	public TestBase() throws IOException {
		
		f = new File(".\\src\\main\\java\\org\\today\\configure\\config.properties");
		fis = new FileInputStream(f);
		pro = new Properties();
		pro.load(fis);
	}
	
	
	public void initBrowser() {
		String browser = pro.getProperty("browserName");
		System.out.println(browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 	
		
		driver.get(pro.getProperty("appurl"));
		Utility.winMax();
		Utility.implicitlyWait(30);
	}
	
	
	public static void main(String[] args) throws IOException {
		new TestBase().initBrowser();
	}
	
}
