package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DestinationsPage extends NavbarPage {
	@FindBy(css = "ul.destinations-page-list>li")
	List<WebElement> popularList;
	@FindBy(css=".destinations-page-list-wrap")
	WebElement destinationsListComtainer;
	public DestinationsPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * public boolean isDestinsationPage() { String title = getTitle();
	 * System.out.println(title); boolean a; if (title.contains("Destinations")) a =
	 * true; else a = false; return a; }
	 */
	public int getLestLength() {
		return popularList.size();
	}
	public String GetDestinationTitle(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(popularList));
			System.out.println(popularList.size()/2);
			if(index>popularList.size()*0.3) {
				scrollDown(destinationsListComtainer, destinationsListComtainer.getSize().height/2);
			}
			System.out.println("Loop: " + index);
			String expected = getText(popularList.get(index).findElement(By.cssSelector(".destinations-page-item__title")));
			int endIndex = expected.indexOf(",");
			expected = expected.substring(0, endIndex);
			System.out.println(expected);
			click(popularList.get(index));
			return expected;
		}
}
