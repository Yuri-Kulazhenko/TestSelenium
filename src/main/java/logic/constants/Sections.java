package logic.constants;

public enum Sections {

    COMPUTERS_AND_NOTEBOOKS ("Ноутбуки и компьютеры"),
    SMARTPHONES_TV_AND_ELECTRONICS ("Смартфоны, ТВ и электроника"),
    PRODUCTS_FOR_GAMERS ("Товары для геймеров"),
    APPLIANCES ("Бытовая техника"),
    HOUSEHOLD_PRODUCTS ("Товары для дома"),
    TOOLS_AND_CAR_GOODS ("Инструменты и автотовары"),
    PLUMBING_AND_REPAIR ("Сантехника и ремонт"),
    COTTAGE_GARDEN_VEGETABLEGARDEN ("Дача, сад и огород"),
    SPORTS_AND_HOBBIES ("Спорт и увлечения"),
    CLOTHES_SHOES_JEWELRY ("Одежда, обувь и украшения"),
    HEALTH_AND_BEAUTY ("Красота и здоровье"),
    CHILDENS_GOODS ("Детские товары"),
    STATIONERY_AND_BOOKS ("Канцтовары и книги"),
    ALCOHOL_AND_FOOD ("Алкоголь и продукты"),
    BUSINESS_GOODS ("Товары для бизнеса"),
    SERVICES_AND_SERVICES ("Услуги и сервисы"),
    TOURS_AND_LEISURE ("Туры и отдых"),
    ACTIONS ("Акции"),
    SCHOOL_FAIR ("Школьная ярмарка до -60%");

    private final String name;

    Sections(String name){
        this.name = name;
    }

    public String get(){
        return name;
    }
}
