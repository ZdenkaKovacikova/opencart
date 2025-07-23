package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest. *****");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.");
		
		hp.clickLogin();
		logger.info("Clicked on Login Link.");
		
		//Login
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Filling in login credentials....");
		lp.setEmail(p.getProperty("email")); //Reading email from properties file
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account
		logger.info("Validating expected message...");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.myAccountPageExists();
		
		Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****  Finished TC002_LoginTest. *****");
		
	
	}
	
	

}
