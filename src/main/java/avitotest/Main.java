package avitotest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String CHOOSE_CATEGORY_LOC =  "category";
    private static final String SEARCH_FIELD_LOC =  "input[data-marker=\"search-form/suggest\"]";
    private static final String SELECT_CITY_LOC =  ".main-select-2pf7p.main-location-3j9by";
    private static final String ENTER_CITY_NAME_LOC =  "[data-marker='popup-location/region/input']";
    private static final String USE_FIRST_CITY_LOC =  "li[data-marker='suggest(0)']";
    private static final String PRESS_SHOW_BUTTON_LOC = "[data-marker='popup-location/save-button']";
    private static final String CHECKBOX_LOC =  "[data-marker='delivery-filter/text']";
    private static final String SORTING_LOC =  ".sort-select-3QxXG.select-select-box-3LBfK.select-size-s-2gvAy>select";
    private static final String PRESS_SUBMIT_BUTTON_SEARCH_LOC =  "[data-marker='search-filters/submit-button']";
    private static final String SEARCH_LIST_LOC =  ".iva-item-root-G3n7v.photo-slider-slider-3tEix iva-item-list-2_PpT iva-item-redesign-1OBTh items-item-1Hoqq items-listItem-11orH js-catalog-item-enum".replace(" ", ".");
    private static final String SHOW_PRINTER_NAME_LOC = "h3[itemprop]";
    private static final String SHOW_PRINTER_COST_LOC = ".price-text-1HrJ_.text-text-1PdBw.text-size-s-1PUdo";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");

        Select category = new Select(driver.findElement(By.id(CHOOSE_CATEGORY_LOC)));

        category.selectByVisibleText("Оргтехника и расходники");

        driver.findElement(By.cssSelector(SEARCH_FIELD_LOC)).sendKeys("Принтер");

        driver.findElement(By.cssSelector(SELECT_CITY_LOC)).click();

        driver.findElement(By.cssSelector((ENTER_CITY_NAME_LOC))).sendKeys("Владивосток");
        driver.findElement(By.cssSelector(USE_FIRST_CITY_LOC)).click();
        driver.findElement(By.cssSelector(PRESS_SHOW_BUTTON_LOC)).click();

        WebElement checkbox = driver.findElement(By.cssSelector(CHECKBOX_LOC));

        if(!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.cssSelector(PRESS_SUBMIT_BUTTON_SEARCH_LOC)).click();

        Select sorting = new Select(driver.findElement(By.cssSelector(SORTING_LOC)));

        sorting.selectByVisibleText("Дороже");


        List<WebElement> searchList
                = driver.findElements(By.cssSelector(SEARCH_LIST_LOC));

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Название принтера " +
                searchList.get(i).findElement(By.cssSelector(SHOW_PRINTER_NAME_LOC)).getText());
                System.out.println("Цена принтера " + searchList.get(i).findElement(By.cssSelector(SHOW_PRINTER_COST_LOC)).getText());

            } catch (NoSuchElementException e) {
                System.out.println("Элемент не найден");
            }

        }

        driver.close();

    }
}
