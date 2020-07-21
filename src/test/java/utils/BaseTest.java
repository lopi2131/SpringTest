package utils;

import config.SpringConfig;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = {SpringConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriverFactory factory;

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = factory.getObject();
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
    }

   /* @AfterMethod
    public void tearDown() {
        *//*if (driver != null) {
            driver.quit();
        }*//*
        driver.manage().deleteAllCookies();
    }*/

    /*@AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }*/
}
