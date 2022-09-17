package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	By loginLogo = By.xpath("//img[@alt='company-branding']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean displayLoginPageLogo() {
		driver.findElement(loginLogo).isDisplayed();
		return true;
	}
	
	public HomePage login(String uname, String pwd) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new HomePage(driver);
	}

}
