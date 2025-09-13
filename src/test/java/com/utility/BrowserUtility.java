package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.browser;
import com.ui.pages.AddressPage;

public class BrowserUtility {
	Logger logger = loggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) { // 1 st constructor accept webdriver
		super();
		this.driver.set(driver); // initialize instance variable driver
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
	}

	public BrowserUtility(browser browserName) { // 2nd constructor accepts browserName
		logger.info("launching the browser " + browserName);

		if (browserName == browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
		} else if (browserName == browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
		} else if (browserName == browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
		} else {
			logger.error("Invalid browserName .... please select chrome or edge");
			System.err.println("Invalid browserName .... please select chrome or edge");
		}
	}

	public BrowserUtility(browser browserName, boolean isHeadless) { // 3rd constructor accept browsername and headless
																		// value in boolean
		logger.info("launching the browser " + browserName);
		if (browserName == browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			}
		} else if (browserName == browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			}
		}

		else if (browserName == browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20L));
			}

		} else {
			logger.error("Invalid browserName .... please select chrome or edge");
			System.err.println("Invalid browserName .... please select chrome or edge");
		}
	}

	public void goToWebsite(String url) {
//		 driver.get(url);
		getDriver().get(url);
		logger.info("visiting to the website" + url);

	}

	public void maximizeWindow() {
		getDriver().manage().window().maximize();
		logger.info("maximize the window screen");
	}

	public void clickOn(By locator) {
		logger.info("finding the element with locator" + locator);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		logger.info("element found and performed click operation");
	}

	public void clickOn(WebElement element) {
		element.click();
		logger.info("webelement found and performed click operation");
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("finding the element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		element.sendKeys(textToEnter);
		logger.info("element found and entered text" + textToEnter);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("finding the element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		element.sendKeys(keyToEnter);
		logger.info("element found and entered special key" + keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("finding the element with locator" + locator);
		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found and visible text is " + element.getText());
		return element.getText();
	}

	public void clearText(By TextBoxLocator) {
		logger.info("finding the element with locator" + TextBoxLocator);
		WebElement element = getDriver().findElement(TextBoxLocator);
		element.clear();
		logger.info("element found and cleared text box field ");
	}

	public String getVisibleText(WebElement element) {
		logger.info("element found and visible text is " + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleTexts(By locator) {
		logger.info("finding the element with locator" + locator);
		List<WebElement> elementList = getDriver().findElements(locator);
		logger.info("element found and now printing list of webelement");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("finding the element with locator" + locator);
		List<WebElement> elementList = getDriver().findElements(locator);

		return elementList;
	}

	public void scrollToElement(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", locator);
			logger.info("element found and user scroll the page untile locator" + locator);
		} catch (TimeoutException e) {
			System.out.println("Element not found within timeout: " + locator);
		} catch (Exception e) {
			System.out.println("Error while scrolling to element: " + e.getMessage());
		}

	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("finding element with locator" + dropDownLocator);
		WebElement element = getDriver().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
		logger.info("selecting the options " + optionToSelect);

	}

	public void quit() {
		logger.info("quit the browser");
		getDriver().quit();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String Path = "." + File.separator + "screenshots" + File.separator + name + "-" + timeStamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenShotFile = new File(Path);
		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Path;
	}
}
