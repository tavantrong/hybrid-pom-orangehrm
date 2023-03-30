package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.BasePageUI;


public class BasePage {
	
	public static BasePage getbasePage () {
		return new BasePage();
	}

 	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String ID : allIDs) {
			if (!ID.equals(windowID)) {
				driver.switchTo().window(ID);
				break;
			}
		}
	}

	public void swithToWindowByTitle(WebDriver driver, String expectedWindowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualWindowTitle = driver.getTitle();
			if (actualWindowTitle.equals(expectedWindowID)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	public void sleepInsecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
		
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		getWebElement(driver, getDynamicLocator(locator, values)).click();
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToUploadFile(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String...values) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locator, values)));
		select.selectByVisibleText(valueItem);
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpass, String allItemXpath, String expectedText) {
		clickToElement(driver, parentXpass);
		sleepInsecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(allItemXpath)));
		
		List<WebElement> allItem = getListWebElement(driver, allItemXpath);
		
		for (WebElement item : allItem) {			
			if (item.getText().equals(expectedText)) {
				JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
				jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(1);
				
				clickToElement(item);
				sleepInsecond(1);
				break;
			}
			
		}
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText();
	}
	
	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[])values);
	}
	
	public String getElementAttributeByName(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getAttribute("value");
	}
	
	public String getElementAttributePlaceholder(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getAttribute("placeholder");
	}
	
	public int getElementNumber(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	
	public int getElementNumber(WebDriver driver, String locator, String...values) {
		return getListWebElement(driver, getDynamicLocator(locator, values)).size();
	}
	
	public void checktoCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void unchecktoCheckbox (WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions (driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}
	
	public void hoverToElement(WebDriver driver, String locator, String...values) {
		Actions action = new Actions (driver);
		action.moveToElement(getWebElement(driver, getDynamicLocator(locator, values))).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions (driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions (driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyboardToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions (driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void pressKeyboardToElement(WebDriver driver, String locator, Keys key, String...values) {
		Actions action = new Actions (driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locator, values)), key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overrideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public static String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
		}
	
	public void overrideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		elements = getListWebElement(driver, locator);
		overrideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	/* Orange HRM Project*/
	public void openMenuPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LINKTEST_MENUPAGE_BY_NAME, "PIM");
		clickToElement(driver, BasePageUI.DYNAMIC_LINKTEST_MENUPAGE_BY_NAME, "PIM");
	}
	
	private long longTimeout = 30;
	List<WebElement> elements;

}
