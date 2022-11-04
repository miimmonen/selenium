package uiNG;

import org.testng.annotations.Test;

@Test(groups="acceptance")
public class GroupsDemo {
	
	@Test(priority=1, groups="security" )
	public void ATest1() {
		System.out.println("First test");

	}

	@Test(priority=2, groups="security")
	public void ATest2() {
		System.out.println("Second test");
	}

	@Test(priority=1, groups= {"security", "database"})
	public void BTest1() {
		System.out.println("third test");

	}

	@Test(priority=2, groups= {"security", "database"})
	public void BTest2() {
		System.out.println("fourth test");
	}

}
