package tests;

import org.apache.poi.hpsf.HPSFException;
import org.testng.annotations.Test;

import objects.BasePage;
import objects.HomePage;

public class LoginTest extends NavbarTest {
	
	@Test
	public void tc01_signup_feild_AllNullValues() {
		HomePage hp = new HomePage(driver);
		hp.SignUp(" "," "," "," ");
	}
	
	
}
