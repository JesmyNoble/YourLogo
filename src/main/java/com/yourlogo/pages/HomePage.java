package com.yourlogo.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yourlogo.base.Base;
import com.yourlogo.utilities.Utils;

public class HomePage extends Base{

	// Page Factory

    @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
    WebElement yourLogoImg;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenTab;

    @FindBy(xpath = "//ul/li[1]/ul//a[@title='Summer Dresses']")
    WebElement summerDresses;
    
    
    public HomePage() {
        PageFactory.initElements(driver, this); 
        Base.getlogger();
    }
    
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public Boolean validateLogo() {
    	return yourLogoImg.isDisplayed();
    }
    public void validateHomePage() {
    	assertNotNull(validateLoginPageTitle(),"Title not displayed !!!");
    	assertTrue(validateLogo(), "YourLogo not displayed !!!");
    	
    	logger.info("In HomePage");
    }
    
    public void clickSummerDressFromWomenTab() {
    	Actions action = new Actions(driver);
    	action.moveToElement(womenTab).perform();
    	Utils.waitForElementVisible(summerDresses);
    	action.moveToElement(summerDresses).build().perform();
    	summerDresses.click();
    }
}
