package config;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pages.*;


@Configuration
@ComponentScan(basePackages = "config")
public class SpringConfig {

    private Logger logger = LogManager.getLogger(SpringConfig.class);

    /*@Bean
    public RemoteWebDriver driver() throws MalformedURLException {
        logger.info("Драйвер поднят");

        return Browsers.valueOf(System.getProperty("browser").toUpperCase()).create();
    }*/

    @Bean
    public WebDriverFactory driverFactory() {
        logger.info("Драйвер поднят");

        return new WebDriverFactory();
    }


    @Bean
    public MainPage mainPage(RemoteWebDriver driver) {

        return new MainPage(driver);
    }

    @Bean
    public CompaniesPage companiesPage(RemoteWebDriver driver) {

        return new CompaniesPage(driver);
    }

    @Bean
    public SiteInformPage siteInformPage(RemoteWebDriver driver) {

        return new SiteInformPage(driver);
    }

    @Bean
    public SearchPage searchPage(RemoteWebDriver driver) {

        return new SearchPage(driver);
    }

    @Bean
    public ManagementPage management(RemoteWebDriver driver) {

        return new ManagementPage(driver);
    }

    @Bean
    public SignUpPage signUpPage(RemoteWebDriver driver) {

        return new SignUpPage(driver);
    }

    @Bean
    public LogInPage logInPage(RemoteWebDriver driver) {

        return new LogInPage(driver);
    }

}
