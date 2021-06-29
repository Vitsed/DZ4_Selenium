package stepDef;

public enum Sorting {
    Дороже("Сначала дороже"),
    Дешевле("Сначала дешевле"),
    Умолчанию("По умолчанию"),
    Дате("По дате");

    public String value;

    Sorting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
