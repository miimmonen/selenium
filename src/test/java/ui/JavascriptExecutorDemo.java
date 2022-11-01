package ui;

import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * 
 * @author Miika I
 *
 */
public class JavascriptExecutorDemo {

	// The browser to be used, can be e.g. sought from external configuration.
	public static final String BROWSER = "edge";
	// we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static final String URL = "https://www.google.com";
	public static final String QUERY = "selenium";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			//we are making a new object of the FirefoxDriver -class
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			//we are making a new object of the Chromedriver -class
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")){
			WebDriverManager.edgedriver().setup(); 
			//we are making a new object of the EdgeDriver -class
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get(URL);
		String script = "return document.title;";
		String title = (String) js.executeScript(script);
		System.out.println(title);		
		driver.quit();
	}
}
