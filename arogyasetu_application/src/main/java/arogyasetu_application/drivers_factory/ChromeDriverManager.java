package arogyasetu_application.drivers_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements DriverInstance{

	@Override
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

}
