package objects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	WebDriver driver;
	String mainWindow;
	Actions action; //
	JavascriptExecutor js;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//	public void closeiframe(WebElement el, WebElement  ) {
//		driver.switchTo().frame(el);
////		driver.findElement(By.id("close-button")).click();
//		driver.switchTo().defaultContent();
//	}

	void fillText(WebElement el, String text) {
		highlightElement(el, "green", "yellow");
		 el.clear();
		waiting(1000);
		el.sendKeys(text);
	}
	
	public void goback() {
		driver.navigate().back();
	}
	
	void click(WebElement el) {
		highlightElement(el, "green", "yellow");
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
	}

	String getText(WebElement el) {
		highlightElement(el, "orange", "orange");
		return el.getText();
	}

	void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public void volidateTitle(String Expected){
		System.out.println(getTitle());
		Assert.assertTrue(getTitle().toLowerCase().contains(Expected.toLowerCase()));
	}
	// Alert
	void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	void alertOK() {
		driver.switchTo().alert().accept();
	}

	void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	void switchTabs(String expected){
		waiting(1000);
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		volidateTitle(expected);
		waiting(1000);
		driver.close();
		driver.switchTo().window(windows.get(0));
	}
	// Mouse
	void dragAndDrop(WebElement src, WebElement target) {
		highlightElement(src, "yellow", "orange");
		highlightElement(target, "blue", "orange");
		action.moveToElement(src).clickAndHold().build().perform();
		waiting(1000);
		action.moveToElement(target).release().build().perform();

	}

	// windows
	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			System.out.println(win);
			driver.switchTo().window(win);
		}
	}

	public void moveToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	// Wait
	void waitForVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	void waitForInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public void waiting(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color, String background) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + background + "; border: 1px solid " + color + ";" + originalStyle;
//		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

	// Scroll Down on page
	void scrollDown(WebElement element , WebElement height) {
		 
		for(int i =0;i<height.getSize().height;i+=10 ) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+i+")", element);
		}
	}

	// Validation
	public boolean validationTitleTab(String titleTab) {
		wait.until(ExpectedConditions.titleContains(titleTab));
		String title = getTitle();
		System.out.println(title);
		boolean a = title.contains(titleTab) ? true : false;
		return a;
	}

}
