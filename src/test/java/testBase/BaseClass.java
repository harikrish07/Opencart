package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Master", "Sanity"})
	@Parameters({"os", "browser"})
	public void launchBrowser(String s, String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		FileReader f= new FileReader("C:\\Users\\sarat\\eclipse-workspace\\OpenCart\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(f);
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("Invalid data"); return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		
	}
	
	@AfterClass
	public void closeBrowser() {
	//	driver.quit();
	}
	
	public String randomString() {
		String str = RandomStringUtils.randomAlphabetic(5);
		return str;
		
	}
	
	public String randomNumeric() {
		String num = RandomStringUtils.randomNumeric(10);
		return num;
		
	}
	
	public String randomAlphaNumeric() {
		String str1 = RandomStringUtils.randomAlphabetic(3);
		String num1 = RandomStringUtils.randomNumeric(3);
		return (str1+"@"+num1);
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
