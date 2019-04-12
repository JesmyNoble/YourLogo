package com.yourlogo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;

public class ShoppingCartPage extends Base {

	@FindBy(id = "cart_title")
	WebElement shoppingCartH1;

	@FindBy(xpath = "//a[@title='Continue shopping']")
	WebElement continueShoppingLnk;

	@FindBy(xpath = "//td/p[@class='product-name']")
	WebElement productName;

	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;

	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}

	public static final String SHOPPING_CART_HEADING = "SHOPPING-CART SUMMARY";
	public static final String CONTINUE_SHOPPING_LINK = "Continue shopping";

	public void validateShoppingCart() {

		logger.info("In Shopping Cart Page");
		assertTrue(shoppingCartH1.getText().contains(SHOPPING_CART_HEADING), "Shopping cart Heading is not correct");
		assertEquals(continueShoppingLnk.getText(), CONTINUE_SHOPPING_LINK, "Continue Shopping Link not present");
		assertTrue(productName.isDisplayed(), "Product is not displayed");
		assertTrue(proceedToCheckOutBtn.isEnabled(), "Proceed to Checkout is not Enabled");

	}

	public void clickonProceedToCheckout() {
		if (proceedToCheckOutBtn.isEnabled()) {
			proceedToCheckOutBtn.click();
		}
	}
}
