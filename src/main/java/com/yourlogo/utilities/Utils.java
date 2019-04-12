package com.yourlogo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yourlogo.base.Base;

public class Utils extends Base{
	public static long Page_Load_TimeOut = 20;
    public static long Implicit_WAIT = 10;
    public static int explicit_Wait=30;
    
    public static WebDriverWait wait;
    
    
    public static void waitForElementVisible(WebElement element) {
    	wait=new WebDriverWait(driver, explicit_Wait);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }

}
