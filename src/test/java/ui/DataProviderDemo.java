package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Trying out the dataProvider-attribute, dataSet contains different user credentials
 * and the test tries to login to a provided site with them.
 * 
 * @author MiikaI
 *
 */
public class DataProviderDemo {
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="dataSet")
	public void test(String usern, String passw) {
		SoftAssert sassert = new SoftAssert();
		System.out.println(usern+" "+passw);
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(usern);
		driver.findElement(By.id("password")).sendKeys(passw);
		//Press enter on the login-button
		driver.findElement(By.id("login-button")).sendKeys(Keys.RETURN);


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3), 
				Duration.ofMillis(1000));	
				wait.until(ExpectedConditions.urlMatches("https://www.saucedemo.com/inventory.html"));
		String text = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String expectedText = "PRODUCTS";
		sassert.assertEquals(text, expectedText, "Text verification failed");
		sassert.assertAll();
	}
	
	@DataProvider
	public Object[][] dataSet() {
		//we define a multidimensional object with 3 rows and 2 columns
		Object[][] dataset = new Object[3][2];
		
		dataset[0][0] = "user1";
		dataset[0][1] = "pass1";
		
		dataset[1][0] = "user2";
		dataset[1][1] = "pass2";
		
		dataset[2][0] = "standard_user";
		dataset[2][1] = "secret_sauce";
		
		return dataset;
	}
	
}
