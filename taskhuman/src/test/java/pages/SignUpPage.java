package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class SignUpPage extends TestBase {
	WebDriverWait wait;

	public Boolean isFirstNameEnable() {
		WebElement element;
		try {
			wait = new WebDriverWait(driver, 40);
			element = driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]"));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void enterFirstName(String fname) {
		WebElement element;

		try {
			wait = new WebDriverWait(driver, 40);
			element = driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]"));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(fname);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isLastNameEnable() {

		try {
			return driver.findElementByXPath("	\n"
					+ "//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
					.isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	@SuppressWarnings("null")
	public void enterLastName(String lname) {
		WebElement element;

		try {
			element = driver.findElementByXPath("	\n"
					+ "//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
			element.clear();
			element.sendKeys(lname);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isEmailFieldEnable() {

		try {
			return driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")
					.isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void enterEmailAddress(String email) {
		WebElement element;
		try {
			element = driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]");
			element.clear();
			element.sendKeys(email);
			;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isPasswordFieldisible() {

		try {
			return driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
					.isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void selectPassword(String pwd) {
		WebElement element;

		try {
			element = driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");

			element.sendKeys(pwd);
			;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isEyeIconVisible() {

		try {
			return driver.findElementByAccessibilityId("Eye").isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void clickEyeIcon() {

		try {
			driver.findElementByAccessibilityId("Eye").click();
			;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isBackToLoginVisible() {

		try {
			return driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Log in here\"]").isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void clickBackToLogin() {

		try {
			driver.findElementByXPath("	\n" + "//XCUIElementTypeStaticText[@name=\"Log in here\"]").click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isRegistrationButtonVisible() {

		try {
			return driver.findElementByXPath("	//XCUIElementTypeButton[@name=\"Sign up\"]").isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
	}

	public void clickRegistrationButton() {

		try {
			driver.findElementByXPath("	//XCUIElementTypeButton[@name=\"Sign up\"]").click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
	}

	public Boolean isSignupHeadingText() {

		try {
			return driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Sign up\"])[1]\n" + "")
					.isDisplayed();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public String checkSignupHeadingText() {

		try {
			return driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Sign up\"])[1]\n" + "").getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}
}
