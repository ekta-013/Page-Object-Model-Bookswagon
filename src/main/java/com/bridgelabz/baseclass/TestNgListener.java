package com.bridgelabz.baseclass;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestNgListener extends Baseclass implements  ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("OnTestSuccess");
        String methodName = result.getMethod().getMethodName();
        try {
            takeScreenshot(methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("OnTestFailure");
        String testName = result.getMethod().getMethodName();
        try {
            takeScreenshot(testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
}
