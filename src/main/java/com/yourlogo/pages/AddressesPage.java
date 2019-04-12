package com.yourlogo.pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;
import com.yourlogo.utilities.Utils;

public class AddressesPage extends Base {

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement proceedCheckoutBtn;

	public AddressesPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnProceedtoCheckout() {

		logger.info("In Address Page");
		Utils.waitForElementVisible(proceedCheckoutBtn);
		assertTrue(proceedCheckoutBtn.isEnabled(), "Proceed to checkout Button is not enabled !!!");
		if (proceedCheckoutBtn.isEnabled()) {
			proceedCheckoutBtn.click();
		}
	}
}
