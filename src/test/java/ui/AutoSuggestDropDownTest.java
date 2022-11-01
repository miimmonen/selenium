package ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDownTest {

	//The browser to be used, can be e.g. sought from external configuration.
	public static String browser = "edge";
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
		driver.manage().window().maximize();
		
		WebElement lahto = driver.findElement(By.xpath("//span[text()='Lähtöpaikka:']//parent::button"));
		lahto.click();
		driver.findElement(By.xpath("//*[@id=\"location-field-origin\"]")).sendKeys("Oulu", Keys.RETURN);

		WebElement maali = driver.findElement(By.xpath("//span[text()='Määränpää:']//parent::button"));
		maali.click();
		driver.findElement(By.xpath("//*[@id=\"location-field-destination\"]")).sendKeys("Helsinki", Keys.RETURN);
		
		driver.findElement(By.xpath("//button[text()='Hae']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.close();
	}
}
