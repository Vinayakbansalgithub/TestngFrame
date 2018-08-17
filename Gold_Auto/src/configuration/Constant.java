/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description : Class contains all the constants which are used at the time of test execution.
*/
package configuration;

import java.util.HashMap;

/**
 * Class contains all the constants which are used at the time of test execution.
 */

public class Constant {

	/** The Constant to keep the value of browserName. */
	public static String browserName;
	
	/** The Constant to keep the value of SET1. */
	public static Boolean SET1 = false; 
	
	/** The Constant to keep the value of SET2. */
	public static Boolean SET2 = false;
	
	/** The Constant to keep the value of SET3. */
	public static Boolean SET3 = false;
	
	/** The Constant to keep the value of SET4. */
	public static Boolean SET4 = false;
	
	/** The Constant to keep the value of SET5. */
	public static Boolean SET5 = false;
	
	/** The Constant to keep the value of SET5. */
	public static Boolean SET6 = false;
	
	/** The Constant to keep the value of SET7. */
	public static Boolean SET7 = false;
	
	/** The Constant to keep the value of SET8. */
	public static Boolean SET8 = false;
	
	/** The Constant to keep the value of SET9. */
	public static Boolean SET9 = false;
	
	/** The Constant to keep the value of SET10. */
	public static Boolean SET10 = false;
	
	/** The Constant to keep the value of Sanity. */
	public static Boolean SANITY = true;
	
	/** An array to keep the names of stages of an Order for SET1. */
	public static String[] SET1ORDERSTAGES = {
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"};
	/** An array to keep the names of stages of an Order for SET2. */
	public static String[] SET2ORDERSTAGES = {
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"};
	
	
	/** An array to keep the names of stages of an Order for SET3. */
	public static String[] SET3ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"
		};
	
	/** An array to keep the names of stages of an Order for SET4. */
	public static String[] SET4ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing",};
	
	/** An array touuuuuuuu9String[] SET5ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing",};
	
	/** An array to keep the names of stages of an Order for SET6. */
	public static String[] SET6ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"};
	
	/** An array to keep the names of stages of an Order for SET7. */
	public static String[] SET7ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"};
	
	/** An array to keep the names of stages of an Order for SET8. */
	public static String[] SET8ORDERSTAGES = {
		"Functionalities",
		"Commercial",
		"Technical",
		"Pricing",
		"SendToCustomer",
		"CustomerApproval",
		"CheckAndRelease",
		"Manage",
		"Acceptance",
		"Billing"};
	
	/** An array to keep the names of stages of an Order for SET9. */
	public static String[] SET9ORDERSTAGES = {
		"Functionalities"};
	/** The Constant to keep source path of the framework. */
	public static final String SOURCELOC = System.getProperty("user.dir") + "\\";
	
	/** The Constant to keep the path to sikuli Images. */
	public static final String SIKULIIMAGELOCATION = SOURCELOC+"src\\Sikuli\\ImagesUnitaction\\";
	
	/** The Constant to keep the path of chrome driver location. */
	public static String CHROMEDRIVERLOCATION = SOURCELOC+"driver\\chromedriver.exe";
	
	/** The Constant to keep the path of IE driver .*/
	public static String IEDRIVER = SOURCELOC+"Drivers\\IEDriverServer.exe";
	
	/** The Constant to keep the path of verification screen shots. */
	public static String SCREENSHOTLOC =SOURCELOC+"Screenshots\\VerificationScreenshots\\";
	
	/** The Constant to keep the path of error screen shots. */
	public static String ERRORSCREENSHOTLOC =SOURCELOC+"Screenshots\\ErrorScreenshots\\";
	
	/** The Constant to keep the path of sikuli IDE . */
	public static String SIKULIIDE=SOURCELOC+"SikuliX\\runsikulix.bat";
	
	/** The Constant to keep the path of Logs. */
	public static String LOGFILELOCATION=SOURCELOC+"src\\Logs\\";
	
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET;
	
	
	
	
	/** The Constant is used to keep login as per test case not by stage. */
	public static boolean LoginPertestcase;
	
	/** The Constant is used to keep boolean for active driver instance */
	public static boolean DriverActive;
		
	/** The Constant to keep the path of test case Executer Sheet. */
	public static String EXECUTERSHEET_EXECUTER = "Executer";
	
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET1 = SOURCELOC+"src\\DataEngine\\Testsuit1.xlsx";
	
	/** The Constant to keep the path of test case Executer. */
	/*public static String EXECUTERFILE1 = SOURCELOC+"src\\DataEngine\\Executer.xlsx";*/
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET2 = SOURCELOC+"src\\DataEngine\\Testsuit2.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET3 = SOURCELOC+"src\\DataEngine\\Testsuit3.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET4 = SOURCELOC+"src\\DataEngine\\Testsuit4.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET5 = SOURCELOC+"src\\DataEngine\\Testsuit5.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET6 = SOURCELOC+"src\\DataEngine\\Testsuit6.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET7 = SOURCELOC+"src\\DataEngine\\Testsuit7.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET8 = SOURCELOC+"src\\DataEngine\\Testsuit8.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET9 = SOURCELOC+"src\\DataEngine\\Testsuit9.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEET10 = SOURCELOC+"src\\DataEngine\\Testsuit10.xlsx";
	
	/** The Constant to keep the path of test case sheet. */
	public static String SANITYSHEET = SOURCELOC+"src\\DataEngine\\Sanity.xlsx";
	
	/** The Constant to keep the path of test reports. */
	public static String TESTREPORT=SOURCELOC+"src\\reports\\";
	
	/** The Constant to keep the path of all input excel files files. */
	public static String DATAENGINEPATH = SOURCELOC+"src\\DataEngine\\";
	
	/** The Constant to keep the name of Application's Object Repository */
	public static String APPLICATIONREPOSITORYNAME = "GOLDStandAlone";
	
	/** The constant to keep SIKULIWAITTIMEOUT. */
	public static Double SIKULIWAITTIMEOUT=120d; // in Seconds
	 
	/** The constant to keep the name of TEST RUN SHEET. */
	//Test files configuration parameters
	public static String TESTRUNSHEET = "Testsuit";
	
	/** The constant to keep the name of REPORTSHEET. */
//	public sta?V?
	
	/** The hash to keep run time values. */
	
	public static HashMap<String, String> TEMPSTORAGE = new HashMap<String, String>();
	
	/** The constant to keep SOAPENDPOINT. */
	
	public static String SOAPENDPOINT; 
	
	/** The constant to enable/disable GUARDIANLOGIN. */
	public static Boolean GUARDIANLOGIN = false; // true; // 
	
	/** The constant to enable/disable NORMALOGIN. */
	public static Boolean NORMALLOGIN = true; // false; // 
	
	/** The constant to keep value of GUARDIAN LOGIN URL. */
	public static String GUARDIANLOGINURL = "https://self.sso-dev.infra.ftgroup/"; // "http://10.237.59.154/home/gold/jsp/Dispatch.jsp?.CurrentState=Login";
	
	/** The constant to keep value of GUARDIAN USER. */
	public static String GUARDIANUSER = "wskc8835"; // "mmmm0948"; // 
	
	/** The constant to keep value of GUARDIAN Password. */
	public static String GUARDIANPASS = "wskc8835"; //  "mmmm0948"; // 
	
	/** The constant to keep value of APPENVIRONMENT. */ //GOLDSANDBOX
	public static String APPENVIRONMENT = "GOLD UAT"; // "GOLD Sandbox"; // 
	
	/** The constant to keep the url of GOLD NORMAL LOGIN. */
	//public static String AppEnvironment = "GOLD UAT";
	public static String GOLDNORMALLOGINURL ="http://10.237.59.154/home/gold/jsp/partner.jsp";//"http://10.237.59.154/home/gold/jsp/partner.jsp";// "http://10.237.93.105/home/gold/jsp/partner.jsp";// 
	
	/** The constant to keep the name of NORMAL USER. */
	public static String NORMALUSER = "qtesting"; //"mccadmin";//"smukherjee";//"sgupta5" ;//"nloomba";//  //  "lwinslade"; // 
	
	/** The constant to keep password of Normal User */
	public static String NORMALPASS ="Qtesting@000";//"mccadm@Aa1";//"Sabby@25";//"qtesting@Aa7";//  "2gX|2hZ!2n";//"qtesting@Aa7";//"3vD~0dN$3m";//"9xN~7tT*9e";//"nloomb@Aa1";//// "3iU|6bW_2f"; //  "gmittal@Aa5"; // "gmittal@Aa9"; // "3cZ#5qN_3k";
	
	/** The constant to keep the name of NORMAL USER. */
	public static String CHANNELUSER = "tchannel"; // "tchannel";
	
	/** The constant to keep password of Normal User */
	public static String CHANNELPASS ="7pY:4pU~6w";//"qtesting@Aa1";//"4hK_5iE.7a";//"6kQ$8mA%3j";//"8iS$0wZ_6x";// "4qX!2uV@1q";//"tchannel@Aa7";////"4lK$2vM!8i";//"4jL:0bN$5n"; //"tchann@Aa2" ; // "tchann@Aa9";
	
	/** The constants to for OIT User credentials */
	public static String OITURL = "http://rcorp22-rdr-01dev-oit-qa.sso-dev.infra.ftgroup/OrderIntakeTool/pages/indexFrm.jsp";
	public static String OITUSER = "jzzv0083";
	public static String OITPASSWORD = "jzzv0083";
	public static String OITAPPENVIRONMENT = "User - QA platform";
	public static Boolean APPCHOICEFLAG = true;
	public static Boolean IE11=true;
	
	/** The constant to keep the name of of user who has access to submit approve charges task */
	public static String APPROVERUSER =  "qtesting";
	
	/** The constant to keep password of user who has access to submit approve charges task */
	public static String APPROVERPASS = "qtesting@Aa7"; //"6nD#6rH:2p"; // "winslade@Aa2";
	
	/** The constant to keeps the id of main window */
	public static String MainWindowHandle; 
	
	/** The constant to keep the value of REF INSTALLED OFFER ID */
	public static String REFINSTALLEDOFFERID;
	
	/** The Constant to Check for migrated product */
	public static Boolean MigratedProduct = true; 
	
	/** The Constant to keep the path of test case sheet. */
	public static String TESTCASESHEETMP = SOURCELOC+"src\\DataEngine\\MigratedProducts.xlsx";
		
}
