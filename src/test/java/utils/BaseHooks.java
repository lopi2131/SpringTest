package utils;

import config.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = {SpringConfig.class})
public class BaseHooks extends AbstractTestNGSpringContextTests {

    @Autowired
    public MainPage mainPage;

    @Autowired
    protected  WebDriver driver;

    @Autowired
    public CompaniesPage companiesPage;

    @Autowired
    public SiteInformPage siteInformPage;

    @Autowired
    public SearchPage searchPage;

    @Autowired
    public Management management;

    @Autowired
    public SignUpPage signUpPage;

    @Autowired
    public LogInPage logInPage;


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
