package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By adminButton = By.xpath("//span[normalize-space()='Admin']");
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	public UserManagemenrPage clickAdminButton() {
		driver.findElement(adminButton).click();
		return new UserManagemenrPage();
	}

}
