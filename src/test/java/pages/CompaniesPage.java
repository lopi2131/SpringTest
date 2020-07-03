package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompaniesPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(MainPage.class);

    private By findCompany = By.xpath("//input[@id='companies_suggest']");
    private By otusBlog = By.xpath("//a[@class='list-snippet__title-link']/em[@class='searched-item']");
    private By location = By.xpath(".//li[@class='defination-list__item defination-list__item_profile-summary']/span[contains(text(),\"Москва\")]");
    private By contentList = By.xpath("//li[@class='content-list__item content-list__item_post shortcuts_item']");
    private By employees = By.xpath(".//h3[contains(text(),\"Сотрудники\")]");
    private By svvyazemsky = By.xpath(".//a[contains(text(),\"Семён Вяземский\")]");
    private By vacancies = By.xpath(".//h3[contains(text(),\"Вакансии\")]");
    private By vacanciesNull = By.xpath(".//p[contains(text(),\"нет открытых вакансий\")]");
    private By siteInform = By.xpath(".//a[contains(text(),\"Устройство сайта\")]");

    public CompaniesPage(WebDriver driver) {
        super(driver);
    }


    public CompaniesPage findOtus(){
        driver.findElement(findCompany).sendKeys("otus");
        logger.info("Поиск компании OTUS");

        return new CompaniesPage(driver);
    }

    public CompaniesPage openOtus(){
        WebElement otus = (new WebDriverWait(driver,5))
                .until(ExpectedConditions.visibilityOfElementLocated(otusBlog));
        otus.click();
        logger.info("Переход в OTUS");

        return new CompaniesPage(driver);
    }

    public CompaniesPage moveToEmployees(){
        WebElement employee = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(employees));
        employee.click();
        logger.info("Переход в Сотрудники");

        return new CompaniesPage(driver);
    }

    public CompaniesPage moveToVacancies(){
        WebElement vacancy = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(vacancies));
        vacancy.click();
        logger.info("Переход в вакансии");

        return new CompaniesPage(driver);
    }

    public SiteInformPage moveToSiteInform(){
        WebElement siteInformation = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(siteInform));
        siteInformation.click();
        logger.info("Переход в 'Устройство сайта'");

        return new SiteInformPage(driver);
    }

    public String checkVacanciesListNull(){
        logger.info("Проверка, что список вакансий пуст");

        return driver.findElement(vacanciesNull).getText();
    }

    public String checkQaLead() {
        logger.info("Проверка QA Lead");

        return driver.findElement(svvyazemsky).getText();
    }

    public int checkContentList(){
        logger.info("Проверка списка публикаций");

        return driver.findElements(contentList).size();
    }

    public String checkSearchResult(){
        logger.info("Проверка результата поиска");

        return driver.findElement(otusBlog).getText();
    }

    public String checkLocation() {
        logger.info("Проверка расположения");

        return driver.findElement(location).getText();}

}
