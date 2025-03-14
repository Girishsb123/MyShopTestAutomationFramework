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
public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "Peter@gmail.com";
	private static final String INVALID_PASSWORD = "Qwerty123";

	@Test(description = "Verify if the proper error message is shown for user the user when they enter invalid credentials", groups = {
			"e2e", "smoke" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentails(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}

}
