package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\Jar files\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Jar files\\BrowserDriver\\geckodriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Jar files\\BrowserDriver\\msedgedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
