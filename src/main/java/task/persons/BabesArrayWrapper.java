package task.persons;

import task.object.Fun;
import java.util.ArrayList;
import java.util.List;

public class BabesArrayWrapper extends Character implements WorkWithWrapper,Tiredness,Interes,Friend{
    ArrayList<Babes> BabesList = new ArrayList<Babes>(); //Cписок для Малышек
    public BabesArrayWrapper(){
        super("Малышки");
    }

    public void addBabes(Babes x){
        BabesList.add(x);
    }

    @Override
    public void tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность,уменьшая внимание
        for (Babes babe : BabesList) {
            plusTiredness(1);
        }
        x.plusInteres(1);
        x.plusTiredness(1);
        x.plusAttention(-1);
    }
    @Override
    public void seekOut(Character x){
        for (Babes babe : BabesList) {
            plusTiredness(1);
        }
        x.plusInteres(1);
    }
    @Override
    public void introduce(Character a,Character b) {
        if (a.getClass() == (BabesList.get(0)).getClass()) {
            for (Babes babe : BabesList) {
                babe.addFriend(b);
                babe.plusTiredness(1);
                babe.plusInteres(1);
            }
            for (Babes babe : BabesList) {
                b.addFriend(babe);
            }
            b.plusInteres(1);
            b.plusTiredness(1);
        } else if (b.getClass() == (BabesList.get(0)).getClass())
        {
            for (Babes babe : BabesList) {
                babe.addFriend(a);
                babe.plusTiredness(1);
                babe.plusInteres(1);
            }
            for (Babes babe : BabesList) {
                a.addFriend(babe);
            }
            a.plusInteres(1);
            a.plusTiredness(1);
        }
        else{
            a.addFriend(b);
            a.plusTiredness(1);
            a.plusInteres(1);

            b.addFriend(a);
            b.plusTiredness(1);
            b.plusInteres(1);
        }
    }

    @Override
    public String toString() {//Состояние героя (Усталость)
        String str="Каждая из малышек имеет следующее состояние:\n";
        for (Babes babe : BabesList) {
            str+=String.format("Усталость: %d,Интерес: %d,Стыд: %d,Внимание: %d\n",babe.getTiredness(),babe.getInteres(),getShame(),getAttention());
        }
        return str;
    }

    @Override
    public void setTiredness(int n) {
        for (Babes babe : BabesList) {
            babe.setTiredness(n);
        }
    }

    @Override
    public void plusTiredness(int n) {
        for (Babes babe : BabesList) {
             babe.setTiredness(babe.getTiredness() + n);
        }
    }

    @Override
    public void setInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(n);
        }
    }

    @Override
    public void plusInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(babe.getInteres() + n);
        }
    }

    @Override
    public void addFriend(Character x){//метод для добавления интерсов
        for (Babes babe : BabesList) {
            babe.FriendList.add(x);
        }
    }
    @Override
    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : FriendList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(removeLastChars(""+result,2));
        else return "Нет друзей";
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }
}
