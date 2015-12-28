package class2015.steps;

import class2015.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anastasia on 28/12/2015.
 */
public class Steps {
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver() {
        driver.quit();
    }

    public void login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(login, password);
    }

    public boolean loggedIn(String userName) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.loggedIn(userName);
    }

    public void search(String filmName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchFilm(filmName);
    }

    public boolean isSuccessfulSearch(String filmName) {
        MainPage mainPage = new MainPage(driver);
        return mainPage.isSuccessfulSearch(filmName);
    }

    public void setFilmRating(){
        FilmInfoPage filmInfoPage = new FilmInfoPage(driver);
        filmInfoPage.openPage();
        filmInfoPage.setFilmRate();

    }

    public boolean checkFilmRating(String filmName){
        FilmInfoPage filmInfoPage = new FilmInfoPage(driver);
        boolean result = filmInfoPage.checkFilmRate(filmName);
        filmInfoPage.unsetFilmRate();
        return result;
    }

    public boolean annotationListIsNotempty(){
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.openPage();
        return personalPage.annotationListIsNotEmpty();
    }

    public void setName(String name){
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPage();
        settingsPage.changeName(name);
    }

    public boolean checkName(String name){
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPage();
        return settingsPage.checkName(name);
    }

}
