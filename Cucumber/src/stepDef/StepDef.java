package stepDef;

import io.cucumber.java.ru.*;

import java.util.HashMap;

public class StepDef {
    private static HashMap<String, Integer> storage = new HashMap<>();

    @Пусть("у меня есть {int} огурца")
    public static void getMyCukes(int num) {
        System.out.println("Мои огурцы " + num + "\n");
        storage.put("Мои огурцы", num);
    }

    @А("у тебя {int} огурца")
    public static void getYourCukes(int num) {
        System.out.println("Твои огурцы " + num + "\n");
        storage.put("Твои огурцы", num);
    }

    @Тогда("сосчитать сколько всего у нас огурцов")
    public static void countSum() {
        System.out.println("Сумма огурцов: " + ((storage.get("Мои огурцы") + storage.get("Твои огурцы")) + "\n"));
    }

    @И("сосчитать нашу разницу в огурцах")
    public static void countSub() {
        System.out.println("Разница огурцов: " + Math.abs(storage.get("Мои огурцы") - storage.get("Твои огурцы")) + "\n");
    }

//    @Затем("скажем привет")
//    public static void sayHello() {
//        System.out.println("Привет!!!");
//    }
}
