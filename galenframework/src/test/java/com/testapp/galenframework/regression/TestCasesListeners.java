package com.testapp.galenframework.regression;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestCasesListeners implements ITestListener{

	// Listener methods
		public void onFinish(ITestContext result) {
			System.out.println("Test Cases finished and Test Cases details are: "+result.getName());
			
		}
		public void onStart(ITestContext result) {
			System.out.println("Test Cases started and details are: "+result.getName());
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("Test Cases failed with success percentage and Test Cases details are: "+result.getName());
			
		}
		public void onTestFailure(ITestResult result) {
			System.out.println("Test Cases failed and Test Cases details are: "+result.getName());
			
		}
		public void onTestSkipped(ITestResult result) {
			System.out.println("Test Cases skipped and Test Cases details are: "+result.getName());
			
		}
		public void onTestStart(ITestResult result) {
			System.out.println("Test Cases started and Test Cases details are: "+result.getName());
			
		}
		public void onTestSuccess(ITestResult result) {
			System.out.println("Test Cases succedded and Test Cases details are: "+result.getName());
			
		}

}
