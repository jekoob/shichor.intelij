package tests;

import org.testng.annotations.Test;

import objects.HomePage;

public class NavbarTest extends BaseTest {
	@Test
	public void tc01_destinationsLink() {
		HomePage hp = new HomePage(driver);
		hp.destinationsBtn();
//		hp.goback();
		hp.waiting(2000);
	}
/*	@Test
	public void tc02_myTripLink() {
		HomePage hp = new HomePage(driver);
		hp.myTripBtn();
		hp.waiting(2000);
		hp.goback();
	}*/
	@Test
	public void tc03_covidAssistLink() {
		HomePage hp = new HomePage(driver);
		hp.covidAssitBtn();
	}

}
