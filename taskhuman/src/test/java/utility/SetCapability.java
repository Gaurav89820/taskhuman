package utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;

public class SetCapability {

	public static DesiredCapabilities setCaps(String platformName, String deviceName, String platformVersion,
			String udid, String automationName, String appPath) throws IOException {
		String result = "xcodeConfigFile";

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", platformName);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("udid", udid);
		cap.setCapability("automationName", automationName);
		cap.setCapability("app", appPath);
		cap.setCapability(result,
				"/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");

		return cap;
	}

	public static URL setUrl(String AppiumUrl) throws MalformedURLException {
		URL url = new URL(AppiumUrl);
		return url;

	}

	public static ExtentReports createExtentReport() {
		System.out.println("inside extent");
		ExtentReports extent = new ExtentReports("/Users/superman/Desktop/taskhuman/taskhuman_report_automation.html",
				true);
		System.out.println("seems created");

		// report will be generated at given location
		return extent;

	}

}
