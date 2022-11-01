package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Trying out some locators of selenium
 * @author Miika
 *
 */
public class Locators {

	//The browser to be used, can be e.g. sought from external configuration.
	public static String browser = "firefox";
	//we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static void main(String[] args) {
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			//we are making a new object of the FirefoxDriver -class
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			//we are making a new object of the Chromedriver -class
			driver = new ChromeDriver();
		} else if (browser.equals("edge")){
			WebDriverManager.edgedriver().setup(); 
			//we are making a new object of the EdgeDriver -class
			driver = new EdgeDriver();
		}
		
		//Prerequisite, web-site is launched.
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.RETURN);
		try {
			driver.findElement(By.className("shopping_cart_container")).click();
		} catch(ElementNotInteractableException ex) {
			System.err.println("-----------Shopping cart cannot be reached--------------");
			//driver.close();
		}
		
		WebElement button = driver.findElement(By.xpath("//button[@id='checkout']"));
		button.click();
		driver.findElement(By.id("first-name")).sendKeys("Matti");
		driver.findElement(By.id("last-name")).sendKeys("Pattinen");
		driver.findElement(By.id("postal-code")).sendKeys("40000");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		driver.findElement(By.xpath("//*[@id='finish']")).click();
		
		driver.close();

	}
}
