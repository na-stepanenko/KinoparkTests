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
public class PersonalPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(PersonalPage.class);

    private final String BASE_URL = "http://kinopark.by/my/";

    @FindBy(className = "my_content")
    private WebElement contentContainer;

    public PersonalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Personal page opened");
    }

    public boolean annotationListIsNotEmpty(){
        List<WebElement> annotations = contentContainer.findElements(By.className("rev"));
        return !annotations.isEmpty();
    }
}
