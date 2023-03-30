package pageUIs;

public class EmployeeDetailPageUI {
	public static final String FIRSTNAME_TEXTBOX_AT_ADD_EMP_FORM = "//input[@name='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_ADD_EMP_FORM = "//input[@name='lastName']";
	public static final String EMPLOYEE_ID_AT_ADD_EMP_FORM = "//div[@class='orangehrm-employee-container']//input[@class='oxd-input oxd-input--active']";
	public static final String ADD_PIC_BUTTON = "//button[@type='button']/i[@class='oxd-icon bi-plus']";
	
	public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@name='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@name='lastName']";
	public static final String FULLNAME_TEXTBOX_AT_HEADER = "//h6[@class='oxd-text oxd-text--h6 --strong']";
	
	public static final String DYNAMIC_TEXTBOX_AT_PERSONAL_DETAIL = "//label[text()='%s']/parent::div/following-sibling::div/input";
	public static final String DATEOFBIRTH_TEXTBOX_AT_PERSONAL_DETAIL = "//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	public static final String NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL = "//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String NATIONALITY_SUBTAB_DROPDOWN_AT_PERSONAL_DETAIL = "//label[text()='Nationality']/parent::div/following-sibling::div//div/span";
	
	public static final String MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL = "//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String MARITAL_STATUS_SUBTAB_DROPDOWN_AT_PERSONAL_DETAIL = "//label[text()='Marital Status']/parent::div/following-sibling::div//div/span";
	
	public static final String DYNAMIC_RADIO_BUTON_AT_PERSONAL_DETAIL = "//label[text()='%s']";
	public static final String DYNAMIC_SAVE_BUTON_AT_FORM = "//h6[text()='%s']/parent::div//div/button[@type='submit']";
	
}
