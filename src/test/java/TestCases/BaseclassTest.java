package TestCases;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseclassTest {

public WebDriver driver;
public Properties prop ;

	
@Parameters({"OS","Browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	
	 public void setup(String OS,String br) throws FileNotFoundException
	 
	 
	 {
		FileReader read =new FileReader("./src//configs//Configuration.properties");
	 	prop=new Properties();
	   try {
		prop.load(read);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 switch(br.toLowerCase())
	 {
	 case "chrome": driver=new ChromeDriver(); break;
	 
	 case "edge" : driver=new EdgeDriver(); break;
	 
	 default:  System.out.println("invalid browser"); 
	 return;
	  
	 }
	 
	 		
	    driver.manage().window().maximize();
	 	driver.manage().deleteAllCookies();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	driver.get(prop.getProperty("url"));
	 //	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	 }
	 
	 
	
	
		
	 @AfterClass(groups= {"sanity","regression","master"})
		public void teardown()
		{
			driver.quit();
			
		}
		
		 
	 public String RandomString()
		
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
	public String RandomNumber()
		
		{
			String generatednumber=RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
	public String Randompassword()

	{
		String generatednumberpp=RandomStringUtils.randomNumeric(3);
		String generatedStringpp=RandomStringUtils.randomAlphabetic(3);
		
	
		return(generatednumberpp+"@"+generatedStringpp);
	}
	
	   

			

	 	 
}





