package logic.constants;

public enum ItemSection {

CHARACTERISTICS ("Характеристики");

    private final String name;

    ItemSection(String name){
        this.name = name;
    }
    public String get(){
        return name;
    }
}
