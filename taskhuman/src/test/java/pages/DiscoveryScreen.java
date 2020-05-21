package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class DiscoveryScreen extends TestBase {
	ExtentTest logger;
	WebElement bookIcon, chatIcon, ShareIcon, backToDiscovery, videoCallIcon;

	public void CheckHowItWorks() {
		driver.findElement(By.xpath(""));

	}

	public void ClickTile(String id) throws InterruptedException {
		Thread.sleep(10000);
		try {
			WebElement element = driver.findElementByAccessibilityId(id);
			element.click();
		} catch (Exception e) {

			e.getMessage();
			// TODO: handle exception
		}

	}

	public void isProviderAvailable() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		System.out.println("Time in 12 Hour format - " + sdf.format(date));
		String f = driver.findElementByXPath("(//XCUIElementTypeButton").getText();
		System.out.println(f);
	}

	public void clickVideoCall() {
//		WebElement element = driver.findElementByXPath("//XCUIElementTypeImage[@name='Call']");
//		element.click();

		if (videoCallIcon.isEnabled())
			videoCallIcon.click();

	}

	public boolean isVideoCallIconVisible() {
//		WebElement element = driver.findElementByXPath("//XCUIElementTypeImage[@name='Call']");
//		element.click();
		videoCallIcon = driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"TH Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeImage");
		return videoCallIcon.isEnabled();

	}

	public boolean isBookIconVisible() {
		bookIcon = driver.findElementByXPath("//XCUIElementTypeImage[@name=\"Book\"]");
		return bookIcon.isEnabled();
	}

	public boolean isChatIconVisible() {
		chatIcon = driver.findElementByXPath("//XCUIElementTypeImage[@name=\"messageReengage\"]");
		return chatIcon.isEnabled();
	}

	public boolean isShareIconVisible() {
		ShareIcon = driver.findElementByXPath("//XCUIElementTypeImage[@name=\"Share\"]");
		return ShareIcon.isEnabled();
	}

	public boolean isBackToDiscoveryButtonVisible() {
		backToDiscovery = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Button\"]");
		return backToDiscovery.isEnabled();
	}

	public void clickBook() {

		bookIcon.click();
		bookIcon.click();
	}

	public void clickChat() {

		chatIcon.click();
		chatIcon.click();
	}

	public void clickShare() {

		ShareIcon.click();
		ShareIcon.click();
	}

	public void clickBackToDiscovery() {

		backToDiscovery.click();
		backToDiscovery.click();
	}

	public void providerHelpWith() {
		logger = extent.startTest("providerHelpWith");
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Calisthenics\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Calisthenics");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Concierge\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Concierge ");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Concierge\"])[2]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Concierge");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Customer support\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Customer support");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Diet and nutrition\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Diet and nutrition");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Eating habits\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Eating habits ");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Intermittent fasting\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Intermittent fasting ");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Learn home based workouts\"])[1]")
					.isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Learn home based workouts");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Lose weight\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Lose weight");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Meditation\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Meditation");
		} catch (Exception e) {

			// TODO: handle exception
		}
		try {

			if (driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Weight loss\"])[1]").isEnabled())
				logger.log(LogStatus.PASS, "Provider help with Weight loss");
		} catch (Exception e) {

			// TODO: handle exception
		}

	}

	public void isTileVisible() throws InterruptedException {
		logger = TestBase.extent.startTest("checkDailySelfcareTiles");
		try {
			for (int i = 1; i <= 37; i++) {
				String id = "(//XCUIElementTypeButton[@name='messageDiscover'])" + "[" + i + "]";
				WebElement element = driver.findElementByXPath(id);
				System.out.println(element.getAttribute("value"));
				if (element.isEnabled())
					logger.log(LogStatus.PASS, element.getText() + "is visible");
				if (i % 5 == 0) {
					System.out.println("scrolling");
					helper.SwipeScreen("down", id);
				}
			}

		} catch (Exception e) {
			e.getMessage();

			// TODO: handle exception
		}

	}

}
