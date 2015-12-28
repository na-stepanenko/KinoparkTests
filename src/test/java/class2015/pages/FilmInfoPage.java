package class2015.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Anastasia on 28/12/2015.
 */
public class FilmInfoPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(FilmInfoPage.class);

    private static final String BASE_URL = "http://kinopark.by/film30284.html";
    private static final String MY_FILMS_PAGE = "http://kinopark.by/my/films/";

    @FindBy( id = "my_vote_href")
    private WebElement filmRateSelect;

    @FindBy (className = "r10")
    private WebElement filmRateOptionMasterpiece;
    @FindBy (className = "r11")
    private WebElement filmRateOptionWithoutRating;
    @FindBy (tagName = "tr")
    private WebElement filmRateInfoList;

    public FilmInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Film info page opened");
    }

    public void setFilmRate(){
        filmRateSelect.click();
        filmRateOptionMasterpiece.click();
    }

    public boolean checkFilmRate(String filmName){
        driver.navigate().to(MY_FILMS_PAGE);
        List<WebElement> rateInfo = filmRateInfoList.findElements(By.tagName("td"));
        return filmName.equals(rateInfo.get(1).getText()) && "шедевр".equals(rateInfo.get(2).getText());
    }

    public void unsetFilmRate(){
        driver.navigate().to(BASE_URL);
        filmRateSelect.click();
        filmRateOptionWithoutRating.click();
    }
}
