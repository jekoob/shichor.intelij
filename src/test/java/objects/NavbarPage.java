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
		click(navBtns.get(1));
		waiting(2000);
		click(closeMyTrip);
		waiting(2000);
	}

	public void covidAssitBtn() {
		click(navBtns.get(2));
	}

	public void dropDownServices(int indexOf) {
		waiting(3000);
		action.moveToElement(ServicesBtn).build().perform();
		System.out.println(dropDownList.get(indexOf).getText());
		System.out.println(dropDownList.size());
		click(dropDownList.get(indexOf));
//		return dropDownList.get(indexOf).getText();
	}

	public boolean isDestinsationPage() {
		String title = getTitle();
		System.out.println(title);
		boolean a;
		if (title.contains("Destinations"))
			a = true;
		else a = false;
		return a;
	}
}
