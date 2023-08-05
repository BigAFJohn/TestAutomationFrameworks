package com.demoblaze.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.demoblaze.Utilities.ExtentManager;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
    public static Properties prop;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    static {
        try {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            context.reset();
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            configurator.doConfigure("C:\\Users\\bigaf\\eclipse-workspace\\NewPOMFramework\\TestAutomationFrameworks\\Framework1\\logback.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
    public Properties loadConfig() {
        ExtentManager.setExtent();

        prop= new Properties();

        try {
            FileInputStream ip = new FileInputStream("Configurations/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browserName) {
        launchApp(browserName);
    }

    public void launchApp(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterSuite()
    @AfterTest
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
