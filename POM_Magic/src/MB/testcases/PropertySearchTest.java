package MB.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MB.core.TestCore;
import MB.pages.Homepage;
import MB.pages.MBLoginPage;
import MB.pages.SearchResultPage;
import MB.utils.Utility;
import MB.utils.excel_reader;
import config.Configuration;

public class PropertySearchTest extends TestCore {

	excel_reader xls;

	public static boolean resultTC = true;

	@BeforeTest
	public void checkRunMode() throws Exception {
		

		xls = new excel_reader(System.getProperty("user.dir")
				+ "\\src\\MB\\testdata\\testdata.xlsx");
		
		if (!Utility.isExecutable(this.getClass().getSimpleName(), xls)) {
			throw new SkipException("Skipping the test");
		} else {

			//System.out.println("  2nd test has been started");

			TestCore.test = reports.startTest("Property search test case");


			
			Utility.startbrowser();
		}

	}

	@Test(dataProvider = "getData")
	public void login(String username, String password, String SearchBuy,
			String Property_Type, String BudgetBuy, String bhk, String socity)
			throws Exception {

		driver.get(Configuration.Loginpage);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		MBLoginPage lp = new MBLoginPage(driver);

		try {

			lp.doLogin(username, password);
		} catch (Throwable t) {
			System.out.println("Error occurred");
		}

	}

	@Test(dependsOnMethods = { "login" }, dataProvider = "getData")
	public void searchproperty(String username, String password,
			String SearchBuy, String Property_Type, String BudgetBuy,
			String bhk, String socity) throws Exception {

		Homepage landingpage = new Homepage(driver);

		landingpage.SearchPropertyBuy(SearchBuy, Property_Type, BudgetBuy, bhk);
	}

	@Test(dependsOnMethods = { "searchproperty" }, dataProvider = "getData", priority = 2)
	public void verifySocietyResult(String username, String password,
			String SearchBuy, String Property_Type, String BudgetBuy,
			String bhk, String socity) throws Exception {

		SearchResultPage srp = new SearchResultPage(driver);

	
		srp.verifySociety(socity);

		

	}

	@Test(dependsOnMethods = { "searchproperty" }, dataProvider = "getData", priority = 1)
	public void verifyBHKResult(String username, String password,
			String SearchBuy, String Property_Type, String BudgetBuy,
			String bhk, String socity) throws Exception {

		SearchResultPage srp = new SearchResultPage(driver);

		srp.verifyBHK(bhk);

	}

	@Test(dependsOnMethods = { "searchproperty" }, dataProvider = "getData", priority = 3)
	public void verifyPriceResult(String username, String password,
			String SearchBuy, String Property_Type, String BudgetBuy,
			String bhk, String socity) throws Exception {

		SearchResultPage srp = new SearchResultPage(driver);

		srp.verifyPrice(BudgetBuy);

	}

	@AfterTest
	public void close() {

		reports.endTest(test);

		driver.close();

		TestCore.emailBody.append(" <tr>");

		TestCore.emailBody.append("<td>" + this.getClass().getSimpleName()
				+ "</td>");

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

		return Utility.getData("LoginTest", xls);
	}

}
