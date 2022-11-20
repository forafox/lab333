package task.object;
import task.persons.*;
public abstract class Berries {
    private final String name;

    public Berries(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
