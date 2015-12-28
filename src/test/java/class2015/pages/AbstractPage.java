package class2015.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Anastasia on 28/12/2015.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
