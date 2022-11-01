package ui;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Trying out Some basic usage of changing 
 * to different Window handles with Selenium.
 * We test navigating to youtube from an external site
 * and then searching for youtube-videos on given topic.
 * 
 * @author Miika I
 *
 */
public class HandlingWindows {

	// The browser to be used, can be e.g. sought from external configuration.
	public static final String BROWSER = "firefox";
	// we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static final String URL = "https://support.google.com/youtube/answer/6180214?ref_topic=9257109";
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
		
		driver.get(URL);
		driver.manage().window().maximize();

		//We are saving the data of parent Window
		String parentWindow = driver.getWindowHandle();
		//Find the a-tag which has the span with 'YouTube' text inside it and click it
		driver.findElement(By.xpath("//span[text()='YouTube']//parent::a")).click();
		//get a set of open window-handles
		//Set is an unordered collection of items
		Set<String> windows = driver.getWindowHandles();
		
		//The iterator gives the element in a random order so we wont use it here
		//Iterator<String> windowIterator = windows.iterator();	
		
		// The child window is one of the two items in our set
		String childWindow = "";
		for (String child: windows) {
			if (child != parentWindow) {
				childWindow = child;
			}
		}
		driver.switchTo().window(childWindow);
		
		driver.manage().window().maximize();
		// We use implicit-wait to specify the maximum wait-time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//accept cookies
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]")).click();
		
		// We could use explicit-wait and when searching the search-field after shutting down cookie-dialog and then activate it with click
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// WebElement searchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
		// searchbox.click();
		
		// We use Fluent-wait to locate the search-box before inputting our query, polling it every 500 milliseconds
		Wait<WebDriver> waitFluently = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(StaleElementReferenceException.class);
		WebElement search = waitFluently.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
		search.sendKeys(Keys.RETURN);
		search.sendKeys(QUERY);
		search.sendKeys(Keys.RETURN);
		
		driver.quit();
	}
}
