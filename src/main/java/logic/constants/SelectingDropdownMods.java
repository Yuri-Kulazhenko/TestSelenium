package logic.constants;

public enum SelectingDropdownMods {
    INDEX("byIndex"),
    VALUE("byValue"),
    TEXT("byVisibleText");

    private final String name;

    SelectingDropdownMods(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}
