package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class GoogleSignup extends TestBase {
	WebDriverWait wait;
	WebElement username, passw;

	public Boolean CheckGoogleLoginScreen() {

		try {
			wait = new WebDriverWait(driver, 40);

			/*
			 * emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By
			 * .xpath("//XCUIElementTypeOther[@name=\\\"Sign in – Google accounts\\\"]/XCUIElementTypeOther[4]"
			 * )));
			 */

			return username.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean isEmailFieldVisible() {

		try {
			username = driver.findElement(
					By.xpath(("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[4]")));
			return username.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}

	}

	public void enterEmailAddress(String email) {
		System.out.println(email);

		try {

			Thread.sleep(10000);
			driver.findElement(
					By.xpath(("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[4]")))
					.sendKeys(email);

			helper.closeKeyboard();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			helper.clickCancel();
			e.printStackTrace();
		}

	}

	public boolean isPasswordFieldVisible() {

		try {

			passw = driver.findElement(
					By.xpath(("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[4]")));
			return passw.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void enterEmailPassword(String pwd) {

		try {

			WebElement element = driver.findElement(
					By.xpath("//XCUIElementTypeOther[@name=\"Sign in – Google accounts\"]/XCUIElementTypeOther[3]"));
			TouchActions action = new TouchActions(driver);
			action.singleTap(element);
			action.perform();
//			helper.closeKeyboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickNext() {

		try {

			driver.findElementByAccessibilityId("Next").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String isAnyPassworderror() {

		WebElement element;
		try {
			element = driver
					.findElementByAccessibilityId("Wrong password. Try again or click Forgot password to reset it.");
			if (element.isDisplayed()) {
				return element.getText();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String isEmailErrorMessage() {
		WebElement element;
		try {
			element = driver.findElementByAccessibilityId("Enter a valid email or phone number");
			if (element.isDisplayed()) {
				return element.getText();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			element = driver.findElementByAccessibilityId("Couldn't find your Google Account");
			if (element.isDisplayed())
				return element.getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Boolean isUseAnotherAccountVisible() {
		WebElement element;
		wait = new WebDriverWait(driver, 40);
		try {

			element = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Use another account\"]"));
			return element.isDisplayed();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Use Another Account is not found");
		}

	}

	public void clickUseAnotherAccount() {
		WebElement element;
		try {

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeStaticText[@name=\"Use another account\"]")));
			if (element.isEnabled()) {
				element.click();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found.");
		}

	}

	public Boolean isAuthorizationScreen() {
		WebElement element;
		try {
			element = driver.findElementByAccessibilityId("Mobile Verification");
			return element.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
			throw new NoSuchElementException("Element not found.");
		}

	}
}
