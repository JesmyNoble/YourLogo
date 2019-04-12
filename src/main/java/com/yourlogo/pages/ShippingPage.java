package com.yourlogo.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;

public class ShippingPage extends Base {

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement cartDetailsTab;

	@FindBy(id = "cgv")
	WebElement termConditionsChkBx;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedtoChekout;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyAndProceed() {
		assertTrue(cartDetailsTab.isDisplayed(), "Cart Details should be displayed");
		if (!termConditionsChkBx.isSelected()) {
			termConditionsChkBx.click();
		}
		proceedtoChekout.click();

	}
}
