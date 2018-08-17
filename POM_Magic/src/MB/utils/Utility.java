package MB.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		
	

}
