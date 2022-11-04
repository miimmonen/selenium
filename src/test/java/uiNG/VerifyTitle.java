package uiNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup(); 
	}
	
	@Test (description="Title of the page matches the expected")
	public void titleTest() {
		
		driver.get("https://www.saavutettavuusvaatimukset.fi/");
		String title = "Digitaaliset palvelut saavutettaviksi - Saavutettavuusvaatimukset";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
