package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.ConfigReader;
import utils.ExtentReportUtils;

public class BaseClass {
	protected static WebDriver driver;
	protected String browserName;


	@Parameters("browser")
    @BeforeClass
	public void initDriver(@Optional("chrome") String browser) {
		browserName = browser;
		if (browser.equalsIgnoreCase("chrome")) {

//			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\2266897\\Documents\\chromedrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name provided!");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.policybazaar.com");
	}

	@BeforeClass
	public void initProperties() {
//		System.out.println(browserName);
		ConfigReader.property();

	}

	@Parameters("browser")
	@BeforeClass
	public void initExtentReport(String browser) {
//		System.out.println(browser);
		String testClassName = this.getClass().getName();
		testClassName = testClassName.substring(6, testClassName.length());
		ExtentReportUtils.generateReport(browser, testClassName);
	}

	@AfterClass
	public void closeReport() {
		//to write or update test information to reporter
		ExtentReportUtils.extentReports.flush();
	}

	@AfterClass
    public void tearDown() {

		driver.quit();
//		if (driver != null) {
//            driver.quit();
//        }
    }



}
