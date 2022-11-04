package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Setup and teardown of the testdata.
 * 
 * @author MiikaI
 *
 */
public class CommonDataSetup {
	
	@BeforeSuite
	public void dataSetup() {
		System.out.println("Common data setup");
	}
	
	@AfterSuite
	public void dataTearDown() {
		System.out.println("Common data cleanup");
	}

}
