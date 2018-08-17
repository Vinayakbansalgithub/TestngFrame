package MB.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import MB.core.TestCore;
import MB.utils.Utility;
import config.Configuration;

public class MBLoginPage {
	
	
	public static WebDriver driver;
	
	public MBLoginPage(WebDriver driver){
		
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=Configuration.emailMobile)
	public WebElement username;
	
	@FindBy(how = How.XPATH, using = Configuration.password)
	public WebElement password;
	
	@FindBy(xpath=Configuration.Next)
	public WebElement Next;
	
	@FindBy(xpath=Configuration.Login)
	public WebElement Login;
	
	//Business Login
	public MBLoginPage doLogin(String myusername, String mypassword){
		
		
	
		
		username.sendKeys(myusername);
		Next.click();
		password.sendKeys(mypassword);
		Login.click();
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Utility.waitForAjax();
		
		
		TestCore.log.info("Pass  "+"User is sucessfully logged in to the application ");
		
		Reporter.log("User is sucessfully logged in to the application ");
		
		TestCore.test.log(LogStatus.PASS,"User is sucessfully logged in to the application");
		
		return PageFactory.initElements(driver, MBLoginPage.class);
	}

}
