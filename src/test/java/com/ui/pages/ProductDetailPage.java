package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.devtools.v127.systeminfo.model.Size;

import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage changeSize(Enum<com.constants.Size> L) {
		selectFromDropDown(SIZE_DROP_DOWN_LOCATOR, L.toString());
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());

	}

	public ShoppingCartPage proceedToCheckout() {

		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}
}
