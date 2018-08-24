package MB.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MB.core.TestCore;
import MB.pages.MBLoginPage;
import MB.utils.Utility;
import MB.utils.excel_reader;
import config.Configuration;

public class LoginTest extends TestCore {

	excel_reader xls;
	public static boolean resultTC = true;

	@BeforeTest
	public void checkRunMode() throws Exception {

	
		xls = new excel_reader(System.getProperty("user.dir")
				+ "\\src\\MB\\testdata\\testdata.xlsx");

		if (!Utility.isExecutable(this.getClass().getSimpleName(), xls)) {
			throw new SkipException("Skipping the test");
		} else {
			
			TestCore.test = reports.startTest("Login test case");


			Utility.startbrowser();
		}

	}

	@Test(dataProvider = "getData")
	public void sampleTest(String username, String password, String SearchBuy,
			String Property_Type, String BudgetBuy, String bhk, String socity) {

		MBLoginPage lp = PageFactory.initElements(driver, MBLoginPage.class);

		Assert.assertEquals(driver.getTitle(),
				"User Login - Buy Sell Rent Properties | MagicBricks");

		lp.doLogin(username, password);

		Assert.assertEquals(driver.getTitle(),
				"Sell or Rent Home Online at Magicbricks");
	}

	@AfterTest
	public void close() throws InterruptedException {

	//	System.out.println("we are in login test case close");
		reports.endTest(test);

		driver.close();
		driver=null;
	//	System.out.println("we are in login test case close after");

		TestCore.emailBody.append(" <tr>");

		TestCore.emailBody.append("<td>" + this.getClass().getSimpleName()
				+ "</td>");
		Thread.sleep(4000);

		
		if (resultTC) {

			TestCore.emailBody.append("<td>" + "PASS" + "</td>");
		}

		else {
			TestCore.emailBody.append("<td>" + "FAIL" + "</td>");
		}

		TestCore.emailBody.append("<td>" + config.getProperty("browser")
				+ "</td>");

		TestCore.emailBody.append("</tr>");

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("LoginTest", excel);
	}

}
