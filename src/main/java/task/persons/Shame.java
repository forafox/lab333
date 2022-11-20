package task.persons;
import task.object.*;
public interface Shame {
    default void ShamePlus(int n){
        this.setShame(this.getShame() +n);
    }

     default String checkShame(){
         return "";
     }

    int getShame();

    void setShame(int n);
}
