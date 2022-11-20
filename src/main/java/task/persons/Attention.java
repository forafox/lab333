package task.persons;
import task.object.*;

public interface Attention {
    default void PlusAttention(int n){
        this.setAttention(this.getAttention() +n);
    }

    default String CheckAttention(){//Проверка внимательности.
        return null;
    }

    int getAttention();

    void setAttention(int n);
}
