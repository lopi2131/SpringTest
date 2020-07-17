package utils;

import config.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = {SpringConfig.class})
public class BaseHooks extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;


    @BeforeClass
    public  void setUp(){
        if (driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public  void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void cleanUp() { driver.manage().deleteAllCookies(); }
}
