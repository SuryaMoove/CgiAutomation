import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HomePageWithLogs extends Reporter{
        private final static String driverPath = "C:\\Users\\surya\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        private final static String homePageUrl = "http://www.cgi.com/canada/en-ca/cgi-toronto";

        HomePage homePage;
        WebDriver driver;
        WebDriverWait wait;
        static ExtentTest test;

        @BeforeTest
        private static void report(){
        test = reports.startTest("Home Page Test");
        test.log(LogStatus.INFO, "Home Page Test Started");
        }

        @BeforeMethod
        void setUp(){
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            driver = new ChromeDriver();

            driver.get(homePageUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            homePage = new HomePage(driver);
        }

        @Test(priority = 0)
        void verifyLogoLink() {
            test = reports.startTest("Logo Link Test Started");

            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkLogo));

            homePage.lnkLogo.click();
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.cgi.com/canada/en-ca";

            try {
                Assert.assertEquals(currentUrl, expectedUrl);
                test.log(LogStatus.PASS, "'Home' page redirects to 'Logo' link page!");
            } catch (AssertionError e) {
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

        @Test(priority = 1)
        void verifySearchButton() throws InterruptedException {
            test = reports.startTest("Search Button Test Started");

            wait.until(ExpectedConditions.elementToBeClickable(homePage.btnSearch));
            homePage.btnSearch.click();

            wait.until(ExpectedConditions.visibilityOf(homePage.txtBox));
            homePage.txtBox.sendKeys("QA Tester");

            WebElement searchCloseButton =  wait.until(ExpectedConditions.elementToBeClickable(homePage.btnSearchClose));
            homePage.btnSearchClose.click();

            try{
               Assert.assertNotNull(searchCloseButton);
               test.log(LogStatus.PASS,"Search Functionality Test Passed!");
           } catch(AssertionError e){
               test.log(LogStatus.FAIL, e.getMessage());
           }
        }

        @Test(priority = 2)
        void verifyHamburgerButton(){
            test = reports.startTest("Hamburger Button Test Started");

            WebElement hamburgerButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.btnHamburger));
            homePage.btnHamburger.click();
            try{
                Assert.assertNotNull(hamburgerButton);
                test.log(LogStatus.PASS,"Hamburger Button Test Passed!");
            } catch(AssertionError e){
                test.log(LogStatus.FAIL,e.getMessage());
            }
        }

        @Test(priority = 3)
        void verifyCanadaLink(){
            test = reports.startTest("'Canada' Link Test Started");
            homePage.btnHamburger.click();

            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkCanada));
            homePage.lnkCanada.click();

            homePage.dialogBox.isDisplayed();

            WebElement dialogCloseButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.btnDialogClose));
            homePage.btnDialogClose.click();

            try{
                Assert.assertNotNull(dialogCloseButton);
                test.log(LogStatus.PASS, "'Canada' Link Functionality Test Passed!");
            } catch(AssertionError e){
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

        @Test(priority = 4)
        void verifyServicesLink(){
            test = reports.startTest("'Services' Link Functionality Test Started");
            homePage.btnHamburger.click();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkServices));
            homePage.lnkServices.click();

            homePage.listServices.isDisplayed();

            WebElement servicesBackButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.btnServicesBack));
            homePage.btnServicesBack.click();

            try{
               Assert.assertNotNull(servicesBackButton);
               test.log(LogStatus.PASS,"'Services' Link Functionality Test Passed!");
            } catch(AssertionError e){
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

        @Test(priority = 5)
        void verifyIndustriesLink(){
            test = reports.startTest("'Industries' Link Functionality Test Started");
            homePage.btnHamburger.click();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkIndustries));
            homePage.lnkIndustries.click();

            homePage.listIndustries.isDisplayed();

            WebElement industriesBackButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.btnIndustriesBack));
            homePage.btnIndustriesBack.click();

            try{
                Assert.assertNotNull(industriesBackButton);
                test.log(LogStatus.PASS, "'Industries' Link Functionality Test Passed!");
            } catch (AssertionError e){
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

        @Test(priority = 6)
        void verifyMergersLink(){
            test = reports.startTest("'Mergers' Link Functionality Test Started");
            homePage.btnHamburger.click();

            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkMergers));
            homePage.lnkMergers.click();

            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.cgi.com/en/mergers";

            try{
                Assert.assertEquals(currentUrl,expectedUrl);
                test.log(LogStatus.PASS, "'Home' page redirects to 'Mergers' page!");
            } catch(AssertionError e){
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

    @Test(priority = 7)
    void verifyInsightsLink(){
        test = reports.startTest("'Insights' Link Functionality Test Started");
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkInsights));
        homePage.lnkInsights.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.cgi.com/en/cgi-insights";

        try{
            Assert.assertEquals(currentUrl,expectedUrl);
            test.log(LogStatus.PASS, "'Home' page redirects to 'Insights' page!");
        } catch(AssertionError e){
            test.log(LogStatus.FAIL, e.getMessage());
        }
    }
        @Test(priority = 8)
        void verifyCareersLink(){
            test = reports.startTest("'Careers' Link Functionality Test Started");
            homePage.btnHamburger.click();

            wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkCareers));
            homePage.lnkCareers.click();

            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.cgi.com/canada/en-ca/careers";

            try{
                Assert.assertEquals(currentUrl,expectedUrl);
                test.log(LogStatus.PASS, "'Home' page redirects to 'Careers' page!");
            } catch (AssertionError e){
                test.log(LogStatus.FAIL, e.getMessage());
            }
        }

    @Test(priority = 9)
    void verifyContactLink(){
        test = reports.startTest("'Contact' Link Functionality Test Started");
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkContact));
        homePage.lnkContact.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.cgi.com/canada/en-ca/contact-us";

        try{
            Assert.assertEquals(currentUrl,expectedUrl);
            test.log(LogStatus.PASS, "'Home' page redirects to 'Contact' page!");
        } catch (AssertionError e){
            test.log(LogStatus.FAIL, e.getMessage());
        }
    }

        @AfterMethod
        void close(){
            driver.close();
        }
    }
