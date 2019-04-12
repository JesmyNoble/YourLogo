package com.yourlogo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.yourlogo.base.Base;
import com.yourlogo.utilities.Utils;

public class SummerDressPage extends Base {

	// Page Factory
	/*
	 * @FindBy(id = "layered_id_attribute_group_2") WebElement sizeM;
	 */

	@FindBy(xpath = "//*[@id='center_column']//a[1]/img[@alt='Printed Chiffon Dress']")
	WebElement printedChifonDressImg;

	@FindBy(id = "group_1")
	WebElement sizeDropdown;

	@FindBy(id = "add_to_cart")
	WebElement addToCardBtn;

	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	WebElement frameInToCardBtn;

	public static final String sizeM = "M";

	public SummerDressPage() {
		PageFactory.initElements(driver, this);
		Base.getlogger();
	}

	public WebElement selectChiffonDress() {
		logger.info("In SummerDress Page");
		return printedChifonDressImg;
	}

	public String getMsize() {
		return sizeM;
	}

	public void selectSizeFrmDropDn(String size) {
		try {
			driver.switchTo().frame(frameInToCardBtn);
			Select sizeDrp = new Select(sizeDropdown);
			sizeDrp.selectByVisibleText(size);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			logger.error("Size dropdown not found!!!");
		}
	}

	public void clickOnDressImg(WebElement dress) {
		if (dress.isDisplayed()) {
			dress.click();
		}

	}

	public void clickOnAddtoCart() {
		if (addToCardBtn.isEnabled()) {
			addToCardBtn.click();
		} else {
			logger.debug("Add to cart is not enabled!!!");
		}
	}

}
