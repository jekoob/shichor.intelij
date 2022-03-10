package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
public WebDriver driver;

	@BeforeClass
	public void bfc01_setup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chocolatey\\lib\\chromedriver\\tools\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.shichor.co.il/en");
	}
}