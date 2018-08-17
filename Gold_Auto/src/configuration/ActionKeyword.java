/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description : Class contains all the Action Keywords and Support Lib Functions that 
	are needed to be called while writing test steps of a test case on excel sheet.
 */
package configuration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import objrepositories.GOLDStandAlone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.basics.Settings;
import org.sikuli.script.Button;
import org.sikuli.script.Finder;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Mouse;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import testrunner.TestCaseRunner;
import util.ExcelUtils;
import util.Log;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Class contains all the Action Keywords and Support Lib Functions that are
 * needed to be called while writing test steps of a test case on excel sheet.
 */
@SuppressWarnings("unused")
public class ActionKeyword {

	/**
	 * All the static element defined here ; Variable to keep the instance of
	 * WebDriver
	 */
	public static WebDriver driver;

	/** The Action element; Variable to keep the instance of WebElement */
	public static WebElement actionElement;

	/** The screen ; Variable to keep the instance of Sikuli Screen Object */
	public static Screen screen;

	/** The pattern; ; Variable to keep the instance of Sikuli Pattern Object */
	public static Pattern pattern;

	/** The finder ; Variable to keep the instance of Sikuli Finder Object */
	public static Finder finder;

	/** The char list; Variable to keep a random list of Numbers and Characters */
	static String CHAR_LIST = "abcdefg123450hijklmn1567890opqrstuvw12390xyzABCDEFGHI1234567890JKLMNO12390PQRSTUV1234567890WXYZ67890";

	/** The strlist ; Variable to keep a random list of Characters **/
	static String STRLIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/** The num list. Variable to keep a list of Numbers */
	static String NUM_LIST = "1234234567890234567890234567890789023456";

	/** The spl list. Variable to keep a list of Special Characters */
	static String SPL_LIST = "abcde!@#$@%fghijklmnopqrst!@#$!@uvyzAL&^%$EMNUV&*$%^WXYZ";

	/** The logmessage. Variable to store logmessages */
	public static String logmessage = null;

	/** The Valuestored. List to keep Captured run time values of WebElement(s) */
	// public static String [] Valuestored;
	public static List<String> valuestored = new ArrayList<String>();

	/**
	 * The Order number captured. List to keep OrderNumbers Captured at run time
	 * from WebElement(s)
	 */
	public static List<String> orderNumberCaptured = new ArrayList<String>();

	/**
	 * The USID captured. List to keep USID's Captured at run time from
	 * WebElement(s)
	 */
	public static List<String> USIDCaptured = new ArrayList<String>();

	/**
	 * The BundleOrder captured. List to keep Bundle Order Numbers Captured at
	 * run time from WebElement(s)
	 */
	public static List<String> BundleOrderCaptured = new ArrayList<String>();

	/**
	 * The Auto disconnect captured. List to keep AutoDisconnect Orders Captured
	 * at run time from WebElement(s)
	 */
	public static List<String> autoDisconnectCaptured = new ArrayList<String>();

	/**
	 * The Value Capture index. An Index number for the size of List
	 * ValueCaptured
	 */
	public static int valueCaptureindex = 0;

	/**
	 * The Value captured. List to keep Captured run time values of
	 * WebElement(s)*
	 */
	public static List<String> valueCaptured = new ArrayList<String>();

	/**
	 * The Order number captured. List to keep Installed Offer ID Captured at
	 * run time from WebElement(s)
	 */
	public static List<String> InstalledOfferIDNumberCaptured = new ArrayList<String>();

	/**
	 * The Value to check if order is for migrated product keep the value of
	 * SET1.
	 */
	public static Boolean MigratedProductOrder = false;

	/**
	 * Function to Open a Browser (FireFox, Chrome, IE and HTMLUnit(UI less
	 * browser) Fields required: Action field, Test data: Browser name as
	 * (Firefox, Chrome, IE, HTMLUnit).
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */

	// api

	static Response res;
	static String msg = "";
	static JSONArray jsonarr;
	static JSONObject jsonobj;
	static String responseBody;
	static Boolean flag = true;
	static Integer nullvalueCount = 0;
	// parameter hashmap
	public static ArrayList<String> listValues = new ArrayList<String>();
	public static ArrayList<String> listAttributes = new ArrayList<String>();
	public static ArrayList<String> nullCount = new ArrayList<String>();

	static String attribute;
	static String attributeValueApi;
	static String attributeValueScript;

	static String[] parameters;
	static Integer totalParameters;
	static String[] keyValue;
	static String[] key;
	static String[] value;
	static String[] jsonAttribute;
	static JSONArray jsonArray;

	// ///////////////////////////////////////////////////////////////////

	// Rest assured function start

	public static void BaseUri() throws Exception {

		String Element = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);

		String ElementLocType = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTFINDERTYPE);

		// rest api set
		/*
		 * RestAssured.baseURI = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
		 * Constant.ELEMENTFINDERTYPE);
		 */

		RestAssured.baseURI = TestCaseRunner.objKeyValue.get(Element);

		/*
		 * res =given().relaxedHTTPSValidation().when().get(); responseBody =
		 * res.getBody().asString();
		 */

		msg = "base uri to be open is "
				+ TestCaseRunner.objKeyValue.get(Element);

		Log.info(msg);
	}

	public static void GetRequest() throws Exception, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InterruptedException {

		String Element = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA1).equals("")) {
			parameters = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA1).split(",");
			totalParameters = parameters.length;
			key = new String[totalParameters];
			value = new String[totalParameters];

			for (int i = 0; i < totalParameters; i++) {

				keyValue = parameters[i].split("=");

				key[i] = keyValue[0];
				value[i] = keyValue[1];

			}
		}
		if (totalParameters != null && totalParameters != 0) {
			switch (totalParameters) {
			case 1:
				// Statements
				res = given()

				.param(key[0], value[0]).when().get(Element);
				responseBody = res.getBody().asString();

				break;

			case 2:
				// Statements
				res = given()

				.param(key[0], value[0]).param(key[1], value[1])

				.when().get(Element);

				responseBody = res.getBody().asString();

				break;

			case 3:
				// Statements
				res = given()

				.param(key[0], value[0]).param(key[1], value[1])
						.param(key[2], value[2]).when().get(Element);
				responseBody = res.getBody().asString();

				break;

			case 4:
				// Statements
				res = given()

				.param(key[0], value[0]).param(key[1], value[1])
						.param(key[2], value[2]).param(key[3], value[3])

						.when().get(Element);
				responseBody = res.getBody().asString();

				break;

			default:
				res = given()

				.when().get(Element);
				responseBody = res.getBody().asString();
			}
		} else {
			res = given().auth().preemptive().basic("30I-30I", "M+p_#5sR")
					.relaxedHTTPSValidation().when().get();

			// System.out.println( res.getBody().prettyPeek());

			/*
			 * InputStream in = res.getBody().asInputStream();
			 * 
			 * 
			 * StringBuffer sbf;
			 * 
			 * int len = 0;
			 * 
			 * String line = null; while ((len = in.read()) != null) {
			 * doSomething(line); }
			 * 
			 * 
			 * 
			 * responseBody=is.toString();
			 */

			responseBody = res.getBody().asString();

			System.out
					.println("-------------------------------start-------------------------------------------------");

			System.out.println(responseBody);

			System.out
					.println("-------------------------------------end-------------------------------------------");

		}

		try (FileWriter file = new FileWriter(Constant.DATAENGINEPATH
				+ "soap\\responses\\" + Constant.CURRENTTESTCASE + "api"
				+ ".json")) {
			file.write(responseBody);
			System.out.println("Successfully Copied JSON Object to File...");

		}

		msg = "get request with parameter " + Element;

		Log.info(msg);

	}

	public static void statusCode() throws Exception {

		String Data = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		int requiredStatusCode = Integer.parseInt(Data);
		if (res.statusCode() == requiredStatusCode) {

			msg = "verify :  status code form API is " + res.statusCode()
					+ "  is verified against " + Data + " and are same ";

			Log.info(msg);
		} else if (res.statusCode() != requiredStatusCode) {

			msg = "verify :  status code form API " + res.statusCode()
					+ "  and required status code " + Data + " are not same";

			Log.info(msg);

		}
	}

	public static void JsonToJavaObject() {
		try {
			jsonobj = new JSONObject(responseBody);

			msg = "convert json object to java object";

			Log.info(msg);

		} catch (Exception e) {
			msg = e.getMessage();

			Log.info(msg);

		}

	}

	public static void InsideGetJSONArray() throws Exception {
		String jsonAttribute = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		// System.out.println( jsonobj.length());

		if (jsonAttribute.equalsIgnoreCase("last")) {

			// JSONObject jsonobjLast

			jsonobj = jsonarr.getJSONObject(jsonarr.length() - 1);

			// new added
			jsonArray = new JSONArray(responseBody);

			String pageAttributevalue = jsonobj.getString("billingSystem");

			System.out.println(pageAttributevalue);
		}

		if (jsonAttribute.equalsIgnoreCase("last")) {

			// JSONObject jsonobjLast

			jsonobj = jsonarr.getJSONObject(jsonarr.length() - 1);

			// new added
			jsonArray = new JSONArray(responseBody);

			String pageAttributevalue = jsonobj.getString("billingSystem");

			System.out.println(pageAttributevalue);
		} else {

			jsonobj = new JSONObject(responseBody);
			jsonarr = jsonobj.getJSONArray(jsonAttribute);
			responseBody = jsonarr.toString();
		}
	}

	// AttributeName

	public static void VerifyAttributeApi() throws Exception {
		attribute = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		flag = false;

		if (responseBody.startsWith("[")) {

			try {
				String pageAttributevalue = jsonobj.getString(attribute);
				flag = true;
				msg = "Attribute  " + attribute + "   found in the list";
				// ConsoleLogs.INFOPass(msg);
				// ExtentHTML.pass(msg);
			} catch (Exception e) {
				flag = false;

			}

			// old code
			/*
			 * if (jsonArray.getJSONObject(0).getString(attribute) != null) {
			 * flag = true; msg = "Attribute  " + attribute +
			 * "   found in the list"; Log.info(msg); flag = true; }
			 */
		} else {

			jsonobj = new JSONObject(responseBody);

			Iterator itr = jsonobj.keys();
			while (itr.hasNext()) {
				// Get key somehow? itr.getKey() ???

				// contains the sub items

				// System.out.println("key "+itr.next());
				listAttributes.add((String) itr.next());
			}
			for (int i = 0; i < listAttributes.size(); i++) {
				// System.out.println("value " + i + " " + listValues.get(i));
				if (listAttributes.get(i).equalsIgnoreCase(attribute)) {
					msg = "Attribute  " + attribute + "   found in the list";

					Log.info(msg);

					flag = true;
				}
			}
		}
		if (flag == false) {

			msg = "value " + attribute + "  not  found in the api";

			Log.info(msg);

		}

		if (flag == true) {

			msg = "Attribute  " + attribute + "   found in the api";
			Log.info(msg);

			flag = true;

		}

	}

	public static void VerifyValue() throws Exception {
		/*
		 * String attributeValueApi; String attributeValueScript;
		 */

		attributeValueScript = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		attributeValueScript = attributeValueScript.trim();
		flag = false;
		// System.out.println("list valus are");

		if (responseBody.startsWith("[")) {

			try {
				attributeValueApi = jsonobj.getString(attribute);
				flag = true;
				msg = "value " + attributeValueApi
						+ "   found in the api against attribute " + attribute;
				// ConsoleLogs.INFOPass(msg);
				// ExtentHTML.pass(msg);
			} catch (Exception e) {
				flag = false;

			}

			// old code

			/*
			 * String pageAttributevalue = jsonArray.getJSONObject(0).getString(
			 * attribute);
			 */

			if (attributeValueScript.equalsIgnoreCase(attributeValueApi)) {
				flag = true;
				msg = "value " + attributeValueApi
						+ "   found in API against attribute " + attribute;

				Log.info(msg);
			} else {
				flag = false;

				Log.info(msg);
			}
		}

		else {

			for (int i = 0; i < listValues.size(); i++) {

				// System.out.println("value " + i + " " + listValues.get(i));
				if (listValues.get(i).equalsIgnoreCase(attributeValueApi)) {
					msg = "value " + attributeValueApi + "   found in the list";

					Log.info(msg);
					flag = true;
				}
			}
		}
		if (flag == false) {

			msg = "value " + attributeValueApi
					+ "  not found in the list against attribute " + attribute;

			Log.info(msg);
		}

	}

	/*
	 * public static void PostRequest() throws IOException { //
	 * System.out.println("we are in post request"); // String
	 * str="{\"name\":\"vinayak bansal\"}";
	 * 
	 * String body = BuildObjrep.TestCaseHashmap.get("Parameter"); body =
	 * body.replaceAll("\"", "\\\"");
	 * System.out.println("post request body is  " + body); //
	 * RequestSpecification re= res =
	 * given().auth().none().contentType("application/json"). //
	 * body("{\"name\":\"vinayak bansal\"}") body("{\"name\":\"Ajay bansal\"}")
	 * 
	 * .
	 * 
	 * when().post("http://127.0.0.1:5984/restassured"); //
	 * .post("http://ip.jsontest.com/ "); // http://ip.jsontest.com/ // res=
	 * re.post(); // System.out.println( res.getHeaders()); //
	 * System.out.println(res.getHeader("Location")); responseBody =
	 * res.getBody().asString(); // System.out.println(responseBody); msg =
	 * "post request  created at url " + res.getHeader("Location");
	 * 
	 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg);
	 * 
	 * 
	 * URL url = new URL(RestAssured.baseURI ); HttpURLConnection conn =
	 * (HttpURLConnection) url.openConnection(); conn.setDoOutput(true);
	 * conn.setRequestMethod("POST"); conn.setRequestProperty("Content-Type",
	 * "application/json");
	 * 
	 * String input = "{\"name\":\"vinayak bansal\"}";
	 * 
	 * OutputStream os = conn.getOutputStream(); os.write(input.getBytes());
	 * os.flush(); System.out.println("end--------"); String output;
	 * System.out.println("Output from Server .... \n");
	 * System.out.println(conn.getHeaderField("Location")); BufferedReader br =
	 * new BufferedReader(new InputStreamReader( (conn.getInputStream())));
	 * while ((output = br.readLine()) != null) { System.out.println(output);
	 * 
	 * }
	 * 
	 * RequestSpecification
	 * re=given().auth().none().contentType(conn.getHeaderField("Location")) .
	 * body("{\"name\":\"Jimi Hendrix\"}") .
	 * 
	 * when() .proxy(RestAssured.baseURI);
	 * 
	 * res= re.post(); responseBody = res.getBody().asString();
	 * 
	 * res=(Response) conn; System.out.println("we are here"); msg =
	 * "post request  created at url " + conn.getHeaderField("Location");
	 * 
	 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static void GetJSONArray() throws JSONException { String strd =
	 * BuildObjrep.TestCaseHashmap.get("Data"); jsonAttribute = strd.split("/");
	 * 
	 * if (responseBody.startsWith("[")) { jsonArray = new
	 * JSONArray(responseBody);
	 * 
	 * System.out.println( jsonArray.length()); //
	 * System.out.println(jsonArray);
	 * 
	 * // String capital = jsonArray.getJSONObject(0).getString("capital");
	 * 
	 * // Asserting that capital of Norway is Oslo //
	 * Assert.assertEquals(capital, "Oslo");
	 * 
	 * msg = "converted to array";
	 * 
	 * } else {
	 * 
	 * 
	 * 
	 * jsonobj = new JSONObject(responseBody);
	 * 
	 * 
	 * System.out.println( jsonobj.length()); jsonarr =
	 * jsonobj.getJSONArray(jsonAttribute[0]);
	 * 
	 * System.out.println(jsonarr.length());
	 * 
	 * JSONObject jsonobj22 = jsonarr.getJSONObject(jsonarr.length()-1);
	 * 
	 * System.out.println(jsonobj22.length());
	 * 
	 * String pageAttributevalue=jsonobj22.getString("billingSystem");
	 * 
	 * 
	 * System.out.println(pageAttributevalue);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * msg = "convert json object to java object"; System.out.println(msg);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if (jsonAttribute.equals("first")) { jsonarr =
	 * jsonobj.getJSONArray(jsonAttribute[0]);
	 * 
	 * for (int i = 0; i < jsonarr.length(); i++) { //
	 * System.out.println(jsonarr.length()); JSONObject jsonobj2 =
	 * jsonarr.getJSONObject(i); String str =
	 * jsonobj2.getString(jsonAttribute[1]); //
	 * System.out.println("formatted_address" + str); String strint =
	 * str.toString(); listValues.add(strint.toString()); } } else if
	 * (jsonAttribute.equals("last")) { jsonarr =
	 * jsonobj.getJSONArray(jsonAttribute[0]);
	 * 
	 * for (int i = 0; i < jsonarr.length(); i++) { //
	 * System.out.println(jsonarr.length()); JSONObject jsonobj2 =
	 * jsonarr.getJSONObject(i); String str =
	 * jsonobj2.getString(jsonAttribute[1]); //
	 * System.out.println("formatted_address" + str); String strint =
	 * str.toString(); listValues.add(strint.toString()); } } else if
	 * (jsonAttribute.length > 1) { jsonarr =
	 * jsonobj.getJSONArray(jsonAttribute[0]);
	 * 
	 * for (int i = 0; i < jsonarr.length(); i++) { //
	 * System.out.println(jsonarr.length()); JSONObject jsonobj2 =
	 * jsonarr.getJSONObject(i); String str =
	 * jsonobj2.getString(jsonAttribute[1]); //
	 * System.out.println("formatted_address" + str); String strint =
	 * str.toString(); listValues.add(strint.toString()); } } else {
	 * 
	 * JSONObject obj = new JSONObject(responseBody); Iterator itr = obj.keys();
	 * while (itr.hasNext()) { // Get key somehow? itr.getKey() ???
	 * 
	 * // contains the sub items
	 * 
	 * String key = (String) itr.next(); String str = obj.getString(key);
	 * listValues.add(str);
	 * 
	 * }
	 * 
	 * } msg = ""; for (int i = 0; i < jsonAttribute.length; i++) { msg += " " +
	 * jsonAttribute[i]; } msg = "Atribute value  " + msg + " are digged";
	 * 
	 * }
	 * 
	 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg); }
	 * 
	 * @SuppressWarnings("rawtypes") public static void NullValues() throws
	 * JSONException { JSONObject obj = new JSONObject(responseBody); Iterator
	 * itr = obj.keys(); while (itr.hasNext()) { // Get key somehow?
	 * itr.getKey() ???
	 * 
	 * // contains the sub items
	 * 
	 * String key = (String) itr.next(); String str = obj.getString(key); if
	 * (str == "null") { nullCount.add(key); nullvalueCount++; } } msg =
	 * nullvalueCount + " attributes having null values";
	 * 
	 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg); }
	 */
	// end here

	// ////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	public static void openBrowser(String browser) throws Exception {

		// System.out.println("Executing Test Case in: "+browser);

		if (browser.equalsIgnoreCase("Api")) {
		} else if (browser.equalsIgnoreCase("chrome")) {

			if (Constant.CHROMEEXTENABLE == 1) {
				// DesiredCapabilities capabilities =
				// DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--always-authorize-plugins=true");
				options.setExperimentalOption("excludeSwitches",
						Arrays.asList("test-type"));
				// options.addExtensions(new
				// File("C://Users//manojso//AppData//Local//Google//Chrome//User Data//Default//Extensions//lmjegmlicamnimmfhcmpkclmigmmcbeh//3.2_0.crx"));
				System.setProperty("webdriver.chrome.driver",
						Constant.CHROMEDRIVERLOCATION);
				// capabilities.setCapability(ChromeOptions.CAPABILITY,
				// options);
				driver = new ChromeDriver(options);
			} else if (Constant.CHROMEEXTENABLE == 0) {
				System.setProperty("webdriver.chrome.driver",
						Constant.CHROMEDRIVERLOCATION);
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Constant.IMPLICITWAIT, TimeUnit.SECONDS);
			Constant.PARENTWINDOWHANDLE = driver.getWindowHandle();

			Log.info("Opening Chrome for Test case execution");
			Constant.DriverActive = true;

		}

		else if (browser.equalsIgnoreCase("FireFox")) {

			// FirefoxProfile profile = new FirefoxProfile();
			// profile.setPreference("browser.link.open_newwindow.restriction",
			// 2);
			// profile.setPreference("browser.link.open_newwindow.override.external",
			// 2);

			// profile.setPreference("browser.link.open_newwindow", 3);
			FirefoxProfile profile = new FirefoxProfile();
			// ProfilesIni iprofile = new ProfilesIni();
			// FirefoxProfile myprofile = iprofile.getProfile("Selenium_User");
			System.setProperty("webdriver.firefox.marionette",
					"D:/eclipse-luna/Selenium/GOLD Automation/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts()
					.implicitlyWait(Constant.IMPLICITWAIT, TimeUnit.SECONDS);
			Constant.PARENTWINDOWHANDLE = driver.getWindowHandle();
			Log.info("Opening Firefox for Test case execution");
			Constant.DriverActive = true;

		} else if (browser.equalsIgnoreCase("HTMLUnit")) {
			driver = new HtmlUnitDriver(true);

			driver.manage().timeouts()
					.implicitlyWait(Constant.IMPLICITWAIT, TimeUnit.SECONDS);
			Constant.DriverActive = true;

		}

		else if (browser.equalsIgnoreCase("IE")) {

			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				System.out.println("killed all IEDriver Instances");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Thread.sleep(5000);

			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			// ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			/*
			 * /-- Below lines only #####
			 * ieCapabilities.setCapability("nativeEvents", false);
			 * ieCapabilities.setCapability("unexpectedAlertBehaviour",
			 * "accept");
			 * ieCapabilities.setCapability("ignoreProtectedModeSettings",
			 * true); ieCapabilities.setCapability("disable-popup-blocking",
			 * true); ieCapabilities.setCapability("enablePersistentHover",
			 * true); //ieCapabilities.setCapability("takesScreenshot", false);
			 */
			// ieCapabilities.setCapability("enablePersistentHover", false);
			// ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("RequireWindowFocus ", true);

			System.setProperty("webdriver.ie.driver", Constant.IEDRIVER);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Opening IE for Test case execution");
			if (Constant.IECLEANHISTORYFLAG == 0) {

			} else if (Constant.IECLEANHISTORYFLAG == 1) {
				// Delete Browser Cache since IE does not open a clean profile
				try {
					Runtime.getRuntime()
							.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
				} catch (IOException e) {

					e.printStackTrace();

				}
			}

			driver.manage().deleteAllCookies();

			driver.manage().timeouts()
					.implicitlyWait(Constant.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Constant.PARENTWINDOWHANDLE = driver.getWindowHandle();
			Constant.DriverActive = true;
		}

		else {
			// System.out.println("Browser value is not set in the test case sheet");
			Log.error("Browser value is not set in the test case sheet ",
					browser, null);
		}
		Thread.sleep(5000);
	}

	/**
	 * Function to Perform click action on WebElement
	 * 
	 * Fields required: Action field, Web Element location, Web element locator
	 * Type Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void Click() throws Exception {
		SupportLib.waitForAjax();

		// find the UI Object
		actionElement = findElement();

		// to perform click action on the UI Object
		actionElement.click();

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION) + ": Action click";

		// log the message
		Log.info(logmessage);
	}

	/**
	 * Function to move Mouse over a WebElement.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void MouseOverElement() throws Exception {
		// find the UI Object
		actionElement = findElement();
		// create action builder
		Actions builder = new Actions(driver);
		// call movetoElement Method
		builder.moveToElement(actionElement).build().perform();
	}

	/**
	 * Function to Perform click action on webelement if Web Element is present
	 * on the screen else control move to the next step Fields required: Action
	 * field, Web Element location, Web element locator Type Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void ClickIf() throws Exception {
		SupportLib.waitForAjax();
		// store the value of explicit wait
		int buffervalue = Constant.EXPLICITWAIT;
		Constant.EXPLICITWAIT = Constant.EXPLICITWAITIF;

		// find the element
		actionElement = findElement();
		// ActionElement = Findif();
		if (actionElement == null) {// if null log and do nothing
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ ": Action Element is not present moving to next step";
		} else {
			try {
				// click on element
				actionElement.click();
			} catch (Exception e) {
				// go silently
			}

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + ": Action click If";

		}
		Constant.EXPLICITWAIT = buffervalue;
		Log.info(logmessage);
	}

	/**
	 * Function to Clear the filed value for the web element Fields required:
	 * Action field, Web Element location.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void Clear() throws Exception

	{

		actionElement = findElement();

		// clear the text from the element
		actionElement.clear();
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION) + "; Action Clear";
		Log.info(logmessage);
	}

	/**
	 * Function to close the current browser(will close only active browser
	 * only) Fields required: Action field Test case will stop and test control
	 * will move to next test case once this function called.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void Close() throws Exception {

		System.out
				.println("&&&&&&&&&&&&&&&&&&&&&&&&&   close driver for the above test case   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

		// return if the driver is null
		if (driver == null) {
			return;
		}
		// get and loop on all the handles
		/*
		 * for(String handle: driver.getWindowHandles()){
		 * if(!Constant.PARENTWINDOWHANDLE.equalsIgnoreCase(handle)){
		 * driver.switchTo().window(handle); try {
		 * 
		 * driver.close(); //screen = new Screen();
		 * //screen.click("YesButton.jpg"); //screen.click("WindowClose.jpg"); }
		 * catch (Exception e) { Log.info(e.getMessage().toString()); }
		 * //driver.switchTo().defaultContent(); }
		 * 
		 * }
		 */

		if (Constant.GUARDIANLOGIN) {
			try {// do clean up during close
				driver.switchTo().window(Constant.PARENTWINDOWHANDLE);
				System.out.println("Parent window Page title is : "
						+ driver.getTitle());
				driver.findElement(By.className("logout_image")).click();
				alertif();
				driver.close();
				Thread.sleep(5000);
				driver.switchTo().window(Constant.MainWindowHandle);
				System.out.println("Main window Page title is : "
						+ driver.getTitle());
				driver.switchTo().frame(
						driver.findElement(By.name("bgmainframe")));

				driver.findElement(By.xpath("//img[@title='Logout']")).click();
				Thread.sleep(5000);
				driver.navigate().refresh();

			} catch (Exception e) {
				driver.switchTo().window(Constant.MainWindowHandle);
				driver.switchTo().frame(
						driver.findElement(By.name("bgmainframe")));
				driver.findElement(By.xpath("//img[@title='Logout']")).click();
				System.out.println(e.getMessage());
			}
		}
		if (Constant.browserName.equalsIgnoreCase("IE")) {
			try {// do clean up during close
				driver.switchTo().window(Constant.PARENTWINDOWHANDLE);
				Thread.sleep(3000);
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				Log.info("killed all IEDriver Instances, sucessfully");
				// create the new instance of Screen
				screen = new Screen();
				// call hover to hover the mouse at the center of the screen
				screen.hover(screen.getCenter());

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			driver.close();
			driver.quit();
		}
		Constant.DriverActive = false;
		Thread.sleep(2000);

	}

	/**
	 * Not a Lib Function. It is called by Test control function from test case
	 * runner file, and is used in excel file after the all the steps are
	 * complete and is used as a wrapper for Close function.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void End() throws Exception {
		// calling close function
		Close();
	}

	/**
	 * Not a Lib Function. It is called by Test control function from test case
	 * runner file, and is used as a wrapper for Close function.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void Quit() throws Exception {
		// calling close function
		Close();
	}

	/**
	 * DragDrop functionality on the WebElement element.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void dragDrop() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Drag and Drop";
		Log.info(logmessage);
		actionElement = findElement();
		Actions builder = new Actions(driver);

		actionElement.click();
		// get the XY Axis location from the data sheet
		String XYloc = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		// split by ','
		String[] xandy = XYloc.split(",");
		int x = Integer.parseInt(xandy[0]);
		int y = Integer.parseInt(xandy[1]);

		// perform drag drop
		builder.dragAndDropBy(actionElement, x, y).build().perform();
	}

	/**
	 * function to switch Window while logging in using gaurdian.
	 * 
	 * @throws InterruptedException
	 */
	public static void windowSwitchGuardian() throws InterruptedException {
		String CurrentWindowHandle = driver.getWindowHandle();
		Set<String> wHandles = driver.getWindowHandles();

		// do not switch if there was no app choice page shown
		if (!Constant.APPCHOICEFLAG) {
			// close the warning window
			for (String winHandle : wHandles) {
				if (!winHandle.equals(CurrentWindowHandle)) {
					driver.switchTo().window(winHandle);
					if (driver.getTitle().equalsIgnoreCase(
							"Internal server error")) {
						driver.close();
					}

					driver.switchTo().window(CurrentWindowHandle);
				}
			}
			// switch to the content frame
			driver.switchTo().frame(driver.findElement(By.name("contentFrm")));
			Thread.sleep(5000);
			return;
		}
		// loop on all handles,
		for (String winHandle : wHandles) {
			if (!winHandle.equals(CurrentWindowHandle)) {
				// switch to the new window
				driver.switchTo().window(winHandle);
				System.out.println("----------- inside for -----------------");
				System.out.println(winHandle);
				System.out.println(driver.getTitle());
				((JavascriptExecutor) driver).executeScript("window.focus()");
				driver.manage().window().maximize();
				Constant.PARENTWINDOWHANDLE = winHandle;
				// close the Previous Window
				driver.switchTo().window(CurrentWindowHandle);
				// driver.close();
				driver.switchTo().window(winHandle);
				break;

			}

		}
	}

	/**
	 * Function to switch window when More than one windows are present required
	 * Title of the window in the data field of test case.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void windowSwitch() throws Exception {
		Thread.sleep(3000);
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Window Switch";

		Log.info(logmessage);

		// get data from the excel
		String Data = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTFINDERTYPE);

		// switch window using URL
		if (Data.contains("URL")) {

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				// System.out.println(driver.getCurrentUrl());
				if (driver.getCurrentUrl().contains(
						ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.DATA))) {
					// System.out.println(driver.getCurrentUrl());
					((JavascriptExecutor) driver)
							.executeScript("window.focus()");
					driver.manage().window().maximize();
					Constant.CHILDWINDOWHANDLE = winHandle;
					break;
				} else {

				}

			}

		} else if (Data.contains("Title")) // switch window using Title
		{
			// Log.info("----------- before for -----------------");
			Log.info(Constant.PARENTWINDOWHANDLE);
			Log.info(driver.getTitle());

			String CurrentWindowHandle = driver.getWindowHandle();
			Set<String> wHandles = driver.getWindowHandles();

			// waiting for some time for more than one windows
			Integer ix = 0;
			while (!(wHandles.size() > 1)) {
				Thread.sleep(1000);
				wHandles = driver.getWindowHandles();
				if (ix > 15) {
					System.out.println("exhaused the number of tries "
							+ "to get more than one handle");
					break;
				}
				ix++;
			}

			for (String winHandle : wHandles) {
				String windowTitle = driver.getTitle().trim().toString()
						.toLowerCase();
				String ExcelDataTitle = ExcelUtils
						.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)
						.trim().toString().toLowerCase();

				if (!winHandle.equals(CurrentWindowHandle)) {
					driver.switchTo().window(winHandle);
					// Log.info("----------- inside for -----------------");
					Log.info(winHandle);
					Log.info(driver.getTitle());

					windowTitle = driver.getTitle().trim().toString()
							.toLowerCase();
					Constant.CHILDWINDOWHANDLE = winHandle;
					if (windowTitle.contains(ExcelDataTitle)
							|| windowTitle.equals(ExcelDataTitle)) {

						// ((JavascriptExecutor)driver).executeScript("window.focus()");
						driver.manage().window().maximize();

						break;
					}
				}

			}

			// Log.info("----------- after for -----------------");
			Log.info(driver.getWindowHandle());
			Log.info(driver.getTitle());

		} else if (Data.contains("default")) {

			System.out.println("here");
			try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {

				// block to switch to the Parent Window by default
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

			}
		} else {
			// block to switch to the Parent Window by default
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			/*
			 * String[] handles = driver.getWindowHandles().toArray(new
			 * String[0]);
			 * 
			 * ExcelUtils.setExcelFile(Constant.SPATH, Constant.SHEETPATH);
			 * Log.info("Window Switch : Switching back to the Parent Window");
			 * Log.info(handles[handles.length - 1]);
			 * driver.switchTo().window(handles[handles.length - 1]);
			 */

		}

		// adding default time out as per implicit wait in constant
		/*
		 * driver.manage().timeouts() .implicitlyWait(Constant.IMPLICITWAIT,
		 * TimeUnit.SECONDS);
		 */
	}

	/**
	 * Function to switch Tab when more than one tab are present
	 * 
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void TabSwitch() throws Exception {

		// create instance of Robot
		Robot robot = new Robot();

		// get the tab number to switch to
		int i = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION) + "; Action: Tab Switch";
		Log.info(logmessage);

		// press control key
		robot.keyPress(KeyEvent.VK_CONTROL);

		// switch to the desired tab
		switch (i) {
		case 1:
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyRelease(KeyEvent.VK_NUMPAD1);
			break;
		case 2:
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyRelease(KeyEvent.VK_NUMPAD2);
			break;
		case 3:
			robot.keyPress(KeyEvent.VK_NUMPAD3);
			robot.keyRelease(KeyEvent.VK_NUMPAD3);
			break;
		case 4:
			robot.keyPress(KeyEvent.VK_NUMPAD4);
			robot.keyRelease(KeyEvent.VK_NUMPAD4);
			break;
		case 5:
			robot.keyPress(KeyEvent.VK_NUMPAD5);
			robot.keyRelease(KeyEvent.VK_NUMPAD5);
			break;
		case 6:
			robot.keyPress(KeyEvent.VK_NUMPAD6);
			robot.keyRelease(KeyEvent.VK_NUMPAD6);
			break;
		case 7:
			robot.keyPress(KeyEvent.VK_NUMPAD7);
			robot.keyRelease(KeyEvent.VK_NUMPAD7);
			break;
		case 8:
			robot.keyPress(KeyEvent.VK_NUMPAD8);
			robot.keyRelease(KeyEvent.VK_NUMPAD8);
			break;
		default:
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; Action: Tab Switch will work only for tab 1 - 8 please enter int 1-8 in test data";
			Log.warn(logmessage);
		}

		// release control key
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);

	}

	/**
	 * Function to Perform Logical click action Smart element(If web element is
	 * not displayed on the screen, can be used to drag the scroll bar using
	 * "AND_XPATH:" seperator) Smart element(Random webelement xpath generation
	 * if Xpath provided with ^ wherer random value is need to generated, to use
	 * this need not to provide [] for the element
	 * 
	 * Fields required: Action field, Web Element location(AND_XPATH: and ^ can
	 * be use for smart option).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void LClick() throws Exception {
		Random Rand = new Random();
		// System.out.println(ExcelUtils.getCellData(Constant.testcaserownum,
		// 3));
		String ExlXpath = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);
		String[] Scroll_ver = ExlXpath.split("AND_XPATH:");
		String[] rnd_ver;
		String ScrollBarXpath = null;
		String EXpath = null;
		List<WebElement> LWE;

		if (Scroll_ver.length > 1) {
			ScrollBarXpath = Scroll_ver[1];
			EXpath = Scroll_ver[0];

		}

		else {
			EXpath = ExlXpath;

		}

		rnd_ver = EXpath.split("\\^");
		if (rnd_ver.length > 1) {
			LWE = driver.findElements(By.xpath(rnd_ver[0] + rnd_ver[1]));

			int randomnum = Rand.nextInt(LWE.size());
			if (randomnum == 0) {
				randomnum++;
			} else {
			}
			// System.out.println("Size of the table is= "+rnd_ver.length);
			// System.out.println("Value of generated random Number is "+randomnum);
			EXpath = rnd_ver[0] + "[" + randomnum + "]" + rnd_ver[1];
			// System.out.println(EXpath);
		} else {
		}

		if (Scroll_ver.length > 1) {

			WebElement we2 = driver.findElement(By.xpath(ScrollBarXpath));

			Actions dragger = new Actions(driver);
			Thread.sleep(1000L);
			while (!driver.findElement(By.xpath(EXpath)).isDisplayed() == true) {
				dragger.moveToElement(we2).clickAndHold().moveByOffset(0, 10)
						.perform();
				dragger.release().perform();

			}

		}

		else {
		}

		System.out.println("Final xpath of the element is " + EXpath);
		driver.findElement(By.xpath(EXpath)).click();

	}

	/**
	 * Function to Switch to another Frame Fields required: Action, Element
	 * locator type, Element Location Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void FrameSwitch() throws Exception {
		/*
		 * // Frames go away in IE11 // if(Constant.IE11) return; actionElement
		 * = findElement(); // switch to the frame
		 * driver.switchTo().frame(actionElement);
		 */

	}

	/**
	 * function to Switch back to default frame Fields required: N/A Test data:
	 * N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void FrameDefault() throws Exception {
		// switch to default content
		// if(Constant.IE11){
		// System.out.println("Testing frame switch");
		// return;
		// }
		// driver.switchTo().defaultContent();
	}

	/**
	 * function to do Mouse Hover and click action together on the Web Element
	 * Fields required: Action,Element locator type, Element Location Test data:
	 * N/A.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void MouseHoverClick() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (!SubElementLink.isEmpty()) {
			action.moveToElement(actionElement)
					.moveToElement(
							driver.findElement(getObjectByLogicalName(SubElementLink)))
					.click().build().perform();
		} else {
			action.moveToElement(actionElement).click().build().perform();
		}

	}

	/**
	 * Function to Create the soap request.
	 *
	 * @param strPath
	 *            ; the path of the xml request file
	 * @param SOAPAction
	 *            the SOAP action
	 * @return the SOAP message
	 * @throws Exception
	 *             the exception
	 */
	private static SOAPMessage createSOAPRequest(String strPath,
			String SOAPAction) throws Exception {

		// Create a SOAP message from the XML file located at the given path
		FileInputStream fis = new FileInputStream(new File(strPath));
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(), fis);
		// adding the action header
		MimeHeaders mimeHeaders = message.getMimeHeaders();
		mimeHeaders.addHeader("SOAPAction", "urn:" + SOAPAction);
		return message;
	}

	/**
	 * Function to Get the SOAP response.
	 *
	 * @param soapRequest
	 *            the soap request
	 * @param strEndpoint
	 *            the EndPoint
	 * @return the SOAP response
	 * @throws Exception
	 *             the exception
	 * @throws SOAPException
	 *             the SOAP exception
	 */
	private static SOAPMessage getSOAPResponse(SOAPMessage soapRequest,
			String strEndpoint) throws Exception, SOAPException {

		// Send the SOAP request to the given endpoint and return the
		// corresponding response
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage soapResponse = soapConnection
				.call(soapRequest, strEndpoint);

		return soapResponse;
	}

	/**
	 * Sends the SOAP request and gets the SOAP response.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void SOAPReqResponse() throws Exception {
		String RequestFilePath = Constant.DATAENGINEPATH
				+ "soap\\"
				+ ExcelUtils
						.getCellData(Constant.TESTCASEROWNUM, Constant.DATA);
		String SOAPAction = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);
		SOAPMessage soapRequest = createSOAPRequest(RequestFilePath, SOAPAction);

		// Send the request to the indicated endpoint and capture the response
		SOAPMessage soapResponse = getSOAPResponse(soapRequest,
				Constant.TEMPSTORAGE.get("SOAPEndPoint"));
		// store the response as file
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer.transform(new DOMSource(soapResponse.getSOAPBody()),
				new StreamResult(new File(Constant.DATAENGINEPATH
						+ "soap\\responses\\" + Constant.CURRENTTESTCASE
						+ ".xml")));
	}

	/**
	 * Function to Edit the xml tag value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	private static String[] tagNames;

	public static void EditXMLTagValue() throws Exception {
		tagNames = null;
		String[] RequestFilePathTagName = ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA).split(",");
		String RequestFilePath = Constant.DATAENGINEPATH + "soap\\"
				+ RequestFilePathTagName[0];
		String ParentTagName = null;

		// get data for tag from Excel
		String tagName = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);
		// String[] tagNames;
		if (tagName.contains(",")) {
			tagNames = tagName.split(",");
			ParentTagName = tagNames[0];
		}

		String tagValue = null;

		if (RequestFilePathTagName[1].startsWith("#")) {// get the Value from
														// the temporary run
														// time storage
			tagValue = Constant.TEMPSTORAGE.get(RequestFilePathTagName[1]);
		} else {
			tagValue = RequestFilePathTagName[1];
		}

		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document document = null;
		try {
			File xmlFileRequest = new File(RequestFilePath);
			FileInputStream fstreamRequest = new FileInputStream(xmlFileRequest);
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(fstreamRequest);
			NodeList elements;
			if (tagName.contains(",") && tagNames.length > 0) {
				elements = document.getElementsByTagName(tagNames[1]);
			} else {
				elements = document.getElementsByTagName(tagName);
			}

			if (elements.getLength() != 1) {
				System.out.println("Expected exactly one element " + tagName
						+ "in message, but found "
						+ Integer.toString(elements.getLength()));
				// if Parent tag name passed in data, then set the text
				// content for the child
				if (elements.getLength() > 1 && ParentTagName != null) {
					for (int i = 0; i < elements.getLength(); i++) {

						if (elements.item(i).getParentNode().getNodeName()
								.equalsIgnoreCase(ParentTagName)) {
							elements.item(i).setTextContent(tagValue);
						}
					}
				}
			} else {
				// edit the value of the tag
				if (tagValue != null) {
					elements.item(0).setTextContent(tagValue);
				}
			}
			// transform the request xml file with updated values
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(
					new File(RequestFilePath)));

		} catch (Exception e) {
			// print the exception
			System.out.println(e.getMessage());
		}

	}

	public static void EditMLANXMLTagValue() throws Exception {
		tagNames = null;
		String[] RequestFilePathTagName = ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA).split(",");
		String RequestFilePath = Constant.DATAENGINEPATH + "soap\\"
				+ RequestFilePathTagName[0];
		String ParentTagName = null;

		// get data for tag from Excel
		String tagName = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);
		// String[] tagNames;
		if (tagName.contains(",")) {
			tagNames = tagName.split(",");
			ParentTagName = tagNames[0];
		}

		String tagValue = null;

		if (RequestFilePathTagName[1].startsWith("#")) {// get the Value from
														// the temporary run
														// time storage
			tagValue = Constant.TEMPSTORAGE.get(RequestFilePathTagName[1]);
		} else {
			tagValue = RequestFilePathTagName[1];
		}

		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document document = null;
		try {
			File xmlFileRequest = new File(RequestFilePath);
			FileInputStream fstreamRequest = new FileInputStream(xmlFileRequest);
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(fstreamRequest);
			NodeList elements;
			if (tagName.contains(",") && tagNames.length > 0) {
				elements = document.getElementsByTagName(tagNames[1]);
			} else {
				elements = document.getElementsByTagName(tagName);
			}

			if (elements.getLength() != 1) {
				System.out.println("Expected exactly one element " + tagName
						+ "in message, but found "
						+ Integer.toString(elements.getLength()));
				// if Parent tag name passed in data, then set the text
				// content for the child
				if (elements.getLength() > 1 && ParentTagName != null) {
					if (RequestFilePathTagName[1].startsWith("#")) {// get the
																	// Value
																	// from the
																	// temporary
																	// run time
																	// storage

						if (elements.item(1).getParentNode().getNodeName()
								.equalsIgnoreCase("ins:ServiceIDDestination")) {
							elements.item(1).setTextContent(tagValue);
						} else {
							elements.item(2).setTextContent(tagValue);
						}
					} else {
						elements.item(1).setTextContent(tagValue);
					}
				}
			} else {
				// edit the value of the tag
				if (tagValue != null) {
					elements.item(0).setTextContent(tagValue);
				}
			}
			// transform the request xml file with updated values
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(
					new File(RequestFilePath)));

		} catch (Exception e) {
			// print the exception
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Function to Parse the soap response xml.
	 *
	 * @param tagName
	 *            the tag name
	 * @return the string
	 */
	private static String parseResponseXML(String tagName) {
		String tagValue = "";
		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document document = null;
		String fileRequestInput = Constant.DATAENGINEPATH + "soap\\responses\\"
				+ Constant.CURRENTTESTCASE + ".xml";
		try {

			File xmlFileRequest = new File(fileRequestInput);
			FileInputStream fstreamRequest = new FileInputStream(xmlFileRequest);
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(fstreamRequest);
			// get the elements matching the passed tagName
			NodeList elements = document.getElementsByTagName(tagName);
			if (elements.getLength() != 1) {
				System.out.println("Expected exactly one element " + tagName
						+ "in message, but found "
						+ Integer.toString(elements.getLength()));
				if (elements.getLength() > 1) {
					// System.out.println("TODO : Search in the multiple tags for the expected Value");
					for (int i = 0; i < elements.getLength(); i++) {

						tagValue = tagValue + ";$"
								+ elements.item(i).getTextContent();

					}
				}

			} else {
				tagValue = elements.item(0).getTextContent();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// return the tag Value
		return tagValue;
	}

	/**
	 * function to temporarily stores value in Temporary storage Hash.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void storeValue() throws Exception {
		// store the value passed from excel
		Constant.TEMPSTORAGE.put(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION), ExcelUtils
				.getCellData(Constant.TESTCASEROWNUM, Constant.DATA));

		System.out
				.println(" ----------store value sucessfully open-------------------------");
	}

	/**
	 * function to move the mouse move using Robot Library.
	 *
	 * @param X
	 *            the x
	 * @param Y
	 *            the y
	 * @throws AWTException
	 *             the AWT exception
	 */
	private static void robotMouseMove(int X, int Y) throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(X, Y);

	}

	/**
	 * function to Gets the object by logical name.
	 *
	 * @param ObjLogicalName
	 *            the obj logical name
	 * @return the object of type by
	 */
	private static By getObjectByLogicalName(String ObjLogicalName) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.EXPLICITWAIT);
		WebElement we = null;
		try {
			Class<?> orcls = Class.forName("objrepositories."
					+ Constant.APPLICATIONREPOSITORYNAME);

			// wait until the Visibility of the element is located
			we = (wait.until(ExpectedConditions
					.visibilityOfElementLocated((By) orcls.getField(
							ObjLogicalName).get(null))));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (By) we;
	}

	/**
	 * Mouse Hover and doubleClick action on the Web Element Fields required:
	 * Action, Element locator type, Element Location Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void mouseHoverdoubleClick() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Double Click";
		Log.info(logmessage);
		actionElement = findElement();
		Actions action = new Actions(driver);

		// perform double click on an element
		action.moveToElement(actionElement).doubleClick().build().perform();

	}

	/**
	 * function to enter a value in the Web Element
	 * 
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: Value to enter in the Web-Element.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void submitValue() throws Exception {
		SupportLib.waitForAjax();
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit Value";
		Log.info(logmessage);
		String sData = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		String[] sAData = sData.split(",");
		actionElement = findElement();
		if (sAData.length > 1) {
			// entering the value in the webelement
			actionElement.sendKeys(sAData[1]);
		} else {
			// entering the value in the webelement
			actionElement.sendKeys(sAData[0]);
		}

	}

	/**
	 * SubmitIfValue action on the Web Element if Web Element is present on the
	 * page
	 * 
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: Value to enter in the Web-Element.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void submitIfValue() throws Exception {
		SupportLib.waitForAjax();
		int buffervalue = Constant.EXPLICITWAIT;
		Constant.EXPLICITWAIT = Constant.EXPLICITWAITIF;
		// ActionElement = Findif();
		actionElement = findElement();
		if (actionElement == null) {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ ": Action Element is not present moving to next step";
		} else {
			actionElement.sendKeys(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA));
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ ": Action Submit If";

		}
		Constant.EXPLICITWAIT = buffervalue;
		Log.info(logmessage);
	}

	/**
	 * SubmitRandom Value action on the Web Element Fields required: Action,
	 * Element locator type, Element Location Test data: type of random value :
	 * A: alphabet value, N for numbers, AN for Alphanumeric and ANS is alpha
	 * numeric with special char. test data need to contain type of random value
	 * followed by : and length of the value i.e. A:4 will enter a 4 digit
	 * alphanumeric value
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void submitRandom() throws Exception {
		String test = null;
		actionElement = findElement();
		if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)
				.contains(":")) {
			int arrayindex = Integer.parseInt(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA));
			String Submitvalue = valuestored.get(arrayindex);
			actionElement.sendKeys(Submitvalue);
		}

		else {
			String[] valueTD = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA).split(":");

			int Lengthvalue = Integer.parseInt(valueTD[1]);

			if (valueTD[0].equalsIgnoreCase("A")) {
				test = randomGenerator(Lengthvalue, 1);
			} else if (valueTD[0].equalsIgnoreCase("N")) {
				test = randomGenerator(Lengthvalue, 2);
			} else if (valueTD[0].equalsIgnoreCase("AN")) {
				test = randomGenerator(Lengthvalue, 3);
			}

			else if (valueTD[0].equalsIgnoreCase("ANS")) {
				test = randomGenerator(Lengthvalue, 4);
			}

			// System.out.println(test);
			actionElement.sendKeys(test + Keys.TAB);
			valuestored.add(test);
		}
		int size = valuestored.size();
		size = size - 1;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit Random Value: "
				+ test
				+ "; "
				+ "Index No is" + size;
		Log.info(logmessage);
	}

	/**
	 * function to explicit wait on the Web Element; used to synchronization
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void explicitWait() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Explicit Wait";
		Log.info(logmessage);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.ELEMENTLOCATION))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.ELEMENTLOCATION))));

	}

	/**
	 * function for pause the the driver for seconds passed in test data Fields
	 * required: Action, Element locator type, Element Location Test data:
	 * Duration of wait in the data field.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for "
				+ ExcelUtils
						.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)
				+ " Milli seconds";
		Log.info(logmessage);

		int waitvalue = Integer.valueOf(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
		Thread.sleep(waitvalue);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 5 seconds
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_5() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 5000" + " Milli seconds";
		Log.info(logmessage);

		Thread.sleep(2000);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 10 seconds
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_10() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 10000" + " Milli seconds";
		Log.info(logmessage);

		// Thread.sleep(2000);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 15 seconds.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_15() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 15000" + " Milli seconds";
		Log.info(logmessage);

		Thread.sleep(2000);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 20 seconds.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_20() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 20000" + " Milli seconds";
		Log.info(logmessage);

		// Thread.sleep(2000);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 25 seconds.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_25() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 25000" + " Milli seconds";
		Log.info(logmessage);

		Thread.sleep(2000);
		// System.out.println("after sec" + waitvalue);

	}

	/**
	 * function for pause the the driver for 30 seconds.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void threadWait_30() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Manual Wait for 30000" + " Milli seconds";
		Log.info(logmessage);

		// Thread.sleep(30000);
		// System.out.println("after sec" + waitvalue);

		int iCount = 0;
		if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTFINDERTYPE).isEmpty()) {
			while (iCount < 30) {

				try {
					actionElement = findElement();
					if (!actionElement.isDisplayed()) {

						Thread.sleep(5000);
						iCount = iCount + 5;
						System.out.println("Waiting Sec : " + iCount);

					} else {
						iCount = 35;
					}
				} catch (Exception e)

				{
					Thread.sleep(5000);
					iCount = iCount + 5;
					System.out.println("Waiting Sec : " + iCount);
				}

			}
		} else {
			// Thread.sleep(30000);
		}
	}

	/**
	 * function select value from a select box/DropDown on the Page.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void dropDownSelectByValue() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Drop Down Select";
		Log.info(logmessage);
		actionElement = findElement();

		new Select(actionElement).selectByValue(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
	}

	/**
	 * DropDownSelect for the driver for a DropDown on the Page Fields required:
	 * Action, Element locator type, Element Location Test data: value to select
	 * in the drop down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void dropDownSelect() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Drop Down Select";
		Log.info(logmessage);
		actionElement = findElement();

		new Select(actionElement).selectByVisibleText(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
	}

	/**
	 * function to find a value in the Drop Down and select the Value .
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void dropDownFindSelect() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Drop Down Select";
		Log.info(logmessage);
		actionElement = findElement();
		/*
		 * new Select(ActionElement).selectByVisibleText(ExcelUtils.getCellData(
		 * Constant.testcaserownum, Constant.Data));
		 */
		String SelectValue = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		List<WebElement> OptionElements = new Select(actionElement)
				.getOptions();

		for (WebElement option : OptionElements) {
			if (option.getText().toLowerCase()
					.contains(SelectValue.toLowerCase())) {
				option.click();
				break;
			}
		}

	}

	/**
	 * Capture and stored value to use further in the script Fields required:
	 * Action, Element locator type, Element Location, Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void valueCapture() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String[] fetchfrompage = null;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText().split(" ");
			valueCaptured.add(fetchfrompage[0]);
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = valueCaptured.size();
			size = size - 1;

			logmessage = valueCaptured.get(size)
					+ "; Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			valueCaptured.add(actionElement.getAttribute(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = valueCaptured.size();
			size = size - 1;
			logmessage = valueCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}
		Log.info(logmessage);
	}

	/**
	 * Capture and stored bundle child order value to use further in the script
	 * Fields required: Action, Element locator type, Element Location, Test
	 * data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void BundleOrderCapture() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String[] fetchfrompage = null;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText().split(" ");
			BundleOrderCaptured.add(fetchfrompage[0]);
			Constant.BUNDLEORDERNUMBER = fetchfrompage[0];
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = BundleOrderCaptured.size();
			size = size - 1;

			logmessage = BundleOrderCaptured.get(size)
					+ "; Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			BundleOrderCaptured.add(actionElement.getAttribute(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = BundleOrderCaptured.size();
			size = size - 1;
			logmessage = BundleOrderCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}
		Log.info(logmessage);
	}

	/**
	 * function to Capture and store the value of a tag from a soap response .
	 * Fields Required : Xml Tag Name
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void captureSOAPResponseTagValue() throws Exception {

		String orderNumber = parseResponseXML(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION));

		orderNumberCaptured.add(orderNumber);
		// ValueCaptureindex=ValueCaptureindex+1;
		int size = orderNumberCaptured.size();
		size = size - 1;
		logmessage = orderNumberCaptured.get(size)
				+ "; Value has been stored in index: " + size;

		Log.info(logmessage);

		// fail the step and the test case if order number was not captured
		if (orderNumber.isEmpty() || orderNumber == null) {
			Log.info("failing the testcase as there was no order number captured");
			TestCaseRunner.vResult = 0;
		}

	}

	/**
	 * function to the value of a tag in the soap response xml Fields required :
	 * tag Name and tag value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifySOAPResponseTagValue() throws Exception {

		// System.out.println(parseResponseXML(ExcelUtils.getCellData(Constant.testcaserownum,
		// Constant.Elementlocation)));
		String ExpectedTagValue = ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA);
		String sExpectedTagValue = null;

		if (ExpectedTagValue.startsWith("#")) {
			sExpectedTagValue = Constant.TEMPSTORAGE.get(ExpectedTagValue);
		} else {
			sExpectedTagValue = ExpectedTagValue;
		}

		String ActualtagValue = parseResponseXML(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION));
		logmessage = "Exptected Value : " + sExpectedTagValue + ", ";

		if (ActualtagValue.contains(";$")) {
			if (ActualtagValue.contains(sExpectedTagValue)) {
				logmessage += "matched Actual Value " + ActualtagValue;
			} else {
				logmessage += "did NOT match Actual Value " + ActualtagValue;
				TestCaseRunner.vResult = 0;
			}

		} else {

			if (ActualtagValue.equals(sExpectedTagValue)) {
				logmessage += "matched Actual Value " + ActualtagValue;
			} else {
				logmessage += "did NOT match Actual Value " + ActualtagValue;
				TestCaseRunner.vResult = 0;
			}
		}

		Log.info(logmessage);
	}

	/**
	 * function to Capture and stored Order Number to use further in the script
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	/*
	 * public static void orderNumberCapture() throws Exception { logmessage =
	 * ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.TESTSTEPID) +
	 * "; " + ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	 * Constant.TESTSTEPDESCRIPTION) + "; Action: Capture and stored value";
	 * Log.info(logmessage); String fetchfrompage = null; actionElement =
	 * findElement(); if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	 * Constant.DATA1) .isEmpty()) { fetchfrompage = actionElement.getText();
	 * String orderNumber = fetchfrompage.substring(9, 15);
	 * orderNumberCaptured.add(orderNumber); Constant.ORDERNUMBER=orderNumber;
	 * // ValueCaptureindex=ValueCaptureindex+1; int size =
	 * orderNumberCaptured.size(); size = size - 1; logmessage =
	 * orderNumberCaptured.get(size) + "; Value has been stored in index: " +
	 * size;
	 * 
	 * 
	 * } else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	 * Constant.DATA1).isEmpty()) {
	 * 
	 * orderNumberCaptured.add(actionElement.getAttribute(ExcelUtils
	 * .getCellData(Constant.TESTCASEROWNUM, Constant.DATA1))); //
	 * System.out.println(ValueCaptured.get(ValueCaptureindex)); int size =
	 * orderNumberCaptured.size(); size = size - 1; logmessage =
	 * orderNumberCaptured.get(size) + "; Value has been stored in index: " +
	 * size;
	 * 
	 * // ValueCaptureindex=ValueCaptureindex+1;
	 * 
	 * } Log.info(logmessage); }
	 */
	/**
	 * function to Capture and stored Order Number to use further in the script
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void orderNumberCapture() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String fetchfrompage = null;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();
			String orderNumber = fetchfrompage.substring(9, 16).trim();
			orderNumberCaptured.add(orderNumber);
			Constant.ORDERNUMBER = orderNumber;
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = orderNumberCaptured.size();
			size = size - 1;
			logmessage = orderNumberCaptured.get(size)
					+ "; Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			orderNumberCaptured.add(actionElement.getAttribute(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = orderNumberCaptured.size();
			size = size - 1;
			logmessage = orderNumberCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}
		Log.info(logmessage);
	}

	public static void doNothing() throws Exception {

		System.out.println("here");
	}

	/**
	 * function to Capture and stored USID Number to use further in the script
	 * Fields required: Action, Element locator type, Element Location Test
	 * data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void uSIDCapture() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String fetchfrompage = null;
		USIDCaptured.clear();
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();
			// String orderNumber = fetchfrompage.substring(9, 15);
			USIDCaptured.add(fetchfrompage.trim());
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = USIDCaptured.size();
			size = size - 1;
			logmessage = USIDCaptured.get(size)
					+ "; USID Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			USIDCaptured.add(actionElement.getAttribute(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = USIDCaptured.size();
			size = size - 1;
			logmessage = USIDCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}

		Constant.TEMPSTORAGE.put("#USID", fetchfrompage.trim());

		Log.info(logmessage);
	}

	/**
	 * Function to verify the runtime Value of an element with the value passed
	 * from test data Fields required: Action, Element locator type, Element
	 * Location, Test data: Expected Value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyCapture() throws Exception {
		String fetchfrompage, Verification;
		int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Verify stored value";
		Log.info(logmessage);
		actionElement = findElement();
		arrayindex = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
		Verification = valueCaptured.get(arrayindex);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();

			if (Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			fetchfrompage = actionElement.getAttribute(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA1));

			if (Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		}
		Log.info(logmessage);
	}

	/**
	 * Function to verify the runtime Value of an element with the value passed
	 * from test data is not equal Fields required: Action, Element locator
	 * type, Element Location, Test data: Expected Value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyNotCapture() throws Exception {
		String fetchfrompage, Verification;
		int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Verify stored value";
		Log.info(logmessage);
		actionElement = findElement();
		arrayindex = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
		Verification = valueCaptured.get(arrayindex);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();

			if (!Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			fetchfrompage = actionElement.getAttribute(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA1));

			if (!Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		}
		Log.info(logmessage);
	}

	/**
	 * function to enter the value stored using function VerifyCapture Fields
	 * Required : Action, Element locator type, Element Location, Test data:
	 * Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void submitCapture() throws Exception {

		int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value";
		Log.info(logmessage);
		actionElement = findElement();
		arrayindex = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
		actionElement.sendKeys(valueCaptured.get(arrayindex));
		Log.info(logmessage);
	}

	/**
	 * function to enter the value stored using function Ref OrderNumberCapture
	 * Fields Required : Action, Element locator type, Element Location, Test
	 * data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void refOrderSubmitCapture() throws Exception {

		// int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value";
		Log.info(logmessage);
		actionElement = findElement();
		// arrayindex = Integer.parseInt(ExcelUtils.getCellData(
		// Constant.testcaserownum, Constant.Data));
		// ActionElement.sendKeys(OrderNumberCaptured.get(arrayindex));
		actionElement.sendKeys(String.valueOf(Constant.REFORDERNUMBER));
		Log.info(logmessage);
	}

	/**
	 * function to enter the value stored using function Ref Child
	 * OrderNumberCapture Fields Required : Action, Element locator type,
	 * Element Location, Test data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void refChildOrderSubmitCapture() throws Exception {

		// int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value";
		Log.info(logmessage);
		actionElement = findElement();
		// arrayindex = Integer.parseInt(ExcelUtils.getCellData(
		// Constant.testcaserownum, Constant.Data));
		// ActionElement.sendKeys(OrderNumberCaptured.get(arrayindex));
		actionElement.sendKeys(Constant.REFCHILDORDERNUMBER);
		Log.info(logmessage);
	}

	/**
	 * function to enter the value stored using function OrderNumberCapture
	 * Fields Required : Action, Element locator type, Element Location, Test
	 * data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void orderSubmitCapture() throws Exception {

		// int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value";
		Log.info(logmessage);
		actionElement = findElement();
		// arrayindex = Integer.parseInt(ExcelUtils.getCellData(
		// Constant.testcaserownum, Constant.Data));
		// ActionElement.sendKeys(OrderNumberCaptured.get(arrayindex));
		actionElement.clear();
		actionElement.sendKeys(String.valueOf(Constant.ORDERNUMBER));
	}

	/**
	 * function to enter the value of bundle child order stored using function
	 * OrderNumberCapture Fields Required : Action, Element locator type,
	 * Element Location, Test data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void BundleorderSubmitCapture() throws Exception {

		// int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value";
		Log.info(logmessage);
		actionElement = findElement();
		// arrayindex = Integer.parseInt(ExcelUtils.getCellData(
		// Constant.testcaserownum, Constant.Data));
		// ActionElement.sendKeys(OrderNumberCaptured.get(arrayindex));
		actionElement.sendKeys(Constant.BUNDLEORDERNUMBER);
		Log.info(logmessage);
	}

	/**
	 * function to enter the Latest value stored using function
	 * OrderNumberCapture Fields Required : Action, Element locator type,
	 * Element Location, Test data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void orderSubmitLastCapture() throws Exception {

		// int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Submit stored value - "
				+ orderNumberCaptured.get(orderNumberCaptured.size() - 1);
		Log.info(logmessage);
		actionElement = findElement();
		// arrayindex = Integer.parseInt(ExcelUtils.getCellData(
		// Constant.testcaserownum, Constant.Data));
		// ActionElement.sendKeys(OrderNumberCaptured.get(arrayindex));
		actionElement.sendKeys(orderNumberCaptured.get(orderNumberCaptured
				.size() - 1));

	}

	/**
	 * function to enter the value(stored using function ValueCapture) using
	 * Sikuli Fields Required : Action, Element locator type, Element Location,
	 * Test data: Index of capture value.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sSubmitCapture() throws Exception {

		int arrayindex = 0;
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		screen = new Screen();
		arrayindex = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA1));
		sikulipattern();
		// screen.type(pattern, ValueCaptured.get(arrayindex));
		screen.paste(pattern, valueCaptured.get(arrayindex));
	}

	/**
	 * function to Capture screen and store it as jpg file.
	 *
	 * @throws Exception
	 *             the exception
	 */
	/*
	 * Capture Screen for the driver Fields required: Action, Element locator
	 * type, Element Location Test data: N/A
	 * 
	 * @throws Exception
	 */
	public static void captureScreen() throws Exception {
		// System.out.println("---------------------------------------------------"+ExcelUtils.getCellData(Constant.testcaserownum,
		// 1));
		// System.out.println(logmessage);
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture screen";
		Log.info(logmessage);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(Constant.SCREENSHOTLOC
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTCASEID)
				+ "_"
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID) + ".jpg");
		FileUtils.copyFile(scrFile, targetFile);
	}

	/**
	 * function to Capture screen and store it as jpg file during Errors.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void errorCaptureScreen() throws Exception {

		// System.out.println("---------------------------------------------------"+ExcelUtils.getCellData(Constant.testcaserownum,
		// 1));
		// System.out.println(logmessage);
		try {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; Action: Error capture screen";
			Log.info(logmessage);

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			File targetFile = new File(Constant.ERRORSCREENSHOTLOC
					+ "Error_"
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTCASEID)
					+ "_"
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID) + ".jpg");
			FileUtils.copyFile(scrFile, targetFile);
		} catch (Exception e) {

		}

	}

	/**
	 * function for URL navigation on the Driver Fields required: Action,
	 * Element Location as URL Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void openURL() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION) + "; Action: open URL";
		Log.info(logmessage);
		// Get the Value of URL from Current Application Repository
		try {
			String ElemType = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE);
			if (ElemType.equalsIgnoreCase("logicalname")) {

				Class<?> orcls = Class.forName("objrepositories."
						+ Constant.APPLICATIONREPOSITORYNAME);
				String ObjLogicalName = ExcelUtils.getCellData(
						Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION);
				driver.get((String) orcls.getField(ObjLogicalName).get(null));
			} else {

				driver.get(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.ELEMENTLOCATION));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Function to perform Login using Guardian URL and login details.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void guardianLogin() throws Exception {
		driver.get(Constant.GUARDIANLOGINURL);
		driver.switchTo().frame(driver.findElement(By.name("bgmainframe")));
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("#user")).sendKeys(
				Constant.GUARDIANUSER);
		driver.findElement(By.id("password")).sendKeys(Constant.GUARDIANPASS);
		driver.findElement(By.id("linkValidForm")).click();
		Thread.sleep(15000);
		String CurrentWindowHandle = driver.getWindowHandle();
		Constant.MainWindowHandle = CurrentWindowHandle;
		Set<String> wHandles = driver.getWindowHandles();
		System.out.println(CurrentWindowHandle);
		// do not switch if there was no app choice page shown

		// close the warning window
		for (String winHandle : wHandles) {
			if (!winHandle.equals(CurrentWindowHandle)) {
				driver.switchTo().window(winHandle);
				System.out.println(winHandle);
				System.out.println("Page title is " + driver.getTitle());
				if (driver.getTitle().equalsIgnoreCase("Internal server error")) {
					driver.close();
				}
				break;
			}
		}

		driver.switchTo().window(CurrentWindowHandle);

		try {
			threadWait_10();
			driver.navigate().refresh();
			Thread.sleep(10000);
			driver.switchTo().window(CurrentWindowHandle);
			driver.switchTo().frame(driver.findElement(By.name("bgmainframe")));
			driver.findElement(By.linkText(Constant.APPENVIRONMENT)).click();
			/*
			 * if(Constant.APPENVIRONMENT.equalsIgnoreCase("GOLDUAT")){
			 * //driver.findElement(By.xpath(
			 * "//table[@id='tabapplis']/tbody//tr/th[@id='30I-01DEVgolduat']/a"
			 * )).click(); }else if
			 * (Constant.APPENVIRONMENT.equalsIgnoreCase("GOLDSANDBOX")){
			 * 
			 * }
			 */

			driver.switchTo().defaultContent();

			// table[@id='tabapplis']/tbody//tr/th[@id='30I-01DEVgoldtest']/a

			// driver.findElement(By.xpath("//a[contains(.,'"+
			// Constant.APPENVIRONMENT + "')]")).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
		driver.switchTo().defaultContent();
		threadWait_10();
		windowSwitchGuardian();
	}

	/**
	 * Function to perform Login using URL and login details.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void goldLogin() throws Exception {
		// if(Constant.LoginPertestcase){
		// Constant.LoginPertestcase=false;
		if (Constant.GUARDIANLOGIN) {
			guardianLogin();
		} else if (Constant.NORMALLOGIN) {
			normalLogin();
		} else {
			Log.warn("Both Normal Login and gaurdian login are disabled");
			ActionKeyword.Quit();
		}
		// }
	}

	/**
	 * Function to perform Login using Guardian URL and login details of OIT.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void guardianOITLogin() throws Exception {
		driver.get(Constant.OITURL);
		Thread.sleep(15000);
		try {
			// switch to the frame if the frame Exists
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(By.cssSelector("#user")).sendKeys(Constant.OITUSER);
		driver.findElement(By.cssSelector("#password")).sendKeys(
				Constant.OITPASSWORD);
		driver.findElement(By.id("linkValidForm")).click();
		try {
			driver.findElement(
					By.xpath("//a[.='" + Constant.OITAPPENVIRONMENT + "']"))
					.click();
			Constant.APPCHOICEFLAG = true;
		} catch (Exception e) {

		}

		driver.switchTo().defaultContent();
		threadWait_5();
		windowSwitchGuardian();
	}

	/**
	 * Function to perform Normal login.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void normalLogin() throws Exception {

		if (Constant.GUARDIANLOGIN) {
			return;
		}
		driver.get(Constant.GOLDNORMALLOGINURL);

		driver.findElement(GOLDStandAlone.Login_UserName_xpath).sendKeys(
				Constant.NORMALUSER);

		driver.findElement(GOLDStandAlone.Login_Password_xpath).sendKeys(
				Constant.NORMALPASS);

		driver.findElement(GOLDStandAlone.Login_Submit_ClassName).click();
		/*
		 * try {
		 * driver.findElement(GOLDStandAlone.Login_closeLink_ClassName).click();
		 * } catch (Exception e) { // silently fail } threadWait_5();
		 */
	}

	/**
	 * Function to perform Logout
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void logout() {

	}

	/**
	 * Function to perform Normal login without URL Open
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void NLoginWithoutURL() throws Exception {

		driver.findElement(GOLDStandAlone.Login_UserName_xpath).sendKeys(
				Constant.NORMALUSER);
		driver.findElement(GOLDStandAlone.Login_Password_xpath).sendKeys(
				Constant.NORMALPASS);
		driver.findElement(GOLDStandAlone.Login_Submit_ClassName).click();
		threadWait_5();
		try {
			driver.findElement(GOLDStandAlone.Login_closeLink_ClassName)
					.click();
		} catch (Exception e) {
			// silently fail
		}
		threadWait_5();
	}

	/**
	 * Function to perform Channel login without URL Open
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void ChannelLogin() throws Exception {

		driver.findElement(GOLDStandAlone.Login_UserName_xpath).sendKeys(
				Constant.CHANNELUSER);
		driver.findElement(GOLDStandAlone.Login_Password_xpath).sendKeys(
				Constant.CHANNELPASS);
		driver.findElement(GOLDStandAlone.Login_Submit_ClassName).click();
		threadWait_5();
		try {
			driver.findElement(GOLDStandAlone.Login_closeLink_ClassName)
					.click();
		} catch (Exception e) {
			// silently fail
		}
		threadWait_5();
	}

	/**
	 * Function to perform Channel login without URL Open
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void CLoginwithURL() throws Exception {

		if (Constant.GUARDIANLOGIN) {
			return;
		}

		driver.get(Constant.GOLDNORMALLOGINURL);
		threadWait_5();
		driver.findElement(GOLDStandAlone.Login_UserName_xpath).sendKeys(
				Constant.CHANNELUSER);
		driver.findElement(GOLDStandAlone.Login_Password_xpath).sendKeys(
				Constant.CHANNELPASS);
		driver.findElement(GOLDStandAlone.Login_Submit_ClassName).click();
		threadWait_5();
		try {
			driver.findElement(GOLDStandAlone.Login_closeLink_ClassName)
					.click();
		} catch (Exception e) {
			// silently fail
		}
		threadWait_5();
	}

	/**
	 * function to handle objects/steps If gate way error appears on the screen.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void ifGateWayError() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Element Verification";
		Log.info(logmessage);
		try {
			driver.findElement(
					By.xpath("//*[@id='TaskListRow']"
							+ "//span[contains(.,'Gateway Error')]")).click();

			driver.findElement(By.xpath("//img[@class='completeTask']"))
					.click();

			driver.findElement(
					By.xpath("//div[@id='WFActionPopup']"
							+ "//nobr[.='Submit And Inform Sdm']")).click();
			alert();
			driver.findElement(By.xpath("//*[@id='headMenu']/li[2]/a/span"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='grid_row_1']/td[3]")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			// silently pass
		}

	}

	/**
	 * function to handle alert at runtime Fields required: N/A Test data: N/A
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void alert() throws Exception {

		Alert alert = driver.switchTo().alert();

		// check if alert exists and get the text
		alert.getText();
		// alert handling
		Log.info("Alert detected: {}" + alert.getText());
		alert.accept();

	}

	public static void alertif() throws Exception {

		try {

			Alert alert = driver.switchTo().alert();
			// check if alert exists and get the text
			alert.getText();
			// alert handling
			Log.info("Alert detected: {}" + alert.getText());
			alert.accept();
		} catch (Exception e) {

			// go silently
		}

	}

	/**
	 * function to handle alert and dismiss it at runtime Fields required: N/A
	 * Test data: N/A
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void alertDismiss() throws Exception {

		Alert alert = driver.switchTo().alert();

		// check if alert exists and get the text
		alert.getText();
		// alert handling
		Log.info("Alert detected: {}" + alert.getText());
		alert.dismiss();

	}

	/**
	 * function to Verify USID capture.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyUSIDCapture() throws Exception {
		String fetchfrompage, Verification;
		int arrayindex = 0;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Verify stored USID";
		Log.info(logmessage);
		actionElement = findElement();
		arrayindex = Integer.parseInt(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA));
		Verification = USIDCaptured.get(arrayindex);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();

			if (Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			fetchfrompage = actionElement.getAttribute(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA1));

			if (Verification.equalsIgnoreCase(fetchfrompage)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: "
						+ Verification
						+ "; Value form page: " + fetchfrompage;
			} else {
				logmessage = "Fail; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Captured text: " + Verification
						+ "; Value form page: " + fetchfrompage;
				TestCaseRunner.vResult = 0;
			}

		}
		Log.info(logmessage);

	}

	/**
	 * function to get the current time and return it as String.
	 *
	 * @return the current time as string
	 */
	public static String getCurrentTime() {
		Date dDate = new Date();
		return dDate.toString();
	}

	/**
	 * Function to close the current browser(will close only active Window only)
	 * Fields required: Action field Test case won't stop and test control will
	 * move to next test case once this function called.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void disposeWindow() throws Exception {

		for (String handle : driver.getWindowHandles()) {
			if (!Constant.PARENTWINDOWHANDLE.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				try {
					screen = new Screen();
					// screen.click("YesButton.jpg");
					screen.click("WindowClose.jpg");
				} catch (Exception e) {
					Log.info(e.getMessage().toString());
				}

				driver.switchTo().defaultContent();
			}

		}
		driver.switchTo().window(Constant.PARENTWINDOWHANDLE);
		// driver.quit();
	}

	/**
	 * Function to refresh the page
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void refresh() throws Exception {

		driver.navigate().refresh();
	}

	/**
	 * Function to execute Java script for web element Fields required:Action,
	 * Element Location as Java script Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void javaScript() throws Exception {
		// Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION));
		// Thread.sleep(3000);

	}

	/**
	 * Function to execute Sikuli scripts can be used for Non Identified
	 * elements Fields required:Action, Element Location as Sikuli IDE location
	 * Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sikuli() throws Exception {

		java.lang.ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C",
				Constant.SIKULIIDE, "-r", ExcelUtils.getCellData(
						Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION));
		java.lang.Process p = pb.start();

		String line;
		BufferedReader r = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		while ((line = r.readLine()) != null) {
			// System.out.println(line);
			Log.info(line);
			if (line.contains("error")) {
				errorCaptureScreen();
				throw new Exception("Sikuli script Fail");

			}
		}

		p.destroy();

	}

	/**
	 * Function to verify text of web element
	 * 
	 * Fields required:Action, Element Location Test data: Verification value
	 * for the text.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyText() throws Exception {
		String fetchfrompage, Verification;
		actionElement = findElement();
		fetchfrompage = actionElement.getText();
		// System.out.println(fetchfrompage);
		Verification = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);

		if (fetchfrompage.toLowerCase().contains(
				ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)
						.toLowerCase())) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ fetchfrompage + "; User Defined Value: " + Verification;

			Log.info(logmessage);
		} else {

			errorCaptureScreen();
			logmessage = "Failed: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + ": from page: "
					+ fetchfrompage + "User Defined Value: " + Verification;
			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}

	}

	/**
	 * function to Verify that a text is not present in the WebElement. Fields
	 * required:Action, Element Location Test data: Verification value for the
	 * text.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyNotText() throws Exception {
		String fetchfrompage, Verification;
		actionElement = findElement();
		fetchfrompage = actionElement.getText();
		// System.out.println(fetchfrompage);
		Verification = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);

		if (fetchfrompage.toLowerCase().contains(
				ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)
						.toLowerCase())) {
			errorCaptureScreen();
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Fail; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ fetchfrompage + "; User Defined Value: " + Verification;
			TestCaseRunner.vResult = 0;
			Log.warn(logmessage);

		} else {

			logmessage = "Pass: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + ": from page: "
					+ fetchfrompage + "User Defined Value: " + Verification;
			Log.info(logmessage);

		}

	}

	/**
	 * Function to Verify file size text displayed for the Documents.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyFileSizeText() throws Exception {
		String fetchfrompage;
		actionElement = findElement();
		fetchfrompage = actionElement.getText().replace(" bytes", "")
				.replace(",", "").replace("(", "").replace(")", "")
				.replace("KB", "").trim();
		// System.out.println(fetchfrompage);
		String[] FileName_Digits = fetchfrompage.split("\\n");

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);

		// verifying if the Number captured at run time is greater than 0
		if (Integer.parseInt(FileName_Digits[1]) > 0) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; File Size is Greater than 0";

			Log.info(logmessage);
		} else {

			errorCaptureScreen();
			logmessage = "Failed: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID) + "; "
					+ "Passed; File Size is NOT Greater than 0";

			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}

	}

	/**
	 * Function to verify Attribute value of web element
	 * 
	 * Fields required:Action,Element Location Test data: Verification value for
	 * the Attribute Test data1: Attribute name and property.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyAttribute() throws Exception {

		String fetchfrompage, Verification;
		actionElement = findElement();

		fetchfrompage = actionElement.getAttribute(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA1));
		Verification = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);
		if (fetchfrompage.contains(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA))) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ fetchfrompage + "; User Defined Value: " + Verification;
			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = "Failed: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + ": from page: "
					+ fetchfrompage + "User Defined Value: " + Verification;
			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to verify enabled disabled
	 * 
	 * Fields required:Action,Element Location Test data: Verification value for
	 * the Attribute Test data1: Attribute name and property.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void verifyEnabled() throws Exception {

		Boolean isenabled;
		actionElement = findElement();

		isenabled = actionElement.getAttribute("disabled").equals("");

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);
		if (isenabled) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ isenabled;
			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = "Failed: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + ": from page: "
					+ isenabled;
			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to Verify attribute of same type of all web elements. Fields
	 * Required : Action Element, the Attribute Name Test Data: N/A
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyAttributeAllelements() throws Exception {
		boolean bResult = false;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);
		String AttributeName, Verification;
		// ActionElement = FindElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("xpath")) {
			List<WebElement> AllElements = driver.findElements(By
					.xpath(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.ELEMENTLOCATION)));
			AttributeName = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA1);

			Verification = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA);

			for (WebElement ele : AllElements) {
				if (ele.getAttribute(AttributeName).equalsIgnoreCase(
						Verification)) {

					bResult = true;
				} else {
					if (ele.isSelected()) {
						System.out.println("the element is selected");
					}
					break;
				}
			}

			if (bResult) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; from page: for all elements "
						+ AttributeName
						+ "; User Defined Value: " + Verification;

				Log.info(logmessage);
			} else {
				errorCaptureScreen();
				logmessage = "Failed: "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ ": "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION) + ": from page: "
						+ AttributeName + "User Defined Value: " + Verification;
				Log.warn(logmessage);
				TestCaseRunner.vResult = 0;
			}
		}

	}

	/**
	 * function to Click a checkbox if it is selected
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void VerifyIfSelected() throws Exception {
		// find the UI Object
		actionElement = findElement();

		if (actionElement.isSelected()) {
			// to perform click action on the UI Object
			actionElement.click();
		}

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ ": Action VerifyIfSelected";

		// log the message
		Log.info(logmessage);

	}

	/**
	 * function to Click a checkbox if it is Not selected
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void VerifyIfNotSelected() throws Exception {
		// find the UI Object
		actionElement = findElement();

		if (!actionElement.isSelected()) {
			// to perform click action on the UI Object
			actionElement.click();
		}

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ ": Action VerifyIfSelected";

		// log the message
		Log.info(logmessage);
	}

	/**
	 * function to Verify that all WebElements on the Page are selected.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyAllSelected() throws Exception {
		boolean bResult = false;
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ ": "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);
		String Verification;
		// ActionElement = FindElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("xpath")) {
			List<WebElement> AllElements = driver.findElements(By
					.xpath(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.ELEMENTLOCATION)));

			Verification = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA);

			for (WebElement ele : AllElements) {
				switch (Verification.toLowerCase()) {
				case "true":
					bResult = ele.isSelected();
					break;
				case "false":
					bResult = !ele.isSelected();
					break;
				default:
					System.out.println("no verification found for the data");
				}

			}

			if (bResult) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; from page: for all elements ";

				Log.info(logmessage);
			} else {
				errorCaptureScreen();
				logmessage = "Failed: "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ ": "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION) + ": from page: ";
				Log.warn(logmessage);
				TestCaseRunner.vResult = 0;
			}
		}

	}

	/**
	 * Function to verify Element existence on the web page Fields
	 * required:Action, Element Location Test data: N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyElement() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Element Verification";

		Log.info(logmessage);

		// System.out.println(driver.getPageSource());
		// System.out.println(driver.getCurrentUrl());
		actionElement = findElement();

		if ((actionElement != null)) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; Sepcified Element present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.info(logmessage);
		} else {

			errorCaptureScreen();
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Failed; Sepcified Element is not present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);

			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}

	}

	/**
	 * Function to find a WebElement with synchronization Fields required: The
	 * Element LocType, Element Name
	 * 
	 * @return the web element
	 * @throws Exception
	 *             the exception
	 */
	public static WebElement findElement() throws Exception {
		WebDriverWait wait = null;

		wait = new WebDriverWait(driver, Constant.EXPLICITWAIT);
		WebElement we = null;
		// System.out.println(Constant.ExplicitWait);
		try {
			if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("Xpath")) {

				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			} else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("ID")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.id(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			}

			else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("CSS")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector(ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			}

			else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("Link")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.linkText(ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			}

			else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("Name")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.name(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			}

			else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("Class")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.className(ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			} else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("partialLink")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.partialLinkText(ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));
			} else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("tagName")) {
				we = (wait.until(ExpectedConditions.presenceOfElementLocated(By
						.tagName(ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM,
								Constant.ELEMENTLOCATION)))));

			} else if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTFINDERTYPE).equalsIgnoreCase("LogicalName")
					&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.ACTION).equalsIgnoreCase("OpenURL")) {
				try {
					Class<?> orcls = Class.forName("objrepositories."
							+ Constant.APPLICATIONREPOSITORYNAME);
					String ObjLogicalName = ExcelUtils.getCellData(
							Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION);

					// System.out.println(orcls.getField(ObjLogicalName).getGenericType().toString());
					By ObjectBy = null;
					if (orcls.getField(ObjLogicalName).get(null) instanceof String) {
						String sData = ExcelUtils.getCellData(
								Constant.TESTCASEROWNUM, Constant.DATA);
						String[] sAData = sData.split(",");
						if (sAData[0].startsWith("#")) {

							ObjectBy = By
									.xpath(orcls
											.getField(ObjLogicalName)
											.get(null)
											.toString()
											.replace(
													"#DATA",
													Constant.TEMPSTORAGE
															.get(sAData[0])));
						} else {
							ObjectBy = By.xpath(orcls.getField(ObjLogicalName)
									.get(null).toString()
									.replace("#DATA", sAData[0]));
						}

					} else {
						ObjectBy = (By) orcls.getField(ObjLogicalName)
								.get(null);
					}

					we = (wait.until(ExpectedConditions
							.visibilityOfElementLocated(ObjectBy)));

				} catch (Exception e) {

					if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.ACTION).contains("If"))
						e.printStackTrace();
				}
			}

		} catch (org.openqa.selenium.TimeoutException e) {
			we = null;
			return we;
		}
		return we;

	}

	/**
	 * Function for a Robot keys as a crude method Fields required:N/A TestData:
	 * All the values to sent through Keyboard and Keys mention in the hash map.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void robotKey() throws Exception {
		Robot robot = new Robot();
		// Create a hash map
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// Put elements to the map

		hm.put("VK_TAB", new Integer(KeyEvent.VK_TAB));
		hm.put("VK_SPACE", new Integer(KeyEvent.VK_SPACE));
		hm.put("VK_ENTER", new Integer(KeyEvent.VK_ENTER));
		hm.put("VK_DELETE", new Integer(KeyEvent.VK_DELETE));
		hm.put("VK_CONTROL", new Integer(KeyEvent.VK_CONTROL));
		hm.put("VK_ALT", new Integer(KeyEvent.VK_ALT));
		hm.put("VK_SHIFT", new Integer(KeyEvent.VK_SHIFT));
		hm.put("w", new Integer(KeyEvent.VK_W));
		hm.put("VK_ESC", new Integer(KeyEvent.VK_ESCAPE));
		hm.put("VK_F5", new Integer(KeyEvent.VK_F5));
		hm.put("VK_T", new Integer(KeyEvent.VK_T));
		hm.put("VK_BACK_SPACE", new Integer(KeyEvent.VK_BACK_SPACE));

		String Keysevent = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		String[] Seperated = Keysevent.split(":");
		int i = 0, j = 0;
		// System.out.println(Seperated.length);
		while (i < Seperated.length) {
			if (Seperated[i].contains("VK_")) {
				String[] Seperatedseq = Keysevent.split("\\+");

				// System.out.println(Seperatedseq.length);
				while (j < Seperatedseq.length) {
					robot.delay(40);

					robot.keyPress(hm.get(Seperatedseq[j]));
					robot.keyRelease(hm.get(Seperatedseq[j]));
					j++;
				}

			}

			else {
				System.out
						.println("this one is a char sequence" + Seperated[i]);

				byte[] bytes = Seperated[i].getBytes();
				// System.out.println("bytes value is " + bytes);
				for (byte b : bytes) {
					// System.out.println("this is byte" + b);
					int code = b;
					// System.out.println("int value" + code);
					// keycode only handles [A-Z] (which is ASCII decimal
					// [65-90])
					if (code > 96 && code < 123)
						code = code - 32;
					robot.delay(40);
					robot.keyPress(code);
					robot.delay(40);
					robot.keyRelease(code);
					robot.delay(40);
				}
			}

			i++;

		}

	}

	/**
	 * Function for a Sikuli click: Required Fields: Element as Image Name in
	 * Images Unitaction folder Data: Optional(can set offset parameter(int x
	 * int y) and matching percentage (float).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sclick() throws Exception

	{

		/*
		 * screen = new Screen();
		 * ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION); if
		 * (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) !=
		 * null && !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
		 * Constant.DATA).isEmpty() ) { Settings.setShowActions(false);
		 * sikulipattern(); screen.click(pattern);
		 * Settings.setShowActions(true); }
		 * 
		 * else {
		 * 
		 * screen.click(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
		 * Constant.ELEMENTLOCATION)); }
		 */

	}

	/**
	 * Function for a Sikuli click: Required Fields: Element as Image Name in
	 * Images Unitaction folder Data: Optional(can set offset parameter(int x
	 * int y) and matching percentage (float).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sHover() throws Exception

	{

		screen = new Screen();
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA).isEmpty()) {
			Settings.setShowActions(false);
			sikulipattern();
			screen.hover(pattern);
			Settings.setShowActions(true);
		}

		else {

			screen.hover(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION));
		}

	}

	/**
	 * function to perform drag using Sikuli.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sdrag() throws Exception

	{

		screen = new Screen();

		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null) {
			sikulipattern();
			Location fromLocation = screen.find(pattern).getCenter();
			Mouse.move(fromLocation);
			Mouse.down(Button.LEFT);
		}

		else {

			screen.drag(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION));
		}

	}

	/**
	 * function to perform drop using Sikuli.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sdrop() throws Exception

	{

		screen = new Screen();
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null) {
			sikulipattern();
			Location ToLocation = screen.find(pattern).getCenter();
			Mouse.move(ToLocation);
			Mouse.up();
		}

		else {

			screen.dropAt(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION));
		}

	}

	/**
	 * Function for a Sikuli Mouse scroll down: Required Fields: Element as
	 * Image Name in Images Unitaction folder Data: Optional(can set wheel
	 * number (int number).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sMDscroll() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null) {
			screen.wheel(1, Integer.parseInt(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA)));
		}

		else {

			screen.wheel(1, 1);
		}

	}

	/**
	 * function to Scroll the Window to top, when a WebElement is not visible.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void scrollToTop() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	/**
	 * Function for a Sikuli Mouse scroll up: Required Fields: Element as Image
	 * Name in Images Unitaction folder Data: Optional(can set wheel number (int
	 * number).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sMUscroll() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null) {
			screen.wheel(-1, Integer.parseInt(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA)));
		}

		else {

			screen.wheel(-1, 1);
		}

	}

	/**
	 * Function for a Sikuli Mouse double click: Required Fields: Element as
	 * Image Name in Images Unitaction folder Data: Optional(can set wheel
	 * number (int number).
	 *
	 * @throws Exception
	 *             the exception
	 */

	public static void sDclick() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null) {
			sikulipattern();
			screen.doubleClick(pattern);
		}

		else {
			screen.doubleClick(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION));
		}

	}

	/**
	 * Function to support Sikuli click action: Required Fields: N/A N/A.
	 *
	 * @throws Exception
	 *             the exception
	 */
	private static void sikulipattern() throws Exception {

		// TODO Auto-generated method stub
		String Datavalue = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		String[] datavalue = Datavalue.split(",");
		if (datavalue.length > 1 && datavalue.length < 2) {
			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar(Float.parseFloat(datavalue[1]));
		} else if (datavalue.length > 2 && datavalue.length < 4) {

			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar(Float.parseFloat(datavalue[0])).targetOffset(
							Integer.parseInt(datavalue[1]),
							Integer.parseInt(datavalue[2]));
		}

		else if (datavalue.length == 2) {
			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar((float) 0.7).targetOffset(
							Integer.parseInt(datavalue[0]),
							Integer.parseInt(datavalue[1]));
		}
		/*
		 * }else if (datavalue.length == 1) { pattern = new
		 * Pattern(ExcelUtils.getCellData( Constant.testcaserownum,
		 * Constant.Elementlocation)) .similar((float) 0.7); }
		 */
	}

	/**
	 * function to find and verify an element using Sikuli .
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sfind() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		Float ExpectedMatchPercent = 0f;
		screen = new Screen();
		Match m = null;

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA).isEmpty()) {
			ExpectedMatchPercent = Float.parseFloat(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA));

			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar(ExpectedMatchPercent);
		}

		else {
			ExpectedMatchPercent = (float) 0.7;
			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar(ExpectedMatchPercent);

		}

		try {
			m = screen.find(pattern);
			/*
			 * */

		}

		catch (Exception FindFailed) {

			Log.info("Fail Image verification point");
			// System.out.println("false"+m);

		} finally {
			m.getScore();
			if (m.getScore() >= ExpectedMatchPercent && m != null) {
				Log.info("Pass Image verification point:" + +m.getScore()
						+ ", % matching");
				// System.out.println("True"+m.getScore());

			} else if (m.getScore() < ExpectedMatchPercent || m == null) {

				Log.info("Fail Image verification point" + m.getScore());
				// System.out.println("false"+m);
			}
		}

	}

	/**
	 * function to toggle the highlighting of an element using Sikuli .
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sikuliShowActions() throws Exception {
		boolean ShowActions = Boolean.parseBoolean(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA).toLowerCase());

		Settings.setShowActions(ShowActions);
	}

	/**
	 * Function to enter text in an element using Sikuli : Required Fields:
	 * Element as Image Name in Images Unitaction folder Data: Optional(can set
	 * offset parameter(int x int y) and matching percentage (float).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void stype() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);

		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA).isEmpty()) {
			sikulipattern();
			String DataTotype = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA1);
			/*
			 * System.out.println(ExcelUtils.getCellData(Constant.testcaserownum,
			 * Constant.Data1) + "8888888888888"+DataTotype);
			 */

			screen.paste(pattern, DataTotype);
		}

		else {
			/*
			 * System.out.println(ExcelUtils.getCellData(Constant.testcaserownum,
			 * Constant.Data1));
			 */
			screen.type(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION), Constant.DATA1);
		}

	}

	/**
	 * Variation of stpye , Function to enter text in an element using Sikuli :
	 * Required Fields: Element as Image Name in Images Unitaction folder Data:
	 * Optional(can set offset parameter(int x int y) and matching percentage
	 * (float). The offsets for clicking need to be given in DATA1 column and
	 * data to enter in the field to be given under test data column
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void stype2() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);

		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA1).isEmpty()) {
			// sikulipattern();
			String datavalue1 = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA1);
			String[] datavalue = datavalue1.split(",");
			pattern = new Pattern(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION))
					.similar((float) 0.7).targetOffset(
							Integer.parseInt(datavalue[0]),
							Integer.parseInt(datavalue[1]));

			String DataTotype = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.DATA);
			/*
			 * System.out.println(ExcelUtils.getCellData(Constant.testcaserownum,
			 * Constant.Data1) + "8888888888888"+DataTotype);
			 */

			screen.paste(pattern, DataTotype);
		}

		else {
			/*
			 * System.out.println(ExcelUtils.getCellData(Constant.testcaserownum,
			 * Constant.Data1));
			 */
			screen.type(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION), Constant.DATA);
		}
	}

	/**
	 * Function for waiting for an element using sikuli: Required Fields:
	 * Element as Image Name in Images Unitaction folder Data: Optional(Time out
	 * seconds).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sWait() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);

		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA).isEmpty()) {
			sikulipattern();
			screen.wait(pattern, Double.parseDouble(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA)));
		}

		else {

			screen.wait(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.ELEMENTLOCATION), Constant.SIKULIWAITTIMEOUT);
		}

		Thread.sleep(2000); // a default wait after explicit wait keyword in a
							// test step
	}

	/**
	 * Function for waiting for an element to Disappear using Sikuli : Required
	 * Fields: Element as Image Name in Images Unit action folder Data:
	 * Optional(Time out seconds).
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void sWaitVanish() throws Exception {
		ImagePath.setBundlePath(Constant.SIKULIIMAGELOCATION);
		boolean vanished = false;
		screen = new Screen();

		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA) != null
				&& !ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.DATA).isEmpty()) {
			sikulipattern();
			vanished = screen.waitVanish(pattern, Double.parseDouble(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA)));

		}

		else {

			vanished = screen.waitVanish(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION),
					Constant.SIKULIWAITTIMEOUT);
		}

		System.out.println("Object vanished ? : " + vanished);

		Thread.sleep(5000); // a default wait after explicit wait keyword in a
							// test step
	}

	/**
	 * Function for Logical Robot keys , used for sending key events using Robot
	 * library Fields required:N/A TestData: All the values to sent through
	 * Keyboard and Keys mention in the hash map.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void robotLKey() throws Exception {
		Robot robot = new Robot();
		// Create a hash map
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// Put elements to the map
		hm.put("VK_TAB", new Integer(KeyEvent.VK_TAB));
		hm.put("VK_SPACE", new Integer(KeyEvent.VK_SPACE));
		hm.put("VK_ENTER", new Integer(KeyEvent.VK_ENTER));
		hm.put("VK_DELETE", new Integer(KeyEvent.VK_DELETE));
		hm.put("VK_CONTROL", new Integer(KeyEvent.VK_CONTROL));
		hm.put("VK_ALT", new Integer(KeyEvent.VK_ALT));
		hm.put("VK_SHIFT", new Integer(KeyEvent.VK_SHIFT));

		String Keysevent = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		String[] Seperated = Keysevent.split("\\^");
		int i = 0;
		while (i < Seperated.length) {
			if (Seperated[i].contains("VK_")) {
				// System.out.println(Seperated.length + Seperated[i]);
				robot.delay(40);
				robot.keyPress(hm.get(Seperated[i]));
				robot.delay(40);
			}

			else {
				System.out
						.println("this one is a char sequence" + Seperated[i]);

				byte[] bytes = Seperated[i].getBytes();
				// System.out.println("bytes value is " + bytes);
				for (byte b : bytes) {
					// System.out.println("this is byte" + b);
					int code = b;
					// System.out.println("int value" + code);
					// keycode only handles [A-Z] (which is ASCII decimal
					// [65-90])
					if (code > 96 && code < 123)
						code = code - 32;
					robot.delay(40);
					robot.keyPress(code);
					robot.delay(40);
					robot.keyRelease(code);
					robot.delay(40);
				}

			}

			i++;

		}
		i = 0;
		while (i < Seperated.length) {
			if (Seperated[i].contains("VK_")) {
				robot.delay(40);
				robot.keyRelease(hm.get(Seperated[i]));
				robot.delay(40);
			}

			else {
			}
			i++;
		}

	}

	/**
	 * function to Press Tab on the Web Element Fields required: Action, Element
	 * locator type, Element Location Test data: Value to enter in the
	 * Web-Element before pressing tab.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void pressTab() throws Exception {
		logmessage = "Pressing Tab for Step"
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTCASEID);
		actionElement = findElement();
		actionElement.sendKeys(ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA) + Keys.TAB);
		Log.info(logmessage);
		
		
		// WebElement currentElement = driver.switchTo().activeElement();
		// String focusOn = currentElement.getAttribute("title");
		// System.out.println("Focus is shifted to: "+focusOn);

	}

	/**
	 * Function to verify page title. required: Action, Element Location Test
	 * data: N/A
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyPageTitle() throws Exception {

		// ActionElement = FindElement();
		String pagetitle = driver.getTitle();
		String expectedtitle = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (pagetitle.equals(expectedtitle)) {
			// System.out.println("Page title verification passed :" +
			// pagetitle);
			// System.out.println("Page title verification passed. Expected title :"
			// + expectedtitle + "Actual title :"+ pagetitle);

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ pagetitle + "; User Defined title:" + expectedtitle;
			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = "Failed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + "; from page: "
					+ pagetitle + "; User Defined title:" + expectedtitle;
			Log.warn(logmessage);
			// System.out.println("Page title verification failed. Expected title :"
			// + expectedtitle + "Actual title :"+ pagetitle);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to verify page URL. required: Action, Element Location Test
	 * data: N/A
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyPageURL() throws Exception {

		// ActionElement = FindElement();
		String pageURL = driver.getCurrentUrl();
		// System.out.println(pageURL);
		String expectedURL = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (pageURL.contains(expectedURL)) {
			// System.out.println("Page title verification passed :" +
			// pagetitle);
			// System.out.println("Page title verification passed. Expected title :"
			// + expectedtitle + "Actual title :"+ pagetitle);

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ pageURL + "; User Defined URL:" + expectedURL;
			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = "Failed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION) + "; from page: "
					+ pageURL + "; User Defined URL:" + expectedURL;
			Log.warn(logmessage);
			// System.out.println("Page title verification failed. Expected title :"
			// + expectedtitle + "Actual title :"+ pagetitle);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to run AutoIt scripts Fields required:Action, Web Element
	 * location as Auto It Script EXE location.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void autoit() throws Exception {

		Runtime.getRuntime().exec(
				ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.ELEMENTLOCATION));

	}

	/**
	 * function to capture the value of Auto disconnect Order on Web Page.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void AutoDisconnectCapture() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String fetchfrompage = null;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();
			// String orderNumber = fetchfrompage.substring(9, 15);
			autoDisconnectCaptured.add(fetchfrompage.trim());
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = autoDisconnectCaptured.size();
			size = size - 1;
			logmessage = autoDisconnectCaptured.get(size)
					+ "; USID Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			autoDisconnectCaptured.add(actionElement.getAttribute(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = autoDisconnectCaptured.size();
			size = size - 1;
			logmessage = autoDisconnectCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}
		Log.info(logmessage);
	}

	/**
	 * function to Close browser tab.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void closeTab() throws Exception {
		Robot robot = new Robot();

		robot.delay(40);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(40);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(40);

	}

	/**
	 * Function to print values in log and on screen only.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void showRecord() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION) + "; Action: Show Record";
		Log.info(logmessage);
		String fetchfrompage;
		actionElement = findElement();
		fetchfrompage = actionElement.getText();
		// System.out.println("Record Details for All>>" +fetchfrompage);
		Log.info("Record Details: " + fetchfrompage);
	}

	/**
	 * Random Values generator.
	 *
	 * @param RANDOM_STRING_LENGTH
	 *            the random string length
	 * @param mod
	 *            the mod
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static String randomGenerator(int RANDOM_STRING_LENGTH, int mod)
			throws Exception {

		/**
		 * This method generates random string
		 * 
		 * @return
		 */

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {

			int number = getRandomNumber(mod);
			if (mod == 1) {
				char ch = STRLIST.charAt(number);
				randStr.append(ch);
			} else if (mod == 2) {
				char ch = NUM_LIST.charAt(number);
				randStr.append(ch);
			} else if (mod == 3) {
				char ch = CHAR_LIST.charAt(number);
				randStr.append(ch);
			} else if (mod == 4) {
				char ch = SPL_LIST.charAt(number);
				randStr.append(ch);
			}
		}
		// System.out.println(randStr.toString());
		return randStr.toString();
	}

	/**
	 * This method generates random numbers.
	 *
	 * @param mod
	 *            the mod
	 * @return int
	 */
	public static int getRandomNumber(int mod) {
		int randomInt = 0;
		Random randomGenerator = new Random();

		if (mod == 1) {
			randomInt = randomGenerator.nextInt(STRLIST.length());
		} else if (mod == 2) {
			randomInt = randomGenerator.nextInt(NUM_LIST.length());
		} else if (mod == 3) {
			randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		} else if (mod == 4) {
			randomInt = randomGenerator.nextInt(SPL_LIST.length());
		}

		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	/**
	 * Function to verify value of web element generated randomly earlier in the
	 * test Fields required:Action, Element Location Test data: Should contain
	 * the index number of submitrandom action i.e of need to verfiy value
	 * randomely generated first time in the test script then test data should
	 * contain '0'
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void verifyRandom() throws Exception {

		String fetchfrompage, Verification;
		int arrayindex;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			fetchfrompage = actionElement.getText();
			arrayindex = Integer.parseInt(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA));
			// System.out.println(arrayindex);
			// System.out.println(Valuestored.get(0));
			Verification = valuestored.get(arrayindex);
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; Random text generated previously:"
					+ Verification
					+ "; Value form page: " + fetchfrompage;
			Log.info(logmessage);
			if (fetchfrompage.equalsIgnoreCase(Verification)) {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Random text generated previously:"
						+ Verification
						+ "; Value form page: " + fetchfrompage;
				Log.info(logmessage);
			} else {
				errorCaptureScreen();
				logmessage = "Failed; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPID)
						+ "; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION)
						+ "; Random text generated previously:" + Verification
						+ "; Value form page: " + fetchfrompage;
				Log.warn(logmessage);
				TestCaseRunner.vResult = 0;
			}
		}

		else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			actionElement = findElement();
			// System.out.println("test in not empty section");
			fetchfrompage = actionElement.getAttribute(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA1));
			arrayindex = Integer.parseInt(ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.DATA));
			Verification = valuestored.get(arrayindex);
			if (fetchfrompage.equalsIgnoreCase(Verification)) {
				Log.info("Pass Value from page " + fetchfrompage
						+ ", contains Verification value: " + Verification);
			} else {
				errorCaptureScreen();
				Log.warn("Failed; Value from page " + fetchfrompage
						+ ", dose not contains Verification value: "
						+ Verification);
				TestCaseRunner.vResult = 0;
			}
		}

	}

	/**
	 * function to Verify size of the value present in a WebElement.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void VerifySize() throws Exception {
		String fetchfrompage;
		actionElement = findElement();
		fetchfrompage = actionElement.getText();
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION);
		Log.info(logmessage);

		if (fetchfrompage.length() > 0) {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; from page: "
					+ fetchfrompage
					+ "; Size of text: "
					+ fetchfrompage.length();

			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = "Failed: "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPID)
					+ ": "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ ": Size of text is 0";

			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to switch between multiple windows.
	 */
	public static void windowHandles() throws InterruptedException {
		String CurrentWindowHandle = driver.getWindowHandle();
		Set<String> wHandles = driver.getWindowHandles();
		System.out.println(CurrentWindowHandle);
		// loop on all handles,
		for (String winHandle : wHandles) {
			if (!winHandle.equals(CurrentWindowHandle)) {
				// switch to the new window
				driver.switchTo().window(winHandle);
				System.out.println("----------- inside for -----------------");
				System.out.println(winHandle);
				System.out.println(driver.getTitle());
				((JavascriptExecutor) driver).executeScript("window.focus()");
				driver.manage().window().maximize();
				Constant.PARENTWINDOWHANDLE = winHandle;
				// close the Previous Window
				driver.switchTo().window(CurrentWindowHandle);
				// driver.close();
				driver.switchTo().window(winHandle);
				break;

			}

		}
	}

	/**
	 * Function to click on create template popup.
	 */
	public static void CreateTemplatepopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (!SubElementLink.isEmpty()) {
			if (SubElementLink.equals("Commercial")) {

				System.out.println("Subelementlink" + SubElementLink);
				action.moveToElement(actionElement).moveByOffset(0, -15)
						.click().build().perform();
				Thread.sleep(2000);
				System.out
						.println("Clicking commercial +++++Subelementlink SubMenu");
				Thread.sleep(2000);

			} else {

				System.out.println("Subelementlink" + SubElementLink);
				action.moveToElement(actionElement).click().build().perform();
				Thread.sleep(2000);
				System.out
						.println("Clicking commercial/technical+++++Subelementlink SubMenu");
				Thread.sleep(2000);

			}

		} else {
			action.moveToElement(actionElement).moveByOffset(0, 15).click()
					.build().perform();
			Thread.sleep(2000);
			System.out.println("Clicking Technical +++++SubMenu");
			Thread.sleep(2000);
		}

	}

	/**
	 * Function to click on appy template popup.
	 *
	 */

	public static void ApplyTemplatepopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		System.out.println(actionElement);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(actionElement, 2, 2).click().perform();
		Thread.sleep(2000);
		System.out.println("Clicked Apply Template SubMenu2");
		Thread.sleep(2000);

	}

	/**
	 * Function to click on apply template 2nd popup .
	 *
	 */

	public static void ApplyTemplatepopup1() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		System.out.println(actionElement);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(actionElement).moveByOffset(5, 5).click().build()
				.perform();
		Thread.sleep(2000);
		System.out.println("Clicked Apply Template SubMenu 1");
		Thread.sleep(2000);

	}

	/**
	 * Function to click on down arrow key.
	 *
	 */

	public static void ClickDownArrowKey() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);

	}

	/**
	 * Function to login with user who has rights to perform approve chrges task
	 * for disconnect orders.
	 *
	 */

	public static void LoginDisconnectApproverWithoutURL() throws Exception {

		driver.findElement(GOLDStandAlone.Login_UserName_xpath).sendKeys(
				Constant.APPROVERUSER);
		driver.findElement(GOLDStandAlone.Login_Password_xpath).sendKeys(
				Constant.APPROVERPASS);
		driver.findElement(GOLDStandAlone.Login_Submit_ClassName).click();
		threadWait_5();
		try {
			driver.findElement(GOLDStandAlone.Login_closeLink_ClassName)
					.click();
		} catch (Exception e) {
			// silently fail
		}
		threadWait_5();
	}

	/**
	 * Function to click on copy dropdown menu.
	 *
	 */

	public static void CopyOrderpopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		System.out.println("Subelementlink" + SubElementLink);
		action.moveToElement(actionElement).moveByOffset(0, 15).click().build()
				.perform();
		Thread.sleep(2000);
		System.out
				.println("Clicking Entire Order (different local site) SubMenu");
		Thread.sleep(2000);
	}

	/**
	 * Function to click on cancel dropdown menu.
	 *
	 */

	public static void CancelOrderpopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		System.out.println("Subelementlink" + SubElementLink);
		action.moveToElement(actionElement, 96, 15).click().build().perform();
		Thread.sleep(2000);
		System.out
				.println("Clicked No Longer Required by Customer Other SubMenu");
		Thread.sleep(2000);
	}

	/**
	 * Function to click on options drop down menu.
	 *
	 */

	public static void OrderOptionspopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		System.out.println("Subelementlink" + SubElementLink);
		action.moveToElement(actionElement).moveByOffset(0, -15).click()
				.build().perform();
		Thread.sleep(2000);
		System.out.println("Clicked Cancel option subMenu");
		Thread.sleep(2000);
	}

	/**
	 * Function to click on modify order pop up
	 */
	public static void ModifyOrderpopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);

		System.out.println("Subelementlink" + SubElementLink);
		// action.moveToElement(actionElement,96,15).click().build().perform();
		action.moveToElement(actionElement, 96, 15).click().build().perform();
		Thread.sleep(2000);
		System.out.println("Clicked on Modify Order without price impact");
		Thread.sleep(2000);
	}

	/**
	 * Function to click on order options pop up
	 */
	public static void OrderOptionspopup1() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		WebElement we = driver
				.findElement(By
						.xpath(".//*[@id='order_options']/table/tbody/tr[6]/td[2]/nobr"));
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[6]/td[2]/nobr"))
				.sendKeys("\n");
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[6]/td[2]/nobr"))
				.sendKeys("\n");
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[6]/td[2]/nobr"))
				.sendKeys("\n");
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath(".//*[@id='modif_menu']/table/tbody/tr[2]/td[2]/nobr")))
				.click().build().perform();
		Thread.sleep(10000);
		System.out.println("++Clicked Modify option subMenu+++++");

	}

	/**
	 * Function to click on order options pop up in billing task
	 */
	public static void OrderOptionspopup2() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		WebElement we = driver
				.findElement(By
						.xpath(".//*[@id='order_options']/table/tbody/tr[4]/td[2]/nobr"));
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[4]/td[2]/nobr"))
				.sendKeys("\n");
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[4]/td[2]/nobr"))
				.sendKeys("\n");
		driver.findElement(
				By.xpath(".//*[@id='order_options']/table/tbody/tr[4]/td[2]/nobr"))
				.sendKeys("\n");
		action.moveToElement(we)
				.moveToElement(
						driver.findElement(By
								.xpath(".//*[@id='modif_menu']/table/tbody/tr[2]/td[2]/nobr")))
				.click().build().perform();
		Thread.sleep(10000);
		System.out.println("++Clicked Modify option subMenu+++++");

	}

	/**
	 * Function to click on partial billing sub menu
	 */
	public static void OrderOptions_partialbilling() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		// System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);
		/*
		 * WebElement we = driver.findElement(By.xpath(
		 * ".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"));
		 * driver.findElement
		 * (By.xpath(".//*[@id='order_options']")).sendKeys("\n");
		 * driver.findElement
		 * (By.xpath(".//*[@id='order_options']")).sendKeys("\n");
		 * driver.findElement
		 * (By.xpath(".//*[@id='order_options']")).sendKeys("\n");
		 * Thread.sleep(2000);
		 * action.moveToElement(we).moveToElement(driver.findElement
		 * (By.xpath(".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"
		 * ))).sendKeys("\n");
		 * action.moveToElement(we).moveToElement(driver.findElement
		 * (By.xpath(".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"
		 * ))).sendKeys("\n");
		 * action.moveToElement(we).moveToElement(driver.findElement
		 * (By.xpath(".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"
		 * ))).sendKeys("\n");
		 * action.moveToElement(we).moveToElement(driver.findElement
		 * (By.xpath(".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"
		 * ))).clickAndHold().build().perform();
		 * action.moveToElement(we).moveToElement(driver.findElement(By.xpath(
		 * ".//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr"
		 * ))).release().build().perform(); Thread.sleep(5000);
		 */
		action.moveToElement(actionElement).moveByOffset(0, 25).click().build()
				.perform();
		Thread.sleep(2000);

		System.out.println("++++Clicked Partial Billing option Menu+++++");

	}

	/**
	 * Function to save template using a new order from information page
	 */
	public static void SaveTemplatepopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (!SubElementLink.isEmpty()) {
			if (SubElementLink.equals("Commercial")) {

				System.out.println("Subelementlink" + SubElementLink);
				action.moveToElement(actionElement).moveByOffset(0, -15)
						.click().build().perform();
				Thread.sleep(2000);
				System.out
						.println("Clicked commercial +++++Subelementlink SubMenu");
				Thread.sleep(2000);

			} else {

				System.out.println("Subelementlink" + SubElementLink);
				action.moveToElement(actionElement).click().build().perform();
				Thread.sleep(2000);
				System.out
						.println("Clicked commercial/technical+++++Subelementlink SubMenu");
				Thread.sleep(2000);

			}

		} else {
			action.moveToElement(actionElement).moveByOffset(0, 15).click()
					.build().perform();
			Thread.sleep(2000);
			System.out.println("Clicked Technical +++++SubMenu");
			Thread.sleep(2000);
		}

	}

	/**
	 * Function to verify for SOAP response data to check if the value is
	 * available or not
	 */
	public static void VerifySOAPResponseTagValueNotAvailable()
			throws Exception {

		// System.out.println(parseResponseXML(ExcelUtils.getCellData(Constant.testcaserownum,
		// Constant.Elementlocation)));
		String ExpectedTagValue = ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.DATA);
		String sExpectedTagValue = null;

		if (ExpectedTagValue.startsWith("#")) {
			sExpectedTagValue = Constant.TEMPSTORAGE.get(ExpectedTagValue);
		} else {
			sExpectedTagValue = ExpectedTagValue;
		}

		String ActualtagValue = parseResponseXML(ExcelUtils.getCellData(
				Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION));
		logmessage = "Exptected Value : " + sExpectedTagValue + ", ";

		if (ActualtagValue.contains(";$")) {
			if (ActualtagValue.contains(sExpectedTagValue)) {
				logmessage += "matched Actual Value " + ActualtagValue;
				TestCaseRunner.vResult = 0;
			} else {
				logmessage += "did NOT match Actual Value " + ActualtagValue;

			}

		} else {

			if (ActualtagValue.equals(sExpectedTagValue)) {
				logmessage += "matched Actual Value " + ActualtagValue;
				TestCaseRunner.vResult = 0;
			} else {
				logmessage += "did NOT match Actual Value " + ActualtagValue;

			}
		}

		Log.info(logmessage);
	}

	/*
	 * Function to verify priced item functionality in pricing page for Service
	 * Change Order,Migration Relocation - NewMonthlyCharge
	 */
	public static void verifyServicePricedItems() throws Exception {

		Thread.sleep(2000);
		if (driver
				.findElement(
						By.xpath("//*[@id='QuoteLineItems']//td[contains(.,'There are no priced items for this order')]"))
				.isDisplayed()) {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; Specified Element present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.info(logmessage);
		} else if (driver.findElement(
				By.xpath("//td[contains(@id,'NewMonthlyCharge')]"))
				.isDisplayed()) {
			String SValue1 = driver.findElement(
					By.xpath(".//td[contains(@id,'NewMonthlyCharge')]"))
					.getText();
			if (SValue1 != "0.00") {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; Specified Element present on the page; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION);
				Log.info(logmessage);
			} else {
				errorCaptureScreen();
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Failed; Specified Element is not present on the page; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION);

				Log.warn(logmessage);
				TestCaseRunner.vResult = 0;
			}

		} else {
			errorCaptureScreen();
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Failed; Specified Element is not present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}
	}

	/**
	 * Function to verify priced item functionality in pricing page
	 */
	public static void verifyPricedItems() throws Exception {

		Thread.sleep(2000);
		if (driver
				.findElement(
						By.xpath("//*[@id='QuoteLineItems']//td[contains(.,'There are no priced items for this order')]"))
				.isDisplayed()) {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; Specified Element present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.info(logmessage);
		} else if (driver.findElement(
				By.xpath("//td[contains(@id,'MonthlyCharges')]")).isDisplayed()) {
			String SValue1 = driver.findElement(
					By.xpath(".//td[contains(@id,'MonthlyCharges')]"))
					.getText();
			if (SValue1 != "0.00") {
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Passed; Specified Element present on the page; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION);
				Log.info(logmessage);
			} else {
				errorCaptureScreen();
				logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPID)
						+ "; "
						+ "Failed; Specified Element is not present on the page; "
						+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
								Constant.TESTSTEPDESCRIPTION);

				Log.warn(logmessage);
				TestCaseRunner.vResult = 0;
			}
		} else {
			errorCaptureScreen();
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Failed; Specified Element is not present on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}
	}

	/*
	 * Function to capture Order Number during bulk task manual milestone
	 * additional functionality
	 */
	public static void MilestoneOrderNumber() throws Exception {
		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Capture and stored value";
		Log.info(logmessage);
		String fetchfrompage = null;
		actionElement = findElement();
		if (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
				.isEmpty()) {
			String orderNumber = actionElement.getText();
			System.out.println("order Number is " + orderNumber);
			orderNumberCaptured.add(orderNumber);
			Constant.ORDERNUMBER = orderNumber;
			// ValueCaptureindex=ValueCaptureindex+1;
			int size = orderNumberCaptured.size();
			size = size - 1;
			logmessage = orderNumberCaptured.get(size)
					+ "; Value has been stored in index: " + size;

		} else if (!ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA1).isEmpty()) {

			orderNumberCaptured.add(actionElement.getAttribute(ExcelUtils
					.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)));
			// System.out.println(ValueCaptured.get(ValueCaptureindex));
			int size = orderNumberCaptured.size();
			size = size - 1;
			logmessage = orderNumberCaptured.get(size)
					+ "; Value has been stored in index: " + size;

			// ValueCaptureindex=ValueCaptureindex+1;

		}
		Log.info(logmessage);
	}

	// Function to check if FPC disabled in pricing page

	public static void VerifyDisabledAttribute() throws Exception {

		String btrue = driver.findElement(
				By.xpath("//input[contains(@id,':NewBillingCode:Edit')]"))
				.getAttribute("disabled");
		if (btrue.equalsIgnoreCase("true")) {
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Passed; Specified Element is disabled on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);
			Log.info(logmessage);
		} else {
			errorCaptureScreen();
			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ "Failed; Specified Element is not disabled on the page; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION);

			Log.warn(logmessage);
			TestCaseRunner.vResult = 0;
		}

	}

	// Function to handle dialod box
	public static void ModalDialogHandle() throws Exception {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void ClickModifyTypeSubMenu() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (!SubElementLink.isEmpty()) {
			System.out.println("Subelementlink" + SubElementLink);
			action.moveToElement(actionElement).moveByOffset(0, -15).click()
					.build().perform();
			Thread.sleep(2000);
			System.out.println("Clicking without price impact SubMenu");
			Thread.sleep(2000);
		} else {
			action.moveToElement(actionElement).moveByOffset(0, 5).click()
					.build().perform();
			Thread.sleep(2000);
			System.out.println("Clicking with price impact SubMenu");
			Thread.sleep(2000);
		}
	}

	public static void ClickPriceImpactOrderTypeSubMenu() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);

		String SubElementLink = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.DATA);
		if (!SubElementLink.isEmpty()) {
			action.moveToElement(actionElement).moveByOffset(0, -15).click()
					.build().perform();
			Thread.sleep(2000);
			System.out
					.println("Clicking 'Back to Capture Commercial Details' SubMenu");
			Thread.sleep(2000);
		} else {
			action.moveToElement(actionElement).moveByOffset(0, 5).click()
					.build().perform();
			Thread.sleep(2000);
			System.out
					.println("Clicking 'Back to Capture Technical Details' SubMenu");
			Thread.sleep(2000);
		}

	}

	public static void ClickMWPIBackCaptureTechnicalDetailsPopUp()
			throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		System.out.println(driver.manage().window().getPosition());
		System.out.println(actionElement);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(actionElement).moveByOffset(5, 5).click().build()
				.perform();
		Thread.sleep(2000);
		System.out.println("Clicking MWPI BackCaptureTechnicalDetails SubMenu");
		Thread.sleep(2000);

	}

	// Function to Click on Current Date from the popup displayed
	public static void GetCurrentDayFromDate() throws Exception {

		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int day = calendar.get(Calendar.DATE);
		// System.out.println("Current Day is:: " + day);
		// driver.findElement(By.xpath("//*[@id='wholedoc']/center//div[.='"+day+"']")).click();
		Class<?> orcls = Class.forName("objrepositories."
				+ Constant.APPLICATIONREPOSITORYNAME);
		String ObjLogicalName = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.ELEMENTLOCATION);
		By ObjectBy = null;
		ObjectBy = By.xpath(orcls.getField(ObjLogicalName).get(null).toString()
				.replace("#DATA", String.valueOf(day)));
		driver.findElement(ObjectBy).click();
		Thread.sleep(5000);
	}

	public static void TaskListMenupopup() throws Exception {

		logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
				Constant.TESTSTEPID)
				+ "; "
				+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
						Constant.TESTSTEPDESCRIPTION)
				+ "; Action: Mouse Hover and Click";
		Log.info(logmessage);

		actionElement = findElement();

		System.out.println(driver.manage().window().getSize());
		Actions action = new Actions(driver);
		action.moveToElement(actionElement).click().build().perform();
		Thread.sleep(2000);
		System.out.println("Clicked TaskList Menu PopUp");
		Thread.sleep(2000);
	}

	// Function to check for migrated product and capture the offerID
	public static void CheckForMigratedProductAndCaptureOfferID()
			throws Exception {

		if (Constant.MigratedProduct) {

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "
					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)
					+ "; Action: Capture and stored value";
			Log.info(logmessage);
			String fetchfrompage = null;
			InstalledOfferIDNumberCaptured.clear();
			actionElement = findElement();
			fetchfrompage = actionElement.getText();
			// System.out.println("Offer Id "+fetchfrompage);
			InstalledOfferIDNumberCaptured.add(fetchfrompage.trim());
			int size = InstalledOfferIDNumberCaptured.size();
			size = size - 1;
			logmessage = InstalledOfferIDNumberCaptured.get(size)
					+ "; Installed Offer ID Value has been stored in index: "
					+ size;
			System.out
					.println("Installed Offer ID Value has been stored in index: "
							+ size);

		}
	}

	// Function to check for order status for migrated product
	public static void CheckForMigratedProductOrderStatus() throws Exception {

		if (Constant.MigratedProduct) {

			String Statusfrompage = null;
			InstalledOfferIDNumberCaptured.clear();
			actionElement = findElement();
			Statusfrompage = actionElement.getText();
			System.out.println("Order Status " + Statusfrompage);
			if (Statusfrompage.equalsIgnoreCase("closed")) {
				MigratedProductOrder = true;
			}

		}
	}

	// Function to check for change order needs to be created for migrated
	// product
	public static void CheckForOrderMigration() throws Exception {

		Screen s = new Screen();
		if (Constant.MigratedProduct) {
			driver.findElement(GOLDStandAlone.InstalledOfferMenu).click();
			Thread.sleep(5000);
			driver.findElement(GOLDStandAlone.InstalledOfferID).sendKeys(
					Constant.REFINSTALLEDOFFERID);
			Thread.sleep(3000);
			driver.findElement(GOLDStandAlone.Inbox_SearchButton).click();
			Thread.sleep(5000);
			driver.findElement(
					GOLDStandAlone.GOLD_orders_CreateOrder_InstalledOffer_xpath)
					.click();
			Thread.sleep(3000);
			// s.click(Constant.SIKULIIMAGELOCATION+"\\InstalledOfferCreateOrderDropDown.jpg");
			Thread.sleep(3000);
			driver.findElement(GOLDStandAlone.InstalledOffer_CreateOrderChange)
					.click();
			Thread.sleep(5000);

		} else {
			driver.findElement(GOLDStandAlone.OrderMenu).click();
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.GOLD_orders_CreateOrder_xpath)
					.click();
			Thread.sleep(1000);
			// s.click(Constant.SIKULIIMAGELOCATION+"\\CreateOrderDropDown.jpg");
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.CreateOrderChange).click();
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.ChO_Selectchange_spyglass)
					.click();
			Thread.sleep(1000);
			/*
			 * String CurrentWindowHandle = driver.getWindowHandle();
			 * Set<String> wHandles = driver.getWindowHandles(); for (String
			 * winHandle : wHandles) { String windowTitle =
			 * driver.getTitle().trim().toString().toLowerCase(); String
			 * ExcelDataTitle = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
			 * Constant.DATA).trim().toString().toLowerCase();
			 * 
			 * if(!winHandle.equals(CurrentWindowHandle) ){
			 * driver.switchTo().window(winHandle); //
			 * Log.info("----------- inside for -----------------");
			 * Log.info(winHandle); Log.info(driver.getTitle());
			 * 
			 * windowTitle = driver.getTitle().trim().toString().toLowerCase();
			 * Constant.CHILDWINDOWHANDLE = winHandle;
			 * if(windowTitle.contains(ExcelDataTitle) ||
			 * windowTitle.equals(ExcelDataTitle)) {
			 * 
			 * ((JavascriptExecutor)driver).executeScript("window.focus()");
			 * driver.manage().window().maximize();
			 * 
			 * break; } } }
			 */
			windowSwitch();
			Thread.sleep(1000);
			// driver.switchTo().frame("SelectorIFrame");
			driver.findElement(GOLDStandAlone.ChO_EnterChangeOrder).sendKeys(
					Constant.REFORDERNUMBER);
			Thread.sleep(2000);
			driver.findElement(GOLDStandAlone.SearchButton).click();
			Thread.sleep(2000);
			driver.findElement(GOLDStandAlone.ResultFirstRow).click();
			Thread.sleep(2000);
			windowSwitch();
			alert();
			/*
			 * Robot robot = new Robot(); robot.delay(40);
			 * robot.keyPress(KeyEvent.VK_ENTER); robot.delay(40);
			 * robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(40);
			 * Thread.sleep(1000);
			 */
			/*
			 * driver.switchTo().defaultContent(); String[] handles =
			 * driver.getWindowHandles().toArray(new String[0]);
			 * driver.switchTo().window(handles[handles.length - 1]);
			 */

		}
	}

	// Function to check for change order needs to be created for migrated
	// product
	public static void CheckForDisconnectOrderMigration() throws Exception {

		Screen s = new Screen();
		if (Constant.MigratedProduct) {
			driver.findElement(GOLDStandAlone.InstalledOfferMenu).click();
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.InstalledOfferID).sendKeys(
					Constant.REFINSTALLEDOFFERID);
			driver.findElement(GOLDStandAlone.Inbox_SearchButton).click();
			driver.findElement(
					GOLDStandAlone.GOLD_orders_CreateOrder_InstalledOffer_xpath)
					.click();
			// s.click(Constant.SIKULIIMAGELOCATION+"\\InstalledOfferCreateOrderDropDown.jpg");
			driver.findElement(
					GOLDStandAlone.InstalledOffer_CreateOrderDisconnect)
					.click();
			Thread.sleep(3000);

		} else {
			driver.findElement(GOLDStandAlone.OrderMenu).click();
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.GOLD_orders_CreateOrder_xpath)
					.click();
			Thread.sleep(1000);
			// s.click(Constant.SIKULIIMAGELOCATION+"\\CreateOrderDropDown.jpg");
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.CreateOrderDisconnect).click();
			Thread.sleep(1000);
			driver.findElement(GOLDStandAlone.ChO_Selectchange_spyglass)
					.click();
			Thread.sleep(1000);
			/*
			 * String CurrentWindowHandle = driver.getWindowHandle();
			 * Set<String> wHandles = driver.getWindowHandles(); for (String
			 * winHandle : wHandles) { String windowTitle =
			 * driver.getTitle().trim().toString().toLowerCase(); String
			 * ExcelDataTitle = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
			 * Constant.DATA).trim().toString().toLowerCase();
			 * 
			 * if(!winHandle.equals(CurrentWindowHandle) ){
			 * driver.switchTo().window(winHandle); //
			 * Log.info("----------- inside for -----------------");
			 * Log.info(winHandle); Log.info(driver.getTitle());
			 * 
			 * windowTitle = driver.getTitle().trim().toString().toLowerCase();
			 * Constant.CHILDWINDOWHANDLE = winHandle;
			 * if(windowTitle.contains(ExcelDataTitle) ||
			 * windowTitle.equals(ExcelDataTitle)) {
			 * 
			 * ((JavascriptExecutor)driver).executeScript("window.focus()");
			 * driver.manage().window().maximize();
			 * 
			 * break; } } }
			 */
			windowSwitch();
			Thread.sleep(1000);
			// driver.switchTo().frame("SelectorIFrame");
			driver.findElement(GOLDStandAlone.ChO_EnterChangeOrder).sendKeys(
					Constant.REFORDERNUMBER);
			Thread.sleep(2000);
			driver.findElement(GOLDStandAlone.SearchButton).click();
			Thread.sleep(2000);
			driver.findElement(GOLDStandAlone.ResultFirstRow).click();
			Thread.sleep(2000);
			windowSwitch();
			alert();
			/*
			 * Robot robot = new Robot(); robot.delay(40);
			 * robot.keyPress(KeyEvent.VK_ENTER); robot.delay(40);
			 * robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(40);
			 * Thread.sleep(1000);
			 */
			/*
			 * driver.switchTo().defaultContent(); String[] handles =
			 * driver.getWindowHandles().toArray(new String[0]);
			 * driver.switchTo().window(handles[handles.length - 1]);
			 */

		}
	}

	public static void AddToTechnicalTeam() throws Exception {

		String userName = driver
				.findElement(
						By.xpath("//tr[./td/img[@class='OBSLogoapp_image']]/td[3]/span[1]"))
				.getText().trim();
		String[] splitName = userName.split(" ");
		String firstName = splitName[0];
		String lastName = splitName[1];

		driver.findElement(
				By.xpath(".//table[@id='LeftNavBar']//tr[.='Teams']")).click();
		driver.findElement(By.className("butManageTeams")).click();
		alertif();

		if (driver.findElement(By.id("TeamControlTechSup_Inherit"))
				.isSelected()) {
			driver.findElement(By.id("TeamControlTechSup_Inherit")).click();
		}
		/*
		 * driver.findElement(By.id("TeamControlTechSup_add")).click();
		 * windowSwitch();
		 * driver.findElement(By.id("firstNameValUser")).sendKeys(firstName);
		 * driver.findElement(By.id("lastNameValUser")).sendKeys(lastName);
		 * driver.findElement(By.id("searchButton")).click();
		 * driver.findElement(By.id("grid_row_1")).click(); windowSwitch();
		 */
		// Team is locked Checked/Unchecked
		if (!driver.findElement(By.id("TeamControlTechSup_Locked"))
				.isSelected()) {
			driver.findElement(By.id("TeamControlTechSup_Locked")).click();
		}
		driver.findElement(By.className("butSaveTeams")).click();
	}

	// Submit the capure Router name
	/*
	 * public static void RouterNameSubmit() throws Exception { logmessage =
	 * ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.TESTSTEPID) +
	 * "; " + ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
	 * Constant.TESTSTEPDESCRIPTION) +
	 * "; Action: Submit the router name captured"; Log.info(logmessage); String
	 * fetchfrompage = null; actionElement = findElement(); if
	 * (ExcelUtils.getCellData(Constant.TESTCASEROWNUM, Constant.DATA1)
	 * .isEmpty()) { if (Routername!=null || Routername!="" || Routername!=" ")
	 * { actionElement.clear(); actionElement.sendKeys(Routername); } else {
	 * Routername="CPE1"; actionElement.clear();
	 * actionElement.sendKeys(Routername); } }
	 * System.out.println("**************Router Name Submitted is :"
	 * +Routername); Log.info(logmessage); }
	 */

	public static void ThreadWaitforObject() throws Exception {

		int iWait;

		for (iWait = 0; iWait < 20; iWait++)

		{

			System.out
					.println("******First Total number of wait time************ : "
							+ iWait);
			Thread.sleep(2000);
			By ObjectBy = null;
			Class<?> orcls = Class.forName("objrepositories."
					+ Constant.APPLICATIONREPOSITORYNAME);
			String ObjLogicalName = ExcelUtils.getCellData(
					Constant.TESTCASEROWNUM, Constant.ELEMENTLOCATION);
			ObjectBy = (By) orcls.getField(ObjLogicalName).get(null);
			System.out.println("******Element String is :" + ObjLogicalName);
			System.out.println("******Element String is :" + ObjectBy);
			int b = driver.findElements(ObjectBy).size();
			System.out.println("******Element Found value :" + b);
			// int b=driver1.findElements(by).size();

			if (b > 0) {
				break;
			}

			logmessage = ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
					Constant.TESTSTEPID)
					+ "; "

					+ ExcelUtils.getCellData(Constant.TESTCASEROWNUM,
							Constant.TESTSTEPDESCRIPTION)

					+ "; Action: Manual Wait for 5000"

					+ " Milli seconds";

			Log.info(logmessage);
			Thread.sleep(5000);
			System.out
					.println("****** Second Total number of wait time************ : "
							+ iWait);

		}

		System.out
				.println("******Final Total number of wait time************ : "
						+ iWait);
	}

	/**
	 * Function to click on down arrow key.
	 *
	 */

	public static void ClickRightArrowKey() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(2000);

	}

	/**
	 * Method to verify Gateway Error milestone and submit it
	 */
	public static void ChechGatewayError() throws Exception {
		String currentTask = driver.findElement(GOLDStandAlone.CurrentTask)
				.getText().trim().toLowerCase();
		if (currentTask.contains("gateway")) {
			driver.findElement(By.className("completeTask")).click();
			driver.findElement(
					By.xpath("//div[@id='WFActionPopup']//td[.='submit and inform sdm']"))
					.click();
			driver.switchTo().alert().accept();
			driver.findElement(
					By.xpath("//a[@onclick='triggerOrdersNavButton();']"))
					.click();
			driver.findElement(By.id("grid_row_1")).click();
		}
	}
}