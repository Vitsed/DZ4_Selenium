package pages.kinopoisk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

public class KinopoiskMainPage extends AbstractPage {

    private By link = By.cssSelector("._2-oC2TAEVytFdm6Kvbc7Hu");


    public KinopoiskMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        super.getDriver().get("https://www.kinopoisk.ru/");
    }


    public boolean atPage() {
        return super.getDriver().getTitle().equals("КиноПоиск. Все фильмы планеты.");
    }

    public SearchMoviePage goToFilmSearchPage() {
        WebElement linkToSearchPage = super.getDriver().findElement(link);
        linkToSearchPage.click();
        return new SearchMoviePage(super.getDriver());
    }
}
