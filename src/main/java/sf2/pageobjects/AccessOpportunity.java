package sf2.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sf2.AbstractComponents.AbstarctComponent;

public class AccessOpportunity extends AbstarctComponent {

	WebDriver driver;

	// constructor to initialize driver
	// Page factory initelements to initialize driver in PageFactory
	public AccessOpportunity(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By home = By.xpath("//a[@title='Home']");

	public void goToOpportunity(String link) {

		waitForElementToAppear(home);
		driver.navigate().to(link);

	}

	public void zoomOut() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot robot = new Robot();

		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}

	}

}
