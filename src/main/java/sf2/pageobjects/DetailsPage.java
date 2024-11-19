package sf2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sf2.AbstractComponents.AbstarctComponent;

public class DetailsPage extends AbstarctComponent {

	WebDriver driver;

	// constructor to initialize driver
	// Page factory initelements to initialize driver in PageFactory
	public DetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By editBudgetButtonVisible = By.xpath("//button[@title='Edit Budget Funding Status']");
	By stepVisibleOnDetail = By.xpath("//label[text()='Opportunity Step']");

	@FindBy(xpath = "//button[@title='Edit Budget Funding Status']")
	WebElement editBudgetClick;
	
	@FindBy(xpath = "//button[@aria-label='Probability to Order by EOD']")
	WebElement ddEodClick;

	@FindBy(xpath = "//button[@aria-label='Budget Funding Status']")
	WebElement ddBudgetClick;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='60']")
	WebElement Eod60;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='80']")
	WebElement Eod80;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Budget not yet requested']")
	WebElement budgetNotYetRequested;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Budget requested, not yet approved']")
	WebElement budgetRequestedNotYetApproved;
	
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Budget approved']")
	WebElement budgetApproved;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;

	@FindBy(xpath = "//lightning-formatted-text[text()='3. Build Strategy/Solution']")
	WebElement resultStep3;
	
	@FindBy(xpath = "//lightning-formatted-text[text()='4. Develop Sponsorship']")
	WebElement resultStep4;
	
	@FindBy(xpath = "//lightning-formatted-text[text()='5. Validate Solution']")
	WebElement resultStep5;
	
	@FindBy(xpath = "//lightning-formatted-text[text()='6. Negotiate & Close']")
	WebElement resultStep6;
	

	public String step3() throws InterruptedException {
		Actions actions = new Actions(driver);
		waitForElementToAppear(editBudgetButtonVisible);
		actions.moveToElement(editBudgetClick).click().build().perform();
		Thread.sleep(3000);
		ddBudgetClick.click();
		budgetNotYetRequested.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step3 = resultStep3.getText();
		return step3;

	}
	
	public String step4() throws InterruptedException {
		Actions actions = new Actions(driver);
		waitForElementToAppear(editBudgetButtonVisible);
		actions.moveToElement(editBudgetClick).click().build().perform();
		Thread.sleep(3000);
		ddBudgetClick.click();
		budgetRequestedNotYetApproved.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step4 = resultStep4.getText();
		return step4;
		
	}
	
	public String step5() throws InterruptedException {
		Actions actions = new Actions(driver);
		waitForElementToAppear(editBudgetButtonVisible);
		actions.moveToElement(editBudgetClick).click().build().perform();
		Thread.sleep(3000);
		ddBudgetClick.click();
		budgetApproved.click();
		Thread.sleep(2000);
		ddEodClick.click();
		Eod60.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step5 = resultStep5.getText();
		return step5;	
	}
	
	public String step6() throws InterruptedException {
		Actions actions = new Actions(driver);
		waitForElementToAppear(editBudgetButtonVisible);
		actions.moveToElement(editBudgetClick).click().build().perform();
		Thread.sleep(3000);
		ddBudgetClick.click();
		budgetApproved.click();
		Thread.sleep(2000);
		ddEodClick.click();
		Eod80.click();
		save.click();
		waitForElementToAppear(stepVisibleOnDetail);
		String step6 = resultStep6.getText();
		return step6;	
	}
	
	

}
