/*
 * #Project Name  : Gold Automation Framework
   #Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description : The Class TestCaseRunner, 
	used to run test cases kept in TestSuit file and corresponding test case files.
*/

package testrunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sikuli.basics.Settings;

import util.ExcelUtils;
import util.Log;
import util.Reporting;
import configuration.ActionKeyword;
import configuration.Constant;


/**
 * The Class TestCaseRunner, used to run test cases kept in TestSuit file and corresponding test case files.
 */
@SuppressWarnings("unused")
public class TestCaseRunner {
	
	
	
	
	
	
	
	// these variable has been used for objrep
			public static HashMap<String, String> objKeyValue = new HashMap<String, String>();
			public static HashMap<String, String> objKeyType = new HashMap<String, String>();
	
	
	
	
	
	
	
	/** The variable to store test case result */
	public static int bResult; 
	
	/** The variable to store row numbers */
	public static int tRow;
	
	/** The variable to store test step result */
	public static int vResult;
	
	/** The variable to store instance of Reporting Object. */
	static Reporting rep = new Reporting();
	/** The variable to store Installed Offer ID */
	public static int bCapture; 

	
	/** stage number */
	public static int ix;	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*This is to configure Log4J XML file*/
		DOMConfigurator.configure("src//Util//Log4j.xml");
		
		
		
		
		
		//  Read the value for objrep
		
		
		
		System.out.println("we are in reading OBJrep");
		

		objKeyValue.clear();
		objKeyType.clear();
		String path = System.getProperty("user.dir");
		String completepath = path + "\\src\\DataEngine\\Objrep.xlsx";
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
		
		
		// End value for objrep
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*This is to configure Sikuli settings*/
		Settings.setShowActions(true);
		Settings.MoveMouseDelay = 1;
		try {
			/*Backing up logs*/
			Log.logBackup();
			Thread.interrupted();
			
			/*This is to clean the logs*/
			Log.logClean();
			
			/*Calling Test Suit Run function*/
			testsuitrun();
			
			/*Backing up logs*/
			Log.logBackup();
			Thread.interrupted();

		} catch (Throwable e) {
			e.printStackTrace();
			Log.logBackup();
		}
	}

	/**
	 * function to process each row of TestSuit Excel.
	 *
	 * @throws Throwable the throwable
	 */
	// Test Suit Handle Function
	public static void testsuitrun() throws Throwable

	{
		
		
		
		
		
		
		//Variables for excel data handling
		
		Integer runModeColumn = 0;
		Integer fileLocationColumn = 0;
		Integer sheetNameColumn=0;
		Integer browserColumn=0;
		Integer billingColumn=0;
		//Integer OrderNumberColumn=0;
		Integer execuerOrderNumberColumn=0;
		Integer execuerRefOrderNumberColumn=0;
		Integer execuerChildRefOrderNumberColumn=0;
		Integer execuerBundleOrderNumberColumn=0;
		Integer InstalledOfferIDColumn=0;
		Integer resultColumn = 0;
		Integer ExecutionTimeColumn=0;
		Integer orderSheetRow=0;
		
		//Setting Test case result as 1
		bResult = 1;
		vResult = 1;
		String dest1=null;
		
		//Setting the start time of test case
		long startTime=0L;
		
		
		//Setting the end time of test case
		long endTime=0L;
		
		
		//Setting Testsuit 1 path and order stages from Constant.java file
		if(Constant.SET1)
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET1;
			Constant.ORDERSTAGES = Constant.SET1ORDERSTAGES;
			//Constant.EXECUTERFILE = Constant.EXECUTERFILE1;
			
		}
		//Setting Testsuit 2 path and order stages from Constant.java file
		else if (Constant.SET2)	
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET2;
			Constant.ORDERSTAGES = Constant.SET2ORDERSTAGES;
			
		}
		//Setting Testsuit 3 path and order stages from Constant.java file
		else if (Constant.SET3)	//Setting Testsuit 3
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET3;
			Constant.ORDERSTAGES = Constant.SET3ORDERSTAGES;
		}
		//Setting Testsuit 4 path and order stages from Constant.java file
		else if (Constant.SET4)	//Setting Testsuit 4
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET4;
			Constant.ORDERSTAGES = Constant.SET4ORDERSTAGES;
		}
		//Setting Testsuit 5 path and order stages from Constant.java file
		else if (Constant.SET5)	//Setting Testsuit 5
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET5;
			Constant.ORDERSTAGES = Constant.SET5ORDERSTAGES;
		}
		//Setting Testsuit 6 path and order stages from Constant.java file
		else if (Constant.SET6)	//Setting Testsuit 6
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET6;
			Constant.ORDERSTAGES = Constant.SET6ORDERSTAGES;
		}
		else if (Constant.SET7)	//Setting Testsuit 6
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET7;
			Constant.ORDERSTAGES = Constant.SET7ORDERSTAGES;
		}
		//Setting Testsuit 8 path and order stages from Constant.java file
		else if (Constant.SET8)	//Setting Testsuit 8
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET8;
			Constant.ORDERSTAGES = Constant.SET3ORDERSTAGES;
		}
		else if (Constant.SET9)	//Setting Testsuit 9
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET9;
			Constant.ORDERSTAGES = Constant.SET3ORDERSTAGES;
		}
		else if (Constant.SET10)	//Setting Testsuit 9
		{
			Constant.TESTCASESHEET = Constant.TESTCASESHEET10;
			Constant.ORDERSTAGES = Constant.SET3ORDERSTAGES;
		}
		else if (Constant.SANITY)
		{
			Constant.TESTCASESHEET = Constant.SANITYSHEET;
			Constant.ORDERSTAGES = Constant.SET4ORDERSTAGES;
			//		Constant.ORDERSTAGES = Constant.SET9ORDERSTAGES;
		}
		
		// Code to take the backup of suite file before start of execution.
		File suitesource = new File(Constant.TESTCASESHEET);
		
		File targetDir = new File(Constant.SOURCELOC+"Testsuitbackup\\"); 
		// System.getProperty("java.io.tmpdir"));
		FileUtils.copyFileToDirectory(suitesource,targetDir);
		
		if (Constant.MigratedProduct)
		{
			
			bCapture = 0;
			ExcelUtils.setExcelFile(Constant.TESTCASESHEETMP,"MigratedProducts");
			Integer endRoww = ExcelUtils.lastRowNum();
			// System.out.println("Number of rows "+endRoww);
			for (tRow = 1; tRow <= endRoww; tRow++) 
			{
				
				// System.out.println("OCATID data is "+ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("OCATID")));
				// System.out.println("NAME data is "+ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("NAME")));
				// System.out.println("Valid data is "+ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("VALID (Y/N)")));
				if(ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("OCATID")).equalsIgnoreCase("10-GPD647") 
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("NAME")).equalsIgnoreCase("Business VPN Small")
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("VALID (Y/N)")).equalsIgnoreCase("Y"))
				{	
					
					bCapture = 1;
					break;
				}
				if(ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("OCATID")).equalsIgnoreCase("10-GPD1549") 
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("NAME")).equalsIgnoreCase("Business VPN Corporate")
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("VALID (Y/N)")).equalsIgnoreCase("Y"))
				{	
					
					bCapture = 1;
					break;
				}
				if(ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("OCATID")).equalsIgnoreCase("10-GPD2362") 
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("NAME")).equalsIgnoreCase("Business VPN Galerie")
						&& ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("VALID (Y/N)")).equalsIgnoreCase("Y"))
				{	
					
					bCapture = 1;
					break;
				}
			}
		}
		ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.EXECUTERSHEET_EXECUTER);
		Integer endRow = ExcelUtils.lastRowNum();
		
		// Loop to control all the test suit
		for (tRow = 1; tRow <= endRow; tRow++) 
		{
			
//			Constant.LoginPertestcase =true;
			// switching to executer sheet for execution control
			ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.EXECUTERSHEET_EXECUTER);
			
			
			/*note down the start time, as soon as the current test case changes, 
			 * else keep the same time for the test 
			 * case
			 */
			if(Constant.CURRENTTESTCASE==null||
					!Constant.CURRENTTESTCASE.equalsIgnoreCase(
							ExcelUtils.getCellData(
									tRow, ExcelUtils.getColumnNoByName("Test case Id"))))
			{
				Constant.CURRENTTESTCASE = ExcelUtils.getCellData(tRow, ExcelUtils.getColumnNoByName("Test case Id"));
				
			}
			
			// STAGES
			for( ix=0;ix<=Constant.ORDERSTAGES.length-1;ix++)
			{
			Log.info("#### Opening Order Stage "+ Constant.ORDERSTAGES[ix] + " of " + Constant.CURRENTTESTCASE + " ####");
			
			Constant.CURRENTSHEETNAME=Constant.ORDERSTAGES[ix];
			ActionKeyword.valueCaptured.clear();
			ActionKeyword.orderNumberCaptured.clear();
			ActionKeyword.autoDisconnectCaptured.clear();
			
			// Setting File for test suit
			//Excel file handler for sheets in a suit
			ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.ORDERSTAGES[ix]);
					
			if(Constant.CURRENTSHEETNAME.equalsIgnoreCase("commercial") || Constant.CURRENTSHEETNAME.equalsIgnoreCase("functionalities"))
			{
				try {
					Constant.COMPONENT = ExcelUtils.getCellData(ExcelUtils.getRowNoByText(Constant.CURRENTTESTCASE, ExcelUtils.getColumnNoByName("Test case Id")), ExcelUtils.getColumnNoByName("Component"));
					//getting cell data from Description column
					Constant.CURRENTTESTCASEDESCRIPTION = ExcelUtils.getCellData(ExcelUtils.getRowNoByText(Constant.CURRENTTESTCASE, ExcelUtils.getColumnNoByName("Test case Id")), ExcelUtils.getColumnNoByName("Description"));	
				} catch (Exception e) {
					// go silently
				}
				
			}
				
		// switching to executer sheet for execution control
		ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.EXECUTERSHEET_EXECUTER);
		
		//Setting run mode column
		runModeColumn=ExcelUtils.getColumnNoByName(Constant.ORDERSTAGES[ix]);
		resultColumn=ExcelUtils.getColumnNoByName(Constant.ORDERSTAGES[ix])+1;
		String RunModeValue = ExcelUtils.getCellData(tRow, runModeColumn);
		
		System.out.println(RunModeValue);
		
		String ResultValue=null;
		if(!Constant.CURRENTSHEETNAME.equalsIgnoreCase("functionalities")){
			ResultValue = ExcelUtils.getCellData(tRow, runModeColumn-1);
		}else{
			ResultValue = "Pass";
		}
		
		execuerOrderNumberColumn = ExcelUtils.getColumnNoByName("OrderNumber");
		execuerRefOrderNumberColumn = ExcelUtils.getColumnNoByName("ReferenceOrder");
		execuerChildRefOrderNumberColumn = ExcelUtils.getColumnNoByName("ReferenceChildOrder");
		execuerBundleOrderNumberColumn = ExcelUtils.getColumnNoByName("BundleChildOrderNumber");
		InstalledOfferIDColumn = ExcelUtils.getColumnNoByName("InstalledOfferID");
		billingColumn = ExcelUtils.getColumnNoByName("Billing");
		String execuerRefInstalledOfferIDValue = ExcelUtils.getCellData(tRow, InstalledOfferIDColumn);
		String OrderNumberValue = (ExcelUtils.getCellData(tRow, execuerOrderNumberColumn)).replace(".0", "");
		String execuerRefOrderNumberValue =ExcelUtils.getCellData(tRow, execuerRefOrderNumberColumn).replace(".0", "");
		String execuerChildRefOrderNumberValue = ExcelUtils.getCellData(tRow, execuerChildRefOrderNumberColumn);
		String execuerBundleOrderNumberValue = ExcelUtils.getCellData(tRow, execuerBundleOrderNumberColumn);
		ExecutionTimeColumn=ExcelUtils.getColumnNoByName("ExecutionTime");

		
		
		// switching back to stage sheet
		ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.ORDERSTAGES[ix]);
		
		fileLocationColumn=ExcelUtils.getColumnNoByName("File location");
		sheetNameColumn=ExcelUtils.getColumnNoByName("SheetName");
		browserColumn=ExcelUtils.getColumnNoByName("Browser");
		//OrderNumberColumn=ExcelUtils.getColumnNoByName("OrderNumber");

		
		
		
			if (bResult == 1) {
				// Checking if user want to execute particular test case or not:
				// Yes: to execute, No: user don't want to execute.
				
				//Checking the run mode value in test suit
				if (RunModeValue.equalsIgnoreCase("Yes"))
				{
					orderSheetRow=ExcelUtils.getRowNoByText(Constant.CURRENTTESTCASE, 
							ExcelUtils.getColumnNoByName("Test case Id"));
					//reset the time to 0 if the current stage is commercial
					if(Constant.CURRENTSHEETNAME.equalsIgnoreCase("commercial"))
					{
						rep.reportUpdate(tRow, ExecutionTimeColumn, "0", 
								Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
					}
					
					startTime = System.currentTimeMillis();
					//Excel file handler for sheets in a suit
					ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.ORDERSTAGES[ix]);
					
					//checking the stage and previous result of order
					if(ix>0 && !ResultValue.equalsIgnoreCase("pass")
							&& !OrderNumberValue.contains("#")
							&& !OrderNumberValue.contains("NA")
							&& !Constant.CURRENTSHEETNAME.equalsIgnoreCase("Functionalities")// this sheet name should not change in testsuit file
							&& !Constant.CURRENTSHEETNAME.equalsIgnoreCase("Commercial"))// this sheet name should not change in testsuit file
							
						
					{
						continue;
						
					}else{// note down the Order Number
						
						Constant.ORDERNUMBER = OrderNumberValue;
						// add the order number to the temporary storage
						Constant.TEMPSTORAGE.put("#ORDERNUM", Constant.ORDERNUMBER);
						
						Constant.REFORDERNUMBER = execuerRefOrderNumberValue;
						Constant.REFCHILDORDERNUMBER = execuerChildRefOrderNumberValue;
						
						// add the ref order number to the temporary storage
						Constant.TEMPSTORAGE.put("#REFORDERNUM", Constant.REFORDERNUMBER);
						Constant.BUNDLEORDERNUMBER = execuerBundleOrderNumberValue;
						// add the Bundle order number to the temporary storage
						Constant.TEMPSTORAGE.put("#BUNDLEORDERNUM", Constant.BUNDLEORDERNUMBER);
						Constant.REFINSTALLEDOFFERID = execuerRefInstalledOfferIDValue;
					}
					
					// note down the Excel file path and Sheet Name 
					Constant.SPATH = Constant.DATAENGINEPATH + 
							ExcelUtils.getCellData(orderSheetRow, fileLocationColumn);
					Constant.SHEETPATH = ExcelUtils.getCellData(orderSheetRow, sheetNameColumn);
					
					if(ExcelUtils.getCellData(tRow, 6).equalsIgnoreCase("Config"))
					{
						//ActionKeyword.config();
						System.out.println("the config is deprecated");
					}
					else
					{
//						if(Constant.LoginPertestcase)
//					{
							// Open the Browser
							String BrowserName = ExcelUtils.getCellData(orderSheetRow, browserColumn);
							Constant.browserName=BrowserName;
							ActionKeyword.openBrowser(BrowserName);
//						}
					
					// Login using Guardian credentials if Guardian flag is set to true
					/*if(Constant.GUARDIANLOGIN){
						Thread.sleep(5000);
						ActionKeyword.guardianLogin();
					}*/
					
					Log.startTestCase(Constant.CURRENTTESTCASE + 
							Constant.CURRENTTESTCASEDESCRIPTION);
					
					
					Log.info("#### Executing Test case: "
							+ Constant.CURRENTTESTCASE 
							+ "; Description: "
							+ Constant.CURRENTTESTCASEDESCRIPTION);
					
									
						
					//**************************************************************
					String destpath = null;
				
					// Create a copy of the test case file in reports folder
					File source = new File(Constant.DATAENGINEPATH + 
							ExcelUtils.getCellData(orderSheetRow, fileLocationColumn));
					String Browsername = ExcelUtils.getCellData(orderSheetRow, browserColumn);
					String destfilename = (source.getAbsolutePath().substring(source
							.getAbsolutePath().lastIndexOf("\\") + 1));
					
					
					String[] filename = destfilename.split("\\.");

					destpath = Constant.TESTREPORT + filename[0] + "_" + Browsername
							+ "." + filename[1];
					
					// create a new file only if it doesn't exist
					File dest = new File(destpath);
					if(!dest.exists())FileUtils.copyFile(source, dest);
					
					//**************************************************************/
					
					// Switching to default sheet before running test cases
					ExcelUtils.setExcelFile(Constant.TESTCASESHEET,Constant.ORDERSTAGES[ix]);
					
					// run the test steps
					teststepsrun();
					}
					
					
					if (bResult == 1) {// if the test case if passed
						
						//switch to Executer sheet
						ExcelUtils.setExcelFile(Constant.TESTCASESHEET,
								Constant.EXECUTERSHEET_EXECUTER);
						
						
						rep.reportUpdate(tRow, resultColumn, "Pass",
								Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
						/*------------------------Newly added for Enhancement --------------------------------*/
						rep.reportUpdate(tRow, resultColumn-1, "No",
								Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
												
						if((ix==0||ix==1) && ActionKeyword.orderNumberCaptured.size()>0){
							/*rep.reportUpdate(TRow, OrderNumberColumn, 
									ActionKeyword.OrderNumberCaptured.get(ActionKeyword.OrderNumberCaptured.size()-1),
									Constant.TESTCASESHEET, Constant.ORDERSTAGES[ix]);*/
							
							// update the order number in executer sheet
							rep.reportUpdate(tRow, execuerOrderNumberColumn, 
									ActionKeyword.orderNumberCaptured.get(ActionKeyword.orderNumberCaptured.size()-1),
									Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
							
						}
						
						if((bCapture==1) && ActionKeyword.InstalledOfferIDNumberCaptured.size()>0){
							// update the installed offer id in executer sheet
							// System.out.println("Installed  Offer Column "+InstalledOfferIDColumn);
							// System.out.println("Installed  Offer Data "+ActionKeyword.InstalledOfferIDNumberCaptured.get(ActionKeyword.InstalledOfferIDNumberCaptured.size()-1));
							rep.reportUpdate(tRow, InstalledOfferIDColumn, 
									ActionKeyword.InstalledOfferIDNumberCaptured.get(ActionKeyword.InstalledOfferIDNumberCaptured.size()-1),
									Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
						}
						
						// write the captured bundle child order number to the Executer sheet
						if((ix==0||ix==1) && ActionKeyword.BundleOrderCaptured.size()>0){
														
							// update the order number in executer sheet
							rep.reportUpdate(tRow, execuerBundleOrderNumberColumn, 
									ActionKeyword.BundleOrderCaptured.get(ActionKeyword.BundleOrderCaptured.size()-1),
									Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
							
						}
						
						
						// Save the AutoDisconnected Order if current stage is billing
						if (Constant.CURRENTSHEETNAME.equalsIgnoreCase("Billing")&& ActionKeyword.autoDisconnectCaptured.size()>0)
                        {
                               rep.reportUpdate(tRow, browserColumn+1, ActionKeyword.autoDisconnectCaptured.get(ActionKeyword.autoDisconnectCaptured.size()-1),
                                             Constant.TESTCASESHEET, Constant.ORDERSTAGES[ix]);
                              
                        }
										
						// Update the billing column to no as the product is migrated product
						if (Constant.CURRENTSHEETNAME.equalsIgnoreCase("Acceptance") && (bCapture==1) && ActionKeyword.MigratedProductOrder == true)
                        {
                               rep.reportUpdate(tRow, billingColumn, "No",Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
                        }
	
						String Endmessage = "### Test case no: "
								+ Constant.CURRENTTESTCASE
								+ "; Description: "
								+ Constant.CURRENTTESTCASEDESCRIPTION
								+ "; status Passed";
						
						Log.info(Endmessage);
						Log.endTestCase(Endmessage);
						
						// note down the end time
						endTime = System.currentTimeMillis();
						long TotalTime = (endTime-startTime)/(60000); // convert to minutes
						/*String Existingtime = ExcelUtils.getCellData(tRow, ExecutionTimeColumn);
						if(Existingtime.isEmpty())Existingtime="0";
						
						Integer ExecutionTime = (int) (Integer.parseInt(Existingtime) + TotalTime);*/
						/*------------------------Newly added for Enhancement --------------------------------*/
						rep.reportUpdate(tRow, resultColumn+22, String.format("%d", TotalTime), 
								Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
						System.out.println(TotalTime);
					}
					
				} 
				
				
				else if (RunModeValue.equalsIgnoreCase(// if run mode is No Skip the test case and log
						"No")) {
					
					
					ExcelUtils.setExcelFile(Constant.TESTCASESHEET,
							Constant.ORDERSTAGES[ix]);
					
					String Endmessage = "### Test case no: "
							+ Constant.CURRENTTESTCASE
							+ "; Description: "
							+ Constant.CURRENTTESTCASEDESCRIPTION
							+ "; Status: NotRun";
					Log.startTestCase(Endmessage);
					Log.info("#### " + Endmessage + " ####");
					Log.endTestCase(Endmessage);
				
				} else if // If the run mode is close break the loop
				(RunModeValue.equalsIgnoreCase("close")) 
				{
					ExcelUtils.setExcelFile(Constant.TESTCASESHEET,
							Constant.ORDERSTAGES[ix]);
					Log.info("####Closing Order Stage "+ Constant.ORDERSTAGES[ix] +" ####");
					//String Endmessage = "Closing Test Suite";
					//Log.endTestCase(Endmessage);
					//break;
				}
			}
			
			// If the test case is failed
			if (bResult == 0) {
				bResult = 1;
				// switch to current stage sheet				
				ExcelUtils.setExcelFile(Constant.TESTCASESHEET,
						Constant.ORDERSTAGES[ix]);
				
				String Endmessage = "### Test case no: "
						+ Constant.CURRENTTESTCASE + "; Description: "
						+ Constant.CURRENTTESTCASEDESCRIPTION + "; status: Failed";
				
				rep.reportUpdate(tRow, resultColumn, "Fail", 
						Constant.TESTCASESHEET,
						Constant.EXECUTERSHEET_EXECUTER);
				
				if((ix==0||ix==1) && ActionKeyword.orderNumberCaptured.size()>0){
					/*rep.reportUpdate(TRow, OrderNumberColumn, ActionKeyword.OrderNumberCaptured.get(ActionKeyword.OrderNumberCaptured.size()-1),
							Constant.TESTCASESHEET, Constant.ORDERSTAGES[ix]);*/
					
					rep.reportUpdate(tRow, execuerOrderNumberColumn, ActionKeyword.orderNumberCaptured.get(ActionKeyword.orderNumberCaptured.size()-1),
							Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
					
				}
				// write the order number in case of AutoDisconnect Orders
				if (Constant.CURRENTSHEETNAME.equalsIgnoreCase("Billing")&& 
						ActionKeyword.autoDisconnectCaptured.size()>0)
                {
                       rep.reportUpdate(tRow, browserColumn+1, 
                    		   ActionKeyword.autoDisconnectCaptured.get(ActionKeyword.autoDisconnectCaptured.size()-1),
                                     Constant.TESTCASESHEET, Constant.ORDERSTAGES[ix]);
                      
                }
				
				// Update the billing column to no as the product is migrated product
				if (Constant.CURRENTSHEETNAME.equalsIgnoreCase("Acceptance") && (bCapture==1) && ActionKeyword.MigratedProductOrder == true)
                {
                    rep.reportUpdate(tRow, billingColumn, "No",Constant.TESTCASESHEET, Constant.EXECUTERSHEET_EXECUTER);
                }
				
				
				Log.error(Endmessage, "", null);
				Log.endTestCase(Endmessage);

				//ActionKeyword.Quit();
				// exit the system
				
			}
			
		}
			if(Constant.DriverActive){
				ActionKeyword.Quit();
				Constant.DriverActive=false;
			} 
		}
		System.exit(0);
	}

	/**
	 * Function to process each row of the test case file passed from testuit file.
	 *
	 * @throws Throwable the throwable
	 */
	public static void teststepsrun() throws Throwable 
	{
		String sActionKeyword = null;
		int iRow = 0;
		String destpath = null;
		long startTime2=0L;
		long endTime2=0L;
		try {
			Class<?> cls = Class.forName("configuration.ActionKeyword");

			
			Integer FileLocationColumn=ExcelUtils.getColumnNoByName("File location");
			
			Integer BrowserColumn=ExcelUtils.getColumnNoByName("Browser");
			
			Integer OrderSheetRow = ExcelUtils.getRowNoByText(Constant.CURRENTTESTCASE, 
					ExcelUtils.getColumnNoByName("Test case Id"));
			
			File source = new File(Constant.DATAENGINEPATH + ExcelUtils.getCellData(OrderSheetRow, FileLocationColumn));
			String Browsername = ExcelUtils.getCellData(OrderSheetRow, BrowserColumn);
			String destfilename = (source.getAbsolutePath().substring(source
					.getAbsolutePath().lastIndexOf("\\") + 1));
			String[] filename = destfilename.split("\\.");

			destpath = Constant.TESTREPORT + filename[0] + "_" + Browsername
					+ "." + filename[1];
			
			ExcelUtils.setExcelFile(Constant.SPATH, Constant.SHEETPATH);
			Integer endRow = ExcelUtils.lastRowNum();
			vResult = 1;
			
			for (iRow = 1; iRow <= endRow; iRow++) {
				
				Constant.TESTCASEROWNUM = iRow;
			
				startTime2 = System.currentTimeMillis();
				
				ExcelUtils.setExcelFile(Constant.SPATH, Constant.SHEETPATH);
				
				if(iRow > ExcelUtils.lastRowNum()){
					break;
				}
				
				sActionKeyword = ExcelUtils.getCellData(iRow, Constant.ACTION);
				//
				Object clsobj = cls.newInstance();
				Method method1=null;
				
				// Setting the Constant.Data based on the current test case
				Constant.DATA = ExcelUtils.getColumnNoByName(Constant.CURRENTTESTCASE);
				String methodArg = ExcelUtils.getCellData(iRow,Constant.DATA);
				
				// skip the step if you find skip keyword in the data
				if(ExcelUtils.getCellData(iRow, Constant.DATA).equalsIgnoreCase("skip")){
					/*Log.info(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	        				Constant.TESTSTEPID)
	        				+ "; "
	        				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	        						Constant.TESTSTEPDESCRIPTION)
	        				+ "; Skipped");*/
					continue;
				}
				
				// Search the method Name in Action keyWord File
				Method[] methods = cls.getDeclaredMethods();
				for(Method mthd:methods){
			
					if(mthd.getName().equalsIgnoreCase(sActionKeyword))
					{
						// break if method is found
						method1 = mthd;
						break;
					}
					
				}
				
				
				// if the test case was passed 
				if (bResult == 1) {
					// if the action keyword is not close and not empty, not end and not null
					if (!sActionKeyword.contains("Close") && !sActionKeyword.isEmpty()
							&& sActionKeyword!=null && !sActionKeyword.equalsIgnoreCase("end")) {
						System.out.println(Constant.CURRENTTESTCASE + " : " 
							+ ExcelUtils.getCellData(iRow,Constant.TESTSTEPID)
							+ " : Performing Action: " + method1.getName() );

						//if the current keyword is openBrowser
						if(sActionKeyword.contains("OpenBrowser")){
							method1.invoke(clsobj, methodArg);
						}else{
							// invoke the method using class object
							method1.invoke(clsobj);
						}
						endTime2 = System.currentTimeMillis();
						// System.out.println("Start Time : "+startTime2);
						// System.out.println("End Time : "+endTime2);
						long TotalTime2 = (endTime2-startTime2); // convert to minutes
						// System.out.println("Total Time : "+TotalTime2);
						
						if (vResult == 0) {
							rep.dReportUpdate(iRow, Constant.DATA+1, "Fail", destpath,
									Constant.SHEETPATH);
							rep.reportUpdate(iRow, Constant.DATA+55, String.format("%d", TotalTime2), 
									destpath, Constant.SHEETPATH);
							// System.out.println("Step time : "+TotalTime2);
							// on a step failure, the testcase should be fail too
							// raise an exception on a step failure
							throw new Exception("the step failed while executing " + method1.getName());

						} else if (vResult == 1) {
							rep.dReportUpdate(iRow, Constant.DATA+1, "Pass", destpath,
									Constant.SHEETPATH);
							rep.reportUpdate(iRow, Constant.DATA+55, String.format("%d", TotalTime2), 
									destpath, Constant.SHEETPATH);
							// System.out.println("Step time : "+TotalTime2);
						} else {
							
						}
						
						vResult = 1;

					}

					else if (sActionKeyword.contains("Close")) {
						ActionKeyword.Quit();
						Thread.sleep(2000);
						// ActionKeyword.Quit();
						//break;
						//System.out.println("Not Quiting on close...");
					}
					
					/*else if(sActionKeyword.equalsIgnoreCase("end") && ix==Constant.ORDERSTAGES.length-1)
					{
						ActionKeyword.Quit();
						Thread.sleep(2000);
						break;
					}*/
					
					else if(sActionKeyword.equalsIgnoreCase("end"))
					{
						Thread.sleep(2000);
						break;
					}

				}

				else if (bResult == 0) {
					iRow--;
					rep.reportUpdate(
							tRow,
							4,
							"\""
									+ ExcelUtils.getCellData(iRow,
											Constant.TESTCASEID)
									+ "\" is not passed becasuse of: \""
									+ ExcelUtils.getCellData(iRow,
											Constant.ACTION)
									+ "\" Action "
									+ "please refer logs and Error Screenshot for more detais",
							Constant.TESTCASESHEET, Constant.REPORTSHEET);
					
					rep.dReportUpdate(iRow, Constant.DATA+1, "Fail", destpath,
							Constant.SHEETPATH);

					break;
				}

			}// ending for
			Log.info("Completed all the steps in Excel :" +destfilename);
			
		} 
		catch (java.lang.NoSuchMethodException e) {
			bResult = 0;
			String logmessage = ExcelUtils.getCellData(iRow,
					Constant.TESTSTEPID) + " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION)
					+ sActionKeyword
					+ ": Action Kewyord is not available in the Script";
			Log.fatal(logmessage, e);
			Constant.ERRORMESSAGE = logmessage;
			 ActionKeyword.errorCaptureScreen();
			e.printStackTrace();
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);
			//rep.DReportupdate(iRow, 9, logmessage, destpath, Constant.sheetpath);

		} catch (org.openqa.selenium.remote.UnreachableBrowserException e) {
			bResult = 0;
			e.printStackTrace();
			String logmessage = ExcelUtils.getCellData(iRow, Constant.TESTSTEPID)
					+ " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION)
					+ "; Browser not available";
			Log.fatal(logmessage, e);
			Constant.ERRORMESSAGE = logmessage;
			 ActionKeyword.errorCaptureScreen();
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);

		} catch (java.io.FileNotFoundException e) {
			bResult = 0;
			e.printStackTrace();
			String logmessage = "Test Script Excel File not found for test case"
					+ ExcelUtils.getCellData(iRow, Constant.TESTSTEPID)
					+ " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION);
			
			Log.fatal(logmessage, e);

			Constant.ERRORMESSAGE = logmessage;
			 ActionKeyword.errorCaptureScreen();
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);

		}

		catch (java.lang.reflect.InvocationTargetException e) {
			bResult = 0;
			e.printStackTrace();
			String logmessage = ExcelUtils.getCellData(iRow, Constant.TESTSTEPID)
					+ " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION)
					+ "; Element not found"; 
			Log.fatal(logmessage, e);
			 ActionKeyword.errorCaptureScreen();
			Constant.ERRORMESSAGE = logmessage;
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);


		} catch (org.openqa.selenium.NoSuchWindowException e) {
			bResult = 0;
			e.printStackTrace();
			String logmessage = ExcelUtils.getCellData(iRow, Constant.TESTSTEPID)
					+ " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION)
					+ "; Browser Window is Closed";
			Log.fatal(logmessage, e);
			 ActionKeyword.errorCaptureScreen();
			Constant.ERRORMESSAGE = logmessage;
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);

		}

		catch (Exception e) {
			bResult = 0;
			// System.out.println(e);
			e.printStackTrace();
			String logmessage = ExcelUtils.getCellData(iRow, Constant.TESTSTEPID)
					+ " : " + 
					ExcelUtils.getCellData(iRow, Constant.TESTSTEPDESCRIPTION)
					+ "; Not able to perform" + sActionKeyword + "Action";  
			Log.fatal(logmessage, e);
			Constant.ERRORMESSAGE = logmessage;
			ActionKeyword.errorCaptureScreen();
			
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);
		} catch (Throwable e) {
			bResult = 0;
			// TODO Auto-generated catch block
			e.printStackTrace();
			String logmessage = e.getMessage();
			Constant.ERRORMESSAGE = logmessage;
			ActionKeyword.errorCaptureScreen();
			rep.dReportUpdate(iRow, Constant.DATA +1 , "Fail ;" + logmessage, destpath, Constant.SHEETPATH);


		}

	}
	
}
