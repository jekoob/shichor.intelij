package objects;

import org.openqa.selenium.WebDriver;

public class DestinationsPage extends NavbarPage {

	public DestinationsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isDestinsationPage() {
		String title = getTitle();
		System.out.println(title);
		boolean a;
		if (title.contains("Destinations")) a = true;
		else a = false;
		return a;
	}
}
