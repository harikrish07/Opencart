package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id = 'input-firstname']")
	WebElement fName;
	
	@FindBy(xpath = "//input[@id = 'input-lastname']")
	WebElement lName;

	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id = 'input-telephone']")
	WebElement tPhone;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@id = 'input-confirm']")
	WebElement cPwd;
	
	@FindBy(xpath = "//input[@name = 'agree']")
	WebElement checkBox;
	
	@FindBy(xpath = "//input[@class = 'btn btn-primary']")
	WebElement submit;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement confirmText;
	
	public void setFname(String fname) {
		fName.sendKeys(fname);
	}
	
	public void setLname(String lname) {
		lName.sendKeys(lname);
	}
	
	public void setemail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setTphone(String number) {
		tPhone.sendKeys(number);
	}
	
	public void setPwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void setCpwd(String cPassword) {
		cPwd.sendKeys(cPassword);
	}
	
	public void setPolicy() {
		checkBox.click();
	}
	
	public void clickContinue() {
		submit.click();
		
		//Action sub = new Action(driver);
		//sub.moveToElement(submit).click().perform();
		
		//Sol 3
		//JavaScriptExecutor js = (JavaScriptExecutor)driver;
		//js.executeScript("arguments[0].click();",submit)
	}
	
	public String getConfirmation() {
		try {
			return(confirmText.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	
	
	
	
}
