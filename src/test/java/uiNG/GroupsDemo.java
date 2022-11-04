package uiNG;

import org.testng.annotations.Test;

import common.CommonDataSetup;

@Test(groups="acceptance")
public class GroupsDemo extends CommonDataSetup {
	
	@Test(priority=1, groups="security" )
	public void ATest1() {
		System.out.println("First test in groups");

	}

	@Test(priority=2, groups="security")
	public void ATest2() {
		System.out.println("Second test in groups");
	}

	@Test(priority=1, groups= {"security", "database"})
	public void BTest1() {
		System.out.println("third test in groups");

	}

	@Test(priority=2, groups= {"security", "database"})
	public void BTest2() {
		System.out.println("fourth test in groups");
	}

}
