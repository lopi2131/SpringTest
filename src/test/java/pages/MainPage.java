package pages;

import config.ServerConfig;
import config.SpringConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends AbstractPage{
    private By companies = By.xpath(".//a[@class='tabs-menu__item tabs-menu__item_link']/h3[contains(text(),\"Компании\")]");

    private Logger logger = LogManager.getLogger(MainPage.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    public MainPage(WebDriver driver) {super(driver);}


    public MainPage open() {
        driver.get(cfg.url());
        logger.info("Открыта страница Хабр");

        return this;
    }

    public CompaniesPage moveToCompanies() {
        WebElement company = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(companies));
        company.click();
        logger.info("Переход в компании");

        return new CompaniesPage(driver);
    }


}
