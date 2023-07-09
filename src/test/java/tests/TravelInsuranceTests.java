package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.TravelInsurancePage;
import utils.ExtentReportUtils;

public class TravelInsuranceTests extends BaseTest {

	private TravelInsurancePage travelInsurance;
	public static ExtentTest test;
//	public static ExtentReports extentReportsObj = ExtentReportUtils.extentReports;

	@BeforeMethod
	void setPage() {
		travelInsurance = new TravelInsurancePage(driver);
		new ExtentReportUtils();
	}

	@Test(priority = 1)
	public void testVisitPolicyBazaar() throws InterruptedException {
		try {
			travelInsurance.visitPolicyBazaar();
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.PASS, "Visited PolicyBazar");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.FAIL, "PolicyBazar not visited");
		}
	}

	@Test(priority = 2, dependsOnMethods = { "testVisitPolicyBazaar" })
	public void testClickTravelInsuranceLink() {
		try {
			travelInsurance.clickTravelInsuranceLink();
			test = ExtentReportUtils.extentReports.createTest("testClickTravelInsuranceLink",
					"Test Clicking Travel Insurance Link");
			test.log(Status.PASS, "CarInsurance Link visited");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testClickTravelInsuranceLink",
					"Test Clicking Travel Insurance Link");
			test.log(Status.FAIL, "CarInsurance Link not visited");
		}

	}

	@Test(priority = 3, dependsOnMethods = { "testClickTravelInsuranceLink" })
	public void testClickStudentTravelInsuranceLink() throws InterruptedException {
		try {
			travelInsurance.clickOnStudentTravelInsurance();
			test = ExtentReportUtils.extentReports.createTest("testClickStudentTravelInsuranceLink",
					"Test Clicking Student Travel Insurance Link");
			test.log(Status.PASS, "Student Travel Insurance Link visited");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testClickStudentTravelInsuranceLink",
					"Test Clicking Student Travel Insurance Link");
			test.log(Status.FAIL, "Student Travel Insurance Link not visited");
		}

	}

	@Test(priority = 4, dependsOnMethods = "testClickStudentTravelInsuranceLink")
	public void testSelectDestination() {
		try {
			travelInsurance.enterDestination();
			test = ExtentReportUtils.extentReports.createTest("testSelectDestination", "Test for selecting destination");
			test.log(Status.PASS, "Selected the destination");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectDestination", "Test for selecting destination");
			test.log(Status.FAIL, "Destination not selected");
		}

	}

	@Test(priority = 5, dependsOnMethods = "testSelectDestination")
	public void testChooseDates() throws InterruptedException {
		try {
			travelInsurance.chooseDate();
			test = ExtentReportUtils.extentReports.createTest("testChooseDates", "Test for choosing dates");
			test.log(Status.PASS, "Travel dates selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testChooseDates", "Test for choosing dates");
			test.log(Status.FAIL, "Travel dates are selected");
		}
	}

	@Test(priority = 6)
	public void testFillTravellerInfo() {
		try {
			travelInsurance.fillTravellerInfo();
			test = ExtentReportUtils.extentReports.createTest("testFillTravellerInfo", "Test for filling traveller info");
			test.log(Status.PASS, "Traveller info filled");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testFillTravellerInfo", "Test for filling traveller info");
			test.log(Status.FAIL, "Traveller info not filled");
		}

	}

	@Test(priority = 7)
	public void testChooseHealthInfo() {
		try {
			travelInsurance.chooseHealthInfo();
			test = ExtentReportUtils.extentReports.createTest("testChooseHealthInfo", "Test for choosing health info");
			test.log(Status.PASS, "Health info filled");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testChooseHealthInfo", "Test for choosing health info");
			test.log(Status.FAIL, "Health info not filled");
		}

	}

	@Test(priority = 8)
	public void testFillContactInfo() {
		try {
			travelInsurance.fillContactInfo();
			test = ExtentReportUtils.extentReports.createTest("testFillContactInfo", "Test for filling contact info");
			test.log(Status.PASS, "Contact info filled");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testFillContactInfo", "Test for filling contact info");
			test.log(Status.FAIL, "Contact info not filled");
		}

	}

	@Test(priority = 9)
	public void testSortPrices() {
		try {
			travelInsurance.sortPrices();
			test = ExtentReportUtils.extentReports.createTest("testSortPrices", "Test for sorting the prices");
			test.log(Status.PASS, "Sorted the prices");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSortPrices", "Test for sorting the prices");
			test.log(Status.FAIL, "Prices cannot be sorted");
		}

	}

	@Test(priority = 10)
	public void takescreenshot() throws IOException, InterruptedException {
		System.out.println("---Taking Screenshot---");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String testClassName = this.getClass().getName();
		testClassName = testClassName.substring(6, testClassName.length()) + ".png";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/ScreenShots/" + testClassName));
		Thread.sleep(1000);
	}

	@Test(priority = 11)
	public void printLowestPrices() throws Exception {
		try {
			travelInsurance.getLowestPrices();
			test = ExtentReportUtils.extentReports.createTest("printLowestPrices", "Test for printing the lowest price");
			test.log(Status.PASS, "lowest prices are printed");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("printLowestPrices", "Test for printing the lowest price");
			test.log(Status.FAIL, "lowest prices are not printed");
		}

	}

}
