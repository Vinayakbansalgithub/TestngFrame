package vb.AutomationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HelpAllfunctions {
	public static String Browser[];
	public static int browsercount;

	public static void ajaxWaitandJquery() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) ActionClass.driver;
		if ((Boolean) executor
				.executeScript("return window.jQuery != undefined")) {
			while (!(Boolean) executor
					.executeScript("return jQuery.active == 0")) {
				Thread.sleep(1000);
			}
		}
		return;

	}

	public static void clearClipboard() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();

		clipboard.setContents(new Transferable() {
			public DataFlavor[] getTransferDataFlavors() {
				return new DataFlavor[0];
			}

			public boolean isDataFlavorSupported(DataFlavor flavor) {
				return false;
			}

			public Object getTransferData(DataFlavor flavor)
					throws UnsupportedFlavorException {
				throw new UnsupportedFlavorException(flavor);
			}
		}, null);

	}

	public static String ClipboardData() throws UnsupportedFlavorException,
			IOException {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String data = (String) clipboard.getData(DataFlavor.stringFlavor);
		return data;

	}

	public static void controlA() throws AWTException {

		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.delay(1000);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CONTROL);

	}

	public static void controlC() throws AWTException {

		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.delay(1000);
		rb.keyRelease(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);

	}
	String browser = BuildObjrep.TestSuitHashmap.get("Browser");

	public static void countbrowser() {
		try {
			String browser = BuildObjrep.TestSuitHashmap.get("Browser");
			if (browser == "Blank") {
				browser = null;
				return;
			}

			Browser = browser.split(",");
			browsercount = Browser.length;
		} catch (Exception e) {
			ConsoleLogs.fatal("Error in counting browser" + e.toString());
		}
	}

}
