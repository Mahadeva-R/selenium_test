package arogyasetu_application.drivers_factory;

import org.openqa.selenium.WebDriver;

import arogyasetu_application.exceptions.BrowserNotSupportedException;

public class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriverInstance(BrowsersList browserName) throws BrowserNotSupportedException {
		WebDriver driver;
		switch (browserName) {

		case CHROME:
			driver = new ChromeDriverManager().createDriver();
			break;

		case FIREFOX:
			driver = new FireFoxDriverManager().createDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().createDriver();
			break;
		default:
			throw new BrowserNotSupportedException("Please Enter the Valid Browser Name");
		}
		return driver;
	}
}
