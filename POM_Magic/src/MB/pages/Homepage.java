package MB.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import MB.core.TestCore;
import MB.utils.Utility;
import config.Configuration;

public class Homepage {

	public static WebDriver driver;

	public Homepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Configuration.Home_Buy)
	public WebElement Home_Buy;

	@FindBy(how = How.XPATH, using = Configuration.Home_Rent)
	public WebElement Home_Rent;

	@FindBy(xpath = Configuration.Home_Search)
	public WebElement Home_Search;

	@FindBy(xpath = Configuration.Home_Search_Suggestion)
	public WebElement Home_Search_Suggestion;

	@FindBy(xpath = Configuration.Home_Buy_Property_Type)
	public WebElement Home_Buy_Property_Type;

	@FindBy(how = How.XPATH, using = Configuration.Home_Rent_Property_Type)
	public WebElement Home_Rent_Property_Type;

	@FindBy(xpath = Configuration.flat)
	public WebElement flat;

	@FindBy(xpath = Configuration.office)
	public WebElement office;

	@FindBy(xpath = Configuration.Home_Rent_Property_Type_Value)
	public WebElement Home_Rent_Property_Type_Value;

	@FindBy(xpath = Configuration.Home_Buy_Property_Type_Value)
	public WebElement Home_Buy_Property_Type_Value;

	@FindBy(xpath = Configuration.Rent_Budget)
	public WebElement Rent_Budget;

	@FindBy(how = How.XPATH, using = Configuration.Buy_Budget)
	public WebElement Buy_Budget;

	@FindBy(xpath = Configuration.Buy_Budget_Value)
	public WebElement Buy_Budget_Value;

	@FindBy(xpath = Configuration.Rent_Budget_Value)
	public WebElement Rent_Budget_Value;

	@FindBy(xpath = Configuration.Buy_Budget_Min_Input)
	public WebElement Buy_Budget_Min_Input;

	@FindBy(how = How.XPATH, using = Configuration.Buy_Budget)
	public WebElement Buy_Budget_Max_Input;

	@FindBy(xpath = Configuration.Rent_Budget_Min_Input)
	public WebElement Rent_Budget_Min_Input;

	@FindBy(xpath = Configuration.Rent_Budget_Max_Input)
	public WebElement Rent_Budget_Max_Input;

	@FindBy(xpath = Configuration.Home_Search_Button)
	public WebElement Home_Search_Button;
	
	
	
	@FindBy(xpath = Configuration.BHK_1)
	public WebElement BHK_1;

	@FindBy(xpath = Configuration.BHK_2)
	public WebElement BHK_2;
	
	@FindBy(xpath = Configuration.Socity)
	public WebElement Socity;
	

	// Home Page
	public void SearchPropertyBuy(String Search, String Property_Type,
			String Budget,String bhk) throws Exception {

		System.out.println(driver);
System.out.println(driver);
		
		Thread.sleep(6000);

		System.out.println("here");
System.out.println("here");
		Home_Buy.click();
		
		Thread.sleep(6000);

		Home_Search.sendKeys(Search);

		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		Thread.sleep(3000);
		try {
			Home_Search_Suggestion.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Home_Buy_Property_Type.click();
		flat.click();

		
		switch (bhk) {
		case "1": BHK_2.click();
			break;
    
		case "2":BHK_2.click();
			break;

		default:
			break;
			
		}
		
		Buy_Budget.click();

		Buy_Budget_Min_Input.sendKeys(Budget);
		Home_Search_Button.click();

		
		TestCore.log.info("Pass  "+" User has sucessfully moved to  SRP page" );

		
		
		Reporter.log(" User has sucessfully moved to  SRP page" );
		
		TestCore.test.log(LogStatus.PASS,"User has sucessfully moved to  SRP page");


	//	return PageFactory.initElements(driver, Homepage.class);
		
		
		
	}

	
	
	
}
