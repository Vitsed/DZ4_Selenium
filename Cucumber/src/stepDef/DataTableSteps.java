package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;

import java.util.List;
import java.util.Map;

public class DataTableSteps {
    @И("посчитаем количество огурцов")
    public void cuke(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        dataTable.forEach(row -> {
            switch (row.get("Операция")) {
                case "Сложение":
                    System.out.println("Огурцов у меня: " + row.get("Мои огурцы") + " ,огурцов у тебя: " + row.get("Твои огурцы") + " Сложение = " + (Integer.parseInt(row.get("Мои огурцы")) + Integer.parseInt(row.get("Твои огурцы"))));
                    break;
                case "Разница":
                    System.out.println("Огурцов у меня: " + row.get("Мои огурцы") + " ,огурцов у тебя: " + row.get("Твои огурцы") + " Разница = " + Math.abs(Integer.parseInt(row.get("Мои огурцы")) - Integer.parseInt(row.get("Твои огурцы"))));
                    break;
            }
        });
    }
}
