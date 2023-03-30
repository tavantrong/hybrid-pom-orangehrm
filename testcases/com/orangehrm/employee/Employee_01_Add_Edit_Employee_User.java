package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.DashboardPageObject;
import pageObjects.EmployeeDetailPageObject;
import pageObjects.EmployeeListPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserDetailPageObject;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeeDetailPage;
	EmployeeListPageObject employeeListPage;
	UserDetailPageObject userDetailPage;

	String firstName, Name2, lastName, employeeID;
	String editFirstname, editLastname, editSSNNumber, editNationality, editMaritalStatus, editDateOfBirth, editGender;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		firstName = "Automation" + getRandomNumber();
		lastName = "Testing" + getRandomNumber();
		editFirstname = "Selenium" + getRandomNumber();
		editLastname = "Java" + getRandomNumber();
		editSSNNumber = "329-68-2055";
		editNationality = "Vietnamese";
		editMaritalStatus = "Single";
		editDateOfBirth = "1990-03-19";
		

		log.info("Pre-Condition - Step 01: Input to Username textbox");
		loginPage.enterKeyToUsernameTextbox("Admin");

		log.info("Pre-Condition - Step 02: Input to Password textbox");
		loginPage.enterKeyToPasswordTextbox("admin123");

		log.info("Pre-Condition - Step 03: Click to Login button");
		dashboardPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Employee_01_Add_Employee() {
		log.info("Add Employee - Step 01: Click to PIM link");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add Employee - Step 02: Click to Add Employee link");
		employeeDetailPage = dashboardPage.clickToAddEmployeeLinkText();

		log.info("Add Employee - Step 03: Input to First name textbox with value " + firstName);
		employeeDetailPage.inputToFirstnameTextboxAtAddEmployeeForm(firstName);

		log.info("Add Employee - Step 04: Input to Last name textbox with value " + lastName);
		employeeDetailPage.inputToLastnameTextboxAtAddEmployeeForm(lastName);

		log.info("Add Employee - Step 05: Get Employee ID with value " + employeeID);
		employeeID = employeeDetailPage.getEmployeeIDAtAddEmployeeForm();

		log.info("Add Employee - Step 06: Click to Save button");
		employeeDetailPage.clickToSaveButtonAtAddEmployeeForm("Add Employee");
		
		employeeDetailPage.sleepInsecond(2);
		
		log.info("Add Employee - Step 07: Verify Fullname display at header");
		verifyTrue(employeeDetailPage.isFullnameDisplayAtHeader(firstName + " " + lastName));

		log.info("Add Employee - Step 08: Verify First name " + firstName);
		//verifyEquals(employeeDetailPage.getFirstnameValueAtPersonalDetail(), firstName);

		log.info("Add Employee - Step 09: Verify Last name" + lastName);
		//verifyEquals(employeeDetailPage.getLastnameValueAtPersonalDetail(), lastName);
	}

	@Test
	public void Employee_03_Edit_Employee_By_Personal() {
		log.info("Edit Employee - Step 01: Enter to 'First Name' textbox with new value: " + editFirstname);
		employeeDetailPage.inputToLastnameTextboxAtPersonalDetailForm(editFirstname);
		
		log.info("Edit Employee - Step 02: Enter to 'Last Name' textbox with new value: " + editLastname);
		employeeDetailPage.inputToLastnameTextboxAtPersonalDetailForm(editLastname);
		
		log.info("Edit Employee - Step 04: Enter to 'Nationality' dropdown with new value: " + editNationality);
		employeeDetailPage.selectToNationalityTextboxAtPersonalDetailform(editNationality);
		employeeDetailPage.sleepInsecond(2);
		
		log.info("Edit Employee - Step 03: Enter to 'SSN Number' textbox with new value: " + editSSNNumber);
		employeeDetailPage.inputToSSNNumberTextboxAtPersonalDetailform("SSN Number", editSSNNumber);
				
		log.info("Edit Employee - Step 05: Enter to 'Marital Status' dropdown with new value: " + editMaritalStatus);
		employeeDetailPage.selectToMaritalStatusDropdownAtPersonalDetailform(editMaritalStatus);
				
		log.info("Edit Employee - Step 06: Enter to 'Date Of Birth' textbox with new value: " + editDateOfBirth);
		employeeDetailPage.inputToDateOfBirthTextboxAtPersonalDetailform("Date Of Birth", editDateOfBirth);
				
		log.info("Edit Employee - Step 07: Enter to 'Gender' radio with new value: Male");
		employeeDetailPage.selectToGenderRadioAtPersonalDetailform("Male");
				
		log.info("Edit Employee - Step 08: Click to 'Save' button at 'Personal Details' form");
		employeeDetailPage.clickToSaveButtonAtAddEmployeeForm("Personal Details");
		employeeDetailPage.sleepInsecond(2);

	}

	@Test
	public void Employee_04_Edit_Employee_By_Contact() {

	}

	@Test
	public void Employee_05_Edit_Employee_By_Job() {

	}

	@Test
	public void Employee_02_Search_Employee() {

	}

	@Test
	public void Employee_06_Edit_Employee_By_Salary() {

	}

	@Test
	public void Employee_07_Add_User_To_Employee() {

	}

	@Test
	public void Employee_08_Search_User() {

	}

	@Test
	public void Employee_09_Delete_User() {

	}

	@Test
	public void Employee_10_Delete_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
