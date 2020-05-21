
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.TestBase;

public class VerifyNumber extends TestBase {

	public void selectCountry(String country) {
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"dropDownIcon\"]").click();
		Select select = new Select(driver.findElementByXPath("//XCUIElementTypeButton[@name=\"dropDownIcon\"]"));

		select.selectByVisibleText(country);

	}

	public void enterPhoneNumber(String phone) {
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
				.sendKeys(phone);
	}

	public void requestOTP() {
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"])[1]").click();
	}

	public Boolean isNumberAlreadyRegister() {
		WebElement element;
		try {
			element = driver.findElementByXPath(
					"//XCUIElementTypeStaticText[@name=\"Mobile number is already associated with a different email address\"]");

			if (element.getText()
					.equalsIgnoreCase("Mobile number is already associated with a different email address")) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public void enterOtp(String otp) {
		WebElement element;
		try {
			element = driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]");
			element.sendKeys(otp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
