package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class FbLoginTest extends TestBase {
	ExtentTest logger;

	@Test(groups = { "test-group2" }, dependsOnGroups = { "test-group1", "test-group" }, priority = 2)
	public void doFacebookLogin() throws InterruptedException {
		logger = extent.startTest("doFacebookLogin");
//		Thread.sleep(10000);
		try {
			if (googleSignupPage.isAuthorizationScreen()) {
				helper.clickBack();
				helper.clickBack();

			}

		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("after 1st try");
		try {
			if (signUpPage.isSignupHeadingText()) {
				helper.clickBack();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		System.out.println("after 2st try");

		try {
			if (homepage.imageShapesPresent()) {
				System.out.println("on homepage");
				helper.clickContinue();
				System.out.println("clicked continue");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		try {
			if (homepage.isFbButtonVisible()) {
				homepage.clickFBLoginButton();
				helper.clickContinue();

			}
		} catch (Exception e) {
			// TODO: handle exception
//			logger.log(LogStatus.SKIP, e.getMessage());
		}

		try {
			System.out.println(fbpage.isFbloginscreen());
			if (fbpage.isFbloginscreen()) {
				fbpage.enterUserName("gauravsinghkaura08@gmail.com");
				logger.log(LogStatus.PASS, "User name for facebook login entered.");
				fbpage.enterUserPassword("gaurav89820");
				logger.log(LogStatus.PASS, "Password for facebook login entered.");
				fbpage.clickSubmit();

//				Thread.sleep(5000);

			}
		} catch (Exception e) {
			logger.log(LogStatus.SKIP, "Sipped Username/Password for facebook login seems already entered.");
			e.getMessage(); // TODO: handle exception
		}
		try {
			if (fbpage.isFbloginscreen())
				logger.log(LogStatus.FAIL, "Facebook login Failed,Check credentials");

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.PASS, "Facebook Login Success");
			e.getMessage();
		}
		try {
			if (fbpage.isContinueAsUserScreen()) {
				fbpage.clickContinueAsUser();
				Thread.sleep(10000);

			}
		} catch (Exception e) {
			// TODO: handle exception
//			fbpage.ClickCancel();
			e.getMessage();
		}
		try {
			Thread.sleep(5000);
			if (googleSignupPage.isAuthorizationScreen()) {
				helper.clickBack();
				helper.clickBack();

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

//	@Test(priority = 7, dependsOnMethods = "clickLogin", groups = { "test-group" })

}