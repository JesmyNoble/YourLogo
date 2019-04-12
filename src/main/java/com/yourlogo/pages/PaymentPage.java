package com.yourlogo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;

public class PaymentPage extends Base {

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedtoChekout;

	@FindBy(xpath = "//*[@id='cart_summary']/tbody//td[2]/p/a")
	WebElement productSummaryName;

	@FindBy(xpath = "//*[@id='cart_summary']/tbody//td[2]/small/a")
	WebElement productSummaryDetails;

	public static final String PRODUCT_SIZE = "Size : M";

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyProductDetails(String productName) {

		logger.info("In Payment Page");
		assertEquals(productSummaryName.getText(), productName, " Product name is not correct !!!");
		assertTrue(productSummaryDetails.getText().contains(PRODUCT_SIZE), "Product size not match !!!");

	}
}
