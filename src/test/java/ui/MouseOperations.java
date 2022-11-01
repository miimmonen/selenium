package ui;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {

	// The browser to be used, can be e.g. sought from external configuration.
	public static String browser = "chrome";
	// we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static final String URL = "https://www.ebay.de";

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
		
		driver.get(URL);

		driver.manage().window().maximize();
		
		WebElement motorsLink = driver.findElement(By.xpath("//a[text()='Motors']//parent::li"));
		Actions action = new Actions(driver);
		action.moveToElement(motorsLink).perform();
		
		driver.close();
	}
}
