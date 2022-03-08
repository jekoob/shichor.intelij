package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class NavbarPage extends BasePage {

	@FindBy(css = "header.app-header img.app-header__logo")
	WebElement iconHomePage;
	@FindBy(css = "header.app-header .app-header__desktop .header-nav__list>a")
	List<WebElement> navBtns;
	
	public NavbarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void iconHomePage () {
		click(iconHomePage);
	}
	public void destinationsBtn() {
		click(navBtns.get(0));
	}
	public void myTripBtn() {
		click(navBtns.get(1));
	}
	public void covidAssitBtn() {
		click(navBtns.get(2));
	}

	
	
	
	
}
