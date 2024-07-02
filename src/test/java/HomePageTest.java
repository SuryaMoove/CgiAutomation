import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    private final static String driverPath = "C:\\Users\\surya\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
    private final static String homePageUrl = "http://www.cgi.com/canada/en-ca/cgi-toronto";

    HomePage homePage;
    WebDriver driver;

    WebDriverWait wait;

    @BeforeMethod
    void setUp(){
       System.setProperty("webdriver.chrome.driver", driverPath);
       System.setProperty("webdriver.http.factory", "jdk-http-client");
       driver = new ChromeDriver();

       driver.get(homePageUrl);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        homePage = new HomePage(driver);
    }

    @Test(priority = 0)
    void verifyLogoLink(){
        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkLogo));
        homePage.lnkLogo.click();
        String currentUrl  = driver.getCurrentUrl();

        String expectedUrl = "https://www.cgi.com/canada/en-ca";
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Test(priority = 1)
    void verifySearchButton() throws InterruptedException {
        homePage.btnSearch.click();

        Thread.sleep(5000);
        homePage.txtBox.sendKeys("QA Tester");
        homePage.btnSearchClose.click();
    }

    @Test(priority = 2)
    void verifyHamburgerButton(){
        homePage.btnHamburger.click();
    }

    @Test(priority = 3)
    void verifyCanadaLink(){
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkCanada));
        homePage.lnkCanada.click();

        homePage.dialogBox.isDisplayed();
        homePage.btnDialogClose.click();
    }
    @Test(priority = 4)
    void verifySearchLink(){
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkServices));
        homePage.lnkServices.click();

        homePage.listServices.isDisplayed();
        homePage.btnServicesBack.click();
    }

    @Test(priority = 5)
    void verifyIndustriesLink(){
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkIndustries));
        homePage.lnkIndustries.click();

        homePage.listIndustries.isDisplayed();
        homePage.btnIndustriesBack.click();
    }

    @Test(priority = 6)
    void verifyMergersLink() {
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkMergers));
        homePage.lnkMergers.click();
    }

    @Test(priority = 7)
    void verifyInsightsLink() {
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkInsights));
        homePage.lnkInsights.click();
        String currentUrl = driver.getCurrentUrl();

        String expectedUrl = "https://www.cgi.com/en/cgi-insights";
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Test(priority = 8)
    void verifyCareersLink(){
        homePage.btnHamburger.click();

        homePage.lnkCareers.click();
        String currentUrl = driver.getCurrentUrl();

        String expectedUrl = "https://www.cgi.com/en/careers";
        Assert.assertEquals(currentUrl,expectedUrl);

    }
    @Test(priority = 9)
    void verifyContactLink() {
        homePage.btnHamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.lnkContact));
        homePage.lnkContact.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.cgi.com/canada/en-ca/contact-us";
        Assert.assertEquals(currentUrl, expectedUrl);
    }

   @AfterMethod
    void close(){
        driver.close();
    }

}