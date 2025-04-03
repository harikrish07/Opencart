package testCase;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.Login;
import pom.Myaccount;
import testBase.BaseClass;


public class TC002_Login extends BaseClass {
	
	
	@Test(groups = {"Sanity", "Master"})
	public void validateLogin()  {
		
		logger.info("Login validation starts");
		
		try {
			HomePage hom = new HomePage(driver);
			hom.clickMyAccount();
			hom.clickLogin();
			
			//Login page
			Login log = new Login(driver);
			log.enterEmail(p.getProperty("email"));
			log.enterPassword(p.getProperty("password"));
			log.clickSubmit();
			
			//MyAcc page
			
			Myaccount myAc = new Myaccount(driver);
			boolean boo = myAc.isMyAccountPageExists();
			Assert.assertEquals(boo, true);
			
			
			
		}catch(Exception e) {
			e.getMessage();
			System.out.println("Login failed");
		} finally {
			System.out.println("Login was successfully completed");
		}
	}

}
