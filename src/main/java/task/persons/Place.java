package task.persons;

public enum Place {

    HOUSE_ZNAYKA("Дом Знайки"),
    TABLE("Стол"),
    STREET("Улица"),
    HOUSE_SOLOMKA("Дом Соломки");
    private String name;

    Place(String name){
        this.name=name;
    }
}
