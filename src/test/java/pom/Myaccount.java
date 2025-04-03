package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends BasePage {

	public Myaccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAcc;
	
	@FindBy(xpath = "//div[@id='top-links']//a[text()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (myAcc.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickLogout() {
		logout.click();

	}


}
