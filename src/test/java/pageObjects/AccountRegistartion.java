package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistartion extends Basepage{

	public AccountRegistartion(WebDriver driver) {
		super (driver);
	
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement Firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement Confpassword;
	@FindBy(xpath="//input[@name=\"agree\"]") WebElement Agree;
	@FindBy(xpath="//input[@value=\"Continue\"]") WebElement btn_Continue;
	
	@FindBy(xpath=" //h1[normalize-space()='Your Account Has Been Created!']") WebElement msgcon;
	public void setfirstname(String name)
	{
		Firstname.sendKeys(name);
	
	}
	public void lastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void inputmail(String mail) {
		
	
		email.sendKeys(mail);
	}

	public void inputtelephone(String mail)
	{
		telephone.sendKeys(mail);
	}
	
	public void passwordone(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void cnfpassword(String repass)
	{
		Confpassword.sendKeys(repass);
		
		
	}
	
	public void Agreeclick() {
		Agree.click();
		btn_Continue.click();	}
	
	public  String getmsg()
	{
		try {
		return (msgcon.getText());
		
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	
	}
}


