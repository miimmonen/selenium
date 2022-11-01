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

public class FindingElements {

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
		

		driver.get("http://127.0.0.1:5500/index.html");
		
		boolean piilossa = driver.findElement(By.tagName("h3")).isDisplayed();
		boolean eiPiilossa = driver.findElement(By.tagName("h4")).isDisplayed();
		
		System.out.println("elementin 'piilossa' isDisplayed-arvo on:"+ piilossa + ", mutta elementin 'eiPiilossa' isDisplayed- arvo on:"+ eiPiilossa);
		driver.close();
	}
}
