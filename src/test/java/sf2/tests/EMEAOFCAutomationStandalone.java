package sf2.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class EMEAOFCAutomationStandalone {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));

		// login to salesforce
		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("touheed.kazmi@gehc.amer.uat");
		driver.findElement(By.id("password")).sendKeys("uat@1996");
		driver.findElement(By.id("Login")).click();

		// navigate to test opportunity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
		driver.navigate().to(
				"https://gehealthcare-amer--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DT00000UfGFZYA3/view");

		// set zoom
		Robot robot = new Robot();

		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}

		// wait for probability fields to appear
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@title='Edit Probability to Order by EOD']")));

		// EOD - 0, GE - 0
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='0']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[7]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc1 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Unqualified']")).getText();
		System.out.println(ofc1);
		softAssert.assertEquals(ofc1, "Unqualified");
		
		// EOD - 0, GE - 100
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='0']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[2]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc2 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Open']")).getText();
		System.out.println(ofc2);
		softAssert.assertEquals(ofc2, "Open");

		// EOD - 20, GE - 0
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='20']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[7]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc3 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Not addressable']")).getText();
		System.out.println(ofc3);
		softAssert.assertEquals(ofc3, "Not addressable");

		// EOD - 20 , GE - 80
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='20']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[3]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc4 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Open']")).getText();
		System.out.println(ofc4);
		softAssert.assertEquals(ofc4, "Open");

		// EOD - 40, GE - 60
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='40']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[4]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc5 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Open']")).getText();
		System.out.println(ofc5);
		softAssert.assertEquals(ofc5, "Open");
		
		// EOD - 40, GE - 80
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='40']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[3]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc6 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Upside']")).getText();
		System.out.println(ofc6);
		softAssert.assertEquals(ofc6, "Upside");

		// EOD - 60, GE - 60
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='60']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[4]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc7 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Upside']")).getText();
		System.out.println(ofc7);
		softAssert.assertEquals(ofc7, "Upside");

		// EOD - 60, GE - 80
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='60']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[3]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc8 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Committed w/risk']")).getText();
		System.out.println(ofc8);
		softAssert.assertEquals(ofc8, "Committed w/risk");

		// EOD - 80, GE - 20
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='80']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[6]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc9 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Open']")).getText();
		System.out.println(ofc9);
		softAssert.assertEquals(ofc9, "Open");

		// EOD - 80, GE - 80
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='80']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[3]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc10 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Committed']")).getText();
		System.out.println(ofc10);
		softAssert.assertEquals(ofc10, "Committed");

		// EOD - 100, GE - 60
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='100']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[4]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc11 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Committed w/risk']")).getText();
		System.out.println(ofc11);
		softAssert.assertEquals(ofc11, "Committed w/risk");

		// EOD - 100, GE - 80
		driver.findElement(By.xpath("//button[@title='Edit Probability to Order by EOD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order by EOD']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='100']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Probability to Order from GE']")).click();
		driver.findElement(
				By.xpath("//div[@aria-label='Probability to Order from GE']//lightning-base-combobox-item[3]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order Forecast Category']")));

		String ofc12 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Committed']")).getText();
		System.out.println(ofc12);
		softAssert.assertEquals(ofc12, "Committed");
		
		softAssert.assertAll();

	}

}
