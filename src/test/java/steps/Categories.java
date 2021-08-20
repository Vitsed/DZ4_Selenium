package steps;

public enum Categories {
    оргтехника(1, "Оргтехника и расходники"),
    автомобили(2, "Транспорт"),
    квартиры(3, "Недвижимсоть"),
    вакансии(4, "Работа"),
    животные(5, "Питомцы");

    private int id;
    private String text;


    Categories(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
