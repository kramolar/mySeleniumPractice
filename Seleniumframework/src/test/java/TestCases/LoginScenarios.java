package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.loginPage;
import Pages.productsPage;
import ReadData.ReadtestData;

public class LoginScenarios extends BaseTest {
	
	loginPage lp; //Refrence variable 
	
	@Test
	public void invalidUsername() {
	lp = new loginPage(driver); // Object 
	lp.enterUsername(new ReadtestData().getInvalidUname()); 
	lp.enterPassword(new ReadtestData().getPassword());
	lp.clickLogin();
	String actualError = lp.getError(); 
	Assert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void invalidPassword() {
		new loginPage(driver).enterUsername(new ReadtestData().getUsername());   // java 8
		new loginPage(driver).enterPassword(new ReadtestData().getinvalidpwd());
		new loginPage(driver).clickLogin();
		String actualError = new loginPage(driver).getError();
		String expectedError = new ReadtestData().getErr();
		Assert.assertEquals(actualError,expectedError);  //Pass or fail decision
	}
	
	@Test
	public void emptyLogin() {
		new loginPage(driver).enterUsername(" ");   // java 8
		new loginPage(driver).enterPassword(" ");
		new loginPage(driver).clickLogin();
		String actualError = new loginPage(driver).getError();
		Assert.assertEquals(actualError,new ReadtestData().getEmptyErr());  //Pass or fail decision
		
	}
	
	@Test
	public void validLogin() {
		new loginPage(driver).enterUsername(new ReadtestData().getUsername());   // java 8
		new loginPage(driver).enterPassword(new ReadtestData().getPassword());
		new loginPage(driver).clickLogin();
		String actual = new productsPage(driver).getHeading();
		String expected = "Products";
		Assert.assertEquals(actual, expected);
	}

}
