package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class Authentication extends TestBase {

	ExtentTest logger;

	@Test(priority = 1)
	public void allowDialogue() {
		System.out.println("inside allow dialogue");
		logger = TestBase.extent.startTest("allowDialogue");
		WebElement allow = TestBase.driver.findElementByAccessibilityId("Allow");
		if (allow.isDisplayed()) {
			allow.click();
			logger.log(LogStatus.PASS, "Allowed Notifications");
		} else
			logger.log(LogStatus.SKIP, "Notifications are already allowed");

	}

	@Test(priority = 2)
	public void clickLogin() {
		System.out.println("inside login");

		logger = TestBase.extent.startTest("clickLogin");
		WebElement login = TestBase.driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Login or SignUp\"]"));
		System.out.println("before if");
		if (login.isDisplayed()) {
			login.click();
			logger.log(LogStatus.PASS, "login clicked");
		} else {
			System.out.println("inside else");
			logger.log(LogStatus.SKIP, "login button will come when app is launched first time.");
		}
	}

	@Test(priority = 3)
	public void clickGoogleLogin() throws InterruptedException {
		System.out.println("inside google");

		System.out.println("logger");
		logger = TestBase.extent.startTest("clickGoogleLogin");
		WebElement googleButton = TestBase.driver.findElementByAccessibilityId("GMAIL OVAL");
		if (googleButton.isDisplayed()) {
			googleButton.click();
			Thread.sleep(4000);// This is temporary we can use explicit wait here. we will never use
								// thread.sleep() in live projects.
			TestBase.driver.findElementByAccessibilityId("Continue").click();
			logger.log(LogStatus.PASS, "Button clicked redirected to google login");

		} else {

			logger.log(LogStatus.FAIL, "problem with google button");
		}
	}

	@Test(priority = 4)
	public void doGoogleLogin() throws InterruptedException {
		Set<String> contextNames = TestBase.driver.getContextHandles();
		Iterator<String> itr = contextNames.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		// ...
		TestBase.driver.context("NATIVE_APP");

		logger = TestBase.extent.startTest("doGoogleLogin");
		Thread.sleep(5000);// This is temporary we can use explicit wait here. we will never use
							// thread.sleep() in live projects.

		WebElement ano = TestBase.driver
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Use another account\"]"));
		if (ano.isDisplayed() || ano.isEnabled()) {
			System.out.println("inside if of goodle ");
			TestBase.driver.findElementByAccessibilityId("Gaurav singh kaura gkauda@gmail.com").click();
			Thread.sleep(5000);// This is temporary we can use explicit wait here. we will never use
								// thread.sleep() in live projects.
			logger.log(LogStatus.PASS, "google login successful");
		} else {
			WebElement username = TestBase.driver.findElement(
					By.xpath(("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[4]")));
			WebElement btn = TestBase.driver.findElementByAccessibilityId("Next");
			WebElement password = TestBase.driver.findElementByAccessibilityId(
					"//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]");

			System.out.println("inside if google ");
			username.clear();
			username.click();
			username.sendKeys("gkauda");
			btn.click();
			password.click();
			password.sendKeys("Gsk@@@89820");
			btn.click();
			logger.log(LogStatus.PASS, "google login successful");
		}
		logger.log(LogStatus.FAIL, "unable to login ");

	}

	@Test(priority = 5)
	public void searchYoga() throws InterruptedException {
		logger = TestBase.extent.startTest("searchYoga");
		Thread.sleep(5000);// This is temporary we can use explicit wait here. we will never use
							// thread.sleep() in live projects
		WebElement search = TestBase.driver
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Search for a Topic or Provider\"]"));
		if (search.isDisplayed()) {
			search.click();
			Thread.sleep(5000); // This is temporary we can use explicit wait here. we will never use
								// thread.sleep() in live projects.
			search.sendKeys("yoga");
			Thread.sleep(3000);// This is temporary we can use explicit wait here. we will never use
								// thread.sleep() in live projects.

			TestBase.driver.findElementByAccessibilityId("Yoga").click();
		} else {

			logger.log(LogStatus.FAIL, "webelement not accessible");

		}
	}

	@Test(priority = 6)
	public void openProfile() throws InterruptedException {
		logger = TestBase.extent.startTest("openProfile");
		Thread.sleep(5000);
		WebElement profile = TestBase.driver
				.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Want your own time?\"])[1]"));
		if (profile.isDisplayed())
			logger.log(LogStatus.SKIP, "No profile online");
		else
			logger.log(LogStatus.INFO, "need to check with dev for elements");

	}

}
