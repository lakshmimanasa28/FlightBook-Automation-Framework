package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

       
        Object obj = result.getInstance();
        WebDriver driver = ((BaseTest) obj).getDriver();

    
        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}