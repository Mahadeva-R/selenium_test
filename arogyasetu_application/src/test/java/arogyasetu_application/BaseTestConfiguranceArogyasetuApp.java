package arogyasetu_application;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import arogyasetu_application.drivers_factory.BrowsersList;
import arogyasetu_application.drivers_factory.DriverFactory;
import arogyasetu_application.exceptions.BrowserNotSupportedException;

public class BaseTestConfiguranceArogyasetuApp {

	WebDriver driver;
	Logger log;

	@BeforeTest
	public void setUp() throws BrowserNotSupportedException {

		log = LogManager.getLogger(BaseTestConfiguranceArogyasetuApp.class);
		driver = DriverFactory.getDriverInstance(BrowsersList.CHROME);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
		log = null;
	}
}
