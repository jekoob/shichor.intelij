package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends NavbarPage {
	@FindBy(css = "#__next .destination-description__heading")
	WebElement titleName;
	
	
	//#__next .destination-description__heading
	public ItemPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public String popularName() {	
		return getText(titleName);	
	}
	
	

}
