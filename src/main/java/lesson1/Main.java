package lesson1;

import org.openqa.selenium.By;
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

        driver.get("https://www.kinopoisk.ru/");

        WebElement params = driver.findElement(By.cssSelector("._2-oC2TAEVytFdm6Kvbc7Hu"));
        params.click();

        driver.findElement(By.id("find_film")).sendKeys("Назад в будущее");
        Select yearSelect = new Select(driver.findElement(By.name("m_act[from_year]")));
        yearSelect.getOptions().forEach(options -> {
            System.out.println("Value = " + options.getAttribute("value") + " Text: " + options.getText());
        });
        yearSelect.selectByValue("1985");

        Select genreSelect = new Select(driver.findElement(By.xpath("//select[@name='m_act[genre][]']")));
        genreSelect.getOptions().forEach(options -> {
            System.out.println("Value = " + options.getAttribute("value") + " Text: " + options.getText());
        });

        genreSelect.selectByVisibleText("комедия");
        genreSelect.selectByVisibleText("приключения");
        genreSelect.selectByVisibleText("фантастика");

        WebElement checkbox = driver.findElement(By.id("m_act[genre_and]"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.cssSelector(".el_18 submit nice_button".replace(" ", "."))).click();

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='search_results search_results_last']/div[@class='element']"));

        for (int i = 0; i < webElementList.size(); i++) {
//            System.out.println(webElementList.get(i));
            System.out.println("Фильм : " +
                    webElementList.get(i).findElement(By.xpath(".//div[@class='info']/p")).getText()
            );
            try {

                System.out.println(". Имеет рейтинг " + webElementList.get(i).findElement(By.xpath(".//div[@class='rating  ratingGreenBG']")).getText());
            } catch (Exception e) {
                System.out.println(". Не имеет рейтинг ");
            }
        }

        System.out.println(webElementList.size());
        driver.close();
    }
}
