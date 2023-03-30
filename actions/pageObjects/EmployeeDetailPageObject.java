package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage  {
	WebDriver driver;
	
	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstnameTextboxAtAddEmployeeForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMP_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMP_FORM, firstName);
	}

	public void inputToLastnameTextboxAtAddEmployeeForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMP_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMP_FORM, lastName);
	}

	public String getEmployeeIDAtAddEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_AT_ADD_EMP_FORM);
		return getTextElement(driver, EmployeeDetailPageUI.EMPLOYEE_ID_AT_ADD_EMP_FORM);
	}

	public void clickToSaveButtonAtAddEmployeeForm(String formName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.DYNAMIC_SAVE_BUTON_AT_FORM, formName);
		clickToElement(driver, EmployeeDetailPageUI.DYNAMIC_SAVE_BUTON_AT_FORM, formName);
	}

	public boolean isFullnameDisplayAtHeader(String fullName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_TEXTBOX_AT_HEADER, fullName);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_TEXTBOX_AT_HEADER, fullName);
	}

	public String getFirstnameValueAtPersonalDetail() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttributePlaceholder(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
	}

	public String getLastnameValueAtPersonalDetail() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttributePlaceholder(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
	}

	public void inputToFirstnameTextboxAtPersonalDetailForm(String editFirstname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL, editFirstname);
	}

	public void inputToLastnameTextboxAtPersonalDetailForm(String editLastname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL, editLastname);
		
	}

	public void inputToSSNNumberTextboxAtPersonalDetailform(String editSSNNumber, String textboxHeader) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DYNAMIC_TEXTBOX_AT_PERSONAL_DETAIL, editSSNNumber);
		sendkeyToElement(driver, EmployeeDetailPageUI.DYNAMIC_TEXTBOX_AT_PERSONAL_DETAIL, textboxHeader, editSSNNumber);
	}

	public void selectToNationalityTextboxAtPersonalDetailform(String editNationality) {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL);
		selectItemInCustomDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL, EmployeeDetailPageUI.NATIONALITY_SUBTAB_DROPDOWN_AT_PERSONAL_DETAIL, editNationality);
	}
	
	public void inputToDateOfBirthTextboxAtPersonalDetailform(String editDateOfBirth, String textboxHeader) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATEOFBIRTH_TEXTBOX_AT_PERSONAL_DETAIL, editDateOfBirth);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATEOFBIRTH_TEXTBOX_AT_PERSONAL_DETAIL, textboxHeader, editDateOfBirth);
	}

	public void selectToMaritalStatusDropdownAtPersonalDetailform(String editMaritalStatus) {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL);
		selectItemInCustomDropdown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL, EmployeeDetailPageUI.MARITAL_STATUS_SUBTAB_DROPDOWN_AT_PERSONAL_DETAIL, editMaritalStatus);
	}



	public void selectToGenderRadioAtPersonalDetailform(String editGender) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DYNAMIC_RADIO_BUTON_AT_PERSONAL_DETAIL, editGender);
		clickToElement(driver, EmployeeDetailPageUI.DYNAMIC_RADIO_BUTON_AT_PERSONAL_DETAIL, editGender);
	}
}
