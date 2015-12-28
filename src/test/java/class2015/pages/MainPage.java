package class2015.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anastasia on 28/12/2015.
 */
public class MainPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(MainPage.class);

    private final String BASE_URL = "http://kinopark.by";

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@value = 'Найти']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id = 'film_info']//h1")
    private WebElement filmNameHeader;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
    }

    public void searchFilm(String filmName){
        searchField.sendKeys(filmName);
        searchButton.click();
    }

    public boolean isSuccessfulSearch(String filmName){
        return filmName.equals(filmNameHeader.getText());
    }
}
