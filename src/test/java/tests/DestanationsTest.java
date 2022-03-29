package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import objects.DestinationsPage;
import objects.HomePage;
import objects.ItemPage;


public class DestanationsTest extends BaseTest {

	@Test
	public void tc01_destanationCheckList(){
		HomePage hp = new HomePage(driver);
		DestinationsPage dp = new DestinationsPage(driver);
		ItemPage ip = new ItemPage(driver);
		hp.destinationsBtn();
		hp.isDestinsationPage();
		System.out.println(dp.getLestLength());
		
		for (int i = 0; i <9; i++) {
			 String expected =dp.GetDestinationTitle(i);
			 String actual = ip.popularName();
			 Assert.assertTrue(actual.contains(expected), actual);
			 ip.goback();
		}
		
	}
}
