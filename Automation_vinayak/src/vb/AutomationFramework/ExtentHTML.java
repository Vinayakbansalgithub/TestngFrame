package vb.AutomationFramework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentHTML {
	public static ExtentTest testrep;
	static ExtentReports extent = new ExtentReports("D:/TestReport.html", true);

	public static void starttest() {
		testrep = extent.startTest(BuildObjrep.TestSuitHashmap
				.get("Testcaseid")+" is started in "+BuildObjrep.TestSuitHashmap.get("Browser"));
	}

	public static void pass(String msg) {

		// extent.flush();
		// extent.close();

		testrep.log(LogStatus.PASS,
				BuildObjrep.TestCaseHashmap.get("TestStepID"), msg.toString());

	}

	public static void Endtest() {
		extent.endTest(testrep);
		extent.flush();
	}

	public static void fail(String msg) {
		// TODO Auto-generated method stub
		testrep.log(LogStatus.FAIL,
				BuildObjrep.TestCaseHashmap.get("TestStepID"), msg.toString());

	}
	public static void Skip(String msg) {
		// TODO Auto-generated method stub
		testrep.log(LogStatus.SKIP,
				BuildObjrep.TestCaseHashmap.get("TestStepID"), msg.toString());

	}

}
