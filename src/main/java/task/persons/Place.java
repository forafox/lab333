package task.persons;

import java.util.ArrayList;

public enum Place {

    HOUSE_ZNAYKA("Дом Знайки"),
    TABLE("Стол"),
    STREET("Улица"),
    HOUSE_SOLOMKA("Дом Соломки");
    private String name;
    ArrayList<String> objectOnPlace = new ArrayList<>();
    Place(String name){
        this.name=name;
    }

    public void addObjectOnPlace(String x){
        objectOnPlace.add(x);
    }
    public String getObjectOnPlace(){
        var result = new StringBuilder();
        for(var placeElementName : objectOnPlace)
            result.append(placeElementName).append(", ");
        if((""+result).length()>2) return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }
}
