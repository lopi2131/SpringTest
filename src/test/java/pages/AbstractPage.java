package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public abstract class AbstractPage {

    protected RemoteWebDriver driver;

    public AbstractPage(RemoteWebDriver driver) { this.driver = driver; }
}
