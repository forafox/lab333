package task.object;
import task.persons.*;
public abstract class FunThings {
    private String name;

    public FunThings(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}
