package TestCases;


import org.testng.annotations.Test;

import Utilities.Dataproviders;
import junit.framework.Assert;

import pageObjects.Homepage;
import pageObjects.Login;
import pageObjects.Options_get;
import pageObjects.myAccountvalidation;

public class TC0003_loginTest extends BaseclassTest {
	
	
	public Homepage hp;
	public Login l;
	public Options_get op;
	myAccountvalidation macc;
	@Test(priority=1,dataProvider="logindata",dataProviderClass=Dataproviders.class)
	
	public void loinDTT(String username,String password,String exp)
	{
	hp=new Homepage(driver);
	hp.myAccount();
	hp.logi();
	l= new Login(driver);
	l.letmail(username);
	l.letpass(password);
	l.button();
	  macc=new myAccountvalidation(driver) ;
	  boolean targetpage =macc.isAccountExist();
	  if(exp.equalsIgnoreCase("valid"))
	  {
		  if(targetpage==true)
		  {    
			  macc.clicklogout();
			  Assert.assertTrue(true);
			
		  }
		  else {
			  Assert.assertTrue(false);
		  }
	  }
	   
	
	 /* if(exp.equalsIgnoreCase("invalid"))
	  {
		  if(targetpage==true)
		  {    
			  macc.clicklogout();
			  Assert.assertTrue(false);
			
		  }
		  else {
			  Assert.assertTrue(false);
		  }
	  } */
	  
	  
	

	}
	
  
 
 
 
 
		
		
		
	
}



