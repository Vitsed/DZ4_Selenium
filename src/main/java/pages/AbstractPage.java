package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage implements AutoCloseable{

    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {

        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public abstract void open();

    public abstract boolean atPage();

    @Override
    public void close() throws Exception {
        driver.close();
    }
}
