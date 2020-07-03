package pages;

import com.example.demo.HabrWeb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(HabrWeb.class);

    private By firstPost = By.xpath(".//li[@class='content-list__item content-list__item_post shortcuts_item'][1]");
    private By hubs = By.xpath(".//h3[contains(text(),'Хабы и компании')]");
    private By otusBlog = By.xpath(".//em[contains(text(),'OTUS')]");
    private By usersButn = By.xpath(".//h3[contains(text(),'Пользователи')]");
    private By users = By.xpath(".//li[@class='content-list__item  content-list__item_users table-grid js-subscribe_item']");
    private By vvzOtus = By.xpath("//a[contains(@class,'list-snippet__fullname')][contains(text(),'vvz-otus')]");
    private By subs = By.xpath(".//a[contains(text(),'OTUS. Онлайн-образование')]");
    private By languageForm = By.xpath("//button[@class='btn btn_medium btn_navbar_lang js-show_lang_settings']");
    private By engInterf = By.xpath("//label[contains(text(),'English')]");
    private By saveBtn = By.xpath("//button[@class='btn btn_blue btn_huge btn_full-width js-popup_save_btn']");
    private By bookmarks = By.xpath("//h3[contains(text(),'Bookmarks')]");
    private By management = By.xpath("//a[contains(text(),'Management')]");

    public Management moveToManagement(){
        driver.findElement(management).click();
        logger.info("Переход во вкладку Management");

        return new Management(driver);
    }


    public String checkFirstPost() {
        logger.info("Проверка заголовка первого поста");

        return driver.findElement(firstPost).getText();
    }

    public String checkInterfaceLang(){
        logger.info("Проверка языка интерфейса");
        Boolean langInt = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.urlContains("/en/"));
        logger.info("Проверка языка интерфейса");

        return driver.findElement(bookmarks).getText().toLowerCase();
    }

    public SearchPage setLanguage() {
        WebElement lang = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(languageForm));
        lang.click();
        driver.findElement(engInterf).click();

        WebElement save = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        save.click();
        logger.info("Смена языка");

        return new SearchPage(driver);
    }

    public SearchPage moveToHub() {
        WebElement hub = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(hubs));
        hub.click();
        logger.info("Переход в 'Хабы и Компании'");

        return new SearchPage(driver);
    }

    public SearchPage moveToUsers() {
        WebElement user = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(usersButn));
        user.click();
        logger.info("Переход в 'Пользователи'");

        return new SearchPage(driver);
    }

    public SearchPage moveToOtusUser() {
        WebElement otusUser = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(vvzOtus));
        otusUser.click();
        logger.info("Переход в 'OTUS'");

        return new SearchPage(driver);
    }

    public String checkSubs() {
        logger.info("Проверка подписок");

        return driver.findElement(subs).getText();
    }

    public int checkUsersCount() {
        logger.info("Проверка количества пользователей");

        return driver.findElements(users).size();
    }

    public String checkOtusBlog() {
        logger.info("Проверка наличия блога OTUS");

        return driver.findElement(otusBlog).getText();
    }


    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
