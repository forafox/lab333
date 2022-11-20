package task.persons;
import task.object.*;
public interface Interes {
    int getInteres();
    void setInteres(int n);

    default void plusInteres(int n){
        setInteres(getInteres()+n);
    }
    String checkInteres();
}
