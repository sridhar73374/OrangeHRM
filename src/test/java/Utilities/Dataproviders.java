package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	 
@DataProvider(name="logindata")
	public String[][] getdata() throws IOException { // 
		
		String path=".\\TestData\\testData.xlsx";
		
		ExcelDataReading xlul=new  ExcelDataReading(path);
		int totalrows=xlul.getrowCount("sheet1");
		System.out.println(totalrows);
		int totalcols=xlul.getcellCount("Sheet1", 1);
		System.out.println(totalcols);
		String logindata[][]= new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
			System.out.print(xlul.getcellData("Sheet1", i, j));
				//int n=i-1; 
				System.out.println(i+" "+ j); 
				
			logindata[i-1][j]=xlul.getcellData("Sheet1", i, j);
			System.out.println(logindata.length);
			
			}
			
		}
		
		return logindata;
		
		
		
		
		
	}
public static String captureScreeshoots(WebDriver driver,String testname)
{
	File Src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir"+"\\Screenshots\\" +testname+".png");
	try {
		FileHandler.copy(Src, new File(destination));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return destination;
}
	
}

