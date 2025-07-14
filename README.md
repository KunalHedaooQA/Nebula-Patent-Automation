# This project automates the extraction and calculation of date differences (Filing Date, Publication Date, and Grant Date) from patent details on the (https://patinformed.wipo.int/) Nebula QA Automation Challenge.

Obejctive 1)Navigate to URL(Incognito mode) 
2)Type any keyword in seach box and click on seearch icon . 
3)One popupwill appear for Disclaimer in which need to appect it. 
4)As well as need to accept the cookiees if any populate 
5)From the enter "keyword" the first result need to be clicked.
 6)After clicking the result at the right side table will appear which will have the "Filing Date, Publication Date, and Grant Date" 
7)Dynamically traverse through the table which hav all this three details and grab the dates and print in the below manner. ****** Publication date: 2024-06-19****** Grant date: 2025-01-20 Filing date: 2025-03-11 Difference between Publication date and Grant date are 180 days. Difference between Publication date and Filing date are 80 days. Difference between Grant date and Filing date are 480 days 
8)Keywords are not hardcoded

Tools Used 1)Java
 2)Seleniium Webdriver
 3)Testng Framework 
4)POM
 5)Extend Report 
6)Eclipse IDE 
7)Maven

Project Structure 
1)src\main\java-->Pages(HomePage,PatentDetailPage,ResultPage) 
2)src\test\java-->test,utils tests-->NebulaPatentDateTest utils-->BaseTest,ExtentManager 
3)Maven Dependenies 
4)src 
5)target
 6)test-output 
7)pom.xml
 8)ReadMe 
9)testng.xml

To Run the Script 
1)NebulaPatentDateTest 
a)Right Click on the file. 
b)RunsAS-->Maven Built

2)testng.xml
 a)Right Click on the file. 
b)RunsAS-->Run Configuration 
c)Pop Window will appear Goal-->test Parameter Parameter name-search value-paracetamol
 d)Click Run

Thank You