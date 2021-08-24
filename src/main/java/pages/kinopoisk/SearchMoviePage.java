package pages.kinopoisk;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;

import java.util.List;

public class SearchMoviePage extends AbstractPage {

    private final By inputFindFilm = By.id("find_film");
    private final By selectYear = By.name("m_act[from_year]");
    private final By selectGenre =  By.xpath("//select[@name='m_act[genre][]']");
    private final By checkboxGenre =  By.id("m_act[genre_and]");
    private final By submitButton = By.cssSelector(".el_18.submit.nice_button");
    private final By webList = By.xpath("//div[@class='search_results search_results_last']/div[@class='element']");

    public SearchMoviePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        super.getDriver().get("https://www.kinopoisk.ru/s/");
    }

    public boolean atPage() {
        return super.getDriver().getTitle().equals("Расширенный поиск");
    }

    public boolean enterFilmName(String name) {
        try {
            super.getDriver().findElement(inputFindFilm).sendKeys(name);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean enterBeginningYear(String startYear) {
        try {
            Select yearSelect = new Select(super.getDriver().findElement(selectYear));
//            yearSelect.getOptions().forEach(options -> {
//                System.out.println("Value = " + options.getAttribute("value") + " Text: " + options.getText());
//            });
            yearSelect.selectByValue(startYear);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean enterGenre(String myGenre) {
        try {
            Select genreSelect = new Select(super.getDriver().findElement(selectGenre));
            genreSelect.getOptions().forEach(options -> {
                System.out.println("Value = " + options.getAttribute("value") + " Text: " + options.getText());
            });

            genreSelect.selectByVisibleText(myGenre);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean useCheckbox() {
        try {
            WebElement checkbox = super.getDriver().findElement(checkboxGenre);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean pressSubmitButton() {
        try {
            super.getDriver().findElement(submitButton).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean showRating() {
        try {
            List<WebElement> webElementList = super.getDriver().findElements(webList);

            for (WebElement webElement : webElementList) {
                System.out.println("Фильм : " +
                        webElement.findElement(By.xpath(".//div[@class='info']/p")).getText()
                );
                try {

                    System.out.println(". Имеет рейтинг " + webElement.findElement(By.xpath(".//div[@class='rating  ratingGreenBG']")).getText());
                } catch (NoSuchElementException e) {
                    System.out.println(". Не имеет рейтинг ");
                }
            }

            try {
                super.close();
            } catch (Exception e) {
                System.out.println("Can't close the window!!!");
            }

            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
