package pages.kinopoisk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

public class SearchMoviePage extends AbstractPage {

    private final By inputFindFilm = By.id("find_film");
    private final By selectYear = By.name("m_act[from_year]");
    private final By selectGenre =  By.xpath("//select[@name='m_act[genre][]']");
    private final By checkbox =  By.id("m_act[genre_and]");
    private final By webElementList = By.xpath("//div[@class='search_results search_results_last']/div[@class='element']");

    public SearchMoviePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        super.getDriver().get("https://www.kinopoisk.ru/s/");
    }

    public boolean atPage() {
        return super.getDriver().getTitle().equals("Расширенный поиск.");
    }



}
