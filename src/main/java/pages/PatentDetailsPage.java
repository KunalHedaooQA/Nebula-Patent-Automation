package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PatentDetailsPage {

    private WebDriver driver;

    public PatentDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if the "No results" element is present
    public boolean isNoResultFound() {
        try {
            WebElement noResult = driver.findElement(By.xpath("//div[@class='card noResult flex center-v']//span"));
            return noResult.isDisplayed();   
        } catch (Exception e) {
            return false; // No such element — which is expected for valid results
        }
    }

    // Clean and parse a raw date string like "2025-07-14 (18 years ago)"
    private LocalDate parseDate(String rawDate) {
        try {
            String cleanDate = rawDate.replaceAll("\\(.*?\\)", "").trim(); 
            return LocalDate.parse(cleanDate); 
        } catch (Exception e) {
            return null;
        }
    }

    
    // Dynamically find date by label
    
    private LocalDate findDateByLabel(String label) {
        try {
            List<WebElement> tables = driver.findElements(By.xpath("(//table[@class='patentDetails noBorder'])"));
            for (WebElement table : tables) 
            {
                List<WebElement> rows = table.findElements(By.tagName("tr"));
                for (WebElement row : rows) 
                {
                    List<WebElement> cols = row.findElements(By.tagName("td"));
                    if (cols.size() >= 2)
                    {
                        String labelText = cols.get(0).getText().trim().toLowerCase();
                        if (labelText.contains(label.toLowerCase())) {
                            return parseDate(cols.get(1).getText());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error locating date for label: " + label);
        }
        return null;
    }

    // Extract and print date differences
    
    public void PrintDateDifferences() {
        // First check if there are any results
        if (isNoResultFound()) {
            System.out.println(" No search results found.");
            
            return;
        }

        // Proceed only if result is found
        LocalDate publicationDate = findDateByLabel("publication date");
        LocalDate grantDate = findDateByLabel("grant date");
        LocalDate filingDate = findDateByLabel("filing date");

        
        //Printing the output as accepted
        
        System.out.println("\n**** Patent Date Details ****");

        if (publicationDate != null)
        {
            System.out.println("Publication date: " + publicationDate);
        }
        if (grantDate != null)
        {
            System.out.println("Grant date: " + grantDate);
        }
        if (filingDate != null)
        {
            System.out.println("Filing date: " + filingDate);
        }
        System.out.println();

        if (publicationDate != null && grantDate != null) 
        {
            System.out.println("Difference between Publication date and Grant date are " +
                    ChronoUnit.DAYS.between(publicationDate, grantDate) + " days");
        }
        if (publicationDate != null && filingDate != null)
        	
        {  System.out.println("Difference between Publication date and Filing date are " +
                    ChronoUnit.DAYS.between(filingDate, publicationDate) + " days");
        }
        if (grantDate != null && filingDate != null)
        	
        {  System.out.println("Difference between Grant date and Filing date are " +
                    ChronoUnit.DAYS.between(filingDate, grantDate) + " days");
        }
    }
}
