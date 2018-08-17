package configuration;

import org.openqa.selenium.JavascriptExecutor;

public class SupportLib {
	
	public static void waitForAjax() {
		if(Constant.WaitforAjax)
		{
			// System.out.println("Checking active ajax calls by calling jquery.active");
			try {
				if (ActionKeyword.driver instanceof JavascriptExecutor) {
					JavascriptExecutor jsDriver = (JavascriptExecutor) ActionKeyword.driver;
					for (int i = 0; i < Constant.AjaxWait; i++) {
						Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
						if (numberOfAjaxConnections instanceof Long) {
							Long n = (Long) numberOfAjaxConnections;
							if (n.longValue() == 0L)break;
						}
						Thread.sleep(1000);
					}
				} else {}
			} catch (InterruptedException e) {
				System.out.println(e);
			} catch (Exception e) {
				return;
			}
		}
		else
		{
			//donothing
		}
	}
	
	

}
