package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Basepage {

	public Login(WebDriver driver)  {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//div//input[@id='input-email']") WebElement lemail;
	@FindBy(xpath="//div//input[@id=\"input-password\"]") WebElement lpassword;
	@FindBy(xpath="//div//input[@value=\"Login\"]") WebElement loginBtn;
	
	
	public void letmail(String E) {
		lemail.sendKeys(E);
		
	}
	

	public void letpass(String pwd )  {
		lpassword.sendKeys(pwd);
		
	}
	public void button() {
		loginBtn.click();                      
	}
	

	
	
	


	
}   
