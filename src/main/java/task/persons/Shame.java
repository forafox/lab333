package task.persons;
import task.object.*;
public interface Shame {
    default void plusShame(int n){
        this.setShame(this.getShame()+n);
    }

    default String checkShame(){
         return "";
     }

    default int getShame() {
        return 0;
    }

    default void setShame(int n) {
    }
}
