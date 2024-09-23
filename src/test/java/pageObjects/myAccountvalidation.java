package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class myAccountvalidation extends Basepage {

	public myAccountvalidation(WebDriver driver) {
		
		super(driver);
		
		
		
		
	}
	
	@FindBy(xpath="//h2[text()='My Account'] ") 
	WebElement msghandling;
	
	@FindBy(xpath="//ul//a[text()='Logout']")  WebElement logout;
	
	public boolean isAccountExist() {
		try {
			return (msghandling.isDisplayed());
		}
		
		catch(Exception e){
			return false;

			
		}
				
		
		
	}
	
	public void clicklogout()
	
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logout);
	}

	

	

}
