package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("***** Starting TC003_LoginDDT. *****");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.");
				
		hp.clickLogin();
		logger.info("Clicked on Login Link.");
				
		//Login
		LoginPage lp=new LoginPage(driver);
				
		logger.info("Filling in login credentials....");
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
		//My Account
		logger.info("Validating expected message...");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.myAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(false);
				macc.clickLogout();
		
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****  Finished TC003_LoginDDT. *****");
	}

}
