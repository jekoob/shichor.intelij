package tests;
import org.testng.annotations.Test;
import objects.DestinationsPage;
import objects.HomePage;
import objects.ItemPage;


public class DestanationsTest extends BaseTest {

	@Test
	public void tc01_destanationCheckList(){
		HomePage hp = new HomePage(driver);
		hp.destinationsBtn();
		hp.isDestinsationPage();
		DestinationsPage dp = new DestinationsPage(driver);
		ItemPage ip = new ItemPage(driver);
		System.out.println(dp.getLestLength());
		for (int i = 0; i <dp.getLestLength(); i++) {
			boolean result =dp.checkPopularList(i);
			if(result) {
				ip.goback();
				dp.waiting(3000);
			}
		}
		
	}
}
