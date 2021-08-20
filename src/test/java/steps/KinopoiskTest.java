package steps;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.kinopoisk.KinopoiskMainPage;

import static org.junit.Assert.assertTrue;

public class KinopoiskTest {

    KinopoiskMainPage mainPage =
            new KinopoiskMainPage(new ChromeDriver());

    @Test
    public void searchMovie() {
        mainPage.open();
        assertTrue(mainPage.atPage());
        mainPage.goToFilmSearchPage();
    }

}
