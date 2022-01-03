package arogyasetu_application.pages;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arogyasetu_application.utilities.ArogyaSetuAppUtilities;
import arogyasetu_application.utilities.Constants;

public class CovidCasesChildPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='clickable is-confirmed']")
	WebElement confirmedCasesTab;
	@FindBy(xpath="//div[@class='clickable is-active']")
	WebElement activeCasesTab;
	@FindBy(xpath="//div[@class='clickable is-recovered']")
	WebElement recoveredCasesTab;
	@FindBy(xpath="//div[@class='clickable is-deceased']")
	WebElement deceasedCasesTab;
	
	@FindBy(xpath="//div[@class='panel-left fadeInUp']/h1/div[1]")
	WebElement totalCovidCases;

	public CovidCasesChildPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Map<String,String> getStateCovidCasesCount() throws InterruptedException {
		
		Map<String,String> covidCasesCount = new LinkedHashMap<>();
		covidCasesCount.put(Constants.CONFIRMED, ArogyaSetuAppUtilities.getStateCovidCasesdata(confirmedCasesTab, totalCovidCases));
		Thread.sleep(1000);
		covidCasesCount.put(Constants.ACTIVE, ArogyaSetuAppUtilities.getStateCovidCasesdata(activeCasesTab, totalCovidCases));
		Thread.sleep(1000);
		covidCasesCount.put(Constants.RECOVERED, ArogyaSetuAppUtilities.getStateCovidCasesdata(recoveredCasesTab, totalCovidCases));
		Thread.sleep(1000);
		covidCasesCount.put(Constants.DECEASED, ArogyaSetuAppUtilities.getStateCovidCasesdata(deceasedCasesTab, totalCovidCases));
		Thread.sleep(1000);
		driver.navigate().back();
		
		return covidCasesCount;
	}
	
	
}
