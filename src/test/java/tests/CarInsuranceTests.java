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
import pages.CarInsurancePage;
import utils.ExtentReportUtils;

public class CarInsuranceTests extends BaseTest {

	private CarInsurancePage carInsurancePage;
	// helps to generate the logs in the test report.
	public static ExtentTest test;
//	public static ExtentReports extentReportsObj;

	@BeforeMethod
	void setPage(Method method) {
		carInsurancePage = new CarInsurancePage(driver);
		new ExtentReportUtils();
	}

	@Test(priority = 1)
	public void testVisitPolicyBazaar() {
		try {
			carInsurancePage.visitPolicyBazaar();
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.PASS, "Visited PolicyBazar");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testVisitPolicyBazaar", "Test for Visiting Policybazar");
			test.log(Status.FAIL, "PolicyBazar not visited");
		}
	}

	@Test(priority = 2, dependsOnMethods = "testVisitPolicyBazaar")
	public void testClickCarInsuranceLink() {
		try {
			carInsurancePage.clickCarInsuranceLink();
			test = ExtentReportUtils.extentReports.createTest("testClickCarInsuranceLink",
					"Test for Clicking Car Insurance Link");
			test.log(Status.PASS, "CarInsurance Link clicked");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testClickCarInsuranceLink",
					"Test for Clicking Car Insurance Link");
			test.log(Status.FAIL, "CarInsurance Link not clicked");
		}

	}

	@Test(priority = 3, dependsOnMethods = "testClickCarInsuranceLink")
	public void testProceedWithoutCarNo() {
		try {
			carInsurancePage.proceedWithoutCarNumber();
			test = ExtentReportUtils.extentReports.createTest("testProceedWithoutCarNo",
					"Test for Proceed without car number");
			test.log(Status.PASS, "Successfully Proceed without Car Number");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testProceedWithoutCarNo",
					"Test for Proceed without car number");
			test.log(Status.FAIL, "Cannot Proceed without Car Number");
		}

	}

	@Test(priority = 4, dependsOnMethods = "testProceedWithoutCarNo")
	public void testSelectCityName() {
		try {
			carInsurancePage.selectCity();
			test = ExtentReportUtils.extentReports.createTest("testSelectCityName", "Test for Select City name");
			test.log(Status.PASS, "City Name selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectCityName", "Test for Select City name");
			test.log(Status.FAIL, "City Name not selected");
		}

	}

	@Test(priority = 5, dependsOnMethods = "testSelectCityName")
	public void testSelectDL1No() {
		try {
			carInsurancePage.selectDL1();
			test = ExtentReportUtils.extentReports.createTest("testSelectDL1No", "Test for Select DL1");
			test.log(Status.PASS, "DL1 selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectDL1No", "Test for Select DL1");
			test.log(Status.FAIL, "DL1 not selected");
		}

	}

	@Test(priority = 6, dependsOnMethods = "testSelectDL1No")
	public void testSelectCarBrand() {
		try {
			carInsurancePage.selectCarBrand();
			test = ExtentReportUtils.extentReports.createTest("testSelectCarBrand", "Test for Selectig Car Brand");
			test.log(Status.PASS, "Car Brand selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectCarBrand", "Test for Selectig Car Brand");
			test.log(Status.FAIL, "Car Brand not selected");
		}

	}

	@Test(priority = 7, dependsOnMethods = "testSelectCarBrand")
	public void testSelectCarModel() {
		try {
			carInsurancePage.selectCarModel();
			test = ExtentReportUtils.extentReports.createTest("testSelectCarModel", "Test for Selectig Car Model");
			test.log(Status.PASS, "Car Model selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectCarModel", "Test for Selectig Car Model");
			test.log(Status.FAIL, "Car Model not selected");
		}

	}

	@Test(priority = 8, dependsOnMethods = "testSelectCarModel")
	public void testSelectFuelType() {
		try {
			carInsurancePage.selectFuelType();
			test = ExtentReportUtils.extentReports.createTest("testSelectFuelType", "Test for Selecting Fuel Type");
			test.log(Status.PASS, "Fuel Type selected");
		} catch (Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectFuelType", "Test for Selecting Fuel Type");
			test.log(Status.FAIL, "Fuel Type not selected");
		}

	}

	@Test(priority = 9, dependsOnMethods = "testSelectFuelType")
	public void testSelectVariantType() throws InterruptedException {
		try {
			carInsurancePage.selectVariant();
			test = ExtentReportUtils.extentReports.createTest("testSelectVariantType", "Test for Selecting Variant Type");
			test.log(Status.PASS, "Variant Type selected");
		}catch(Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectVariantType", "Test for Selecting Variant Type");
			test.log(Status.FAIL, "Variant Type not selected");
		}

	}

	@Test(priority = 10, dependsOnMethods = "testSelectVariantType")
	public void testSelectRegistrationYear() {
		try {
			carInsurancePage.selectRegistrationYear();
			test = ExtentReportUtils.extentReports.createTest("testSelectRegistrationYear",
					"Test for Selecting Registration year");
			test.log(Status.PASS, "Registration year selected");
		}catch(Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testSelectRegistrationYear",
					"Test for Selecting Registration year");
			test.log(Status.FAIL, "Registration year not selected");
		}

	}

	@Test(priority = 11, dependsOnMethods = "testSelectRegistrationYear")
	public void testFillPersonalInfo() {
		try {
			carInsurancePage.inputName();
			carInsurancePage.inputEmail();
			carInsurancePage.inputPhoneNo();
			test = ExtentReportUtils.extentReports.createTest("testFillPersonalInfo", "Test for Filling Personal Info");
			test.log(Status.PASS, "Personal details filled");
		}catch(Exception e) {
			test = ExtentReportUtils.extentReports.createTest("testFillPersonalInfo", "Test for Filling Personal Info");
			test.log(Status.FAIL, "Cannot fill Personal details");
		}

	}

	@Test(priority = 12)
	public void takescreenshot() throws IOException, InterruptedException {
		System.out.println("---Taking Screenshot---");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String testClassName = this.getClass().getName();
		testClassName = testClassName.substring(6, testClassName.length()) + ".png";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/ScreenShots/" + testClassName));
		Thread.sleep(1000);
	}

}