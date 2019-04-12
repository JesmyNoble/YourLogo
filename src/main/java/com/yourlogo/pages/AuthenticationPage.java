package com.yourlogo.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.yourlogo.base.Base;

public class AuthenticationPage extends Base {

	@FindBy(id = "email_create")
	WebElement emailTxtFld;

	@FindBy(id = "SubmitCreate")
	WebElement createAccBtn;

	@FindBy(id = "customer_firstname")
	WebElement fNameTxtFld;

	@FindBy(id = "customer_lastname")
	WebElement lNameTxtFld;

	@FindBy(id = "passwd")
	WebElement passwdTxtFld;

	@FindBy(id = "firstname")
	WebElement fnameInAddTxtFld;

	@FindBy(id = "lastname")
	WebElement lnameInAddTxtFld;

	@FindBy(id = "address1")
	WebElement address1TxtFld;

	@FindBy(id = "city")
	WebElement cityTxtFld;

	@FindBy(id = "id_state")
	WebElement stateTxtFld;
	@FindBy(id = "postcode")
	WebElement postalCodeTxtFld;

	@FindBy(id = "phone_mobile")
	WebElement mobPhTxtFld;
	@FindBy(id = "alias")
	WebElement addressaliasTxtFld;

	@FindBy(id = "submitAccount")
	WebElement registerBtn;

	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}

	public void createAccount() {
		emailTxtFld.clear();
		emailTxtFld.sendKeys(Base.prop.getProperty("emailId"));
		createAccBtn.click();

	}

	public void enterPersonelDetails() {
		logger.info("In Authentication Page");
		fNameTxtFld.sendKeys(Base.prop.getProperty("fName"));
		lNameTxtFld.sendKeys(Base.prop.getProperty("lName"));
		passwdTxtFld.sendKeys(Base.prop.getProperty("pw"));
	}

	public void enterAddressDetails() {
		fnameInAddTxtFld.sendKeys(Base.prop.getProperty("fName"));
		lnameInAddTxtFld.sendKeys(Base.prop.getProperty("lName"));
		address1TxtFld.sendKeys(Base.prop.getProperty("address1"));
		cityTxtFld.sendKeys(Base.prop.getProperty("city"));

		Select stateDrp = new Select(stateTxtFld);
		stateDrp.selectByVisibleText(Base.prop.getProperty("state"));

		postalCodeTxtFld.sendKeys(Base.prop.getProperty("zipCode"));
		mobPhTxtFld.sendKeys(Base.prop.getProperty("mobPh"));
		addressaliasTxtFld.sendKeys(Base.prop.getProperty("addAlias"));

	}

	public void enterDetailsandRegister() {
		enterPersonelDetails();
		enterAddressDetails();
		assertTrue(registerBtn.isEnabled(), "Register button should be enabled");
		registerBtn.click();
	}
}
