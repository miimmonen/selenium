package uiNG;

import org.testng.annotations.Test;

/**
 * Trying out that testNG works and some basic annotations and attributes
 * 
 * @author MiikaI
 *
 */
public class LoginTest {

	@Test(priority=1, description="User can login")
	public void loginTest() {
		System.out.println("Login is succesful");

	}

	@Test(priority=2, description="User can logout")
	public void logoutTest() {
		System.out.println("Logout is succesful");
	}
}
