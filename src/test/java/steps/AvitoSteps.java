package steps;


import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AvitoSteps {

    public static final String CHOOSE_CATEGORY_LOC = "category";
    private static final String SEARCH_FIELD_LOC = "input[data-marker=\"search-form/suggest\"]";
    private static final String SELECT_CITY_LOC = ".main-select-2pf7p.main-location-3j9by";
    private static final String ENTER_CITY_NAME_LOC = "[data-marker='popup-location/region/input']";
    private static final String USE_FIRST_CITY_LOC = "li[data-marker='suggest(0)']";
    private static final String PRESS_SHOW_BUTTON_LOC = "[data-marker='popup-location/save-button']";
    private static final String CHECKBOX_LOC = "[data-marker='delivery-filter/text']";
    private static final String ORDER_BY_LOC = ".sort-select-3QxXG.select-select-box-3LBfK.select-size-s-2gvAy>select";
    private static final String PRESS_SUBMIT_BUTTON_SEARCH_LOC = "[data-marker='search-filters/submit-button']";
    private static final String SEARCH_LIST_LOC = ".iva-item-root-G3n7v.photo-slider-slider-3tEix iva-item-list-2_PpT iva-item-redesign-1OBTh items-item-1Hoqq items-listItem-11orH js-catalog-item-enum".replace(" ", ".");
    private static final String SHOW_PRINTER_NAME_LOC = "h3[itemprop]";
    private static final String SHOW_PRINTER_COST_LOC = ".price-text-1HrJ_.text-text-1PdBw.text-size-s-1PUdo";


    private static HashMap<String, Integer> storage = new HashMap<>();

    public static WebDriver driver;

    @Before
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Пусть("открыт ресурс авито")
    public static void getAvito() {
        driver.get("https://www.avito.ru/");
    }

    @ParameterType(".*")
    public Categories category(String category) {
        return Categories.valueOf(category);
    }
    @И("в выпадающем списке категорий выбрана {category}")
    public static void getEquipment(Categories category) {
        Select cat = new Select(driver.findElement(By.id(CHOOSE_CATEGORY_LOC)));
        cat.selectByVisibleText(category.getText());
        System.out.println("Выбрана категория: " + category);
    }

    @И("в поле поиска введено значение {word}")
    public static void getPrinter(String printer) {
        driver.findElement(By.cssSelector(SEARCH_FIELD_LOC)).sendKeys(printer);
        System.out.println("Введено значение \"" + printer + "\" в поле поиска");
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void getClick() {
        driver.findElement(By.cssSelector(SELECT_CITY_LOC)).click();
        System.out.println("Выполнен щелчок мышью по выпадающему списку");
    }

    @Тогда("в поле регион введено значение {word}")
    public static void getCityName(String city) {
        driver.findElement(By.cssSelector((ENTER_CITY_NAME_LOC))).sendKeys(city);
        driver.findElement(By.cssSelector(USE_FIRST_CITY_LOC)).click();
        System.out.println("Введено значение \"" + city + "\" в поле регион");
    }

    @И("нажата кнопка показать объявления")
    public static void getMessage() {
        driver.findElement(By.cssSelector(PRESS_SHOW_BUTTON_LOC)).click();
        System.out.println("Нажали кнопку показать объявления");
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public static void getPage(String query) {
        System.out.println("Открылась страница по запросу: " + query);
    }

    @И("активирован чекбокс только с фотографией")
    public static void getCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector(CHECKBOX_LOC));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Поставлена галочка в чекбокс");
    }

    @ParameterType(".*")
    public Sorting sorting(String sortBy) {
        return Sorting.valueOf(sortBy);
    }
    @И("в выпадающем списке сортировка выбрано значение {sorting}")
    public static void getSortingType(Sorting sortType) {
        driver.findElement(By.cssSelector(PRESS_SUBMIT_BUTTON_SEARCH_LOC)).click();

        Select sorting = new Select(driver.findElement(By.cssSelector(ORDER_BY_LOC)));

        sorting.selectByVisibleText(sortType.getText());
        System.out.println("Выбран тип сортировки: " + sortType);
    }

    @И("в консоль выведено значение, названия и цены {int} первых товаров")
    public static void getThirdPrintersName(int things) {
        List<WebElement> searchList
                = driver.findElements(By.cssSelector(SEARCH_LIST_LOC));

        for (int i = 0; i < things; i++) {
            try {
                System.out.println("Название принтера " +
                        searchList.get(i).findElement(By.cssSelector(SHOW_PRINTER_NAME_LOC)).getText());
                System.out.println("Цена принтера " + searchList.get(i).findElement(By.cssSelector(SHOW_PRINTER_COST_LOC)).getText());

            } catch (NoSuchElementException e) {
                System.out.println("Элемент не найден");
            }

        }

        driver.close();
        System.out.println("Список из " + things + " первых товаров выведен");
    }
}
