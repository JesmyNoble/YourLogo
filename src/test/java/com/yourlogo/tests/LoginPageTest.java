package com.yourlogo.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.base.Base;
import com.yourlogo.pages.AddedToCartPage;
import com.yourlogo.pages.AddressesPage;
import com.yourlogo.pages.AuthenticationPage;
import com.yourlogo.pages.HomePage;
import com.yourlogo.pages.PaymentPage;
import com.yourlogo.pages.ShippingPage;
import com.yourlogo.pages.ShoppingCartPage;
import com.yourlogo.pages.SummerDressPage;

public class LoginPageTest extends Base{

	  HomePage homePage;  // helps to use it through out the function
	 
	  SummerDressPage summerDressPage;
	  AddedToCartPage addedToCartPage;
	  ShoppingCartPage shoppingCartPage;
	  AuthenticationPage authenticationPage;
	  AddressesPage addressesPage;
	  ShippingPage shippingPage;
	  PaymentPage paymentPage;
	    public LoginPageTest() {
	        super();   // It will help to call constructor
	    }

	    @BeforeMethod
	    public void setUp() {
	        initializeApp();
	        homePage = new HomePage();

	        summerDressPage = new SummerDressPage();
	        addedToCartPage = new AddedToCartPage();
	        shoppingCartPage =new ShoppingCartPage();
	        authenticationPage = new AuthenticationPage();
	        addressesPage = new AddressesPage();
	        shippingPage = new ShippingPage();
	        paymentPage = new PaymentPage();
	    }
	    
	    @Test
	    public void BuySummerChiffonDressAfterRegisterTest() {
	    	
	    	homePage.validateHomePage();
	    	homePage.clickSummerDressFromWomenTab();
	    	summerDressPage.clickOnDressImg(summerDressPage.selectChiffonDress());
	    	summerDressPage.selectSizeFrmDropDn(summerDressPage.getMsize());
	    	summerDressPage.clickOnAddtoCart();
	    	addedToCartPage.validateAddedToCartDetails();
	    	addedToCartPage.clickonProceedToCheckout();
	    	shoppingCartPage.validateShoppingCart();
	    	shoppingCartPage.clickonProceedToCheckout();
	    	
	    	authenticationPage.createAccount();
	    	authenticationPage.enterDetailsandRegister();
	    	
	    	addressesPage.clickOnProceedtoCheckout();
	    	
	    	shippingPage.verifyAndProceed();
	    	
	    	paymentPage.verifyProductDetails(addedToCartPage.returnProductName());
	    	
	    	
	    }
	    
	    @AfterMethod
	    public void teardown() {
	    	driver.quit();
	    } 
}
