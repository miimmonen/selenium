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

public class CheckBoxDemo {

	// The browser to be used, can be e.g. sought from external configuration.
	public static String browser = "firefox";
	// we are referencing the WebDriver -interface
	public static WebDriver driver;
	public static final String URL = "https://demo.seleniumeasy.com/basic-checkbox-demo.html";

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

		driver.findElement(By.id("isAgeSelected")).sendKeys(Keys.SPACE);
		boolean selected = driver.findElement(By.id("isAgeSelected")).isSelected();
		System.out.printf("is it selected: %s \n", selected);
		
		List<WebElement> cb = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(cb.size());
		
		for (int i = 0; i<cb.size();) {
			cb.get(i).findElement(By.xpath("//label[text()='Option 1']//child::input")).sendKeys(Keys.SPACE);
			i++;
		}

		driver.close();
	}
}
