package task.persons;
import task.object.*;

public interface Tiredness {
     int getTiredness();
     void setTiredness(int n);
     default void plusTiredness(int n){
          setTiredness(getTiredness()+n);
     }
}
