package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.browser;

public class BrowserUtility {
	Logger logger = loggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {  //1 st constructor accept webdriver
		super();
		this.driver.set(driver); // initialize instance variable driver
	}
	
	public BrowserUtility(browser browserName) { //2nd constructor accepts browserName
		logger.info("launching the browser " + browserName);

		if (browserName == browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else {
			logger.error("Invalid browserName .... please select chrome or edge");
			System.err.println("Invalid browserName .... please select chrome or edge");
		}
	}

	public BrowserUtility(browser browserName, boolean isHeadless) {  //3rd constructor accept browsername and headless value in boolean
		logger.info("launching the browser " + browserName);
		if (browserName == browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		}
			
		else if (browserName == browser.FIREFOX) {
			driver.set(new FirefoxDriver());
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
		WebElement element = getDriver().findElement(locator);
		element.click();
		logger.info("element found and performed click operation");
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("finding the element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		element.sendKeys(textToEnter);
		logger.info("element found and entered text" + textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("finding the element with locator" + locator);
		WebElement element = getDriver().findElement(locator);
		logger.info("element found and visible text is " + element.getText());
		return element.getText();
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
		String Path = System.getProperty("user.dir") + "//screenshots//" + name + "-" + timeStamp + ".png";
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
