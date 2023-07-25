package com.demoblaze.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoblaze.ActionClass.Action;

public class ListenerClass extends ExtentManager implements ITestListener {
    Action action= new Action();
    ExtentTest test;

    private void init() {
        ExtentManager.setExtent();
        test = ExtentManager.extent.createTest("Test");
    }

    public void onTestStart(ITestResult result) {
        init();
        test = ExtentManager.extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }

    public void onTestFailure(ITestResult result) {
        if (test == null) {
            init();
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Fail Test case is: " + result.getName());
        }
    }

    public void onTestSkipped(ITestResult result) {
        if (test == null) {
            init();
        }
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        init();
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }
}
