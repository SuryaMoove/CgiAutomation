import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class Reporter {
    static ExtentReports reports;

    @BeforeTest
    ExtentReports setReport(){
        reports = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/CgiAutomation Report.html");
        //giving the filepath and file name to store the reports
        return reports;
    }

    @AfterMethod
    void endReport(){
        reports.flush(); //to erase any previous data and creates a whole new report
    }

}
