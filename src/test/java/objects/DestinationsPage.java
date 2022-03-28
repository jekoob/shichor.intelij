package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DestinationsPage extends NavbarPage {
	@FindBy(css = "ul.destinations-page-list>li")
	List<WebElement> popularList;

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
	public boolean checkPopularList(int counter) {
	

			System.out.println("Loop: " + counter);
			String expected = getText(popularList.get(counter).findElement(By.cssSelector(".destinations-page-item__title")));
			//String expected = getText(el.findElement(By.cssSelector(".destinations-page-item__title")));
			int endIndex = expected.indexOf(",");
			expected = expected.substring(0, endIndex);
			System.out.println(expected);
			click(popularList.get(counter));
			waiting(6000);
//			waitForVisibilityOf(driver.findElement(By.cssSelector("#__next .destination-description__heading")));
			ItemPage ip = new ItemPage(driver);
			String actual = ip.popularName();
			waiting(6000);
			System.out.println(actual);
			if(actual.contains(expected)) {
				return true;
			}
			else {
				return false;
			}
		}
}
