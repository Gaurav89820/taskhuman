package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class FacebookSignup extends TestBase {
	WebDriverWait wait;

	public Boolean isFbloginscreen() {
		wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//XCUIElementTypeStaticText[@name=\"Log in to your Facebook account to connect to TaskHuman\"]")));
		return element.getText().equalsIgnoreCase("Log in to your Facebook account to connect to TaskHuman");
	}

	public void enterUserName(String name) {
		/*
		 * wait = new WebDriverWait(driver, 40); WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.
		 * xpath("//XCUIElementTypeTextField[@name=\"Phone number or email address\"]"))
		 * );
		 */
		driver.findElement((By.xpath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField")))
				.sendKeys(name);
	}

	public void enterUserPassword(String name) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField")));

		element.clear();
		element.sendKeys(name);
	}

	public void clickSubmit() {

		driver.findElementByAccessibilityId("Log In").click();
		;

	}

	public void clickNotNow() {

		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Not now\"]")));
		element.click();

	}

	public void clickContinueAsUser() {
		try {

			if (driver.findElementByAccessibilityId("name and profile picture and email address").isDisplayed())
				driver.findElementByAccessibilityId("Continue as Kaura").click();
		} catch (Exception e) {
			driver.findElementByAccessibilityId("Continue").click();
			// TODO: handle exception
		}

	}

	public void ClickCancel() {
		driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Cancel\"])[2]").click();
	}

	public boolean isContinueAsUserScreen() {

		try {
			return driver.findElementByAccessibilityId("You previously logged in to TaskHuman with Facebook.")
					.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver.findElementByAccessibilityId("name and profile picture and email address").isDisplayed();
	}

}
