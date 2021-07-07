package steps;

import io.cucumber.java.ParameterType;
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

    @ParameterType(".*")
    public Categories category(String category) {
        return Categories.valueOf(category);
    }
    @И("в выпадающем списке категорий выбрана {category}")
    public static void getEquipment(Categories category) {
        System.out.println("Выбрана категория: " + category);
    }

    @И("в поле поиска введено значение {word}")
    public static void getPrinter(String printer) {
        System.out.println("Введено значение \"" + printer + "\" в поле поиска");
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void getClick() {
        System.out.println("Выполнен щелчок мышью по выпадающему списку");
    }

    @Тогда("в поле регион введено значение {word}")
    public static void getCityName(String name) {
        System.out.println("Введено значение \"" + name + "\" в поле регион");
    }

    @И("нажата кнопка показать объявления")
    public static void getMessage() {
        System.out.println("Нажали кнопку показать объявления");
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public static void getPage(String query) {
        System.out.println("Открылась страница по запросу: " + query);
    }

    @И("активирован чекбокс только с фотографией")
    public static void getCheckbox() {
        System.out.println("Поставлена галочка в чекбокс");
    }

    @ParameterType(".*")
    public Sorting sorting(String sortBy) {
        return Sorting.valueOf(sortBy);
    }
    @И("в выпадающем списке сортировка выбрано значение {sorting}")
    public static void getSortingType(Sorting sortType) {
        System.out.println("Выбран тип сортировки: " + sortType);
    }

    @И("в консоль выведено значение, названия и цены {int} первых товаров")
    public static void getThirdPrintersName(int things) {
        System.out.println("Список из " + things + " первых товаров выведен");
    }
}
