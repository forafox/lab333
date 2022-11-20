package task.persons;
import task.object.*;
public class Solomka extends Character{
    private static Solomka INSTANCE;
    private Solomka() {
        super("Знайка");
    }
    public static Solomka getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Solomka();
        }
        return INSTANCE;
    }

}
