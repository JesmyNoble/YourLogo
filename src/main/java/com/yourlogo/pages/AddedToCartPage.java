package com.yourlogo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;
import com.yourlogo.utilities.Utils;

public class AddedToCartPage extends Base {

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
	WebElement addedToCartIcon;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement addedToCartMsg;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedCheckoutBtn;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]//div[1]/img")
	WebElement productimg;

	public static final String productAddedMsg = "Product successfully added to your shopping cart";
	private String mName;

	public AddedToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateAddedToCartDetails() {

		assertTrue(addedToCartIcon.isDisplayed(), "Added to Cart Tick mark not Found !!!");
		assertEquals(addedToCartMsg.getText(), productAddedMsg, " Successfully Added- message not found !!!");

	}

	public void clickonProceedToCheckout() {
		mName = productimg.getAttribute("alt");
		Utils.waitForElementVisible(proceedCheckoutBtn);

		assertTrue(proceedCheckoutBtn.isEnabled(), "Proceed To Checkout Button should be enabled !!!");
		if (proceedCheckoutBtn.isEnabled()) {
			proceedCheckoutBtn.click();
		}
	}

	public String returnProductName() {
		return mName;
	}

}
