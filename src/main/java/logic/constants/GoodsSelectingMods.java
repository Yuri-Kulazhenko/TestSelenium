package logic.constants;

public enum GoodsSelectingMods {
    RANK ("По рейтингу"),
    CHEAP ("От дешевых к дорогим"),
    EXPENSIVE ("От дорогих к дешевым"),
    POPULARITY("Популярные"),
    NOVELTY("Новинки"),
    ACTION ("Акционные");

    private final String name;

    GoodsSelectingMods(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}
