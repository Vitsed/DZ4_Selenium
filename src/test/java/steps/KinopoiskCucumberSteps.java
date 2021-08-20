package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;

import java.util.List;

public class KinopoiskCucumberSteps {

    //todo Написать реализацию шагов сценария "Поиск фильма на вечер"

     //open site kinopoisk.ru
    @Пусть("открыт ресурс {word}")
    public void openSource(String word) {
        System.out.println(word);
    }

    @И("нажата кнопка {word}")
    public void pressButtonFullSearch(String word) {
        System.out.println(word);
    }

    @Дано("в поле '...или интервал' указаны значения с {word}:")
    public void вПолеУказаныЗначенияСНачального_года(List<String> word) {
        System.out.println(word);
    }
}
