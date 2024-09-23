package resources;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.Dataproviders;
import Utilities.ExtentReporter;

public class MyListeners implements ITestListener {

	ExtentReports extentreports;
	ExtentTest extenttest;
	 WebDriver driver=null; 
	 String testname;
	@Override
	public void onStart(ITestContext context) {	
		try {
			extentreports= ExtentReporter.generateExtentreport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void onTestStart(ITestResult result) {
		
		testname= result.getName();
	 extenttest =	extentreports.createTest(testname);
	
	extenttest.log(Status.INFO, "Started Excution");
	
	
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	//String testname=result.getName();
	
	extenttest.log(Status.PASS,"got successfully excuted");
	
	
			}

	@Override
	public void onTestFailure(ITestResult result) {
	 testname=result.getName();
	//	System.out.println(testname+ " got Failed");
	
	try {
		driver = (WebDriver)	result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	  String DS=Dataproviders.captureScreeshoots(driver, testname);
		
		extenttest.addScreenCaptureFromPath(DS);
		

		extenttest.log(Status.INFO ,result.getThrowable());
		extenttest.log(Status.FAIL, "got failed");
	
		
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extenttest.log( Status.INFO,result.getName());
		extenttest.log(Status.SKIP, "gotskipped");
		
		

			}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("Finish all the Worked");

		extentreports.flush();
		
		String path =System.getProperty("user.dir")+"\\test-output\\Extentreport\\extentreport.html";
		File extentReport=new File(path);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
}
