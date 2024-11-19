package sf2.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class EMEACreateOpportunityPageFieldsStandAlone {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		SoftAssert softAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(55));

		// login to salesforce
		driver.get("https://test.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("touheed.kazmi@gehc.amer.uat");
		driver.findElement(By.id("password")).sendKeys("uat@1996");
		driver.findElement(By.id("Login")).click();
		
		/*

		// Account tab - opty grid
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Accounts']")));
		driver.navigate().to(
				"https://gehealthcare-amer--uat.sandbox.lightning.force.com/lightning/r/Account/001a000001cqGe2AAE/view");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Click here')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
		Thread.sleep(50000);
		driver.findElement(By.xpath("//lightning-icon[contains(@class,'slds-icon-utility-add slds-icon_container')]"))
				.click();
		driver.findElement(By.xpath("//button[@name='Opportunity']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='Budget Funding Status']")));

		// check the fields present on create record
		String fields[] = { "", "Opportunities", "globalsearch", "Expand", "*Name", "*Account Name", "Secondary Owner",
				"*Opportunity Currency", "*Opportunity Step", "*Opportunity Socket Type", "*Order Forecast Category",
				"Competitor Owning IB", "*Sales Forecast Category", "Primary Contact", "Search Record",
				"*Estimated Order Date", "Parent Opportunity", "*Estimated Sales Date", "Competitor", "Global Region",
				"Probability to Order by EOD", "Probability to Order from GE", "Budget Funding Status", "Parent",
				"Ultimate Parent"};
		ArrayList<String> expFields = new ArrayList<String>();
		expFields.addAll(Arrays.asList(fields));
		System.out.println(expFields);

		List<WebElement> createRecordFields = driver.findElements(By.tagName("label"));

		ArrayList<String> arFields = new ArrayList<String>();
		for (WebElement field : createRecordFields) {
			arFields.add(field.getText());
		}
		System.out.println(arFields);
		System.out.println(arFields.size());
		
		softAssert.assertEquals(arFields, expFields);
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("//lightning-icon[@icon-name='utility:close']")).click();
		
		*/
		
		//check from IBGS create opportunity flow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='IB Global Search']")));
		driver.findElement(By.xpath("//a[.='IB Global Search']")).click();
		Thread.sleep(30000);
		
		Robot robot = new Robot();

		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
		
		
		driver.findElement(By.xpath("//button[.='Search']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='checkbox-9460']//span[@class='slds-checkbox_faux']")));
		driver.findElement(By.xpath("//label[@for='checkbox-9460']//span[@class='slds-checkbox_faux']")).click();
		
		
		
		
		
		
		
		softAssert.assertAll();

	}

}
