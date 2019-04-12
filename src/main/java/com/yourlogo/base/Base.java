package com.yourlogo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.yourlogo.utilities.Utils;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	public static String configFilename = "/Users/noblepp/Desktop/Jesmy/JavaProjects/MavenProjects/YourLogoProj/YourLogoPro/src/main/java/src/main/resources/log4j.properties";
	public static final org.apache.log4j.Logger logger = LogManager.getLogger(Base.class.getName());

	public Base() {
		try {
			prop = new Properties();
			FileInputStream propFile = new FileInputStream(
					"/Users/noblepp/Desktop/Jesmy/JavaProjects/MavenProjects/YourLogoProj/YourLogoPro/src/main/java/com/yourlogo/config/config.properties");
			try {
				prop.load(propFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public static void getlogger() {
		PropertyConfigurator.configure(configFilename);
	}

	public static void initializeApp() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/noblepp/Desktop/Jesmy/JavaProjects/ChromeDriver/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.Implicit_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
