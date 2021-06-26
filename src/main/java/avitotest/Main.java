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

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Soft\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");

        Select category = new Select(driver.findElement(By.id("category")));

        category.selectByVisibleText("Оргтехника и расходники");

        driver.findElement(By.cssSelector("input[data-marker=\"search-form/suggest\"]")).sendKeys("Принтер");

        driver.findElement(By.cssSelector(".main-select-2pf7p.main-location-3j9by")).click();

        driver.findElement(By.cssSelector((".suggest-input-3p8yi"))).sendKeys("Владивосток");
        driver.findElement(By.cssSelector("li[data-marker='suggest(0)']")).click();
        driver.findElement(By.cssSelector("[data-marker='popup-location/save-button']")).click();

        WebElement checkbox = driver.findElement(By.cssSelector("[data-marker='delivery-filter/text']"));

        if(!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.cssSelector(".button-button-2Fo5k.button-size-s-3-rn6.button-primary-1RhOG.width-width-12-2VZLz"));

        Select sorting = new Select(driver.findElement(By.cssSelector(".sort-select-3QxXG.select-select-box-3LBfK.select-size-s-2gvAy>select")));

        sorting.selectByVisibleText("Дороже");


        List<WebElement> searchList
                = driver.findElements(By.cssSelector(".iva-item-root-G3n7v.photo-slider-slider-3tEix iva-item-list-2_PpT iva-item-redesign-1OBTh items-item-1Hoqq items-listItem-11orH js-catalog-item-enum".replace(" ", ".")));

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Название принтера " +
                searchList.get(i).findElement(By.cssSelector("h3[itemprop]")).getText());
                System.out.println("Цена принтера " + searchList.get(i).findElement(By.cssSelector(".price-text-1HrJ_.text-text-1PdBw.text-size-s-1PUdo")).getText());

            } catch (NoSuchElementException e) {
                System.out.println("Элемент не найден");
            }

        }

        driver.close();

    }
}
