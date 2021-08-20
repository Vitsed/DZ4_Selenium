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
        System.setProperty("webdriver.chrome.driver", "D:\\Soft\\Selenium\\chromedriver.exe");
        mainPage =
                new KinopoiskMainPage(new ChromeDriver());
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
    }

}
