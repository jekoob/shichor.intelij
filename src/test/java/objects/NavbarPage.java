package objects;

import org.apache.poi.hpsf.Array;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import net.bytebuddy.asm.Advice.Argument;

import java.util.ArrayList;
import java.util.Iterator;
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
	@FindBy(css = ".app-header__container .app-header__desktop .btn-dark-blue.btn")
	WebElement signInBtn;
	@FindBy(css = ".sign-in-form__footer>a:nth-child(2)")
	WebElement signUpBtn;
	@FindBy(css = ".sign-up-form .form-input__wrapper>input")
	List<WebElement> feildsSignUp;
	@FindBy(css = ".sign-up-form .form-field.error")
	List<WebElement> errorLable;
	@FindBy(css = ".sign-up-form [type='submit']")
	WebElement createBtnProfile;

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

	public void SignUp(String firstName, String lastName, String email, String pass) {
		String array[] = { "yossi", "ro", "yossi1985@gmail.com", "7896789" };
		click(signInBtn);
		click(signUpBtn);
		for (int i = 0; i < feildsSignUp.size(); i++) {
			String Arg = "";
			switch (i) {
			case 0:
				click(createBtnProfile);
				for (int j = 0; j < feildsSignUp.size(); j++) {
					System.out.println(feildsSignUp.get(j).getAttribute("id"));
					String expectedError = getText(errorLable.get(j));
					Assert.assertTrue(expectedError.equalsIgnoreCase("Required"));
				}
				break;
			case 1:
				for (int j = 0; j < feildsSignUp.size(); j++) {
					switch (j) {
					case 0:
						Arg = firstName;
						break;
					case 1:
						Arg = lastName;
						break;
					case 2:
						Arg = email;
						break;
					case 3:
						Arg = pass;
						break;
					}
					fillText(feildsSignUp.get(j), Arg);
				}
				click(createBtnProfile);
				String expectedError = getText(errorLable.get(2));
				Assert.assertTrue(expectedError.equalsIgnoreCase("Please enter a valid email address"));
				break;
			case 2:
				wait.until(ExpectedConditions.attributeToBeNotEmpty(feildsSignUp.get(2),"value"));
				fillText(feildsSignUp.get(2), array[2]);
				click(createBtnProfile);
				break;
			}
		}
	}
	public void dropDownServices(int indexOf) {
		waiting(3000);
		action.moveToElement(ServicesBtn).build().perform();
		System.out.println(indexOf);
		System.out.println(dropDownList.get(indexOf).getText());
		click(dropDownList.get(indexOf));
		String expected;
		switch (indexOf) {
		case 0:
			expected = "Booking.com";
			break;
		case 2:
			expected = "viator";
			break;
		case 3:
			expected = "מגדל";
			break;
		case 4:
			expected = "Shichor WL";
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
