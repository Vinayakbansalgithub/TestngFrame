package vb.AutomationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.internal.Locatable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.net.ssl.SSLSocket;

// api imports

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
class LowBatteryException extends Exception {
	LowBatteryException(String s) {
		super(s);
	}
}

class coordinateNotDefinedException extends Exception {
	coordinateNotDefinedException(String s) {
		super(s);
	}
}

class NoDeviceFoundException extends Exception {
	NoDeviceFoundException(String s) {
		super(s);
	}
}

public class ActionClass {

	public static WebDriver driver = null;
	// static ATUTestRecorder recorder;
	static DateFormat dateFormat;

	static WebElement from, to, wbFrom, wbTo;
	static int devicecount = 0;

	public static boolean suitrunner = true;
	static DesiredCapabilities capabilities;
	static String nodePath = "\"C:\\Program Files (x86)\\Appium\\node.exe\"";
	static String appiumJSPath = "\"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js\"";
	static String versionapp = "--address 127.0.0.1 --port 4723 --platform-name Android --platform-version 23 --automation-name Appium --log-no-color";
	static String cmd = nodePath + " " + appiumJSPath + " " + versionapp;
	static Process p;

	/*
	 * public static Screen screen; public static Pattern pattern;
	 */
	public static long startTime;
	public static long starttest;
	static String nullcheck;

	// api

	static Response res;
	static String msg = "";
	static JSONArray jsonarr;
	static JSONObject jsonobj;
	static String responseBody;
	static Boolean flag=true;
	static Integer nullvalueCount = 0;
	// parameter hashmap
	public static TreeMap<String, String> HashMapParameter = new TreeMap<String, String>();
	public static ArrayList<String> listValues = new ArrayList<String>();
	public static ArrayList<String> listAttributes = new ArrayList<String>();
	public static ArrayList<String> nullCount = new ArrayList<String>();

	static String attribute;
	static String attributeValue;

	static String[] parameters;
	static Integer totalParameters;
	static String[] keyValue;
	static String[] key;
	static String[] value;
	static String[] jsonAttribute;
	static JSONArray jsonArray;

	// get the y corrdinate for the horizontal view
	static int ycoordinate;

	// otp capture
	public static String otpvalue = null;

	// generic webelement used everywhere
	public static WebElement we;

	static WebElement findPath(String string) {

		WebDriverWait wait = new WebDriverWait(driver, 10); // explicit wait

		if (string.equalsIgnoreCase("Xpath")) {
			return (wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath((BuildObjrep.TestCaseHashmap
									.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("ObjectRep")) {

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath((BuildObjrep.objKeyValue
							.get(BuildObjrep.TestCaseHashmap
									.get("Elementlocation")))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.objKeyValue
			 * .get(BuildObjrep.TestCaseHashmap.get("Elementlocation"))));
			 */

		}

		if (string.equalsIgnoreCase("name")) {
			return (wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.name((BuildObjrep.TestCaseHashmap
									.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("className")) {
			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.className((BuildObjrep.TestCaseHashmap
							.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("id")) {
			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.id((BuildObjrep.TestCaseHashmap.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		return null;

	}

	static WebElement findPathActionSupport(String locType) {

		switch (locType) {
		case "name":
			we = driver.findElement(By.name(BuildObjrep.TestCaseHashmap
					.get("ActionSupportValue")));
			break;

		default:
			break;
		}

		return we;
	}

	static WebElement findPathclick(String string, AndroidDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10); // explicit wait

		if (string.equalsIgnoreCase("Xpath")) {
			return (wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath((BuildObjrep.TestCaseHashmap
									.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("ObjectRep")) {

			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath((BuildObjrep.objKeyValue
							.get(BuildObjrep.TestCaseHashmap
									.get("Elementlocation")))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.objKeyValue
			 * .get(BuildObjrep.TestCaseHashmap.get("Elementlocation"))));
			 */

		}

		if (string.equalsIgnoreCase("name")) {
			return (wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.name((BuildObjrep.TestCaseHashmap
									.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("className")) {
			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.className((BuildObjrep.TestCaseHashmap
							.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		if (string.equalsIgnoreCase("id")) {
			return (wait.until(ExpectedConditions.presenceOfElementLocated(By
					.id((BuildObjrep.TestCaseHashmap.get("Elementlocation"))))));

			/*
			 * return driver.findElement(By.xpath(BuildObjrep.TestCaseHashmap
			 * .get("Elementlocation")));
			 */
		}

		return null;

	}

	public static List<String> getAllElementText(List<WebElement> wb, int size) {
		List<String> PageList = new ArrayList<String>();
		for (WebElement eachwb : wb) {
			PageList.add(eachwb.getText());
		}

		return PageList;

	}

	static List<WebElement> findPaths(String string) {

		WebDriverWait wait = new WebDriverWait(driver, 10); // explicit wait

		if (string.equalsIgnoreCase("Xpath")) {

			return driver.findElements(By.xpath(BuildObjrep.TestCaseHashmap
					.get("Elementlocation")));

		}

		if (string.equalsIgnoreCase("ObjectRep")) {
			return driver.findElements(By.xpath(BuildObjrep.objKeyValue
					.get(BuildObjrep.TestCaseHashmap.get("Elementlocation"))));

		}

		return null;

	}

	public static void BrowserUsed(String browser) throws IOException,
			NoDeviceFoundException, ClassNotFoundException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InterruptedException {

		if (browser.equalsIgnoreCase("firefox")) {
			ExtentHTML.starttest();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			BuildObjrep.runTestCase(driver);
		} else if (browser.equalsIgnoreCase("chrome")) {

			try {
				ExtentHTML.starttest();
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.BROWSER_NAME,
						"chrome");
				capabilities
						.setCapability(
								CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
								true);

				System.setProperty("webdriver.chrome.driver",
						"D:\\Vinayak\\workspace\\asdasd\\Driver\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();
				BuildObjrep.runTestCase(driver);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
System.out.println("chrome check");
		}

		else if (browser.equalsIgnoreCase("Appium")) {

			// Created object of DesiredCapabilities class.
			capabilities = new DesiredCapabilities();

			System.out.println("appium setup is running on the system");

			// Set android deviceName desired capability. Set it Android
			// Emulator.
			String developer_mode = "enable developer mode";
			String device_adb = "adb devices";
			Process p_device = Runtime.getRuntime().exec(device_adb);
			// System.out.println("process name is " + p);

			java.io.InputStream is = p_device.getInputStream();
			java.io.BufferedReader reader = new java.io.BufferedReader(
					new InputStreamReader(is));
			reader.readLine();
			for (int i = 0; i < 5; ++i) {

				String lineIWant = reader.readLine();
				if (lineIWant == null) {
					break;
				}

				if (flag == true) {
					nullcheck = lineIWant;
					flag = false;
				}

				if (nullcheck.equals(null) || nullcheck.equals("")) {
					// System.out.println("No device or emulator is available");
					throw new NoDeviceFoundException(
							"No device or emulator is available");

				}

				if (lineIWant.contains("emulator") && !lineIWant.isEmpty()) {
					capabilities
							.setCapability("deviceName", "Android Emulator");
					// break;

				} else if (!lineIWant.contains("emulator")
						&& !lineIWant.isEmpty()) {
					String[] str = lineIWant.split("\\s+");

					// lineIWant.split("\\d+");
					System.out.println("device name is " + str[0]);
					// capabilities.setCapability("deviceName", str[0]);

					capabilities.setCapability("udid", str[0]);

					break;
				}

			}

			String device_version = "adb shell getprop ro.build.version.release";
			Process p_version = Runtime.getRuntime().exec(device_version);
			// System.out.println("process name is " + p);
			BufferedReader errinput = new BufferedReader(new InputStreamReader(
					p_version.getErrorStream()));

			String errormsg = errinput.readLine();
			System.out.println("error message is " + errormsg);
			java.io.InputStream isV = p_version.getInputStream();
			java.io.BufferedReader version = new java.io.BufferedReader(
					new InputStreamReader(isV));
			String versionvalue = version.readLine();

			if (errormsg == null) {
				errormsg = "only one device connected";
				System.out.println("version for the defined device is "
						+ versionvalue);
			}

			if (!(errormsg.contains("only one device connected"))) {

				// capabilities.setCapability("platformVersion", "6.0");

			}
			if (!(versionvalue == null))
				if (versionvalue.contains(".")) {
					// capabilities.setCapability("platformVersion",
					// versionvalue);

					capabilities.setCapability("platformVersion", versionvalue);

				}
			capabilities.setCapability("deviceName", "Android Emulator");
			// capabilities.setCapability("udid", "emulator-5554");

			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("deviceName", "Android");

			capabilities.setCapability("noReset", "true");

			// calling package activity class
			PackageActivityClass.findPackageActivityfun();

			// CapabilitiesDevice.findPackageActivity();

			capabilities.setCapability("appPackage",
					BuildObjrep.PackageActivityMap.get("Package"));

			capabilities.setCapability("appActivity",
					BuildObjrep.PackageActivityMap.get("Activity"));

			try {
				// AndroidDriver Adriver
				driver = new AndroidDriver(new URL(
						"http://127.0.0.1:4723/wd/hub"), capabilities);

				System.out.println("driver capabilities has been set: "
						+ driver);
			} catch (SecurityException | IllegalArgumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BuildObjrep.runTestCase(driver);

		}

		if (browser.equalsIgnoreCase("Api")) {
			// need to be done
			BuildObjrep.runTestCase(null);

			/*System.out
					.println("need to be inplemented using Rest Assured- api Automionat");*/

		}
	}

	public static void OpenURL() throws InterruptedException, IOException {

		// Get current date and time to provide in recorded video name.
		Date date = new Date();

		startTime = System.currentTimeMillis();
		starttest = TimeUnit.MILLISECONDS.toSeconds(startTime);
		System.out.println("test case start at  " + starttest);
		// Created object of ATUTestRecorder.
		// Provide path to store videos and file name format.
		/*
		 * recorder = new ATUTestRecorder("D:/ScriptVideos/", "TestVideo-" +
		 * dateFormat.format(date), false);
		 */

		/*
		 * recorder = new ATUTestRecorder("D:/ScriptVideos/",
		 * "TestVideo-appium record", false);
		 * 
		 * recorder.start();
		 */
		String browserName = BuildObjrep.TestSuitHashmap.get("Browser");

		if (BuildObjrep.browser.equalsIgnoreCase("chrome")
				|| BuildObjrep.browser.equalsIgnoreCase("Firefox")) {
			ExtentHTML.starttest();
			driver.get(BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
					.get("Elementlocation")));
			msg = "opening url :   "
					+ BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
							.get("Elementlocation"));
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		}
		if (BuildObjrep.browser.equalsIgnoreCase("Appium")) {

			ExtentHTML.starttest();

			msg = "opening application :   "
					+ BuildObjrep.TestCaseHashmap.get("Testcaseid");
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);

		}
		if (BuildObjrep.browser.equalsIgnoreCase("Api")) {
		} /*
		 * ExtentHTML.starttest();
		 * 
		 * try { URL url = new URL(
		 * BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
		 * .get("Elementlocation"))); HttpURLConnection conn =
		 * (HttpURLConnection) url .openConnection();
		 * conn.setRequestMethod("GET"); conn.setRequestProperty("Accept",
		 * "application/json");
		 * 
		 * if (conn.getResponseCode() != 200) { throw new
		 * RuntimeException(" HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * Scanner scan = new Scanner(url.openStream()); jsonResponse = new
		 * String(); while (scan.hasNext()) jsonResponse += scan.nextLine();
		 * 
		 * System.out.println("Response : " + jsonResponse);
		 * 
		 * scan.close(); msg = "opening url :   " + BuildObjrep.objKeyValue
		 * .get(BuildObjrep.TestCaseHashmap .get("Elementlocation"));
		 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg);
		 * 
		 * } catch (MalformedURLException e) { e.printStackTrace();
		 * 
		 * } catch (IOException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * } }
		 */

	}

	// to switch application add package name and activity name in data column
	// seperated by comma

	public static void Applicationswitch(AndroidDriver driver)
			throws InterruptedException, MalformedURLException {

		String DataFieldValue = BuildObjrep.TestCaseHashmap.get("Data");
		String index[] = DataFieldValue.split(",");

		String packagename = index[0];
		String activityname = index[1];

		try {
			driver.startActivity(packagename, activityname);
			String msg = "application has been changed to " + packagename;

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.fail(msg);
		} catch (Exception e) {

			String msg = "application is not changed, Application package or activity name may be incorrect";
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void ApplicationSwitchBack() {

		((StartsActivity) driver).startActivity(
				BuildObjrep.PackageActivityMap.get("Package"),
				BuildObjrep.PackageActivityMap.get("Activity"));

	}

	public static void SubmitValue() throws InterruptedException {

		// HelpAllfunctions.ajaxWaitandJquery();

		/*
		 * if(BuildObjrep.browser.equalsIgnoreCase("Appium")){
		 * 
		 * ((AppiumDriver) driver).resetApp(); }
		 */
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		we.sendKeys(BuildObjrep.TestCaseHashmap.get("Data"));

		Thread.sleep(2000);

		msg = "value " + BuildObjrep.TestCaseHashmap.get("Data")
				+ "  has been submited";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void OTPcapture() throws InterruptedException {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		System.out.println("wb has been created");

		String frompage = we.getText();
		String[] splited = frompage.split(" ");
		for (String string : splited) {
			if (string.matches("\\d+")) {
				otpvalue = string;
				break;
			}

		}

		BuildObjrep.arraylist.add(otpvalue);

	}

	public static void ValueCapture() throws Exception, Throwable {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		String DataValue = BuildObjrep.TestCaseHashmap.get("Data");
		String ValueFromPage = "";
		String Leftlimit = "", RightLimit = "";
		if (we == null) {
			NoSuchElementException e = new NoSuchElementException();
			throw e;
		}
		if (!DataValue.contains("Blank")) {
			if (DataValue.contains("^")) {
				Leftlimit = DataValue.split("\\^")[0];
				RightLimit = DataValue.split("\\^")[1];
				Leftlimit = Leftlimit.replace("&lt", "");
				RightLimit = RightLimit.replace("&rt", "");
			} else if (DataValue.contains("&lt")) {
				Leftlimit = DataValue.replace("&lt", "");
			} else {
				RightLimit = DataValue.replace("&rt", "");
			}
		}

		if (BuildObjrep.TestCaseHashmap.get("ActionSupportValue") == "Blank") {
			ValueFromPage = we.getText();
		} else {
			ValueFromPage = we.getAttribute(BuildObjrep.TestCaseHashmap
					.get("ActionSupportValue"));
		}

		if (Leftlimit != "") {
			Leftlimit = Leftlimit.trim();
			ValueFromPage = ValueFromPage.split(Leftlimit)[1];
		}
		if (RightLimit != "") {
			RightLimit = RightLimit.trim();
			ValueFromPage = ValueFromPage.split(RightLimit)[0];
			// ValueFromPage = ValueFromPage.split("\\(")[0];
		}
		if (ValueFromPage.contains("Post")) {
			ValueFromPage = ValueFromPage.trim();
			ValueFromPage = ValueFromPage.split(" ")[0];
		}
		ValueFromPage = ValueFromPage.trim();

		BuildObjrep.arraylist.add(ValueFromPage);
		int size = BuildObjrep.arraylist.size();
		size = size - 1;
		msg = "value " + BuildObjrep.TestCaseHashmap.get("Data")
				+ "  has been stored";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// you can give percentage in the data column, like 50 or 80.
	public static void seekBar(MobileDriver driver) {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		float precentage = Float.parseFloat(BuildObjrep.TestCaseHashmap
				.get("Data"));
		precentage = (float) (precentage * .01);
		// Get start point of seekbar.
		int startX = we.getLocation().getX();
		System.out.println(startX);
		// Get end point of seekbar.
		int endX = we.getSize().getWidth();
		System.out.println(endX);
		// Get vertical location of seekbar.
		int yAxis = we.getLocation().getY();

		// Set sllebar move to position.
		// endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * (precentage));
		System.out.println("Moving seek bar at " + moveToXDirectionAt
				+ " In X direction.");

		// Moving seekbar using TouchAction class.
		TouchAction act = new TouchAction(driver);
		act.press(startX, yAxis).moveTo(moveToXDirectionAt, yAxis).release()
				.perform();

		msg = "value " + BuildObjrep.TestCaseHashmap.get("Data")
				+ "  has been submited";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// in data colum either landscape or portrait
	public static void ScreenOrientation(MobileDriver driver) {

		String orientation = BuildObjrep.TestCaseHashmap.get("Data");

		if (orientation.equalsIgnoreCase("LANDSCAPE")) {
			driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		}
		if (orientation.equalsIgnoreCase("PORTRAIT")) {
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		}

		msg = "screen orientation is " + driver.getOrientation();

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// this will hide keyboard which appear on screen
	public static void hideKeyboard(MobileDriver driver) {

		driver.hideKeyboard();

		msg = "keyboard is hidden";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void Click() {

		/*
		 * WebElement wb = findPath(BuildObjrep.TestCaseHashmap
		 * .get("ElementFinderType"));
		 */
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		/*
		 * Point point = we.getLocation(); point = we.getLocation();
		 */
		Point p = ((Locatable) we).getCoordinates().inViewPort();
		we.click();

		// point = wb.getLocation();

		msg = "value " + we + "  has been clicked";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void clear() {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		we.clear();

		msg = "value " + we + "  has been cleared";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void LongClick(MobileDriver driver) {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		TouchAction action = new TouchAction(driver);
		action.longPress(we).release().perform();
		msg = "value " + we + "  has been clicked";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void Tap(AndroidDriver driver) {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		Point point1 = we.getLocation();
		int y = point1.getY();
		int x = point1.getX();
		TouchAction action = new TouchAction(driver);

		action.tap(we);

		msg = "value " + we + "  has been tap";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void DoubleTap(MobileDriver driver) {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		Point point = we.getLocation();
		int y = point.getY();
		int x = point.getX();
		TouchAction action = new TouchAction(driver);
		action.tap(we, x, y);
		action.tap(we, x, y);
		msg = "value " + we + "  has been double tap";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void ClickCopyCapture() throws InterruptedException,
			AWTException, UnsupportedFlavorException, IOException {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		driver.manage().window().maximize();

		HelpAllfunctions.clearClipboard();
		we.click();

		HelpAllfunctions.controlA();

		HelpAllfunctions.controlC();

		String data = HelpAllfunctions.ClipboardData();

		BuildObjrep.arraylist.add(data);
		int size = BuildObjrep.arraylist.size();
		size = size - 1;
		// System.out.println(BuildObjrep.arraylist.get(size));
		msg = "value " + BuildObjrep.arraylist.get(size)
				+ "  has been captured and stored at index" + size;
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void VerifyText() {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		// System.out.println("wb has been created");
		String frompage = we.getText();
		String fromdatafield = BuildObjrep.TestCaseHashmap.get("Data");
		// System.out.println("data field value is  " + fromdatafield);
		msg = "value from page " + frompage + "  value from data field is "
				+ fromdatafield + " for method  VerifyText";

		if (frompage.contains(fromdatafield)) {
			System.out.println("contains check  "
					+ frompage.contains(fromdatafield));
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} else {
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void Pageback() {

		driver.navigate().back();

		String msg = " Back Button is clicked sucessfully";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// give clear in data column if want to clear notification

	public static void openNotification(AndroidDriver driver)
			throws InterruptedException {

		driver.openNotifications();

		Thread.sleep(2000);
		String fromdatafield = BuildObjrep.TestCaseHashmap.get("Data");

		if (fromdatafield.equalsIgnoreCase("clear")
				&& BuildObjrep.TestCaseHashmap.get("Elementlocation")
						.equalsIgnoreCase("")) {

			we = driver.findElement(By
					.id("com.android.systemui:id/dismiss_text"));
			we.click();
		}
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		we.click();

		System.out.println("element has been clicked" + we);

	}

	public static void isAppInstalled(AndroidDriver driver) {

		String packagename = BuildObjrep.TestCaseHashmap.get("Data");
		Boolean value = driver.isAppInstalled(packagename);
		if (value.equals("true")) {
			String msg = "Application is installed";
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);

		} else {

			String msg = "please install " + packagename + " before you test";
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void Zoom() throws InterruptedException {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		((AndroidDriver) driver).zoom(we);

		String msg = "zoom";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void WindowSwitch() {

		// by Id
		String toWindow = BuildObjrep.TestCaseHashmap.get("Data");
		driver.switchTo().window(toWindow);

	}

	public static void frameSwitch() {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < size; i++) {

			if (we == null) {
				driver.switchTo().defaultContent();
			} else {
				driver.switchTo().frame(i);
			}
		}

	}

	public static void VerifyAny() throws IOException {
		boolean Result = false;
		List<WebElement> wb = findPaths(BuildObjrep.TestCaseHashmap
				.get("ElementFinderType"));
		// System.out.println("total number of elements  " + wb.size());

		List<String> frompageList = getAllElementText(wb, wb.size());
		frompageList = new ArrayList<String>(new LinkedHashSet<String>(
				frompageList));
		// System.out.println("from page values   "+frompageList);
		for (String pagevalue : frompageList) {
			if (pagevalue.contains(BuildObjrep.TestCaseHashmap.get("Data"))) {

				Result = true;
				break;
			}

		}
		if (Result) {
			String msg = "value " + BuildObjrep.TestCaseHashmap.get("Data")
					+ "  is found in list" + frompageList;
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} else {

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			// Now you can do whatever you need to do with it, for example copy
			// somewhere

			FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
			String msg = "value " + BuildObjrep.TestCaseHashmap.get("Data")
					+ "  is not found in list" + frompageList;
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void VerifyCapture() {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		String frompage = we.getText();
		int index = Integer.parseInt(BuildObjrep.TestCaseHashmap.get("Data"));

		String valueatIndex = BuildObjrep.arraylist.get(index);

		msg = "value from page " + frompage + "value stored at Index "
				+ valueatIndex + "is " + valueatIndex
				+ " for method  VerifyCapture";

		if (frompage.contains(valueatIndex)) {
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} else {
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	// this alert work for both Web and mobile
	public static void AlertAccept() {

		if (BuildObjrep.browser.equalsIgnoreCase("Appium")) {

			driver.findElement(By.name("OK")).click();
		} else
			driver.switchTo().alert().accept();

		msg = "Alert accepted";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// this alert work for both Web and mobile
	public static void AlertReject() {

		if (BuildObjrep.browser.equalsIgnoreCase("Appium")) {
			driver.findElement(By.name("Cancel")).click();
		} else
			driver.switchTo().alert().dismiss();

		msg = "Alert dismissed";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	public static void VerifyElement() throws IOException {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));
		if (we != null) {
			msg = "Element present";

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);

		} else {

			msg = "Element not present";
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			// Now you can do whatever you need to do with it, for example copy
			// somewhere

			FileUtils.copyFile(scrFile, new File("D:\\screenshot"
					+ BuildObjrep.TestCaseHashmap.get("Testcaseid") + ".png"));

			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);

		}

	}

	public static void VerifyAttribute() {
		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		String att = we.getAttribute(BuildObjrep.TestCaseHashmap
				.get("ActionSupportValue"));
		String data = BuildObjrep.TestCaseHashmap.get("Data");
		String msg = "value from page  " + att + "  value in datfield  " + data
				+ " for method  verifyelement";
		if (att.equals(data)) {
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} else {
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	// This is to verify the Android package name against the value defined in
	// the data section.
	public static void VerifyApkPackage() {

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		String fromPageValue = we.getText();
		String DataFieldValue = BuildObjrep.TestCaseHashmap.get("Data");
		String msg = "package name from page  " + fromPageValue
				+ "  value in datafield  " + DataFieldValue
				+ "  method  VerifyApkPackage";

		if (fromPageValue.contains(DataFieldValue)) {
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} else {
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void Native(AndroidDriver driver)
			throws InterruptedException, IOException {
		String command = BuildObjrep.TestCaseHashmap.get("Data");
		if (command.equalsIgnoreCase("home")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		}
		if (command.equalsIgnoreCase("menu")) {
			driver.pressKeyCode(AndroidKeyCode.MENU);
			Thread.sleep(2000);

		}
		if (command.equalsIgnoreCase("volume up")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		}
		if (command.equalsIgnoreCase("volume down")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		}

		if (command.equalsIgnoreCase("mute")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_MUTE);

		}

		if (command.equalsIgnoreCase("brightness up")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);

		}

		if (command.equalsIgnoreCase("brightness down")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);

		}

		if (command.equalsIgnoreCase("brightness down")) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);

		}

		if (command.equalsIgnoreCase("lock")) {
			Runtime.getRuntime().exec("adb shell input keyevent 26");

		}

		if (command.equalsIgnoreCase("unlock")) {
			Runtime.getRuntime().exec("adb shell input keyevent 82");

		}
		if (command.equalsIgnoreCase("back"))
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);

		String msg = "commad for " + command + " has been executed";
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// This is to test the application in batter saver mode
	// batter saver functionality will not work with usb connnected.
	// for this try emulator or bluetooth
	public static void BatteryStatus(AndroidDriver driver)
			throws InterruptedException {

		String uservalue = BuildObjrep.TestCaseHashmap.get("Data");

		if (uservalue.equals("battery saver")) {
			driver.startActivity("com.android.settings",
					"com.android.settings.fuelgauge.PowerUsageSummary");

			driver.findElement(
					By.xpath("//android.widget.ImageButton[@content-desc='More options']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//android.widget.TextView[@text='Battery saver']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.android.settings:id/switch_widget"))
					.click();
		}

		Integer uservaluebattery = Integer.parseInt(uservalue);

		String value = driver
				.findElement(
						By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout/android.view.View"))
				.getAttribute("name");
		String[] split = value.split("%");

		String battery = split[0];
		Integer phonebattery = Integer.parseInt(battery);
		try {
			if (phonebattery >= uservaluebattery) {

				System.out.println("test case has been passed");

			} else {
				throw new LowBatteryException(
						"battery level is lower then required level");
			}

			System.out.println("battery percentage is " + battery);

			String msg = "battery level is  " + phonebattery
					+ "  and minimum battery required   " + uservaluebattery;

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);

		} catch (Exception e) {
			String msg = "battery level is  " + phonebattery
					+ "  and minimum battery required   " + uservaluebattery
					+ e;

			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);

		}
	}

	public static void Wifi(AndroidDriver driver) {

		driver.startActivity("com.android.settings",
				"com.android.settings.wifi.WifiSettings");

		String wifi = BuildObjrep.TestCaseHashmap.get("Data");

		if (capabilities.getCapability("platformName") == "Android"
				|| capabilities.getCapability("platformNAme") == "android"
				|| capabilities.getCapability("platformNAme") == "ANDROID") {

			we = driver.findElement(By
					.id("com.android.settings:id/switch_widget"));

			if (wifi.equalsIgnoreCase("on")) {

				if (we.getAttribute("checked").equals(false)) {
					we.click();
				} else {
					System.out.println("Wifi Already ON");
				}

			} else if (wifi.equalsIgnoreCase("off")) {

				if (we.getAttribute("checked").equalsIgnoreCase("true")) {
					we.click();
				} else {
					System.out.println("Wifi Already OFF");
				}

			}
		} else if (capabilities.getCapability("platformName") == "ios"
				|| capabilities.getCapability("platformName") == "IOS"
				|| capabilities.getCapability("platformName") == "Ios") {

			driver.startActivity("com.android.settings",
					"com.android.settings.Settings");

			we = driver.findElement(
					By.id("com.android.settings:id/wifi_settings"))
					.findElement(By.id("com.android.settings:id/switchWidget"));

			if (wifi.equalsIgnoreCase("on")) {

				if (we.getAttribute("checked").equals(false)) {
					we.click();
				} else {
					System.out.println("Wifi Already ON");
				}

			} else if (wifi.equalsIgnoreCase("off")) {

				if (we.getAttribute("checked").equals(true)) {
					we.click();
				} else {
					System.out.println("Wifi Already OFF");
				}

			}
		}

	}

	// This function is used to change the network settings-To switch on
	// wifi,airplaneMode mode and data connection

	// Example if you want to open wifi give wifi in data column and if you want
	// airplaneMode and wifi to get activated give airplaneMode,wifi

	/*
	 * public static void Network(AndroidDriver driver) {
	 * 
	 * String awd = BuildObjrep.TestCaseHashmap.get("Data");
	 * System.out.println("value from data field is" + awd); if
	 * (awd.equalsIgnoreCase("wifi")) { NetworkConnectionSetting connection =
	 * new NetworkConnectionSetting( false, true, false);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver } if (awd.equalsIgnoreCase("data")) { NetworkConnectionSetting
	 * connection = new NetworkConnectionSetting( false, false, true);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver } if (awd.equalsIgnoreCase("airplaneMode")) {
	 * NetworkConnectionSetting connection = new NetworkConnectionSetting( true,
	 * false, false); driver.setNetworkConnection(connection);// here driver
	 * type is // Android driver }
	 * 
	 * if (awd.contains("airplaneMode") && awd.contains("wifi") &&
	 * awd.contains("data")) { NetworkConnectionSetting connection = new
	 * NetworkConnectionSetting( true, true, true);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver }
	 * 
	 * if (awd.contains("airplaneMode") && awd.contains("wifi") &&
	 * !awd.contains("data")) { NetworkConnectionSetting connection = new
	 * NetworkConnectionSetting( true, true, false);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver } if (awd.contains("airplaneMode") && !awd.contains("wifi") &&
	 * awd.contains("data")) { NetworkConnectionSetting connection = new
	 * NetworkConnectionSetting( true, false, true);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver }
	 * 
	 * if (!awd.contains("airplaneMode") && awd.contains("wifi") &&
	 * awd.contains("data")) { NetworkConnectionSetting connection = new
	 * NetworkConnectionSetting( false, true, true);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver }
	 * 
	 * if (!awd.contains("airplaneMode") && !awd.contains("wifi") &&
	 * !awd.contains("data")) { NetworkConnectionSetting connection = new
	 * NetworkConnectionSetting( false, false, false);
	 * driver.setNetworkConnection(connection);// here driver type is // Android
	 * driver }
	 * 
	 * }
	 */

	// Element you want to drag in element and where you want to drop in
	// actionSupport and indexes in data column with comma separation

	public static void DragNDrop(MobileDriver driver) {
		System.out.println("DragNDrop start");

		TouchAction action = new TouchAction(driver);

		/*
		 * if (BuildObjrep.TestCaseHashmap.get("Data") != null) { String
		 * DataFieldValue = BuildObjrep.TestCaseHashmap.get("Data"); String
		 * index[] = DataFieldValue.split(","); if
		 * (BuildObjrep.TestCaseHashmap.get("Data") != null) { from = index[0];
		 * to = index[1];
		 * 
		 * }
		 */

		String locTypeActionSupport = BuildObjrep.TestCaseHashmap
				.get("ElementFinderType");

		String ActionSupport = BuildObjrep.TestCaseHashmap
				.get("ActionSupportValue");

		switch (locTypeActionSupport) {
		case "name":
			wbTo = driver.findElement(By.name(ActionSupport));
			break;

		default:
			break;
		}

		wbFrom = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		wbTo = findPathActionSupport(BuildObjrep.TestCaseHashmap
				.get("ElementFinderType"));

		// action.longPress(wbFrom).perform();

		action = new TouchAction(driver);
		action.longPress(wbFrom).moveTo(wbTo).release().perform();
	}

	public static void getCordinates(AndroidDriver driver)
			throws InterruptedException {

		/*
		 * WebElement wb = findPathclick(
		 * BuildObjrep.TestCaseHashmap.get("ElementFinderType"), driver);
		 */
		we = driver.findElement(By
				.className("android.widget.HorizontalScrollView"));
		Point point = we.getLocation();
		ycoordinate = point.getY();
	}

	public static void SwipeHorizontal(AndroidDriver driver)
			throws InterruptedException, coordinateNotDefinedException {
		Dimension size;
		int startx, endx;
		we = findPathclick(
				BuildObjrep.TestCaseHashmap.get("ElementFinderType"), driver);
		try {
			driver.findElement(By
					.className("android.widget.HorizontalScrollView"));

			getCordinates(driver);
		}
		/*
		 * if (ycoordinate == 0) { throw new coordinateNotDefinedException(
		 * "for using swipe horizontal we need to define Y coordinate using getcoordinatefunction "
		 * );}
		 */
		catch (Exception e) {
			Point point = we.getLocation();
			ycoordinate = point.getY();
		}

		Point point = we.getLocation();
		Dimension dd = we.getSize();

		Dimension sized = driver.manage().window().getSize();

		int hgt = we.getSize().height;

		int tttt = sized.height / 2;

		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		startx = (int) (size.width * 0.50);
		// Find endx point which is at left side of screen.
		// int endx = (int) (size.width * 0.30);
		Thread.sleep(2000);
		System.out.println("test");

		int swipeStartHorizontal = point.getX();

		if (BuildObjrep.TestCaseHashmap.get("ActionSupportValue") == null) {

			if (BuildObjrep.TestCaseHashmap.get("Data").equalsIgnoreCase("R2L")) {
				// Swipe from Right to Left.

				endx = (int) (size.width * 0.25);
				driver.swipe(startx, ycoordinate, endx, ycoordinate, 1000);
				Thread.sleep(2000);
			} else if (BuildObjrep.TestCaseHashmap.get("Data")
					.equalsIgnoreCase("L2R")) {
				endx = (int) (size.width * 0.75);

				driver.swipe(startx, ycoordinate, endx, ycoordinate, 1000);
				Thread.sleep(2000);
			}

			String msg = "element  "
					+ BuildObjrep.TestCaseHashmap.get("TeststepDescription")
					+ "  has been swipped"
					+ BuildObjrep.TestCaseHashmap.get("Data");
			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);

		} else if (BuildObjrep.TestCaseHashmap.get("ActionSupportValue") != null) {

			for (int i = 0; i <= 100; i++) {
				int mysize = driver.findElements(
						By.name(BuildObjrep.TestCaseHashmap
								.get("ActionSupportValue"))).size();
				if (mysize != 0) {
					break;
				} else {

					if (BuildObjrep.TestCaseHashmap.get("Data")
							.equalsIgnoreCase("R2L")) {
						// Swipe from Right to Left.
						// driver.swipe(startx, startx1, endx, startx1, 1000);
						endx = (int) (size.width * 0.25);

						driver.swipe(startx, ycoordinate, endx, ycoordinate,
								1000);

						// Thread.sleep(500);
					} else if (BuildObjrep.TestCaseHashmap.get("Data")
							.equalsIgnoreCase("L2R")) {
						// driver.swipe(endx, startx1, startx, startx1, 5000);
						endx = (int) (size.width * 0.75);

						// driver.swipe(375, 200, 675, 200, 5000);
						driver.swipe(startx, ycoordinate, endx, ycoordinate,
								1000);

						Thread.sleep(500);
					}

				}
			}

		}

	}

	public static void SwipeVertical(AndroidDriver driver)
			throws InterruptedException {
		Dimension size;
		System.out.println("swipe vertical");
		we = findPathclick(
				BuildObjrep.TestCaseHashmap.get("ElementFinderType"), driver);

		// driver.swipe(239,536,239,200,2000); // swipe using element
		// coordinates
		size = driver.manage().window().getSize();
		int screenhight = size.height;
		int screenwidth = size.width;

		System.out.println("scren size is " + size);
		Point point = we.getLocation();

		int swipeStartXcoordinate = point.getX();
		int swipeStartYcoordinate = point.getY();
		Dimension dimension = we.getSize();
		int elementhight = dimension.height;
		int elementwidth = dimension.width;

		int middlevaleuex = (swipeStartXcoordinate + elementwidth) / 2;
		int middlevaluey = (swipeStartYcoordinate + elementhight) / 2;

		System.out.println("middle value of x" + middlevaleuex);

		System.out.println("middle value of y" + middlevaluey);

		if (BuildObjrep.TestCaseHashmap.get("Data").equalsIgnoreCase("B2T")) {

			int endx = middlevaleuex;
			int endy = swipeStartYcoordinate - 250;
			driver.swipe(239, 536, 239, 200, 2000); // swipe using element

		} else if (BuildObjrep.TestCaseHashmap.get("Data").equalsIgnoreCase(
				"T2B")) {
			// driver.swipe(startx, endy, startx, starty, 3000);

			int endx = middlevaleuex;
			int endy = swipeStartYcoordinate + 250;

			driver.swipe(middlevaleuex, swipeStartYcoordinate, endx, endy, 1000);

		}

		String msg = "element  "
				+ BuildObjrep.TestCaseHashmap.get("TeststepDescription")
				+ "  has been swipped"
				+ BuildObjrep.TestCaseHashmap.get("Data");
		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	// this will work with test name only
	// if you dont have name or text use VerticalScroll

	public static void AppiumScrollTo(AndroidDriver driver)
			throws InterruptedException {
		System.out.println("modified Appium scrollTo");
		String scrollTo = BuildObjrep.TestCaseHashmap.get("Data");

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		for (int i = 0; i < 100; i++) {

			try {
				we = driver.findElement(By.name(scrollTo));
				System.out.println("printed value is " + we);
				break;
			} catch (Exception e) {
				Dimension size = driver.manage().window().getSize();
				int x = size.getWidth() / 2;
				int starty = (int) (size.getHeight() * 0.60);
				int endy = (int) (size.getHeight() * 0.10);
				driver.swipe(x, starty, x, endy, 2000);
			}

		}/*
		 * String scrollTo = BuildObjrep.TestCaseHashmap.get("Data");
		 * Thread.sleep(2000); driver.scrollTo(scrollTo);
		 * 
		 * String msg = "element  " +
		 * BuildObjrep.TestCaseHashmap.get("TeststepDescription") +
		 * "  scrolled " + BuildObjrep.TestCaseHashmap.get("Data");
		 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg);
		 */

	}

	/*
	 * public WebElement scroll(String keyword) { HashMap scrollObject = new
	 * HashMap(); RemoteWebElement element = (RemoteWebElement) ((AndroidDriver)
	 * driver).findElementByAndroidUIAutomator(
	 * "new UiSelector().xpath(\"'//android.widget.EditText[@content-desc='Locality']\")"
	 * ); JavascriptExecutor js = (JavascriptExecutor) driver; String
	 * webElementId = ((RemoteWebElement) element).getId();
	 * System.out.println(webElementId);System.out.println(element);
	 * scrollObject.put("text", keyword); scrollObject.put("element",
	 * webElementId); js.executeScript("mobile: scrollTo", scrollObject); return
	 * element; }
	 */

	public static void takeScreenShot() {
		// Set folder name to store screenshots.
		String destDir = "D:\\Appium_project\\Screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = BuildObjrep.TestSuitHashmap.get("Testcaseid")
				+ dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void verifyToast() {
	 * 
	 * String path = @"D:\\Appium_project\\Screenshots\\"; Bitmap image = new
	 * Bitmap(path); Tesseract ocr = new Tesseract();
	 * ocr.SetVariable("tessedit_char_whitelist", "0123456789"); // If digit
	 * only ocr.Init(@"C:\\tessdata\", "eng", false); // To use correct tessdata
	 * List<tessnet2.Word> result = ocr.DoOCR(image, Rectangle.Empty); foreach
	 * (tessnet2.Word word in result) Console.WriteLine("{0} : {1}",
	 * word.Confidence, word.Text); }
	 */

	public static void verifyImages() throws IOException {

		// WebElement img =
		// driver.findElementByClassName("android.widget.ImageView");

		// take screen shot

		String destDir = "D:\\Appium_project\\Screenshots";
		File screen = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		// capture image of searched contact icon
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();

		we = findPath(BuildObjrep.TestCaseHashmap.get("ElementFinderType"));

		String destFile = BuildObjrep.TestSuitHashmap.get("Testcaseid")
				+ dateFormat.format(new Date()) + ".png";

		Point point = we.getLocation();

		int width = we.getSize().getWidth();
		int height = we.getSize().getHeight();

		BufferedImage img = ImageIO.read(screen);
		BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width,
				height);
		ImageIO.write(dest, "png", screen);
		// File file = new File("Menu.png");

		/*
		 * try { // Copy paste file at destination folder location
		 * FileUtils.copyFile(screen, new File(destDir + "/" + destFile)); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */

		FileUtils.copyFile(screen, new File(destDir + "/" + destFile));
		String imagename = screen.getAbsolutePath();
		String againstimage = BuildObjrep.TestCaseHashmap.get("Data");
		// verify images
		verifyImage(imagename, againstimage);
	}

	public static void verifyImage(String image1, String image2)
			throws IOException {
		File fileInput = new File(image1);
		File fileOutPut = new File(image2);

		BufferedImage bufileInput = ImageIO.read(fileInput);
		DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
		int sizefileInput = dafileInput.getSize();
		BufferedImage bufileOutPut = ImageIO.read(fileOutPut);
		DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
		int sizefileOutPut = dafileOutPut.getSize();
		Boolean matchFlag = true;
		if (sizefileInput == sizefileOutPut) {
			for (int j = 0; j < sizefileInput; j++) {
				if (dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
					matchFlag = false;
					break;
				}
			}
		} else {
			matchFlag = false;

		}
		if (matchFlag == false) {
			String msg = "image sub image from the xpath and the image provided are not same";
			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);

		}
		if (matchFlag == true) {
			String msg = "Subimage of element and image given are same";

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		}
		// Assert.assertTrue(matchFlag, "Images are not same");
	}

	public static void RobotKey() throws Exception, Throwable {
		Robot robot = new Robot();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
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
		hm.put("VK_SHIFT", new Integer(KeyEvent.VK_SHIFT));
		hm.put("VK_DOWN", new Integer(KeyEvent.VK_DOWN));
		hm.put("VK_UP", new Integer(KeyEvent.VK_UP));
		hm.put("VK_Right", new Integer(KeyEvent.VK_RIGHT));
		hm.put("VK_Left", new Integer(KeyEvent.VK_LEFT));
		hm.put("VK_S", new Integer(KeyEvent.VK_S));
		String Keysevent = BuildObjrep.TestCaseHashmap.get("Data");
		if (Keysevent.contains(":")) {

		}
		String[] Seperated = Keysevent.split(":");
		int i = 0, j = 0;
		while (i < Seperated.length) {
			if (Seperated[i].contains("VK_")) {
				String[] Seperatedseq = Keysevent.split("\\+");
				while (j < Seperatedseq.length) {
					robot.delay(40);
					robot.keyPress((int) hm.get(Seperatedseq[j]));
					j++;
				}
				while (j > 0) {
					j--;
					robot.keyRelease((int) hm.get(Seperatedseq[j]));

				}

			} else {
				System.out
						.println("this one is a char sequence" + Seperated[i]);

				byte[] bytes = Seperated[i].getBytes();
				for (byte b : bytes) {
					int code = b;
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

	/*
	 * public static void MouseHoverClick() {
	 * HelpAllfunctions.ajaxWaitandJquery();
	 * 
	 * if (BuildObjrep.browser.contains("Safari")) { Click(); return; }
	 * 
	 * if (BuildObjrep.browser.contains("DeviceWep")) { Touchpress(); return; }
	 * 
	 * if (BuildObjrep.browser.contains("IE")) { //JMouseHover(); Robot robot;
	 * try { robot = new Robot();
	 * 
	 * robot.mousePress(InputEvent.BUTTON1_MASK);
	 * robot.mouseRelease(InputEvent.BUTTON1_MASK); } catch (AWTException e) {
	 * Log.error(e.getStackTrace().toString());
	 * ExtentLogs.error(e.getStackTrace().toString());
	 * 
	 * } return; }
	 * 
	 * if
	 * (!(BuildObjrep.TestCaseRow.get("ActionSupportValue").contains("Blank"))
	 * || !(Constant.TestCaseRow.get("Data").contains("Blank"))) {
	 * WebElementCollection = FindElements();
	 * 
	 * } else { ActionElement = FindElement(); } if (ActionElement == null) {
	 * NoSuchElementException e = new NoSuchElementException(); throw e; }
	 * 
	 * passMessage = Constant.TestCaseRow.get("TestStepID") + ": " +
	 * Constant.TestCaseRow.get("TeststepDescription") +
	 * "; Action: Mouse Hover and Clicked";
	 * 
	 * Actions action = new Actions(driver);
	 * 
	 * action.moveToElement(ActionElement).build().perform();
	 * action.moveToElement(ActionElement).click().build().perform();
	 * ePassMessage = "Action: Mouse Hover and Clicked is performed on Element"
	 * + Constant.TestCaseRow.get("Elementlocation");
	 * ExtentLogs.pass(ePassMessage); Log.pass(passMessage);
	 * 
	 * }
	 */

	/*
	 * public static void Touchpress() { SupportLib.waitForAjax(); if
	 * (!(Constant.TestCaseRow.get("ActionSupportValue").contains("Blank")) ||
	 * !(Constant.TestCaseRow.get("Data").contains("Blank"))) {
	 * WebElementCollection = FindElements();
	 * 
	 * if (WebElementCollection == null) { NoSuchElementException e = new
	 * NoSuchElementException(); throw e; } else { ActionElement =
	 * SupportLib.SearhElement(WebElementCollection); }
	 * 
	 * } else { ActionElement = FindElement(); } if (ActionElement == null) {
	 * NoSuchElementException e = new NoSuchElementException(); throw e; }
	 * 
	 * TouchActions action = new TouchActions(driver);
	 * action.singleTap(ActionElement).build().perform();
	 * 
	 * Log.pass(passMessage); ePassMessage =
	 * "Touch action is performed on Element" +
	 * Constant.TestCaseRow.get("Elementlocation");
	 * ExtentLogs.pass(ePassMessage); Locatable hoverItem = (Locatable)
	 * ActionElement; Mouse mouse = ((HasInputDevices) driver).getMouse();
	 * mouse.mouseMove(hoverItem.getCoordinates());
	 * 
	 * passMessage = Constant.TestCaseRow.get("TestStepID") + ": " +
	 * Constant.TestCaseRow.get("TeststepDescription") +
	 * "; Action: Mouse Hover";
	 * 
	 * }
	 */
	// getJSONArray

	// Rest assured function start

	public static void BaseUri() throws IOException, InvocationTargetException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InterruptedException {
		ExtentHTML.starttest();
		// System.out.println("__________________ergrre_____________");
		RestAssured.baseURI = BuildObjrep.objKeyValue
				.get(BuildObjrep.TestCaseHashmap.get("Elementlocation"));

		msg = "base uri to be open is "
				+ BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
						.get("Elementlocation"));

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

	}

	/*
	 * public static void ajaxWaitandJquery() throws InterruptedException {
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor) ActionClass.driver; if
	 * ((Boolean) executor .executeScript("return window.jQuery != undefined"))
	 * { while (!(Boolean) executor .executeScript("return jQuery.active == 0"))
	 * { Thread.sleep(1000); } } return;
	 * 
	 * }
	 */
	public static void GetRequest() throws IOException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InterruptedException {
		if (BuildObjrep.TestCaseHashmap.get("Parameter") != null
				&& !BuildObjrep.TestCaseHashmap.get("Parameter").equals("")) {
			parameters = BuildObjrep.TestCaseHashmap.get("Parameter")
					.split(",");
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

						.param(key[0], value[0])
						.when()
						.get(BuildObjrep.objKeyValue
								.get(BuildObjrep.TestCaseHashmap
										.get("Elementlocation")));
				responseBody = res.getBody().asString();

				break;

			case 2:
				// Statements
				res = given()

						.param(key[0], value[0])
						.param(key[1], value[1])

						.when()
						.get(BuildObjrep.objKeyValue
								.get(BuildObjrep.TestCaseHashmap
										.get("Elementlocation")));

				responseBody = res.getBody().asString();

				break;

			case 3:
				// Statements
				res = given()

						.param(key[0], value[0])
						.param(key[1], value[1])
						.param(key[2], value[2])
						.when()
						.get(BuildObjrep.objKeyValue
								.get(BuildObjrep.TestCaseHashmap
										.get("Elementlocation")));
				responseBody = res.getBody().asString();

				break;

			case 4:
				// Statements
				res = given()

						.param(key[0], value[0])
						.param(key[1], value[1])
						.param(key[2], value[2])
						.param(key[3], value[3])

						.when()
						.get(BuildObjrep.objKeyValue
								.get(BuildObjrep.TestCaseHashmap
										.get("Elementlocation")));
				responseBody = res.getBody().asString();

				break;

			default:
				res = given()

				.when().get(
						BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
								.get("Elementlocation")));
				responseBody = res.getBody().asString();
			}
		} else {
			res = given().when().get();
			responseBody = res.getBody().asString();
		}
		msg = "get request  "
				+ BuildObjrep.objKeyValue.get(BuildObjrep.TestCaseHashmap
						.get("Elementlocation"));

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);
	}

	public static void PostRequest() throws IOException {
		// System.out.println("we are in post request");
		// String str="{\"name\":\"vinayak bansal\"}";

		String body = BuildObjrep.TestCaseHashmap.get("Parameter");
		body = body.replaceAll("\"", "\\\"");
		System.out.println("post request body is  " + body);
		// RequestSpecification re=
		res = given().auth().none().contentType("application/json").
		// body("{\"name\":\"vinayak bansal\"}")
				body("{\"name\":\"Ajay bansal\"}")

				.

				when().post("http://127.0.0.1:5984/restassured");
		// .post("http://ip.jsontest.com/ ");
		// http://ip.jsontest.com/
		// res= re.post();
		// System.out.println( res.getHeaders());
		// System.out.println(res.getHeader("Location"));
		responseBody = res.getBody().asString();
		// System.out.println(responseBody);
		msg = "post request  created at url " + res.getHeader("Location");

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);

		/*
		 * URL url = new URL(RestAssured.baseURI ); HttpURLConnection conn =
		 * (HttpURLConnection) url.openConnection(); conn.setDoOutput(true);
		 * conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * 
		 * String input = "{\"name\":\"vinayak bansal\"}";
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(input.getBytes());
		 * os.flush(); System.out.println("end--------"); String output;
		 * System.out.println("Output from Server .... \n");
		 * System.out.println(conn.getHeaderField("Location")); BufferedReader
		 * br = new BufferedReader(new InputStreamReader(
		 * (conn.getInputStream()))); while ((output = br.readLine()) != null) {
		 * System.out.println(output);
		 * 
		 * }
		 * 
		 * RequestSpecification
		 * re=given().auth().none().contentType(conn.getHeaderField("Location"))
		 * . body("{\"name\":\"Jimi Hendrix\"}") .
		 * 
		 * when() .proxy(RestAssured.baseURI);
		 * 
		 * res= re.post(); responseBody = res.getBody().asString();
		 * 
		 * res=(Response) conn; System.out.println("we are here"); msg =
		 * "post request  created at url " + conn.getHeaderField("Location");
		 * 
		 * ConsoleLogs.INFOPass(msg); ExtentHTML.pass(msg);
		 */
	}

	public static void statusCode() {

		int requiredStatusCode = Integer.parseInt(BuildObjrep.TestCaseHashmap
				.get("Data"));
		if (res.statusCode() == requiredStatusCode) {

			msg = "verify :  status code form API is " + res.statusCode()
					+ "  is verified against "
					+ BuildObjrep.TestCaseHashmap.get("Data")
					+ " and are same ";

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		}
		if (res.statusCode() != requiredStatusCode) {

			msg = "verify :  status code form API " + res.statusCode()
					+ "  and required status code "
					+ BuildObjrep.TestCaseHashmap.get("Data") + " are not same";

			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);
		}

	}

	public static void JsonToJavaObject() {
		try {
			jsonobj = new JSONObject(responseBody);
			msg = "convert json object to java object";

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		} catch (Exception e) {
			msg = e.getMessage();

			ConsoleLogs.INFOPass(msg);
			ExtentHTML.pass(msg);
		}

	}

	//

	public static void GetJSONArray() throws JSONException {
		String strd = BuildObjrep.TestCaseHashmap.get("Data");
		jsonAttribute = strd.split("/");

		if (responseBody.startsWith("[")) {
			jsonArray = new JSONArray(responseBody);
			// System.out.println(jsonArray);

			// String capital = jsonArray.getJSONObject(0).getString("capital");

			// Asserting that capital of Norway is Oslo
			// Assert.assertEquals(capital, "Oslo");

			msg = "converted to array";

		} else {

			jsonobj = new JSONObject(responseBody);
			msg = "convert json object to java object";
			System.out.println(msg);

			if (jsonAttribute.length > 1) {
				jsonarr = jsonobj.getJSONArray(jsonAttribute[0]);

				for (int i = 0; i < jsonarr.length(); i++) {
					// System.out.println(jsonarr.length());
					JSONObject jsonobj2 = jsonarr.getJSONObject(i);
					String str = jsonobj2.getString(jsonAttribute[1]);
					// System.out.println("formatted_address" + str);
					String strint = str.toString();
					listValues.add(strint.toString());
				}
			} else {

				JSONObject obj = new JSONObject(responseBody);
				Iterator itr = obj.keys();
				while (itr.hasNext()) {
					// Get key somehow? itr.getKey() ???

					// contains the sub items

					String key = (String) itr.next();
					String str = obj.getString(key);
					listValues.add(str);

				}

			}
			msg = "";
			for (int i = 0; i < jsonAttribute.length; i++) {
				msg += " " + jsonAttribute[i];
			}
			msg = "Atribute value  " + msg + " are digged";

		}

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);
	}

	@SuppressWarnings("rawtypes")
	public static void NullValues() throws JSONException {
		JSONObject obj = new JSONObject(responseBody);
		Iterator itr = obj.keys();
		while (itr.hasNext()) {
			// Get key somehow? itr.getKey() ???

			// contains the sub items

			String key = (String) itr.next();
			String str = obj.getString(key);
			if (str == "null") {
				nullCount.add(key);
				nullvalueCount++;
			}
		}
		msg = nullvalueCount + " attributes having null values";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);
	}

	// AttributeName

	public static void VerifyAttributeApi() throws JSONException {
		attribute = BuildObjrep.TestCaseHashmap.get("Data");
		flag = false;

		if (responseBody.startsWith("[")) {

			if (jsonArray.getJSONObject(0).getString(attribute) != null) {
				flag = true;
				msg = "Attribute  " + attribute + "   found in the list";
				ConsoleLogs.INFOPass(msg);
				ExtentHTML.pass(msg);
				flag = true;
			}

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

					ConsoleLogs.INFOPass(msg);
					ExtentHTML.pass(msg);
					flag = true;
				}
			}
		}
		if (flag == false) {

			msg = "value " + attribute + "  not  found in the list";

			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);

		}

	}

	public static void VerifyValue() throws InterruptedException, JSONException {
		attributeValue = BuildObjrep.TestCaseHashmap.get("Data");
		attributeValue = attributeValue.trim();
		flag = false;
		// System.out.println("list valus are");

		if (responseBody.startsWith("[")) {

			String pageAttributevalue = jsonArray.getJSONObject(0).getString(
					attribute);
			if (attributeValue.equalsIgnoreCase(pageAttributevalue)) {
				flag = true;
				msg = "value " + attributeValue + "   found in the list";

				ConsoleLogs.INFOPass(msg);
				ExtentHTML.pass(msg);
			}
		}

		else {

			for (int i = 0; i < listValues.size(); i++) {

				// System.out.println("value " + i + " " + listValues.get(i));
				if (listValues.get(i).equalsIgnoreCase(attributeValue)) {
					msg = "value " + attributeValue + "   found in the list";

					ConsoleLogs.INFOPass(msg);
					ExtentHTML.pass(msg);
					flag = true;
				}
			}
		}
		if (flag == false) {

			msg = "value " + attributeValue + "  not  found in the list";

			ConsoleLogs.INFOFail(msg);
			ExtentHTML.fail(msg);

		}

	}

	public static void ThreadWait() throws InterruptedException {
		String time = BuildObjrep.TestCaseHashmap.get("Data");
		int timeInt = Integer.parseInt(time);
		Thread.sleep(timeInt);
		msg = "wait for   " + timeInt + " ms.";

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);
	}

	public static void close() throws InterruptedException {

		totalParameters = 0;
		listValues.clear();
		listAttributes.clear();
		nullCount.clear();

		// writing everything to document
		msg = "closing test case ";
		/*
		 * String msg = "Student Name : ${name} \n Student ID : ${id} ";
		 * TemplateMatcher matcher = new TemplateMatcher("${", "}");
		 */

		BuildObjrep.emailBody.append(" <tr>");
		BuildObjrep.emailBody.append("<td>"
				+ BuildObjrep.TestSuitHashmap.get("Testcaseid") + "</td>");
		BuildObjrep.emailBody.append("<td>"
				+ ExtentHTML.testrep.getRunStatus().toString() + "</td>");
		BuildObjrep.emailBody.append("<td>"
				+ BuildObjrep.TestSuitHashmap.get("Environment") + "</td>");
		BuildObjrep.emailBody.append("</tr>");

		ConsoleLogs.INFOPass(msg);
		ExtentHTML.pass(msg);
		/*
		 * System.out.println("test case status is " +
		 * ExtentHTML.testrep.getRunStatus().toString());
		 * System.out.println("test case enviroment is " +
		 * BuildObjrep.TestSuitHashmap.get("Environment"));
		 * 
		 * System.out.println("test case name is " +
		 * BuildObjrep.TestSuitHashmap.get("Testcaseid"));
		 */

	}

}
