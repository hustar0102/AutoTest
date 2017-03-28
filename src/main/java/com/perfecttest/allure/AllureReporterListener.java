package com.perfecttest.allure;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import com.thit.hustar.util.TestCase.DriverManager;

import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureReporterListener implements IHookable{

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		 callBack.runTestMethod(testResult);
	        if (testResult.getThrowable() != null) {
	            try {       
	                takeScreenShot(testResult.getMethod().getMethodName());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	}
	 @Attachment(value = "Failure in method {0}", type = "image/png")
	    private byte[] takeScreenShot(String methodName) throws IOException {
		 return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	 }
}
