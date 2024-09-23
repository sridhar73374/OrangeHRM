package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Homepage extends Basepage {
	
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']") WebElement Account;
	@FindBy(xpath="//ul//a[text()='Register']") WebElement Reg;
	@FindBy(xpath="//li//a[text()='Login']") WebElement login;
	
	public void myAccount()
	{
		Account.click();
		
	}
	public void regi()
	{
		Reg.click();
	}
	
	public void logi()
	{
		login.click();
	}
	
	

	
		
	}


