// ResultPage.java

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize driver and wait
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click the first data result title
    public void clickFirstData() {
        try {
            // Wait until the first data appears in the result table
        	WebElement firstData = wait.until(
        		    ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='results'])//ul"))
        		);


            // Click the first data link
        	firstData.click();

        } catch (Exception firstData) {
            System.out.println("Unable to click the first patent title: " + firstData.getMessage());
        }
    }
}
