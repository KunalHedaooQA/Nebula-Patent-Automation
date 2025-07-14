package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;
import pages.PatentDetailsPage;
import utils.BaseTest;

public class NebulaPatentDateTest extends BaseTest {

    
    //  keyword from DataProvider
 //   @Test(dataProvider = "searchKeywords",dataProviderClass = utils.BaseTest.class)
    
  //  public void testDateDifferences(String keyword) {

    //    test = extent.createTest("Patent Date Difference Test - " + keyword);

        // Optional: log in console
     //   System.out.println("search keyword: " + keyword);
	
	 @Test
	    public void testDateDifferences() {

	        // Create Extent report entry using keyword from BaseTest
	        test = extent.createTest("Patent Date Difference Test - " + searchKeyword);

	        //  Log to console and report
	        System.out.println(" Search keyword: " + searchKeyword);
	        test.info("Search keyword used: " + searchKeyword);


        // Step 1: Navigate and search using keyword
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookiesIfPresent();
        homePage.searchPatent(searchKeyword);
      //  test.info("Search keyword used: " + keyword); 

        // Step 2: Click first result
        ResultPage resultPage = new ResultPage(driver);
        resultPage.clickFirstData();
        test.info("Clicked First result data");

        // Step 3: Extract dates and calculate differences
        PatentDetailsPage detailsPage = new PatentDetailsPage(driver);
        detailsPage.PrintDateDifferences();
        test.info("Date difference calculated");
    }
}
