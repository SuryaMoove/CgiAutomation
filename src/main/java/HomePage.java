import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "Calque_1")
    WebElement lnkLogo;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Search terms')]")
    WebElement btnSearch;

    @FindBy(how = How.ID, using = "edit-keyword")
    WebElement txtBox;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Close search bar')]")
    WebElement btnSearchClose;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Access to main navigation']")
    WebElement btnHamburger;

    @FindBy(how = How.XPATH, using = "//a[@data-once='ajax']")
    WebElement lnkCanada;

    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-id-1']")
    WebElement dialogBox;

    @FindBy(how = How.XPATH, using = "//button[@title='Close']")
    WebElement btnDialogClose;

    @FindBy(how = How.XPATH, using = "//a[@href='#mm-2']")
    WebElement lnkServices;

    @FindBy(how = How.ID, using = "mm-2")
    WebElement listServices;

    @FindBy(how = How.XPATH, using = "//a[@aria-owns='mm-1']")
    WebElement btnServicesBack;

    @FindBy(how = How.XPATH, using = "//a[@href='#mm-6']")
    WebElement lnkIndustries;

    @FindBy(how = How.ID, using = "mm-6")
    WebElement listIndustries;

    @FindBy(how = How.XPATH, using = "//*[@id='mm-6']/div/a[1]")
    WebElement btnIndustriesBack;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Mergers')]")
    WebElement lnkMergers;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Insights')]")
    WebElement lnkInsights;

    @FindBy(how = How.XPATH, using = "//a[@title='Careers']")
    WebElement lnkCareers;

    @FindBy(how = How.XPATH, using = "//a[@alt='Contact']")
    WebElement lnkContact;
}
