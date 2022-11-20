package task.persons;

import task.object.Fun;
import java.util.ArrayList;
import java.util.List;

public class BabesArrayWrapper extends Character implements WorkWithWrapper,Tiredness,Interes,Friend{
    private int globalTiredness=0;
    private final int BabesCount=3;
    ArrayList<Character> FriendList = new ArrayList<>();
    private int globalInteres=0;
    ArrayList<Babes> BabesList = new ArrayList<Babes>(); //Cписок для Малышек
    public BabesArrayWrapper(){
        super("Малышки");
        Babes babeOne = new Babes("Кнопочка");
        Babes babeTwo = new Babes("Синеглазка");
        Babes babeThree = new Babes("Ромашка");
        BabesList.add(babeOne);
        BabesList.add(babeTwo);
        BabesList.add(babeThree);
        globalTiredness=babeOne.getTiredness()+babeTwo.getTiredness()+babeThree.getTiredness();
        globalInteres=babeOne.getInteres()+babeTwo.getInteres()+babeThree.getInteres();
    }

    @Override
    public void Tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность,уменьшая внимание
        x.plusInteres(1);
        plusTiredness(1*BabesCount);
        x.plusTiredness(1);
        x.PlusAttention(-1);
    }
    @Override
    public void SeekOut(Character x){
        plusTiredness(1*BabesCount);
        x.plusInteres(1);
    }
    @Override
    public void introduce(Character a,Character b){
        a.addFriend(b);
        a.plusTiredness(1*BabesCount);
        a.plusInteres(1*BabesCount);
        b.plusInteres(1);
        b.plusTiredness(1);
        b.addFriend(a);
    }

    @Override
    public int getTiredness() {
        return globalTiredness;
    }

    @Override
    public void setTiredness(int n) {
        globalTiredness=n;
    }

    @Override
    public void plusTiredness(int n) {
        globalTiredness=getTiredness()+n;
    }

    @Override
    public int getInteres() {
        return globalInteres;
    }

    @Override
    public void setInteres(int n) {
        globalInteres=n;
    }

    @Override
    public void plusInteres(int n) {
        globalInteres=getInteres()+n;
    }

    @Override
    public String checkInteres() {
        return  (this.getInteres() > 3) ? " захотели" : " не хотели";
    }
    @Override
    public void addFriend(Character x){//метод для добавления интерсов
        FriendList.add(x);
    }
    @Override
    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : FriendList)
            result.append(x.getName()).append(", ");
        return String.format(removeLastChars(""+result,2));
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }


}
