package uiNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleAndText {
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup(); 
	}
	
	@Test (description="Title of the page matches the expected")
	public void titleTest() {
		SoftAssert sassert = new SoftAssert();
		
		driver.get("https://www.saavutettavuusvaatimukset.fi/");
		driver.manage().window().maximize();
		String title = "Digitaaliset palvelut saavutettaviksi - Saavutettavuusvaatimukset";
		String actualTitle = driver.getTitle();
		sassert.assertEquals(actualTitle, title, "Title verification failed");
		String text = driver.findElement(By.xpath("//*[@id=\"primary-item-58\"]/a/span")).getText();
		String expectedText = "Etusivu";
		sassert.assertEquals(text, expectedText, "Text verification failed");
		sassert.assertAll();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
