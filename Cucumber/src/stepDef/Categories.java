package stepDef;

public enum Categories {
    оргтехника("Электроника"),
    автомобили("Транспорт"),
    квартиры("Недвижимсоть"),
    вакансии("Работа"),
    животные("Питомцы");

    public String value;

    Categories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
