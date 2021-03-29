package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.cssSelector("a[href*='sign_in']");
	By text = By.xpath("//h2[contains(text(),'Courses')]");
	By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}

	public WebElement getText() {
		return driver.findElement(text);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
}
