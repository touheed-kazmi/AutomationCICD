package sf2.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sf2.TestComponents.BaseTest;
import sf2.pageobjects.AccessOpportunity;
import sf2.pageobjects.DetailsPage;
import sf2.pageobjects.DetailsPageTender;
import sf2.pageobjects.LandingPage;

public class EMEAStepAutomation extends BaseTest {

	@Test(dataProvider = "getData")
	public void stepAutomation(HashMap<String,String> input) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();

		// login to salesforce org
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication(input.get("userName"), input.get("password"));

		// access the opportunity and set zoom
		AccessOpportunity accessOpportunity = new AccessOpportunity(driver);
		accessOpportunity.goToOpportunity(
				"https://gehealthcare-amer--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DT00000UfGFZYA3/view");
		accessOpportunity.zoomOut();

		// create object of details page
		DetailsPage detailPage = new DetailsPage(driver);

		// Automation for step 3
		String step3 = detailPage.step3();
		softAssert.assertEquals(step3, input.get("expStep3"));

		// Automation for step 4
		String step4 = detailPage.step4();
		softAssert.assertEquals(step4, input.get("expStep4"));

		// Automation for step 5
		String step5 = detailPage.step5();
		softAssert.assertEquals(step5, input.get("expStep5"));

		// Automation for step 6
		String step6 = detailPage.step6();
		softAssert.assertEquals(step6, input.get("expStep6"));
	}

	// Tender Scenarios
	@Test(dependsOnMethods = { "stepAutomation" }, dataProvider = "getData")
	public void tenderStepAutomation(HashMap<String,String> input) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// check tender status to true and select ge bid decision
		DetailsPageTender detailsTender = new DetailsPageTender(driver);
		detailsTender.checkTenderTrue();

		// Tender automation step 4
		String step4t = detailsTender.step4t();
		softAssert.assertEquals(step4t, input.get("expStep4"));

		// Tender automation step 5
		String step5t = detailsTender.step5t();
		softAssert.assertEquals(step5t, input.get("expStep5"));

		// Tender automation step 5
		String step6t = detailsTender.step6t();
		softAssert.assertEquals(step6t, input.get("expStep6"));

		softAssert.assertAll();
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>>data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\sf2\\data\\Steps.json");	
		return new Object[][] {{data.get(0)}};
	}

}
