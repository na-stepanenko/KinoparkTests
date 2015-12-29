package class2015.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SettingsPage extends AbstractPage {
    private final Logger logger = Logger.getLogger(PersonalPage.class);

    private final String BASE_URL = "http://kinopark.by/my/settings/";

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@value = 'Сохранить']")
    private WebElement submitButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Settings page opened");
    }

    public void changeName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);// wait for login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_message")));
    }

    public boolean checkName(String name){
        return name.equals(nameInput.getAttribute("value"));
    }
}
