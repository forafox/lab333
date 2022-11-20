package task.persons;
import task.object.*;
public final class Znayka extends Character implements Tiredness,Shame,Attention {

    private static int bookCount=0;
        private static Znayka INSTANCEONE;
        private Znayka() {
            super("Знайка");
        }
        public static Znayka getInstance() {
            if (INSTANCEONE == null) {
                INSTANCEONE = new Znayka();
            }
            return INSTANCEONE;
        }
    public static void setBookCount(int n){
        bookCount+=n;
    }
    public static int getBookCount(){
        return bookCount;
    }

    @Override
    public String checkShame(){//Проверка стыда. Если книг больше 5, то знайке стыдно
        return (this.getBookCount() > 5) ? " стыдно " : " не стыдно ";
    }

    public static void PlusBookCount(int count){
            setBookCount(getBookCount()+count);
        }



}
