package MB.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import MB.core.TestCore;
import MB.testcases.PropertySearchTest;
import MB.utils.Utility;
import config.Configuration;

public class SearchResultPage {

	public static WebDriver driver;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Configuration.heading)
	public WebElement heading;

	@FindAll({ @FindBy(xpath = Configuration.Socity) })
	public List<WebElement> Socity;

	@FindAll({ @FindBy(xpath = Configuration.List_prop_BHK) })
	public List<WebElement> List_prop_BHK;

	@FindAll({ @FindBy(xpath = Configuration.List_price) })
	public List<WebElement> List_price;

	public void verifyHeading(String Property_Type) throws Exception {

		System.out.println(heading.getText().contains(Property_Type));

		Assert.assertTrue(heading.getText().contains(Property_Type));

	}

	public void verifySociety(String socity) throws Exception {

		SoftAssert softAssertion = new SoftAssert();

		String reportSocity = "";

		for (int i = 0; i < Socity.size(); i++) {

			String Societypage = Socity.get(i).getText();

			reportSocity = reportSocity + " " + Societypage + ", ";

			// Assert.assertTrue(Societypage.contains(socity));

			// System.out.println(Societypage);

			softAssertion.assertTrue(Societypage.contains(socity));

		}

		
		
		TestCore.log.info("Pass  "+" properties names from page " + reportSocity
				+ "------------ against: " + socity);
		
		
		Reporter.log(" properties names from page " + reportSocity
				+ "------------ against: " + socity);
		
		
		TestCore.test.log(LogStatus.PASS,"properties names from page " + reportSocity
				+ "------------ against: " + socity);


		softAssertion.assertAll();

	}

	public void verifyBHK(String bhk) throws Exception {

		SoftAssert softAssertion = new SoftAssert();

		String reportBHK = "";

		for (int i = 0; i < List_prop_BHK.size(); i++) {

			String bhkpage = List_prop_BHK.get(i).getText();

			reportBHK = reportBHK + " " + bhkpage + ", ";

			// Assert.assertTrue(bhkpage.contains(bhk));

			softAssertion.assertTrue(bhkpage.contains(bhk));

		}


		TestCore.log.info("Pass  "+"  page properties have  have bhk" + reportBHK
				+ " ---------- against: " + bhk);
		
		
		Reporter.log(" page properties have  have bhk" + reportBHK
				+ " ---------- against: " + bhk);
		
		
		TestCore.test.log(LogStatus.PASS," page properties have  have bhk" + reportBHK
				+ " ---------- against: " + bhk);

		softAssertion.assertAll();

	}

	public void verifyPrice(String price) throws Exception {

		SoftAssert softAssertion = new SoftAssert();

		String reportPrice = "";
		boolean result = true;

		double priceSheet = Double.parseDouble(price);

		for (int i = 0; i < List_price.size(); i++) {

			double pricepage = Utility.ExtractInt(List_price.get(i).getText());

			reportPrice = reportPrice + " " + pricepage + ", ";

			if (priceSheet > pricepage) {
				PropertySearchTest.resultTC = false;
				TestCore.test.log(LogStatus.FAIL," price " + pricepage
						+ " is less the given :--------- " + priceSheet);
				
				TestCore.log.info("Fail "+"price"  + pricepage
						+ " is less the given :--------- " + priceSheet);
				
				

			}

			softAssertion.assertTrue(priceSheet <= pricepage);
			
			

		}


		TestCore.log.info("pass "+"price"  + reportPrice
				+ " have price above or equal:--------- " + price);
		
		
		
		Reporter.log(" All the properties" + reportPrice
				+ " have price above or equal:--------- " + price);
		
		if(	PropertySearchTest.resultTC!=false){
		TestCore.test.log(LogStatus.PASS," All the properties" + reportPrice
				+ " have price above or equal:--------- " + price);
		}
		softAssertion.assertAll();

	}

}
