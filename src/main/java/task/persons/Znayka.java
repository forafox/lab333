package task.persons;
import task.object.*;
public final class Znayka extends Character implements Tiredness,Shame,Attention {

    private  int bookCount=6;
        private static Znayka INSTANCE;
        private Znayka() {
            super("Знайка");
        }
        public static Znayka getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Znayka();
            }
            return INSTANCE;
        }
    public void setBookCount(int n){
        this.bookCount+=n;
    }
    public  int getBookCount(){
        return this.bookCount;
    }

    @Override
    public String checkShame(){//Проверка стыда. Если книг больше 5, то знайке стыдно
        return (this.getBookCount() > 5) ? " стыдно " : " не стыдно ";
    }


}
