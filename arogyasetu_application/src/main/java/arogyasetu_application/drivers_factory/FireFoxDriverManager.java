package arogyasetu_application.drivers_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager implements DriverInstance {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
