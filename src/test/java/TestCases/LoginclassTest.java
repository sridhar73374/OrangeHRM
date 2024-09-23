package TestCases;
import org.testng.annotations.Test;

import junit.framework.Assert;
 
import pageObjects.Homepage;
import pageObjects.Login;
import pageObjects.Monitorsclsaa;
import pageObjects.Options_get;
import pageObjects.myAccountvalidation;


public class LoginclassTest extends BaseclassTest{
	Monitorsclsaa Ma;
	
	public Homepage hp;
	public Login l;
	public Options_get op;
	myAccountvalidation macc;
	@Test(priority=1, groups={"sanity","master"})
	public void loinAccount()
	{
	hp=new Homepage(driver);
	hp.myAccount();
	hp.logi();
	l= new Login(driver);
	l.letmail(prop.getProperty("email"));
	l.letpass(prop.getProperty("password"));
	l.button();
	

	}
	@Test(priority=2,groups={"sanity","master"})
	public void Myaccount() {
macc=new myAccountvalidation(driver) ;
 boolean targetpage =macc.isAccountExist();
 Assert.assertEquals(targetpage, true);
 macc.clicklogout();
 
 
		
		
		
	}

	@Test(priority=3)
  void mouse() throws InterruptedException
  
{
	Ma=new   Monitorsclsaa (driver);
	Thread.sleep(3000);
	Ma.Monitors();
	
	Thread.sleep(3000);
}
	@Test(priority=4)
	public void Monoptions()
	
	{
		 op=new Options_get(driver);
		 op.priceoptions();
		driver.navigate().back();
		String S1= driver.getCurrentUrl();
		System.out.println(S1);
		// Assert.assertEquals(S1, "https://tutorialsninja.com/demo/index.php?route=account/account");
		
	}

	
	
	
	
		 
	
		


}
