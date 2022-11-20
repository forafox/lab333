package task.persons;
import task.object.*;

public interface Attention {
    default void plusAttention(int n){
        this.setAttention(this.getAttention() +n);
    }

    default String checkAttention(){//Проверка внимательности.
        return null;
    }

    int getAttention();

    void setAttention(int n);
}
