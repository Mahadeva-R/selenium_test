package arogyasetu_application;

import java.util.List;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import arogyasetu_application.pages.HomePageArogyasetuApp;
import arogyasetu_application.listeners.ArogyaSetuAppListener;
import arogyasetu_application.utilities.Constants;

@Listeners(ArogyaSetuAppListener.class)
public class TestArogyasetuApp extends BaseTestConfiguranceArogyasetuApp {

	HomePageArogyasetuApp homePage;
	SoftAssert softAssert;

	@Test(priority = 1)
	public void testFullyVaccinatedStates() throws InterruptedException {
		homePage = new HomePageArogyasetuApp(driver);
		homePage.openApplication();
		List<String> actualTopThreeStates = homePage.getTopThreeStates();
		log.info(actualTopThreeStates);
		Assert.assertEquals(actualTopThreeStates, Constants.getExpectedTopThreeStates());
	}

	@Test(priority = 2)
	public void testStateWiseCovidCasesCount() throws InterruptedException {
		Map<String, String> actualFirstStateCovidCases = homePage.firstStateData();
		Map<String, String> actualSecondtStateCovidCases = homePage.secondStateData();
		Map<String, String> actualThirdStateCovidCases = homePage.thirdStateData();

		Map<String, String> expectedFirstStateCovidCases = homePage.getFirstStateCovidCasesDataFromChildPage()
				.getStateCovidCasesCount();
		Map<String, String> expectedSecondStateCovidCases = homePage.getSecondStateCovidCasesDataFromChildPage()
				.getStateCovidCasesCount();
		Map<String, String> expectedThirdStateCovidCases = homePage.getThirdStateCovidCasesDataFromChildPage()
				.getStateCovidCasesCount();

		log.info("Uttar Pradesh : " + "\n[Actual] : " + actualFirstStateCovidCases + "\n[Expected] : "
				+ expectedFirstStateCovidCases);
		log.info("Maharashtra : " + "\n[Actual] : " + actualSecondtStateCovidCases + "\n[Expected] : "
				+ expectedSecondStateCovidCases);
		log.info("Gujarath : " + "\n[Actual] : " + actualThirdStateCovidCases + "\n[Expected] : "
				+ expectedThirdStateCovidCases);

		softAssert = new SoftAssert();
		softAssert.assertEquals(actualFirstStateCovidCases, expectedFirstStateCovidCases);
		softAssert.assertEquals(actualSecondtStateCovidCases, expectedSecondStateCovidCases);
		softAssert.assertEquals(actualThirdStateCovidCases, expectedThirdStateCovidCases);
		softAssert.assertAll();
	}
}
