package ui;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Point of this is just to try print all the anchor tags
 * from a site and checking are there empty ones.
 */
public class PrintingLinks {

	//The browser to be used, can be e.g. sought from external configuration.
	public static final String browser = "chrome";
	//we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static final String URL = "https://www.saavutettavuusvaatimukset.fi/";
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
		//Find all anchor-tag elements
		List<WebElement> anchors =  driver.findElements(By.tagName("a"));
		System.out.println(anchors.size());
		int emptyTags = 0;
		for (WebElement element : anchors ) {
			System.out.println(element.getAttribute("href"));
			if(element.getText().replaceAll("\\s","") == "") {
				try {
					WebElement span = element.findElement(By.xpath("//a/*"));
					//System.out.println(span.getText());	
				}catch (NoSuchElementException ex){
					System.out.println("---WARNING EMPTY ANCHOR-TAG---");
					continue;
				} 
			}else {
				//System.out.println(element.getText());
			}
			
		}
		if(emptyTags > 0) {
			System.err.printf("There were %s empty anchor tags", emptyTags);	
		}
		driver.close();
		
	}
}
