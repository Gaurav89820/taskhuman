package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestBase;

public class DiscoveryTest extends TestBase {
	ExtentTest logger;

	@Test(groups = { "test-group3" }, dependsOnGroups = { "test-group1", "test-group", "test-group2" }, priority = 1)
	public void doLoginWithEmail() throws Exception {
		System.out.println("Inside login wih");
		logger = TestBase.extent.startTest("doLoginWithEmail");
		homepage.clickloginButton();

		try {
			if (homepage.isMainScreenloginButtonVisible()) {
				homepage.clickMainScreenloginButton();
				helper.clickContinue();

			}
		} catch (Exception e) {
			// TODO: handle exception
//	logger.log(LogStatus.SKIP, e.getMessage());
		}

		if (lp.checkLoginPageText().equals("Login")) {
			logger.log(LogStatus.PASS, "clicked login button");
			logger.log(LogStatus.PASS, "Reached login screen");
			lp.enterEmail("er@yopmail.com");
			lp.enterPassword("Aaaaaaaa@1");
			lp.clickLogin();
			Thread.sleep(15000);

		} else {

			logger.log(LogStatus.FAIL, "Failed to click ");
			logger.log(LogStatus.FAIL, "Failed login ");
			logger.log(LogStatus.SKIP, "login failed");
			logger.log(LogStatus.SKIP, "login failed");

		}

	}

	@Test(groups = { "test-group3" }, dependsOnGroups = { "test-group1", "test-group", "test-group2" }, priority = 2)
	public void checkDailySelfcareTiles() throws InterruptedException {

		discovery.isTileVisible();
		/*
		 * if (discovery.isTileVisible("Yoga")) logger.log(LogStatus.PASS,
		 * "Yoga Tile is displayed"); else logger.log(LogStatus.FAIL,
		 * "Yoga Tile is not displayed");
		 * 
		 * if (discovery.isTileVisible("Meditation")) logger.log(LogStatus.PASS,
		 * "Meditation Tile is displayed"); else logger.log(LogStatus.FAIL,
		 * "Meditation Tile is not displayed");
		 * 
		 * if (discovery.isTileVisible("Breathing techniques"))
		 * logger.log(LogStatus.PASS, "Breathing techniques Tile is displayed"); else
		 * logger.log(LogStatus.FAIL, "Breathing techniques Tile is not displayed");
		 * 
		 * helper.SwipeScreen("down", "HIIT session"); System.out.println("scrolled");
		 * if (discovery.isTileVisible("Stretching")) logger.log(LogStatus.PASS,
		 * "Stretching Tile is displayed"); else logger.log(LogStatus.FAIL,
		 * "Stretching Tile is not displayed");
		 * 
		 * if (discovery.isTileVisible("HIIT session")) logger.log(LogStatus.PASS,
		 * "HIIT session Tile is displayed"); else logger.log(LogStatus.FAIL,
		 * "HIIT session Tile is not displayed");
		 * 
		 * if (discovery.isTileVisible("Home based workouts"))
		 * logger.log(LogStatus.PASS, "Home based workouts Tile is displayed"); else
		 * logger.log(LogStatus.FAIL, "Home based workouts Tile is not displayed");
		 * helper.SwipeScreen("down", "Mat Pilates"); if
		 * (discovery.isTileVisible("Mat Pilates")) logger.log(LogStatus.PASS,
		 * "Mat pilates Tile is displayed"); else logger.log(LogStatus.FAIL,
		 * "Mat pilates Tile is not displayed");
		 */
	}

	/*
	 * @Test(groups = { "test-group3" }, dependsOnGroups = { "test-group1",
	 * "test-group", "test-group2" }, priority = 3) public void
	 * checkEatHealthyTiles() throws InterruptedException { logger =
	 * TestBase.extent.startTest("checkEatHealthyTiles"); if
	 * (discovery.isTileVisible("Clean eating basics")) logger.log(LogStatus.PASS,
	 * "Clean eating basics Tile is displayed"); else logger.log(LogStatus.FAIL,
	 * "Clean eating basics Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Plant based & vegan eating"))
	 * logger.log(LogStatus.PASS, "Plant based & vegan eating Tile is displayed");
	 * else logger.log(LogStatus.FAIL,
	 * "Plant based & vegan eating Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Intermittent fasting"))
	 * logger.log(LogStatus.PASS, "Intermittent fasting Tile is displayed"); else
	 * logger.log(LogStatus.FAIL, "Intermittent fasting Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Eating trends- Paleo, Keto, etc"))
	 * logger.log(LogStatus.PASS,
	 * "Eating trends- Paleo, Keto, etc Tile is displayed"); else
	 * logger.log(LogStatus.FAIL,
	 * "Eating trends- Paleo, Keto, etc Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Improve your digestion"))
	 * logger.log(LogStatus.PASS, "Improve your digestion Tile is displayed"); else
	 * logger.log(LogStatus.FAIL, "Improve your digestion Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Supplements to take"))
	 * logger.log(LogStatus.PASS, "Supplements to take Tile is displayed"); else
	 * logger.log(LogStatus.FAIL, "Supplements to take Tile is not displayed");
	 * 
	 * if (discovery.isTileVisible("Recipes and meal prep"))
	 * logger.log(LogStatus.PASS, "Recipes and meak prep Tile is displayed"); else
	 * logger.log(LogStatus.FAIL,
	 * "\"Recipes and meal prep\" Tile is not displayed");
	 * 
	 * }
	 */
	@Test(groups = { "test-group3" }, dependsOnGroups = { "test-group1", "test-group", "test-group2" }, priority = 4)
	public void checkProviderProfile() throws InterruptedException {
		logger = TestBase.extent.startTest("checkProviderProfile");
		System.out.println("before 15000 ");
		Thread.sleep(15000);
		System.out.println("clicked login and awake after 15000 ");
		System.out.println("Enter Category");
		String category = input.next();

		discovery.ClickTile(category);
		Thread.sleep(15000);
		System.out.println("Please enter name of provider you want to contact");
		String provider = input.next();
		driver.findElementByAccessibilityId(provider).click();
		System.out.println("clicked provider");
		Thread.sleep(17000);
		if (discovery.isVideoCallIconVisible()) {
			logger.log(LogStatus.PASS, "Video call icon is visible and displayed");
			discovery.clickVideoCall();
		}

		discovery.isProviderAvailable();

		System.out.println("clicked vcall");
		// driver.findElementByXPath("(//XCUIElementTypeImage[@name=\"Call\"])[1]").click();

	}

}
