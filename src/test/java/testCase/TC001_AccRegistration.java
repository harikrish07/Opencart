package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccRegistration extends BaseClass {

	@Test(groups = {"Sanity", "Regression", "Master"})
	public void acc_registration() {

		logger.info("***Starting Registration*****");
		logger.debug("This is a debug log message");

		try {
			logger.info("Browser Launch");
			HomePage hom = new HomePage(driver);
			hom.clickMyAccount();
			logger.info("opening registration page");
			hom.clickRegister();

			RegistrationPage reg = new RegistrationPage(driver);

			logger.info("Entering customer details");
			reg.setFname(randomString().toUpperCase());
			reg.setLname(randomString().toLowerCase());
			reg.setemail(randomString() + "@gmail.com");
			reg.setTphone(randomNumeric());
			String pass = randomAlphaNumeric();
			reg.setPwd(pass);
			reg.setCpwd(pass);
			
			System.out.println(pass);

			reg.setPolicy();
			reg.clickContinue();
			String Amsg = reg.getConfirmation();

			Assert.assertEquals(Amsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Registration Finished *****");
		}
	}

}
