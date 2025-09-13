package com.utility;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constants.browser;

public class LambdaTestUtility {
	
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();   //make driver locale as thread safe
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();
	
	 public static WebDriver initializeLambdaTestSession(browser browser, String testName) {
		 
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browser);
	        capabilities.setCapability("browserVersion", "127");
	        Map<String, Object> ltOptions = new HashMap();
	        ltOptions.put("user","agashetanmay");                                                  //taken from lambdaTest
	        ltOptions.put("accessKey","LT_5CEU2DFbwn1voPrheNI3g6kbqcZwyKE7rI2xdSjI49WV7IQ");     //Taken from lambdatest
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", testName);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "4.23.0");
	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitiesLocal.set(capabilities);                           //adding all capabilities into threadSafe variable so that it each test have run in isolation.
	        WebDriver driver = null;
			try {
				driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get()); //initialize the driver local
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 
	        driverLocal.set(driver);    //set the driver to driverlocal to do thread safe execution
	          
	        return driverLocal.get();    //return the driverlocal which is thread safe
	 }
	 
	 public static void quitSession() {         //this method help to end the dtiverLocal session
		 if(driverLocal.get()!=null) {
			 driverLocal.get().quit();
		 }
	 } 
}
