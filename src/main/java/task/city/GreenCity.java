package task.city;

public class GreenCity extends City{
    private static GreenCity INSTANCEGCITY;
    private GreenCity() {
        super("Зеленый город");
    }
    public static GreenCity getInstance() {
        if (INSTANCEGCITY == null) {
            INSTANCEGCITY = new GreenCity();
        }
        return INSTANCEGCITY;
    }
}
