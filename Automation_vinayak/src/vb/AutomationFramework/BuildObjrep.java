package vb.AutomationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

//import atu.testrecorder.exceptions.ATUTestRecorderException;


class PackageActivityClass {

	public static void findPackageActivityfun() throws IOException {

		String loc = BuildObjrep.TestSuitHashmap.get("File location");
		File fileTestcase = new File("D:\\Vinayak\\scripts-Appium\\" + loc);

		FileInputStream ExcelFileToReadTestcase = new FileInputStream(
				fileTestcase);

		// Read the spreadsheet that needs to be updated

		XSSFWorkbook wbTestcase = new XSSFWorkbook(ExcelFileToReadTestcase);
		// Access the workbook

		// Access the Worksheet, so that we can update / modify it.

		XSSFSheet worksheetTestcase = wbTestcase.getSheet("test steps");
		System.out.println("Total test steps in testcase  "
				+ worksheetTestcase.getLastRowNum());
		BuildObjrep.PackageActivityMap.clear();

		if (BuildObjrep.browser.equalsIgnoreCase("Appium")) {
			
			XSSFSheet TestcasePackageActivity = wbTestcase
					.getSheet("package|Activity");
			for (int pa = 0; pa <= TestcasePackageActivity.getLastRowNum(); pa++) {

				// ,PackageKey,PackageValue,ActivityKey,ActivityValue;

				BuildObjrep.cellTestcase = TestcasePackageActivity.getRow(pa)
						.getCell(0);

				BuildObjrep.PackageKey = BuildObjrep.cellTestcase
						.getStringCellValue();
				BuildObjrep.cellTestcase = TestcasePackageActivity.getRow(pa)
						.getCell(1);

				BuildObjrep.PackageValue = BuildObjrep.cellTestcase
						.getStringCellValue();
				BuildObjrep.PackageActivityMap.put(BuildObjrep.PackageKey,
						BuildObjrep.PackageValue);
			}
		}
	}
}

public class BuildObjrep {

	// to check any adb command visit
	// http://www.growingwiththeweb.com/2014/01/handy-adb-commands-for-android.html

	public static HashMap<String, String> objKeyValue = new HashMap<String, String>();
	public static HashMap<String, String> objKeyType = new HashMap<String, String>();
	public static HashMap<String, String> TestSuitHashmap = new LinkedHashMap<String, String>();
	public static HashMap<String, String> TestCaseHashmap = new LinkedHashMap<String, String>();
	public static HashMap<String, String> PackageActivityMap = new LinkedHashMap<String, String>();
	public static List<String> arraylist = new ArrayList<String>();
	static int totaltestcaserun;

	static String browser;

	// Set path of your node.exe file.
	// Program represents Program Files folder.
	// Set path of your appium.js file.

	// value for test case
	static int countTc = 1, k = 1;
	static String TestcaseIdValue, TS_IDValue, DescriptionTCValue,
			ElementLocTypeValue, ElementValue, ActionSupportValueValue,
			actionValue, DataValue, Parameter,PackageKey, PackageValue, ActivityKey,
			ActivityValue;
	static Cell cellTestcase;

	
	
	
	
	public static StringBuilder  emailBody = new StringBuilder();
	
	
	
	static void TastcaseSteps(int v, XSSFSheet worksheetTestcase) {

		TestCaseHashmap.clear();

		cellTestcase = worksheetTestcase.getRow(v).getCell(0);

		TestcaseIdValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(1);
		TS_IDValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(2);
		DescriptionTCValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(3);
		if (cellTestcase == null) {
			ActionSupportValueValue = null;
		} else
			ElementLocTypeValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(4);
		if (cellTestcase == null) {
			ActionSupportValueValue = null;
		} else
			ElementValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(5);
		if (cellTestcase == null) {
			ActionSupportValueValue = null;
		} else
			ActionSupportValueValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(6);
		actionValue = cellTestcase.getStringCellValue();

		cellTestcase = worksheetTestcase.getRow(v).getCell(7);
		if (cellTestcase == null) {
			ActionSupportValueValue = null;
		} else
			DataValue = cellTestcase.getStringCellValue();
		
		cellTestcase = worksheetTestcase.getRow(v).getCell(8);
		if (cellTestcase == null) {
			ActionSupportValueValue = null;
		} else
			Parameter = cellTestcase.getStringCellValue();

		TestCaseHashmap.put("Testcaseid", TestcaseIdValue);
		TestCaseHashmap.put("TestStepID", TS_IDValue);
		TestCaseHashmap.put("TeststepDescription", DescriptionTCValue);
		TestCaseHashmap.put("ElementFinderType", ElementLocTypeValue);
		TestCaseHashmap.put("Elementlocation", ElementValue);
		TestCaseHashmap.put("Data", DataValue);
		TestCaseHashmap.put("Action", actionValue);
		TestCaseHashmap.put("ActionSupportValue", ActionSupportValueValue);
		TestCaseHashmap.put("Data", DataValue);
		TestCaseHashmap.put("Parameter", Parameter);



	}

	// ///////////////////////////testscase///////////////////////////////////////

	public static void runTestCase(WebDriver driver) throws IOException,
			ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException {
		// ATUTestRecorderException
		if (TestSuitHashmap.get("RunMode").equalsIgnoreCase("Yes")) {

			totaltestcaserun++;

			String loc = BuildObjrep.TestSuitHashmap.get("File location");
			
			
			String pathscript = System.getProperty("user.dir");
			String completepathscript = pathscript + "\\scripts\\"+loc;
			File filescript = new File(completepathscript);

			
			
		//	File fileTestcase = new File("D:\\Vinayak\\scripts-Appium\\" + loc);
			// System.out.println("Test suit file exist " +
			// fileTestcase.exists());
			FileInputStream ExcelFileToReadTestcase = new FileInputStream(
					filescript);

			// Read the spreadsheet that needs to be updated

			XSSFWorkbook wbTestcase = new XSSFWorkbook(ExcelFileToReadTestcase);
			// Access the workbook

			// Access the Worksheet, so that we can update / modify it.

			XSSFSheet worksheetTestcase = wbTestcase.getSheetAt(0);
			System.out.println("Total test steps in testcase  "
					+ worksheetTestcase.getLastRowNum());
			PackageActivityMap.clear();

			if (browser.equalsIgnoreCase("Appium")) {
				XSSFSheet TestcasePackageActivity = wbTestcase
						.getSheet("package|Activity");
				for (int pa = 0; pa <= TestcasePackageActivity.getLastRowNum(); pa++) {

					// ,PackageKey,PackageValue,ActivityKey,ActivityValue;

					cellTestcase = TestcasePackageActivity.getRow(pa)
							.getCell(0);

					PackageKey = cellTestcase.getStringCellValue();
					cellTestcase = TestcasePackageActivity.getRow(pa)
							.getCell(1);

					PackageValue = cellTestcase.getStringCellValue();
					PackageActivityMap.put(PackageKey, PackageValue);
				}
			}

			try {
				for (int v = 1; v < worksheetTestcase.getLastRowNum(); v++) {
					TestCaseHashmap.clear();

					TastcaseSteps(v, worksheetTestcase);
					Class cls = null;
					Method method;
					String actionName = TestCaseHashmap.get("Action");

					// part of reflection in java

					cls = Class.forName("vb.AutomationFramework.ActionClass");

					// method = ((Class) cls).getDeclaredMethod(actionName,
					// null);
//Annotation[] anno= cls.getAnnotations();
					Method[] m1 = ((Class) cls).getMethods();

					for (Method m2 : m1) {
						if (m2.getParameterTypes() != null
								&& m2.getParameterTypes().length > 0) {

							if (m2.getName().equals(actionName)) {
								// WebDriver webDriver = null ;
								// ActionClass.driver
								m2.invoke(actionName, driver);
							}
						} else {
							if (m2.getName().equals(actionName)) {
                     m2.invoke(actionName, null);
							/*	Method method1 = ((Class) cls)
										.getDeclaredMethod(actionName, null);
								method1.invoke(actionName, null);*/
								break;
							}
						}
					}
					// System.out.println("Method name  " + method.getName());
				}
			} catch (Exception e) {
				// ActionClass.p.destroy();

				if (browser.equalsIgnoreCase("Appium")) {

					ActionClass.driver.quit();
					// ActionClass.driver2.quit();

					ConsoleLogs.INFOFail(e.getCause().getMessage());
					ExtentHTML.fail(e.getCause().getMessage());
					System.out
							.println("nodejs has been killed ................. ");
					System.out.println("Exception is "
							+ e.getCause().getMessage());
					System.out
							.println("------------driver has been stoped-----------");

				} else {
					ActionClass.driver.close();
					// ActionClass.driver2.close();
					ConsoleLogs.INFOFail(e.getCause().getMessage());
					ExtentHTML.fail(e.getCause().getMessage());
				}

			}

			System.out.println("test case is finished");
			long endTime = System.currentTimeMillis();
			long endTest = TimeUnit.MILLISECONDS.toSeconds(endTime);

			System.out.println("test case has been finished at" + endTest);
			int final_time = (int) (endTest - ActionClass.starttest);

			String in = Integer.toString(final_time);
			System.out.println("time taken to run test case " + final_time
					+ "seconds");

			// excel part to save time taken

			// Create blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			// Create a blank sheet
			XSSFSheet spreadsheet = workbook.createSheet(" time details ");
			// Create row object
			XSSFRow row;
			// This data needs to be written (Object[])
			Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
			empinfo.put("1", new Object[] { "testcase name", "date",
					"time taken to run in sec" });
			empinfo.put(
					"2",
					new Object[] {
							BuildObjrep.TestSuitHashmap.get("Testcaseid"),
							new Date().toString(), in });

			// Iterate over data and write to sheet
			Set<String> keyid = empinfo.keySet();
			int rowid = 0;
			for (String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = empinfo.get(key);
				int cellid = 0;
				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(
					"D://vinayak//scripts-Appium//Writesheet.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Writesheet.xlsx written successfully");

			// excel part ends

			if (browser.equalsIgnoreCase("Appium")) {
				// CapabilitiesDevice. p.destroy();

				// CapabilitiesDevice.driver.quit();
				ActionClass.driver.quit();

			}
			 else
				 try{
			 ActionClass.driver.quit();
				 }catch(Exception e){
//					 System.out.println(e);
				 }
			// ActionClass.driver2.close();

			ExtentHTML.Endtest();
		} else {
			System.out.println("testcase has been skipped");

		}
	}

	public static void main(String[] args) throws Exception,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException, InterruptedException,
			NoDeviceFoundException {

		DOMConfigurator.configure("src//Log4j.xml");

		
		
		
		
		
		
		
		emailBody.append("<html>");
		emailBody.append("<body>");
		emailBody.append("<div style='padding:20px'>");
		emailBody.append("<h2>Automation Progress Report</h2>");
		emailBody.append("<b>QA engineer</b> : Vinayak bansal<br/>");
		emailBody.append("<b>Project </b> : Vroozi Inc.<br/>");
		emailBody.append("<br/>");
		
		emailBody.append("<table border='1' style='border-collapse:collapse;text-align:center'>");
		emailBody.append("<tr>");
		emailBody.append(" <th style='padding:5px'>Test case name</th>");
		emailBody.append("<th style='padding:5px'>Status</th>");
		emailBody.append("<th style='padding:5px'>Environment and/or Browser</th>");
		emailBody.append("</tr>");
		
		
		
		
		
		
		
		
		System.out.println("we are in different framework");
		// ActionClass.startAppium();
	//	AppiumStartFramework.StartAppium();

		objKeyValue.clear();
		objKeyType.clear();
		String path = System.getProperty("user.dir");
		String completepath = path + "\\scripts\\BuildObjrep.xlsx";
		File file = new File(completepath);

		//File file = new File("D:/Vinayak/scripts-Appium/BuildObjrep.xlsx");
		System.out.println("object rep exist:" + file.exists());
		FileInputStream ExcelFileToRead = new FileInputStream(file);

		// Read the spreadsheet that needs to be updated
		System.out.println(ExcelFileToRead);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		// Access the workbook

		// Access the Worksheet, so that we can update / modify it.

		XSSFSheet worksheet = wb.getSheet("BuildObjrep");

		System.out.println(worksheet.getLastRowNum());
		int i = 0;
		String key, value, type;
		Cell cellkey, cellvalue, celltype;
		int count = 0;
		while (worksheet.getRow(count) != null) {
			count++;
		}

		System.out.println("last row is " + count);
		while (i != count) {
			cellkey = worksheet.getRow(i).getCell(0);
			key = cellkey.getStringCellValue();
			cellvalue = worksheet.getRow(i).getCell(1);
			value = cellvalue.getStringCellValue();
			celltype = worksheet.getRow(i).getCell(2);
			type = celltype.getStringCellValue();
			objKeyValue.put(key, value);
			objKeyType.put(key, type);

			i++;
		}

		// /////////////////////// test suit ///////////////////////////////////

		String pathsuit = System.getProperty("user.dir");
		String completepathsuit = pathsuit + "\\scripts\\Testsuit.xlsx";
		 completepathsuit = "D:\\workspace\\AutomationFramework\\scripts\\Testsuit.xlsx";

		File filesuit = new File(completepathsuit);

		
		
	//	File fileTestsuit = new File("D:/Vinayak/scripts-Appium/Testsuit.xlsx");
		FileInputStream ExcelFileToReadTestsuit = new FileInputStream(
				filesuit);

		// Read the spreadsheet that needs to be updated

		XSSFWorkbook wbTestsuit = new XSSFWorkbook(ExcelFileToReadTestsuit);

		XSSFSheet worksheetTestsuit = wbTestsuit.getSheet("MyTestsuit");
		System.out.println("Total test cases in testsuit  "
				+ worksheetTestsuit.getLastRowNum());

		int countTS = 1, j = 1;
		String TestcaseidValue, DescriptionValue, RunModeValue, SheetNameValue, BrowserValue, filelocationValue;
		while (worksheetTestsuit.getRow(countTS) != null) {
			countTS++;
		}

		while (j != countTS) {
			cellkey = worksheetTestsuit.getRow(j).getCell(0);
			TestcaseidValue = cellkey.getStringCellValue();

			cellkey = worksheetTestsuit.getRow(j).getCell(1);
			DescriptionValue = cellkey.getStringCellValue();

			cellkey = worksheetTestsuit.getRow(j).getCell(2);
			RunModeValue = cellkey.getStringCellValue();

			cellkey = worksheetTestsuit.getRow(j).getCell(3);
			filelocationValue = cellkey.getStringCellValue();

			cellkey = worksheetTestsuit.getRow(j).getCell(4);
			SheetNameValue = cellkey.getStringCellValue();

			cellkey = worksheetTestsuit.getRow(j).getCell(5);
			BrowserValue = cellkey.getStringCellValue();

			TestSuitHashmap.put("Testcaseid", TestcaseidValue);
			TestSuitHashmap.put("Description", DescriptionValue);
			TestSuitHashmap.put("RunMode", RunModeValue);
			TestSuitHashmap.put("File location", filelocationValue);
			TestSuitHashmap.put("SheetName", SheetNameValue);
			TestSuitHashmap.put("Browser", BrowserValue);
			System.out
					.println("------------------------------------------------------");
			System.out.println("Test case "
					+ BuildObjrep.TestSuitHashmap.get("File location")
					+ "is running in "
					+ BuildObjrep.TestSuitHashmap.get("Browser"));

			HelpAllfunctions.countbrowser();

			for (int browsercount = 0; browsercount < HelpAllfunctions.browsercount; browsercount++) {
				browser = HelpAllfunctions.Browser[browsercount];
				if(TestSuitHashmap.get("RunMode").equalsIgnoreCase("yes")){
				ActionClass.BrowserUsed(browser);
				}
				else{
					System.out.println("Test case "+TestSuitHashmap.get("File location")+ "  Skipped");
					break;
				}

				// CapabilitiesDevice capabilitiesDevice = new
				// CapabilitiesDevice();
				// capabilitiesDevice.runDevicecapabilities();
				// Thread thread1 = new Thread(capabilitiesDevice);

//			/	Thread.sleep(5000);

				// runTestCase();
			}

			j++;
		}
		System.out.println("------------Test suit Ends--------------");
		// ActionClass.p.destroy();
		// ActionClass.p2.destroy();
		Runtime.getRuntime().exec("taskkill /im node.exe /f");
		System.out
				.println("-------------Appium server has been closed---------------");

		if (totaltestcaserun >= 5) {
			SendReport.sendmail();
		}
		// ActionClass.recorder.stop();
	}

}
