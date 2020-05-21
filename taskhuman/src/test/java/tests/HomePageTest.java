package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import utility.Helper;
import utility.TestBase;

public class HomePageTest extends TestBase {
	HomePage homePage = new HomePage();
	Helper helper = new Helper();
	ExtentTest logger;

	@Test(priority = 1, groups = { "test-group" })
	public void allowDialogue() throws InterruptedException {
		System.out.println("allow");
		logger = TestBase.extent.startTest("allowDialogue");
//		WebElement allow = TestBase.driver.findElementByAccessibilityId("Allow");
		if (helper.isAllowVisible()) {
			helper.clickAllow();
			logger.log(LogStatus.PASS, "Allowed Notifications");
		} else
			logger.log(LogStatus.SKIP, "Notifications are already allowed");

	}

	@Test(priority = 2, dependsOnMethods = "allowDialogue", groups = { "test-group" })
	public void clickLogin() throws Exception {

		System.out.println(driver.getContext());
		logger = TestBase.extent.startTest("clickLogin");

		try {
			if (homePage.isMainScreenloginButtonVisible()) {
				homePage.clickMainScreenloginButton();
				logger.log(LogStatus.PASS, "login clicked");

			} else {

				logger.log(LogStatus.SKIP, "login button will come when app is launched first time.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Element not found");
		}
	}

	@Test(priority = 3, dependsOnMethods = "clickLogin", groups = { "test-group" })
	public void verifyLogo() throws Exception {

		logger = TestBase.extent.startTest("verifyLogo");
		if (homePage.isLogoPresent()) {
			logger.log(LogStatus.PASS, "Logo present on Home screen");
		} else {
			logger.log(LogStatus.FAIL, "Logo is not visible ");
		}

	}

	@Test(priority = 4, dependsOnMethods = "clickLogin", groups = { "test-group" })
	public void VerifyTagLine() throws Exception {
		logger = TestBase.extent.startTest("VerifyTagLine");
		if (homePage.isBusinessTagLineVisible()) {
			logger.log(LogStatus.PASS, "Tag line is visible ");
		} else {
			logger.log(LogStatus.FAIL, "Tag line is not visible ");
		}

	}

	@Test(priority = 5, dependsOnMethods = "clickLogin", groups = { "test-group" })
	public void VerifyTagLineText() throws Exception {
		logger = TestBase.extent.startTest("VerifyTagLineText");
		if (homePage.checkBusinessTagLineValue().equalsIgnoreCase("HUMAN GUIDANCE ON TAP")) {
			logger.log(LogStatus.PASS, "Tag line text is as expected ");
		} else {
			logger.log(LogStatus.FAIL,
					"Tag line text is " + homePage.checkBusinessTagLineValue() + "which is not expected");
		}

	}

	@Test(priority = 6, dependsOnMethods = "clickLogin", groups = { "test-group" })
	public void verifyShapeImage() throws Exception {
		logger = TestBase.extent.startTest("verifyShapeImage");
		if (homePage.imageShapesPresent()) {
			logger.log(LogStatus.PASS, "Shapes image is visible ");
		} else {
			logger.log(LogStatus.FAIL, "Shapes image is not visible ");
		}

	}

}
