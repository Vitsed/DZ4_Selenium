package stepDef;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

import java.util.HashMap;

public class AvitoSteps {

    private static HashMap<String, Integer> storage = new HashMap<>();

    @Пусть("открыт ресурс авито")
    public static void getAvito() {
        System.out.println("Авито открыто");

    }

    @И("в выпадающем списке категорий выбрана {word}")
    public static void getEquipment(String equipment) {
        System.out.println();
    }

    @И("в поле поиска введено значение {word}")
    public static void getPrinter(String printer) {
        System.out.println();
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void getClick() {
        System.out.println();
    }

    @Тогда("в поле регион введено значение {word}")
    public static void getCityName(String name) {
        System.out.println();
    }

    @И("нажата кнопка показать объявления")
    public static void getMessage() {
        System.out.println();
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public static void getPage(String printer) {
        System.out.println();
    }

    @И("активирован чекбокс только с фотографией")
    public static void getCheckbox() {
        System.out.println();
    }
    @И("в выпадающем списке сортировка выбрано значение {word}")
    public static void getList() {
        System.out.println();
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public static void getThirdPrintersName() {
        System.out.println();
    }
}
