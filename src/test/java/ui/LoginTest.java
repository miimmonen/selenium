package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	//The browser to be used, can be e.g. sought from external configuration.
	public static String browser = "chrome";
	//we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static void main(String[] args){
		
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
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//Press enter on the login-button
		driver.findElement(By.id("login-button")).sendKeys(Keys.RETURN);
		//close the window
		driver.close();
	}
}
