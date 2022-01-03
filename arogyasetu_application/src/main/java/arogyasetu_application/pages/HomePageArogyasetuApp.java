package arogyasetu_application.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arogyasetu_application.utilities.ArogyaSetuAppUtilities;
import arogyasetu_application.utilities.Constants;

public class HomePageArogyasetuApp {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='toggle expand-table-toggle']")
	WebElement expandButton;
	@FindBy(xpath = "//div[contains(text(),'Fully Vaccinated')]")
	WebElement fullyVacinatedTAB;
	@FindBy(xpath = "(//div [@class='state-name fadeInUp'])[position()>=1 and position()<=3]")
	List<WebElement> topThreeFullyVacinatedStates;
	@FindBy(xpath = "//div[@class='state-page']")
	WebElement seeMoreDetailsButton;
	
	@FindBy(xpath = "(//div[@class='total'])[position()=1]")
	WebElement stateOneConfirmed;
	@FindBy(xpath = "(//div[@class='total'])[position()=2]")
	WebElement stateOneActive;
	@FindBy(xpath = "(//div[@class='total'])[position()=3]")
	WebElement stateOneRecovered;
	@FindBy(xpath = "(//div[@class='total'])[position()=4]")
	WebElement stateOneDeceased;

	@FindBy(xpath = "//div[@class='table fadeInUp']/div[3]/div[2]/div[2]")
	WebElement stateTwoConfirmed;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[3]/div[3]/div")
	WebElement stateTwoActive;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[3]/div[4]/div[2]")
	WebElement stateTwoRecovered;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[3]/div[5]/div[2]")
	WebElement stateTwoDeceased;

	@FindBy(xpath = "//div[@class='table fadeInUp']/div[4]/div[2]/div[2]")
	WebElement stateThreeConfirmed;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[4]/div[3]/div")
	WebElement stateThreeActive;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[4]/div[4]/div[2]")
	WebElement stateThreeRecovered;
	@FindBy(xpath = "//div[@class='table fadeInUp']/div[4]/div[5]/div[2]")
	WebElement stateThreeDeceased;


	public HomePageArogyasetuApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openApplication() {
		driver.get(Constants.APP_URL);
	}

	public List<String> getTopThreeStates() throws InterruptedException {
		ArogyaSetuAppUtilities.waitForElement(driver,expandButton).click();
		ArogyaSetuAppUtilities.waitForElement(driver,fullyVacinatedTAB).click();

		List<String> actualTopThreeStates = new ArrayList<>();
		for (WebElement state : topThreeFullyVacinatedStates) {
			actualTopThreeStates.add(state.getText());
		}
		return actualTopThreeStates;
	}

	public CovidCasesChildPage getFirstStateCovidCasesDataFromChildPage() {
		ArogyaSetuAppUtilities.waitForElement(driver,topThreeFullyVacinatedStates.get(0)).click();
		ArogyaSetuAppUtilities.waitForElement(driver,seeMoreDetailsButton).click();
		return new CovidCasesChildPage(driver);
	}

	public CovidCasesChildPage getSecondStateCovidCasesDataFromChildPage() {
		ArogyaSetuAppUtilities.waitForElement(driver,topThreeFullyVacinatedStates.get(1)).click();
		ArogyaSetuAppUtilities.waitForElement(driver,seeMoreDetailsButton).click();
		return new CovidCasesChildPage(driver);
	}

	public CovidCasesChildPage getThirdStateCovidCasesDataFromChildPage() {
		ArogyaSetuAppUtilities.waitForElement(driver,topThreeFullyVacinatedStates.get(2)).click();
		ArogyaSetuAppUtilities.waitForElement(driver,seeMoreDetailsButton).click();
		return new CovidCasesChildPage(driver);
	}
	
	public Map<String, String> firstStateData() throws InterruptedException {
		Map<String, String> actualCasesState1 = new LinkedHashMap<>();
		actualCasesState1.put(Constants.CONFIRMED, stateOneConfirmed.getText());
		actualCasesState1.put(Constants.ACTIVE, stateOneActive.getText());
		actualCasesState1.put(Constants.RECOVERED, stateOneRecovered.getText());
		actualCasesState1.put(Constants.DECEASED, stateOneDeceased.getText());
		Thread.sleep(1000);
		return actualCasesState1;
	}

	public Map<String, String> secondStateData() throws InterruptedException {
		Map<String, String> actualCasesState2 = new LinkedHashMap<>();
		actualCasesState2.put(Constants.CONFIRMED, stateTwoConfirmed.getText());
		actualCasesState2.put(Constants.ACTIVE, stateTwoActive.getText());
		actualCasesState2.put(Constants.RECOVERED, stateTwoRecovered.getText());
		actualCasesState2.put(Constants.DECEASED, stateTwoDeceased.getText());
		Thread.sleep(1000);
		return actualCasesState2;
	}

	public Map<String, String> thirdStateData() throws InterruptedException {
		Map<String, String> actualCasesState3 = new LinkedHashMap<>();
		actualCasesState3.put(Constants.CONFIRMED, stateThreeConfirmed.getText());
		actualCasesState3.put(Constants.ACTIVE, stateThreeActive.getText());
		actualCasesState3.put(Constants.RECOVERED, stateThreeRecovered.getText());
		actualCasesState3.put(Constants.DECEASED, stateThreeDeceased.getText());
		Thread.sleep(1000);
		return actualCasesState3;
	}
}
