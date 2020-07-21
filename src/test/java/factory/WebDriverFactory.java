package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.FactoryBean;
import utils.Browsers;

public class WebDriverFactory implements FactoryBean<RemoteWebDriver> {

    @Override
    public RemoteWebDriver getObject() throws Exception {
        return Browsers.valueOf(System.getProperty("browser").toUpperCase()).create();
    }

    @Override
    public Class<?> getObjectType() {
        return RemoteWebDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
