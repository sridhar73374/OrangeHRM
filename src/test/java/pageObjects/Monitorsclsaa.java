package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Monitorsclsaa extends Basepage {

	public Monitorsclsaa(WebDriver driver) {
		
		super(driver);
		

	}
	
	@FindBy(xpath="(//li//a[text()='Components'])[1]") WebElement components;
	@FindBy(xpath=" //div [contains(@class,'collapse navbar')]//ul//a[contains(text(),'Monitors')]") WebElement Monitors;
	
	
	
	public void Monitors()
	
	{
		Actions A= new Actions(driver);
		A.moveToElement(components).moveToElement(Monitors).click().build().perform();
		System.out.println(	driver.getCurrentUrl());
	
	}
	
	

}



