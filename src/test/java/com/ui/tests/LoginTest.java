package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

/*
 * Test methods
 * 
 * 1.Test script small 2.Can't have conditional statements,try catch and loops
 * 3.Reduce the use of local vars 4.Should have atleast one assertion
 * 
 */
@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase{

	Logger logger = LoggerUtility.getLogger(this.getClass());


	@Test(description = "Verifies with valid user is able to login to the application ", groups = { "e2e",
			"smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Girish sb");

	}

//	@Test(description = "Verifies with valid user is able to login to the application ", groups = { "e2e",
//			"smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Girish sb");
//
//	}
//
//	@Test(description = "Verifies with valid user is able to login to the application ", groups = { "e2e",
//			"smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzire.class)
//	public void loginExcelTest(User user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Girish sb");
//
//	}

}
