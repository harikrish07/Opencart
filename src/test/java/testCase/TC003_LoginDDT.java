package testCase;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.Login;
import pom.Myaccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(groups = {"Regression", "Master"}, dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void validateLogin(String email, String pass, String exp)  {
		
		logger.info("Login validation starts");
		
		try {
			HomePage hom = new HomePage(driver);
			hom.clickMyAccount();
			hom.clickLogin();
			
			//Login page
			Login log = new Login(driver);
			log.enterEmail(email);
			log.enterPassword(pass);
			log.clickSubmit();
			
			//MyAcc page
			
			Myaccount myAc = new Myaccount(driver);
			boolean boo = myAc.isMyAccountPageExists();
			Assert.assertEquals(boo, true);
			
			if(exp.equalsIgnoreCase("valid")) {
				if(boo==true) {
					myAc.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
				
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(boo==true) {
					myAc.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
			
		}catch(Exception e) {
			e.getMessage();
			System.out.println("Login failed");
		} finally {
			System.out.println("Login was successfully completed");
		}
	}

}
