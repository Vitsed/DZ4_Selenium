package avitotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Soft\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");

        WebElement params = driver.findElement(By.cssSelector("._2-oC2TAEVytFdm6Kvbc7Hu"));
        params.click();



        driver.close();

    }
}
