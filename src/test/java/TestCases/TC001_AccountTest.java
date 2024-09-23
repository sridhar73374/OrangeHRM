package TestCases;





import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.AccountRegistartion;

import pageObjects.Homepage;

public class TC001_AccountTest extends BaseclassTest  {

	//public WebDriver driver;
	public Homepage hp;
	public  AccountRegistartion AC;
	//public Properties prop;
	
	
	
	
	
	
	@Test(groups={"regression","master"})
	public  void Account_Registration()
	{
	
	    hp=new Homepage(driver);
		hp.myAccount();
		hp.regi();
		AC=new AccountRegistartion(driver);
		AC.setfirstname(RandomString().toUpperCase());
		AC.lastname(RandomString().toUpperCase());
		AC.inputmail(RandomString().toUpperCase()+"@gmail.com");
		AC.inputtelephone(RandomNumber());
       String pass=Randompassword();
		AC.passwordone(pass);
		AC.cnfpassword(pass);
		AC.Agreeclick();
		 String Conf=AC.getmsg();
		 Assert.assertEquals(Conf,"Your Account Has Been Created!");
		
	}
	
	
		
	}
		
	 
	  
	
		


