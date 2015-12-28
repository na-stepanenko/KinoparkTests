package class2015;

import class2015.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Anastasia on 22/12/2015.
 */
public class KinoparkAutomationTest {
    private Steps steps;
    private static final String LOGIN = "AsyaGrape";
    private static final String PASSWORD = "qazwsxedc";
    private static final String USERNAME = "AsyaGrape";
    private static final String FILM_NAME = "Маленький принц";


    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

    @Test(description = "Successful log in")
    public void successfulLogIn() {
        steps.login(LOGIN, PASSWORD);
        Assert.assertTrue(steps.loggedIn(USERNAME));
    }

    @Test(description = "Successful search")
    public void successfulSearch() {
        steps.search(FILM_NAME);
        Assert.assertTrue(steps.isSuccessfulSearch(FILM_NAME));
    }

    @Test(description = "Set film rating")
    public void setFilmRating() {
        steps.login(LOGIN, PASSWORD);
        steps.setFilmRating();
        Assert.assertTrue(steps.checkFilmRating(FILM_NAME));
    }

    @Test( description = "Non empty annotations list")
    public void annotationsListIsNotEmpty(){
        steps.login(LOGIN, PASSWORD);
        Assert.assertTrue(steps.annotationListIsNotempty());
    }

    @Test( description = "Change name")
    public void changeName(){
        steps.login(LOGIN, PASSWORD);
        String name = UUID.randomUUID().toString();
        steps.setName(name);
        Assert.assertTrue(steps.checkName(name));
    }
}
