package class2015.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anastasia on 28/12/2015.
 */
public class LoginPage extends AbstractPage {
    private final Logger logger = Logger.getLogger(LoginPage.class);

    private final String BASE_URL = "http://kinopark.by/login.cgi?target=2f";

    @FindBy(xpath = "//input[@name='userid']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordInput;

    @FindBy(className = "disableableButton")
    private WebElement submitButton;


    @FindBy(xpath = "//span[@id = 'header_username']/a")
    private WebElement userNameSpan;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);// wait for login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id = 'header_username']/a")));
        logger.info("Logged in");
    }

    public boolean loggedIn(String login){
        return login.equals(userNameSpan.getText());
    }
}
