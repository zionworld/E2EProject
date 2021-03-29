package Academy;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	@BeforeMethod
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
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
		Assert.assertEquals("Featured Courses", landingPage.getText().getText());
	}

	@Test
	public void validationPresenceOfNavigationBar() {

		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
	}

}
