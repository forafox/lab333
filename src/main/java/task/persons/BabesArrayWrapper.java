package task.persons;

import task.object.Fun;
import java.util.ArrayList;

public class BabesArrayWrapper extends Character{

    ArrayList<Babes> BabesList = new ArrayList<Babes>(); //Cписок для Малышек

    public BabesArrayWrapper(){
        super("Малышки");

    }

    @Override
    public void Tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность
        x.plusInteres(1);
        plusTiredness(1);
        x.plusTiredness(1);
        x.PlusAttention(-1);
    }
    @Override
    public void SeekOut(Character x){
        plusTiredness(1);
        x.plusInteres(1);
    }
    @Override
    public void introduce(Character a,Character b){
        a.addFriend(b);
        a.plusTiredness(1);
        a.plusInteres(1);
        b.plusInteres(1);
        b.plusTiredness(1);
        b.addFriend(a);
    }

}
