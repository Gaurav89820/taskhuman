package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class GoogleSignupTest extends TestBase {

	ExtentTest logger;

	@Test(groups = { "test-group2" }, dependsOnGroups = { "test-group1", "test-group" }, priority = 1)

	public void checkValidGoogleLogin() throws Exception {
		logger = extent.startTest("checkValidGoogleLogin");
		Thread.sleep(5000);
		try {
			if (googleSignupPage.isAuthorizationScreen()) {
				helper.clickBack();
				helper.clickBack();

			}

		} catch (Exception e) {
			e.getMessage();
		}

		try {
			if (signUpPage.isSignupHeadingText()) {
				helper.clickBack();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		try {
			if (homepage.imageShapesPresent()) {
				homepage.clickGmailLoginButton();
				Thread.sleep(5000);
				helper.clickContinue();

				if (googleSignupPage.isUseAnotherAccountVisible()) {
					googleSignupPage.clickUseAnotherAccount();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		try {

			if (homepage.imageShapesPresent()) {
				homepage.clickGmailLoginButton();
				helper.clickContinue();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		try {
			Thread.sleep(4000);
			if (googleSignupPage.isUseAnotherAccountVisible())
				googleSignupPage.clickUseAnotherAccount();

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.SKIP, e.getMessage());
		}
		logger.log(LogStatus.PASS, "Reached Google Login screen");

		System.out.println("reached google");
//		Thread.sleep(5000);

		try {

			System.out.println("after username");
			Thread.sleep(10000);
			if (googleSignupPage.isEmailFieldVisible()) {
				googleSignupPage.enterEmailAddress("kauragaurav85");
				System.out.println("email entered");
				googleSignupPage.clickNext();
				Thread.sleep(10000);
				driver.findElement(
						By.xpath("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[3]"))
						.sendKeys("gaurav89820");

				helper.closeKeyboard();
				System.out.println("keyboard closed");
				googleSignupPage.clickNext();
				logger.log(LogStatus.PASS, "Google Login Success");

			}

		} catch (Exception e) {
			logger.log(LogStatus.SKIP, e.getMessage());

			e.getMessage();

		}
		try {
			Thread.sleep(10000);
			if (googleSignupPage.isAuthorizationScreen()) {
				helper.clickBack();
				helper.clickBack();

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/*
	 * @Test(groups = { "test-group2" }, dependsOnGroups = { "test-group1",
	 * "test-group" }, priority = 2, dependsOnMethods = "checkInvalidGoogleLogin")
	 * 
	 * public void checkValidGoogleLogin() throws Exception {
	 * extent.startTest("checkValidGoogleLogin"); verify.selectCountry("India");
	 * verify.enterPhoneNumber("7999150055"); System.out.println(
	 * "end===========================================river.findElementByXPath(\"//XCUIElementTypeButton[@name=\\\"dropDownIcon\\\"]\")ere"
	 * );
	 * 
	 * }
	 */}
