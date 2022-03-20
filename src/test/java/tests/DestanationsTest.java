package tests;
import org.testng.annotations.Test;
import objects.DestinationsPage;
import objects.HomePage;


public class DestanationsTest extends BaseTest {

	@Test
	public void tc01_destanationCheckList(){
		HomePage hp = new HomePage(driver);
		hp.destinationsBtn();
		hp.isDestinsationPage();
		DestinationsPage dp = new DestinationsPage(driver);
		dp.checkPopularList();
	}
}
