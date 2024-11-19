package sf2.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class StepAutomationStandalone {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		SoftAssert softAssert = new SoftAssert();
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		
		String tenderDate = "11/5/2024";

		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();

		// login to salesforce org
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("touheed.kazmi@gehc.amer.uat");
		driver.findElement(By.id("password")).sendKeys("uat@1996");
		driver.findElement(By.cssSelector("#Login")).click();

		// access the opportunity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Home']")));
		driver.navigate().to(
				"https://gehealthcare-amer--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DT00000UfGFZYA3/view");

		// zoom out
		Thread.sleep(2000);
		Robot robot = new Robot();

		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}

		// edit budget funding status LOV

		// Budget not yet requested - for step 3
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Budget Funding Status']")));
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Budget Funding Status']"))).click()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Budget Funding Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Budget not yet requested']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step3 = driver.findElement(By.xpath("//lightning-formatted-text[text()='3. Build Strategy/Solution']"))
				.getText();
		softAssert.assertEquals(step3, "3. Build Strategy/Solution");

		// Budget not yet requested - for step 4
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Budget Funding Status']")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Budget Funding Status']"))).click()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Budget Funding Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Budget requested, not yet approved']"))
				.click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step4 = driver.findElement(By.xpath("//lightning-formatted-text[text()='4. Develop Sponsorship']"))
				.getText();
		softAssert.assertEquals(step4, "4. Develop Sponsorship");

		// Budget not yet requested - for step 5
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Budget Funding Status']")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Budget Funding Status']"))).click()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Budget Funding Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Budget approved']")).click();

		// EOD as 60
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='60']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step5 = driver.findElement(By.xpath("//lightning-formatted-text[text()='5. Validate Solution']"))
				.getText();
		softAssert.assertEquals(step5, "5. Validate Solution");

		softAssert.assertAll();

		// Budget not yet requested - for step 6
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Budget Funding Status']")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Budget Funding Status']"))).click()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Budget Funding Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Budget approved']")).click();

		// EOD as 80
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='80']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step6 = driver.findElement(By.xpath("//lightning-formatted-text[text()='6. Negotiate & Close']"))
				.getText();
		softAssert.assertEquals(step6, "6. Negotiate & Close");

		// Tender Scenarios
		// check tender status to true and select ge bid decision
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Tender Opportunity']"))).click()
				.build().perform();
		driver.findElement(By.xpath("//input[@name='Tender_Opportunity__c']")).click();
		driver.findElement(By.xpath("//button[@aria-label='GE Bid Decision']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Cancelled']")).click();
		driver.findElement(By.xpath("//input[@name='Tender_Due_Date__c']")).sendKeys(tenderDate);
		
		
		// for step 4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Tender Status']")));
		driver.findElement(By.xpath("//button[@aria-label='Tender Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Announced']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step4t = driver.findElement(By.xpath("//lightning-formatted-text[text()='4. Develop Sponsorship']"))
				.getText();
		softAssert.assertEquals(step4t, "4. Develop Sponsorship");
		
		//for step 5
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Tender Opportunity']")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Tender Opportunity']"))).click()
				.build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Tender Status']")));
		driver.findElement(By.xpath("//button[@aria-label='Tender Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Submitted']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step5t = driver.findElement(By.xpath("//lightning-formatted-text[text()='5. Validate Solution']"))
				.getText();
		softAssert.assertEquals(step5t, "5. Validate Solution");
		
		//for step 6
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Tender Opportunity']")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Tender Opportunity']"))).click()
				.build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Tender Status']")));
		driver.findElement(By.xpath("//button[@aria-label='Tender Status']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Awarded']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Step']")));
		String step6t = driver.findElement(By.xpath("//lightning-formatted-text[text()='6. Negotiate & Close']"))
				.getText();
		softAssert.assertEquals(step6t, "6. Negotiate & Close");
		

		softAssert.assertAll();

	}

}
