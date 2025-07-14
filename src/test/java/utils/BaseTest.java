package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    protected String searchKeyword;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
        System.out.println(" Extent report initialized.");
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent report flushed and saved.");
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://patinformed.wipo.int/");

        //  Get search keyword from command-line argument
        searchKeyword = System.getProperty("search");
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            throw new RuntimeException(" No search keyword provided.");
        }

        System.out.println(" Using search keyword: " + searchKeyword);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
