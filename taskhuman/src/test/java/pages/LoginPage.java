package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait;

	public String checkLoginPageText() {

		try {
			return driver.findElementByAccessibilityId("Login").getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void enterEmail(String email) {

		try {
			wait = new WebDriverWait(driver, 50);

			driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"))
					.sendKeys(email);
			;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void enterPassword(String password) {

		try {

			driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField"))
					.sendKeys(password);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void clickLogin() {
		WebElement element;
		try {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Log in\"]")));
			element.click();

		} catch (

		NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

}
