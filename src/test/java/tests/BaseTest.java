package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
public WebDriver driver;
	private io.github.bonigarcia.wdm.WebDriverManager WebDriverManager;

	@BeforeClass
	public void bfc01_setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\automation\\drivers\\chromedriver.exe");

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.shichor.co.il/en");
	}

	
	
//	@BeforeClass 
//	public void bfc02_check_The_Language() {
//		NavPage np=new NavPage(driver);
//		np.set_Language();
//	}
//	@AfterClass
//	public void tearDown() {
//		//close browser
//				driver.quit();
//	   //kill all chromedriver process
//			try {
//				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//}
}