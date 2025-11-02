package org.today.testScript;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.today.base.TestBase;
import org.today.pages.LoginPage;
import org.today.utilities.Utility;
import org.today.utilities.WithExcel;

public class TC002 extends TestBase{

	public TC002() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage lp;
	
	@BeforeTest
	public void setUp() throws IOException {
		initBrowser();
		lp = new LoginPage();
	}
	
	@AfterTest
	public void tearDown() {
		Utility.windowClose();
	}
	
	@Test(dataProvider = "J")
	public void data(String un, String pw ) {
		lp.input_username_textbox.sendKeys(un);
		lp.input_password_textbox.sendKeys(pw);
		lp.login_button.click();
		lp.button_openmenu.click();
		lp.a_logout.click();
	}
	
	@DataProvider(name = "J")
	public Object[][] dataprovider() throws IOException{
		
		WithExcel withExcel = new WithExcel("Sheet4", ".\\src\\main\\java\\org\\today\\excelData\\Demo.xlsx");
		int rowCount = withExcel.rowCount();
		short columnCount = withExcel.columnCount();
		
		Object[][] obj = new Object[rowCount][columnCount];
		
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				obj[i][j] = withExcel.getData(i, j);
			}
		}
		
		return obj;

	
	
	
	
	
	
}
}