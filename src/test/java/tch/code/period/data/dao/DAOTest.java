package tch.code.period.data.dao;

import java.net.UnknownHostException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tch.code.period.data.dao.impl.PeriodDAOImpl;


public class DAOTest {
	PeriodDAOImpl periodDAOImpl;

	@BeforeMethod
	public void beforeMethod() throws UnknownHostException {
		periodDAOImpl = new PeriodDAOImpl("test");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" },
				new Object[] { 2, "b" }, };
	}
	
	@Test(expectedExceptions = NullPointerException.class)
	public void noCollectionDefinedTest() {
		periodDAOImpl.findAllPeriods();
	}
	
	

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
