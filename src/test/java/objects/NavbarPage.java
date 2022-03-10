package objects;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NavbarPage extends BasePage {

	@FindBy(css = "header.app-header img.app-header__logo")
	WebElement iconHomePage;
	@FindBy(css = "header.app-header .app-header__desktop .header-nav__list>a")
	List<WebElement> navBtns;
	@FindBy(css = "div button [href='#close']")
	WebElement closeMyTrip;
	@FindBy(css = ".app-header__container .app-header__desktop .show-xl .header-dropdown-list a")
	List<WebElement> dropDownList;
	@FindBy(css = ".app-header__container .app-header__desktop .header-dropdown__title")
	WebElement ServicesBtn;

	public NavbarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void iconHomePage() {
		click(iconHomePage);
	}

	public void destinationsBtn() {
		click(navBtns.get(0));
		waiting(2000);
	}

	public void myTripBtn() {
		waiting(2000);
		click(navBtns.get(1));
		waiting(2000);
		click(closeMyTrip);
	}

	public void covidAssitBtn() {
		click(navBtns.get(2));
		System.out.println(driver.getWindowHandles());
		switchTabs("Tripready");
	}

	public void dropDownServices(int indexOf) {
		waiting(3000);
		action.moveToElement(ServicesBtn).build().perform();
		System.out.println(indexOf);
		System.out.println(dropDownList.get(indexOf).getText());
		click(dropDownList.get(indexOf));
		String expected;
		switch (indexOf){
			case 2 :
				expected = "viator";
				break;
			case 3 :
				expected = "מגדל";
				break;
			case 4 :	expected = "Shichor WL";
				break;
			default:
				expected = dropDownList.get(indexOf).getText();
		}

		switchTabs(expected);
	}

	public void isDestinsationPage() {
		System.out.println(navBtns.get(0).getText());
		volidateTitle(navBtns.get(0).getText());
	}
}
