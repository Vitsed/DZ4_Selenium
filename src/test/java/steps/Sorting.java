package steps;

public enum Sorting {
    Дороже(1, "Дороже"),
    Дешевле(2, "Дешевле"),
    Умолчанию(3, "По умолчанию"),
    Дате(4, "По дате");

    private int id;
    private String text;

    Sorting(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
