package uiNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Trying out that testNG works and some basic annotations and attributes
 * 
 * @author MiikaI
 *
 */
public class LoginTest {
	
	/**
	 * Runs before tests
	 */
	@BeforeTest
	public void loginToApplication() {
		System.out.println("Login to application");
	}
	
	/**
	 * Runs after tests
	 */
	@AfterTest
	public void logOutFromApplication() {
		System.out.println("Logout from application");
	}
	
	/**
	 * Runs before each test
	 */
	@BeforeMethod
	public void establishConnection() {
		System.out.println("Establishing connection");
	}
	
	/**
	 * Runs after each test
	 */
	@AfterMethod
	public void disconnect() {
		System.out.println("Disconnected");
	}

	@Test(priority=1, description="A primary test")
	public void Test1() {
		System.out.println("First test");

	}

	@Test(priority=2, description="A secondary test")
	public void Test2() {
		System.out.println("Second test");
	}
}
