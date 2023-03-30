package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmployeeListPageObject extends BasePage  {
	WebDriver driver;
	
	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
