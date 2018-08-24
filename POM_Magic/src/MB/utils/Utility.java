package MB.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import MB.core.TestCore;
import MB.pages.MBLoginPage;


public class Utility {
	
	
	
	
	
	
	
	public static void waitForAjax()  {

		if (true) {
			try {
				AdsHelpControl();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (true) {
			try {
				if (MBLoginPage.driver instanceof JavascriptExecutor) {
					JavascriptExecutor jsDriver = (JavascriptExecutor) MBLoginPage.driver;
					for (int i = 0; i < 10; i++) {
						Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
						if (numberOfAjaxConnections instanceof Long) {
							Long n = (Long) numberOfAjaxConnections;
							if (n.longValue() == 0L)
								break;
						}
						Thread.sleep(1000);
					}
				} else {
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			} catch (Exception e) {
				return;
			}
		} else {

		}
	}
	
	
	
	
	
public static void AdsHelpControl() throws InterruptedException {

		
		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(1500);
				WebElement blocker = MBLoginPage.driver.findElement(By
						.xpath(".//*[@id='popupjsp']/a"));
				
				blocker.click();
					// System.out.println("find spinner");

					break;

				}

			 catch (Exception e) {
				 System.out.println("in catch");

				Thread.sleep(2000);
				
				
				
				
				
				
			}

		}

		
		
	}

public static Double ExtractInt(String frompage) {
	String fetchfrompage = frompage;
	fetchfrompage = fetchfrompage.replaceAll("[^\\d.]+|\\.(?!\\d)", "");
	
	
	Double rangefromwebpage;
	if (fetchfrompage.isEmpty()) {
		rangefromwebpage = 0.0;
	} else {
		rangefromwebpage = Double.valueOf(fetchfrompage);
	}
	
	
if(frompage.contains("Cr")){
	rangefromwebpage=rangefromwebpage*100.00d;
		
	}
	
	System.out.println(rangefromwebpage);
	return rangefromwebpage;
}

	
	
	
	
	
	public static boolean isExecutable(String test_name, excel_reader excel){
		
		String sheetName="testcases";
		for(int rowNum=2;rowNum<=excel.getRowCount(sheetName);rowNum++){
			
			if(excel.getCellData(sheetName, "test_name", rowNum).equals(test_name)){
						
				if(excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y"))
						return true;
					else
						return false;
				
			}
		}
		
		return false;
		
	}
	
	
	//TestNG Parameterization
		public static Object[][] getData(String sheetName, excel_reader excel){
			// return test data;
			// read test data from xls
			
			int rows=excel.getRowCount(sheetName)-1;
			if(rows <=0){
				Object[][] testData =new Object[1][0];
				return testData;
				
			}
		    rows = excel.getRowCount(sheetName);  // 3
			int cols = excel.getColumnCount(sheetName);
			Object data[][] = new Object[rows-1][cols];
			
			for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
				
				for(int colNum=0 ; colNum< cols; colNum++){
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				}
			}
			
			return data;
			
			
		}
		
		public static  void  startbrowser() throws Exception{
			
			if(TestCore.driver == null){
				
				
				
				//Load the Config Properties file
				
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
				TestCore.config.load(fis);
				TestCore.app_logs.debug("Config property file loaded");
			
				/*//Load the Object Properties file
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
				object.load(fis);
				app_logs.debug("Object property file loaded");*/
				
		
				//load the Excel file
				TestCore.excel = new excel_reader(System.getProperty("user.dir")+"\\src\\MB\\testdata\\testdata.xlsx");
				TestCore.app_logs.debug("Excel file loaded");
				
				
				//Initialize the WebDriver
				if(TestCore.config.getProperty("browser").equals("firefox")){
					
					
					System.setProperty("webdriver.firefox.marionette",
							System.getProperty("user.dir")+"\\src\\driver\\geckodriver.exe");

					
					
					

					TestCore.driver = new FirefoxDriver();
					
			    	//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\driver\\geckodriver.exe");
			    	
			    	/* DesiredCapabilities capabilities = new DesiredCapabilities();

			    	 capabilities = DesiredCapabilities.firefox();
			    	 capabilities.setBrowserName("firefox");
			    	 capabilities.setVersion("your firefox version");
			    	 capabilities.setPlatform(Platform.WINDOWS);
			    	 capabilities.setCapability("marionette", false);

			    	 //WebDriver driver = new FirefoxDriver(capabilities);
			    	  * 
			    	  * 
	*/		
				
				
					TestCore.app_logs.debug("Firefox driver initialized");
				}else if(TestCore.config.getProperty("browser").equals("ie")){
					
					
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\driver\\IEDriverServer.exe");
					TestCore.driver = new InternetExplorerDriver();
				}else if(TestCore.config.getProperty("browser").equals("chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
					TestCore.driver = new ChromeDriver();
					
					
					TestCore.driver.manage().window().maximize();
				}
				
				TestCore.driver.get(TestCore.config.getProperty("testsite"));

			
		}


		}		
	

}
