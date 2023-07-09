package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.HealthInsurancePage;
import utils.ExtentReportUtils;

public class HealthInsuranceTests extends BaseTest {

	private HealthInsurancePage healthInsurancePage;
	public static ExtentTest test;
//	public static ExtentReports extentReportsObj;

	@BeforeMethod
	void setPage(Method method) {
		healthInsurancePage = new HealthInsurancePage(driver);
		new ExtentReportUtils();
	}

	@Test(priority = 1)
	public void testVisitPolicyBazaar() throws InterruptedException {
		try {
			healthInsurancePage.visitPolicyBazaar();
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.PASS, "Visited PolicyBazar");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.FAIL, "PolicyBazar not visited");
		}

	}

	@Test(priority = 2, dependsOnMethods = "testVisitPolicyBazaar")
	public void testGetHealthInsuranceList() throws Exception {
		try {
			healthInsurancePage.getHealthInsuranceList();
			test = ExtentReportUtils.extentReports.createTest("testGetHealthInsuranceList",
					"Test for getting Health Insurance List");
			test.log(Status.PASS, "Health Insurance List found");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testGetHealthInsuranceList",
					"Test for getting Health Insurance List");
			test.log(Status.FAIL, "Health Insurance List not found");
		}

	}

	@Test(priority = 3)
	public void takescreenshot() throws IOException, InterruptedException {
		System.out.println("---Taking Screenshot---");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String testClassName = this.getClass().getName();
		testClassName = testClassName.substring(6, testClassName.length()) + ".png";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/ScreenShots/" + testClassName));
		Thread.sleep(1000);
	}

}
