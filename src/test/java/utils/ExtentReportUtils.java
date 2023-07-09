package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;

	public static void generateReport(String browser, String testClassName) {
		String reportName = testClassName+"_"+browser+".html";
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/"+reportName);

		extentHtmlReporter.config().setDocumentTitle("Automation Report");
		extentHtmlReporter.config().setReportName(testClassName+" Report for "+browser);
		extentHtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extentHtmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

	}
}
