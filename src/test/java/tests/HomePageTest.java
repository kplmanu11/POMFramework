package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1, test2;

	@BeforeSuite
	public void extendReportSetup() {
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.edge.driver", "D:\\Demo\\drivers\\edgedriver_win64 (3)\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// create the instance of the login page

		loginPage = new LoginPage(driver);
	}

	@Test
	public void checkAdminModuleOpenedTestCase() {
		test1 = extent.createTest("Admin Module Checked ");
		test1.log(Status.INFO, "Starting test case");
		homePage = loginPage.login("Admin", "admin123");
		homePage.clickAdminButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void flushExtentReport() {
		extent.flush();
	}

}
