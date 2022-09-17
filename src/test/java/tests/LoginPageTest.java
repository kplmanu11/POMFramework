package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest {
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
	public void loginPageLogoTestCase() {

		test1 = extent.createTest("Login Logo Test ");
		test1.log(Status.INFO, "Starting test case");

		boolean flag = loginPage.displayLoginPageLogo();
		Assert.assertFalse(true);
	}


	@Test
	public void loginPageLoginFunctionalityTestCase() {

		
			test2 = extent.createTest("User Login functinality ");
			test2.log(Status.INFO, "Starting test case");
			// test2.fail("Test Fail");

			homePage = loginPage.login("Admin", "admin123");
			String actualURL = driver.getCurrentUrl();
			String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

			Assert.assertEquals(actualURL, expectedURL);
		

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
