package sf2.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sf2.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public WebDriver initializeDriver() throws IOException {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\sf2\\resources\\GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900)); //full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// convert to hashmap

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@AfterTest(alwaysRun = true)
	public void closeDriver() {
		driver.close();
	}

//	public LandingPage launchApplication() throws IOException {
//
//		driver = initializeDriver();
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.goTo();
//		return landingPage;
//	}
}
