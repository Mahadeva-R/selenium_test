package arogyasetu_application.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ArogyaSetuAppUtilities {

	public static WebElement waitForElement(WebDriver driver, final WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement loacteElement = wait.until(ExpectedConditions.visibilityOf(element));
		return loacteElement;
	}

	public static String actualCovidCases(WebElement covidCase) {
		String covidCaseCount = covidCase.getText();
		return covidCaseCount;
	}

	public static String getStateCovidCasesdata(WebElement element, WebElement covidCount) throws InterruptedException {

		element.click();
		Thread.sleep(1500);
		String stateCovidCount = expectedCovidCases(covidCount);
		return stateCovidCount;
	}

	public static String expectedCovidCases(WebElement covidCount) {
		String expectedCount = covidCount.getText();
		return expectedCount;
	}

}
