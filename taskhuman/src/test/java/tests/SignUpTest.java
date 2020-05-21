package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class SignUpTest extends TestBase {

	ExtentTest logger;

	@Test(groups = { "test-group1" }, dependsOnGroups = "test-group", priority = 1)
	public void CheckUserRedirection() throws Exception {

		logger = TestBase.extent.startTest("CheckUserRedirection");
//		Thread.sleep(10000);
		homepage.clickSignupButton();
		if (signUpPage.isBackToLoginVisible()) {
			signUpPage.clickBackToLogin();
			logger.log(LogStatus.PASS, "Back to login button clicked");

			if (lp.checkLoginPageText().equalsIgnoreCase("Login")) {
				logger.log(LogStatus.PASS,
						"User redirected to login screen once clicked Back to Login button from signup page");
				helper.clickBack();

			}
		}

		if (signUpPage.checkSignupHeadingText().equalsIgnoreCase("Sign up"))
			logger.log(LogStatus.PASS, "User redirected to Signup screen once clicked Back button from Login page");

	}

	@Test(groups = {
			"test-group1" }, dependsOnGroups = "test-group", dependsOnMethods = "CheckUserRedirection", priority = 2)
	public void fillSignupForm() throws Exception {
		logger = TestBase.extent.startTest("fillSignupForm");
		try {

			if (signUpPage.checkSignupHeadingText().equalsIgnoreCase("Sign up")) {
				if (signUpPage.isFirstNameEnable()) {
					signUpPage.enterFirstName("Gaurav");
					logger.log(LogStatus.PASS, "Entered First Name ");
				}

				if (signUpPage.isLastNameEnable()) {
					signUpPage.enterLastName("singh");
					logger.log(LogStatus.PASS, "Entered Last Name ");
				}
				if (signUpPage.isEmailFieldEnable()) {
					signUpPage.enterEmailAddress("gsp21@yopmail.com");
					logger.log(LogStatus.PASS, "Entered Email Address ");
				}
				if (signUpPage.isPasswordFieldisible()) {
					signUpPage.selectPassword("Gaurav@123");
					logger.log(LogStatus.PASS, "Entered Password");
				}
				if (signUpPage.isEyeIconVisible()) {
					signUpPage.clickEyeIcon();
					logger.log(LogStatus.PASS, "Eye icon clicked ");
				}

				helper.closeKeyboard();
			} else {
				logger.log(LogStatus.SKIP, "Fields not found or May be unable to reach signup form page");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			helper.closeKeyboard();
			helper.clickBack();
		}
	}

	@Test(groups = { "test-group1" }, dependsOnGroups = "test-group", dependsOnMethods = "fillSignupForm", priority = 3)
	public void doSignup() throws Exception {
		logger = TestBase.extent.startTest("doSignup");

		if (signUpPage.checkSignupHeadingText().equalsIgnoreCase("Sign up")) {
			if (signUpPage.isRegistrationButtonVisible()) {
				signUpPage.clickRegistrationButton();
				logger.log(LogStatus.PASS, "Submit button clicked");
				logger.log(LogStatus.PASS, "User sign up with email Successfully done ");
				logger.log(LogStatus.PASS, "Verify your number ,you're at verification screen");
			}
		} else {
			logger.log(LogStatus.SKIP, "Submit button not found or May be unable to reach signup form page");
		}

		System.out.println("out");

	}

	/*
	 * @Test(groups = { "test-group1" }, dependsOnGroups = "test-group",
	 * dependsOnMethods = "fillSignupForm", priority = 4) public void
	 * numberVerification() throws Exception { Thread.sleep(15000); logger =
	 * TestBase.extent.startTest("numberVerification");
	 * 
	 * Scanner scanner = new Scanner(System.in); verify.selectCountry("India");
	 * verify.enterPhoneNumber("9009552115"); verify.requestOTP(); if
	 * (verify.isNumberAlreadyRegister()) {
	 * 
	 * logger.log(LogStatus.SKIP, "Phone number already registered"); } else {
	 * System.out.println("Enter OTP"); String otp = scanner.nextLine();
	 * verify.enterOtp(otp);
	 * 
	 * scanner.close(); System.out.println("out");
	 * 
	 * }
	 * 
	 * }
	 */
}
