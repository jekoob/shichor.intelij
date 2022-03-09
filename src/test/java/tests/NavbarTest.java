package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.DestinationsPage;
import objects.HomePage;

public class NavbarTest extends BaseTest {
	
	@Test
	public void tc01_destinationsLink() {
		HomePage hp = new HomePage(driver);
		hp.destinationsBtn();
		DestinationsPage dp = new DestinationsPage(driver);
		Assert.assertTrue(dp.isDestinsationPage());
		hp.goback();
//		DestinationsPage dp = new DestinationsPage(driver);
//		Assert.assertTrue(dp.isDestinsationPage());
//		DestinationsPage dp = new D
//		bp.moveToNewWindow();
//		Assert.assertTrue(bp.isBookingPage());
//		bp.moveToMainWindow();
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
