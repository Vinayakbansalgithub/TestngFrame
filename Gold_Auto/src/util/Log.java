/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description :  The Class Log, Used for Logging using Log4j.
*/
package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import configuration.Constant;


/**
 * The Class Log, Used for Logging using Log4j.
 */
public class Log {

	/** Variable to keep the instance of Logger object . */
	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());

	// This is to print log for the beginning of the test case, as we usually
	/**
	 * function to log the Start of a test case.
	 *
	 * @param sTestCaseName the s test case name
	 */
	// run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName
				+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");

	}

	/**
	 * function to log the End of a test case.
	 *
	 * @param sTestCaseName the s test case name
	 */
	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-"
				+ "             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");

	}

	/**
	 * function to log the Info.
	 *
	 * @param message the message
	 */
	// Need to create these methods, so that they can be called
	public static void info(String message) {
		System.out.println("Info# " + message);
		Log.info(message);
	}

	/**
	 * function to log the Warning.
	 *
	 * @param message the message
	 */
	public static void warn(String message) {
		System.out.println("warn# " + message);
		Log.warn(message);
	}

	/**
	 * function to log the Error.
	 *
	 * @param Teststep the teststep
	 * @param Error the error
	 * @param e the e
	 */
	public static void error(String Teststep, String Error, Exception e) {
		String Message = Teststep + Error;
		System.out.println(Message);
		Log.error("Error#: " + Message, e);
	}

	/**
	 * function to log the Fatal error.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public static void fatal(String message, Exception e) {
		System.out.println("Fatal# " + message + e);
		Log.fatal(message, e);
	}

	/**
	 * function to log the Debug message.
	 *
	 * @param message the message
	 */
	public static void debug(String message) {
		System.out.println("Debug# " + message);
		Log.debug(message);
	}

	/**
	 * function to create Log backup.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void logBackup() throws IOException {

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd MMM yyyy kk:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("IST"));
		File SRC_LOG_FILE = FileUtils.getFile("logfile.log");
		// System.out.println(df.format(date));
		String logFileName = df.format(date) + "_log" + ".txt";
		logFileName = logFileName.replace(':', '_');
		logFileName = logFileName.replace(' ', '_');
		System.out.println(logFileName);
		File targetFile = new File(Constant.LOGFILELOCATION + logFileName);
		FileUtils.copyFile(SRC_LOG_FILE, targetFile);

	}

	/**
	 * function to clean the Logs .
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void logClean() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter("logfile.log");
		writer.print("");
		writer.close();
	}

}