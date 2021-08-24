package steps;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.kinopoisk.KinopoiskMainPage;
import pages.kinopoisk.SearchMoviePage;

import static org.junit.Assert.assertTrue;

public class KinopoiskTest {

    KinopoiskMainPage mainPage;
    SearchMoviePage searchMoviePage;

    @Before
    public void settings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        mainPage =
                new KinopoiskMainPage(new ChromeDriver());
        mainPage.getDriver().manage().window().maximize();
    }


    @Test
    public void searchMovie() {

        mainPage.open();
        assertTrue(mainPage.atPage());
        searchMoviePage = mainPage.goToFilmSearchPage();
        assertTrue(searchMoviePage.atPage());

        searchMoviePage.enterFilmName("Назад в будущее");
        searchMoviePage.enterBeginningYear("1985");
        searchMoviePage.enterGenre("комедия");
        searchMoviePage.useCheckbox();
        searchMoviePage.pressSubmitButton();
        searchMoviePage.showRating();

        try {
            searchMoviePage.close();
        } catch (Exception e) {
            System.out.println("Can't close the window!!!");
        }
    }

}
