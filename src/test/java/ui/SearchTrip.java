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

public class SearchTrip {

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
		

		driver.get("https://www.ebookers.fi/");
		
		driver.findElement(By.className("uitk-fake-input")).click();
		WebElement paamaara = driver.findElement(By.className("uitk-typeahead-input-v2"));
		paamaara.sendKeys("Helsinki");
		paamaara.sendKeys(Keys.RETURN);
		driver.findElement(By.className("SwapLocationsDesktop")).click();
		driver.findElement(By.className("uitk-fake-input")).click();
		WebElement lahto = driver.findElement(By.className("uitk-typeahead-input-v2"));
		lahto.sendKeys("Oulu");
		lahto.sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("//*[@id=\"wizard-package-pwa-1\"]/div[3]/div[2]/button")).sendKeys(Keys.RETURN);
	}
}
