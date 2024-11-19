package sf2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sf2.AbstractComponents.AbstarctComponent;

public class DetailsPageTender extends AbstarctComponent {

	WebDriver driver;

	// constructor to initialize driver
	// Page factory initelements to initialize driver in PageFactory
	public DetailsPageTender(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By stepVisibleOnDetail = By.xpath("//label[text()='Opportunity Step']");
	By TenderStatusVisibleOnDetail = By.xpath("//label[text()='Tender Status']");

	@FindBy(xpath = "//button[@title='Edit Tender Opportunity']")
	WebElement EditTenderOpty;
	
	@FindBy(xpath = "//button[@aria-label='Tender Status']")
	WebElement ddTenderStatus;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Announced']")
	WebElement announced;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Submitted']")
	WebElement submitted;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Awarded']")
	WebElement awarded;

	@FindBy(xpath = "//lightning-formatted-text[text()='4. Develop Sponsorship']")
	WebElement resultStep4;

	@FindBy(xpath = "//lightning-formatted-text[text()='5. Validate Solution']")
	WebElement resultStep5;

	@FindBy(xpath = "//lightning-formatted-text[text()='6. Negotiate & Close']")
	WebElement resultStep6;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;

	public void checkTenderTrue() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Tender Opportunity']"))).click()
				.build().perform();
		driver.findElement(By.xpath("//input[@name='Tender_Opportunity__c']")).click();
		driver.findElement(By.xpath("//button[@aria-label='GE Bid Decision']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Cancelled']")).click();
		driver.findElement(By.xpath("//input[@name='Tender_Due_Date__c']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Tender_Due_Date__c']")).sendKeys("11/5/2024");
	}

	public String step4t() throws InterruptedException {

		waitForElementToAppear(TenderStatusVisibleOnDetail);
		
		ddTenderStatus.click();
		announced.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step4t = resultStep4.getText();
		return step4t;

	}

	public String step5t() throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.moveToElement(EditTenderOpty).click().build().perform();
		waitForElementToAppear(TenderStatusVisibleOnDetail);
		ddTenderStatus.click();
		submitted.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step5t = resultStep5.getText();
		return step5t;

	}
	
	public String step6t() throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.moveToElement(EditTenderOpty).click().build().perform();
		waitForElementToAppear(TenderStatusVisibleOnDetail);	
		ddTenderStatus.click();
		awarded.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step6t = resultStep6.getText();
		return step6t;

	}

}
