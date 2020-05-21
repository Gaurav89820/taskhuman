package utility;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Helper extends TestBase {
	ExtentTest logger;

	public void clickBack() {

		try {
			driver.findElementByAccessibilityId("back").click();
			;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public Boolean isAllowVisible() {
		try {
			return driver.findElementByAccessibilityId("Allow").isEnabled();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void clickAllow() {
		try {
			driver.findElementByAccessibilityId("Allow").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());
		}

	}

	public void clickContinue() {

		try {
			Thread.sleep(3000);
			driver.findElementByAccessibilityId("Continue").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());

		}
		driver.findElementByAccessibilityId("Done").click();
	}

	public void closeKeyboard() {

		try {
			driver.findElementByAccessibilityId("Done").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NoSuchElementException("Element not found" + e.getMessage());

		}

	}

	public void logout() throws Exception {
		try {
			extent.startTest("logout");
			Thread.sleep(10000);
			System.out.println(driver.findElementByAccessibilityId("SettingsBottonTab").isEnabled());
			driver.findElementByAccessibilityId("SettingsBottonTab").click();
			logger.log(LogStatus.PASS, "Inside settings tab");
			System.out.println("Clicked");
			driver.findElementByAccessibilityId("Logout").click();
			driver.findElementByAccessibilityId("Logout").click();
			logger.log(LogStatus.PASS, "Logout Button clicked ");
			Thread.sleep(5000);
			driver.findElementByAccessibilityId("OK").click();
			logger.log(LogStatus.PASS, "Confirmed user want to logout");
			Thread.sleep(10000);
			homepage.clickMainScreenloginButton();
			logger.log(LogStatus.PASS, "Logged Out Successfully");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Seems unable to find elements");
			// TODO: handle exception
		}
	}

	public void clickCancel() {
		driver.findElementByAccessibilityId("Cancel").click();
	}

	public void SwipeScreen(String direction, String text) {

		/*
		 * JavascriptExecutor js = driver; HashMap scrollObject = new HashMap();
		 * scrollObject.put("direction", direction); scrollObject.put("name", text);
		 * js.executeScript("mobile: scroll", scrollObject);
		 */
//		TouchActions action = new TouchActions(driver);
//		action.scroll(element, 10, 100);
//		action.perform();
//		
		RemoteWebElement element = driver.findElementByXPath(text);
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID); // Only for ‘scroll in element’
		scrollObject.put("direction", direction);
		driver.executeScript("mobile:scroll", scrollObject);

	}

}
