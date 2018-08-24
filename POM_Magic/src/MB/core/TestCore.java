package MB.core;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.log4j.xml.DOMConfigurator;

import MB.utils.SendReport;
import MB.utils.excel_reader;








import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class TestCore {
	

	public static Properties config = new Properties();
	
	public static Properties object = new Properties();
	
	public static WebDriver driver = null;
	
	public static excel_reader excel = null;
	
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public static StringBuilder  emailBody = new StringBuilder();
	
	public static Logger log = Logger.getLogger(TestCore.class.getName());

	
	
	public static ExtentReports reports;
	public static ExtentTest test;

	
	
	@BeforeSuite
	public static void init() throws Exception{
		
		
		System.out.println("we are in before suite");

		
		
		DOMConfigurator.configure("src//Util//Log4j.xml");
		


		reports= new ExtentReports(System.getProperty("user.dir")+"\\test-output\\Relevent-report\\MyOwnReport.html", true);
	
		
		reports.addSystemInfo("owner", "Vinayak");
		reports.addSystemInfo("enviromet", "Stage");
		reports.addSystemInfo("Project", "Automation project");
		reports.config().reportName("vinayak autotest");
		reports.config().reportHeadline("selenium heading");
		reports.config().documentTitle("doc title");
		
		
		
			
			
			

			// send report email
			
			
			emailBody.append("<html>");
			emailBody.append("<body>");
			emailBody.append("<div style='padding:20px'>");
			emailBody.append("<h2> Automation Run Report</h2>");
			emailBody.append("<b>Project </b> : Magic bricks <br/>");
			emailBody.append("<tr>");
			emailBody.append(" <th>*Refer attachment for detailed results </th>");
			emailBody.append("</tr>");
			
			
			emailBody.append("<table border='1' style='border-collapse:collapse;text-align:center'>");
			emailBody.append("<tr>");
			emailBody.append(" <th style='padding:5px'>Test Case Id</th>");
			emailBody.append("<th style='padding:5px'>Status</th>");
			emailBody.append("<th style='padding:5px'>Browser</th>");

			emailBody.append("</tr>");			
			
			
			
		
		
		
		
		
		
		
		
	}
	
	
	@AfterSuite(alwaysRun = true)
	public static void testQuitDriver() throws Exception {
		
		
		System.out.println("we are in after suite");
		
		Thread.sleep(3000);
		  
		 reports.flush();
		  reports.close();
		
		
		//code for sending mails
		//testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, "Test Report", "Please find the attached report", TestConfig.reportPath, "Reports.zip");
		
		//driver.quit();
		
		
		
	//	SendReport.sendmail();
		
	}
	

}
