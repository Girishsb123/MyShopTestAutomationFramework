package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);// To call parent class const.. from child class
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		super(driver);// To call parent class const.. from child class
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@title='Log in to your customer account']");

	public LoginPage goToLoginPage() { // Page functions -- > can't use void
		logger.info("Trying to performing click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}

	public void quit() {
         
	}

}
