package Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter  {
	public static  Properties prop ;
	
	public static ExtentReports generateExtentreport() throws IOException {
		ExtentReports extentreport=new ExtentReports();
		
		File extentpeportfile =new File(System.getProperty("user.dir")+"\\test-output\\Extentreport\\extentreport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentpeportfile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("tutorial ninja");
		spark.config().setDocumentTitle("TN Automation Report");
		spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm.ss");
		extentreport.attachReporter(spark);
		
		
		
		
		FileReader read =new FileReader("./src//configs//Configuration.properties");
	 	try {
			prop=new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		prop.load(read);
		extentreport.setSystemInfo("Application url",prop.getProperty("url") );// to give the data in the report 
		extentreport.setSystemInfo("Application email",prop.getProperty("email") );// to give the data in the report 
		extentreport.setSystemInfo("Application email",prop.getProperty("password") );
		
		return extentreport;
		

		
		
		
		
		
		
		
		
		
		
		

		
	}

}
