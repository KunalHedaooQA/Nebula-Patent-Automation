

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize driver and wait
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Method to handle cookie popups 
    public void acceptCookiesIfPresent() {
        try {
            WebElement AgreeButton = driver.findElement(By.xpath("//button[contains(text(),'Accept') or contains(text(),'Agree')]"));
            AgreeButton.click();
        } catch (Exception cookieAgree) {
            // Ignores it if not visible
        }

        try {
            WebElement ButtonOk = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
            ButtonOk.click();
        } catch (Exception OkButton) {
            // Ignores it if not visible
        }

    }

    // Perform the search action and click the disclaimer agree buuton
    public void searchPatent(String keyword) {
        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
            searchBox.sendKeys(keyword);

            // Wait for and click the green button
            WebElement greenButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='green']")));
            greenButton.click();

        } catch (Exception Disclaimer) {
            System.out.println("Error during search: " + Disclaimer.getMessage());
        }
    }
}
