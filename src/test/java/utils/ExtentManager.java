package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
        	//storing the report in workspace by creating folder
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            //Mentioning the report
            
            spark.config().setReportName("Nebula QA Automation Report");
            //Report Title
            spark.config().setDocumentTitle("Patent Date Testing");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            //Providing additional information run and environment
            
            extent.setSystemInfo("Tester", "Kunal");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
