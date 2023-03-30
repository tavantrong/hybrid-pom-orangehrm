package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EmployeeListPageUI;

public class DashboardPageObject extends BasePage  {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailPageObject clickToAddEmployeeLinkText() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return PageGeneratorManager.getEmployeeDetailPage(driver);
	}


}
