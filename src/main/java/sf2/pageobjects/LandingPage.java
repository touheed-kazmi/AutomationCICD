package sf2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sf2.AbstractComponents.AbstarctComponent;

public class LandingPage extends AbstarctComponent {

	WebDriver driver;

	// constructor to initialize driver
	//Page factory initelements to initialize driver in PageFactory 
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.id("username"));

	// PageFactory - same as above simplified syntax
	@FindBy(id = "username")
	WebElement userEmail;
	
	@FindBy(id = "password")
	WebElement userpassword;
	
	@FindBy(css = "#Login")
	WebElement login;
	
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		login.click();
	}
	
	public void goTo() {
		driver.get("https://test.salesforce.com/");
		
		
	}


}
