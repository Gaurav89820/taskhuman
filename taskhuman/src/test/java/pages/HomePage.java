package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSElement;
import utility.TestBase;

public class HomePage extends TestBase {
	WebDriverWait wait;

	/*
	 * public void clickLoginButton() throws InterruptedException, Exception {
	 * 
	 * try { driver.
	 * findElementByAccessibilityId("//XCUIETTTlementTypeButton[@name=\\\"Login or SignUp\\"
	 * ).click(); } catch (Exception e) { // TODO Auto-generated catch block throw
	 * new NoSuchElementException("Element not found" + e.getMessage()); } }
	 */
	public Boolean isLogoPresent() throws Exception {

		try {
			if (driver.findElementByAccessibilityId("taskhuman logo").isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public Boolean isBusinessTagLineVisible() throws Exception {
		try {
			wait = new WebDriverWait(driver, 10);
			WebElement element = driver.findElementByAccessibilityId("HUMAN GUIDANCE ON TAP");
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public String checkBusinessTagLineValue() throws Exception {
		try {
			return driver.findElementByAccessibilityId("HUMAN GUIDANCE ON TAP").getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean imageShapesPresent() throws Exception {
		try {
			if (driver.findElementByAccessibilityId("image-shapes").isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("image shapes not found" + e.getMessage());
		}
		return false;

	}

	public Boolean isTermPrivacyVisible() throws Exception {
		try {
			if (driver.findElementByAccessibilityId("By continuing, I agree to TaskHuman's").isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public String checkTermPrivacyValue() throws Exception {
		try {
			return driver.findElementByAccessibilityId("By continuing, I agree to TaskHuman's").getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isTermConditionVisible() throws Exception {
		try {
			IOSElement termsCondition = driver.findElementByAccessibilityId("Terms & Conditions");

			if (termsCondition.isDisplayed() && termsCondition.isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public Boolean isPrivacyPolicyVisible() throws Exception {
		try {
			IOSElement privacyPolicy = driver.findElementByAccessibilityId("Privacy Policy");
			if (privacyPolicy.isDisplayed() && privacyPolicy.isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public Boolean isFbButtonVisible() throws Exception {
		try {
			if (driver.findElementByAccessibilityId("FACEBOOK OVAL").isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;

	}

	public Boolean isGmailButtonVisible() throws Exception {

		try {
			if (driver.findElementByAccessibilityId("GMAIL OVAL").isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
		return false;
	}

	public void clickGmailLoginButton() throws Exception {
		try {
			driver.findElementByAccessibilityId("GMAIL OVAL").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
	}

	public void clickFBLoginButton() throws Exception {
		try {
			driver.findElementByAccessibilityId("FACEBOOK OVAL").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
	}

	public void clickSignupButton() throws Exception {
		try {
			wait = new WebDriverWait(driver, 40);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("	\n" + "//XCUIElementTypeButton[@name=\"Sign up with Email\"]")));
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Wrong xpath" + e.getMessage());
		}

	}

	public String checkLogintext() throws Exception {
		String text = "";
		try {
			text = driver.findElementByAccessibilityId("Already have an account? Login").getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Element not found" + e.getMessage());
		}

	}

	public void clickloginButton() throws Exception {
		try {
			driver.findElementByAccessibilityId("Already have an account? Login").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}
	}

	public void clickMainScreenloginButton() throws Exception {
		try {
			wait = new WebDriverWait(driver, 40);
			WebElement login;

			login = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Login or SignUp\"]")));
			if (login.isDisplayed()) {
				login.click();
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Wrong xpath" + e.getMessage());
		}

	}

	public Boolean isMainScreenloginButtonVisible() throws Exception {

		try {
			wait = new WebDriverWait(driver, 40);
			WebElement login = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Login or SignUp\"]")));
			if (login.isDisplayed())
				return true;

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Wrong xpath" + e.getMessage());
		}
		return false;
	}

	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getPageSource();

	}

}