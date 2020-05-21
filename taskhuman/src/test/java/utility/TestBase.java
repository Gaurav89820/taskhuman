package utility;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import pages.DiscoveryScreen;
import pages.FacebookSignup;
import pages.GoogleSignup;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import pages.VerifyNumber;

public class TestBase {
	public static ExtentReports extent;
	public static URL url;
	public static FacebookSignup fbpage = new FacebookSignup();
	public static AppiumDriver<IOSElement> driver;
	public static DesiredCapabilities cap;
	public static HomePage homepage = new HomePage();
	public static SignUpPage signUpPage = new SignUpPage();
	public static LoginPage lp = new LoginPage();
	public static Helper helper = new Helper();
	public static GoogleSignup googleSignupPage = new GoogleSignup();
	public static VerifyNumber verify = new VerifyNumber();
	public static DiscoveryScreen discovery = new DiscoveryScreen();
	public static Scanner input = new Scanner(System.in);

	@BeforeSuite(enabled = true)
	public static void setup() throws IOException {

		extent = SetCapability.createExtentReport();
		String appLocation = "/Users/superman/Desktop/Dev_TaskHuman.app";
		cap = SetCapability.setCaps("iOS", "iPhone 8 Plus", "13.4", "A0A42977-8D22-467B-9879-E839648725D0", "XCUITest",
				appLocation);
		url = SetCapability.setUrl("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<IOSElement>(url, cap);

	}

	@AfterSuite
	public void closeDriver() {

		extent.flush();
//		extent.close();

//		driver.quit();

	}

}
