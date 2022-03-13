package tests;

import org.testng.annotations.Test;

import objects.HomePage;

public class NavbarTest extends BaseTest {
	
	@Test
	public void tc01_destinationsLink() {
		HomePage hp = new HomePage(driver);
		hp.destinationsBtn();
		hp.isDestinsationPage();
		hp.goback();
	}

	@Test
	public void tc02_myTripLink() {
		HomePage hp = new HomePage(driver);
		hp.myTripBtn();
	}
	@Test
	public void tc03_covidAssistLink() {
		HomePage hp = new HomePage(driver);
		hp.covidAssitBtn();
	}
	@Test
	public void tc04_dropDownServices() {
		HomePage hp = new HomePage(driver);
		for (int i = 0; i < 5; i++) {
			hp.dropDownServices(i);
		}
	}
}
