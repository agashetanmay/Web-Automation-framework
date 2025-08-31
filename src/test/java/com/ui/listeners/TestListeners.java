package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.loggerUtility;
import com.ui.test.*;

public class TestListeners implements ITestListener {
	Logger logger = loggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;  // HTML reports Looks and styling taken care by ExtentSparkReporter 
	ExtentReports extentReports;       // heavy lifting and CSS data will be taken care by ExtentReports
    ExtentTest extentTest;             // to store the information about test
    
	public void onTestStart(ITestResult result) {
      logger.info(result.getMethod().getMethodName());
      logger.info(result.getMethod().getDescription());
      logger.info(Arrays.toString(result.getMethod().getGroups()));
      ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+" "+ "PASSED");
		 ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+ "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName()+" "+ "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+ "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		   
		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		logger.info("capturing screenshot for failed tests");
		String screenShotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attatching screenshot to HTML file");
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenShotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+" "+ "The Test has skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+ "The Test has skipped");
	}

	public void onStart(ITestContext context) {
       logger.info("the test suite has started excution");
       ExtentReportUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("the test suite has finished excution");
		 ExtentReportUtility.flushReport();
	}

}
