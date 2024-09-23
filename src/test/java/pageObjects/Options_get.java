package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Options_get extends Basepage {

	public Options_get(WebDriver driver) {
		
		super(driver);
			}
	
	@FindBy(xpath="(//div/select[@class=\"form-control\"])[1]") WebElement Opp;
	
	
	
	
	public void priceoptions()
	
	{
		Select ss=new Select(Opp);
		List<WebElement> We = ss.getOptions();
		for(int i=0;i<We.size();i++)
			
		{
			We.get(i);
			System.out.println(We.get(i).getText());
		}
	}
	
	
	

}
