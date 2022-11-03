package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginExternalProperties {

	//The browser to be used, defaults to 'firefox' if no browser defined in properties 
	public static String browser = "firefox";
	//we are referencing the WebDriver -interface
	public static String URL = "https://www.saucedemo.com";
	public static WebDriver driver;
	public static void main(String[] args){
		
		Properties properties = new Properties();
		try {
			FileInputStream inputstream = new FileInputStream("src/test/resources/properties/testdata.properties");
			properties.load(inputstream);
			browser = properties.getProperty("browser");
			System.out.printf("Properties define the browser as: %s \n",
					properties.getProperty("browser"));
		} catch (FileNotFoundException e) {
			System.err.print("The file is not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print("Failed to load inputstream");
			e.printStackTrace();
		}
		
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
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//Press enter on the login-button
		driver.findElement(By.id("login-button")).sendKeys(Keys.RETURN);
		//close the window
		driver.quit();
	}
}
