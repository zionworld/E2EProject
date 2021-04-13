package Academy;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initiated");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	@Test(dataProvider = "dataSet")
	public void initializeBrowserTest(String email, String password) {

		LandingPage landingPage = new LandingPage(driver);
		// driver.switchTo().alert(".//div[contains(@class,'listbuilder-popup-scale')]");
		landingPage.getLogin().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginBtn().click();
		log.info("Validated smoke test");

	}

	@DataProvider(name = "dataSet")
	public Object[][] getData() {
		Object[][] dataSet = new Object[3][2];
		dataSet[0][0] = "abc@gmail.com";
		dataSet[0][1] = "1234567";

		dataSet[1][0] = "def@gmail.com";
		dataSet[1][1] = "7654321";

		dataSet[2][0] = "ghi@gmail.com";
		dataSet[2][1] = "45877";

		return dataSet;

	}

	@Test
	public void validateTitle() {

		LandingPage landingPage = new LandingPage(driver);
		Assert.assertEquals("FEATURED COURSES", landingPage.getText().getText());
		log.info("Validated title of the block");
	}

	@Test
	public void validationPresenceOfNavigationBar() {

		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
		log.info("Validated visibility of the navigation bar");
		System.out.println(System.getProperty("user.dir"));
	}

}
