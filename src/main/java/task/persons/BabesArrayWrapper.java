package task.persons;

import task.object.Joyful;

import java.util.ArrayList;

public class BabesArrayWrapper implements WorkWithWrapper {
    private String name;
    ArrayList<Character> FriendList = new ArrayList<>(); //Cписок для хранения интересов
    ArrayList<Babes> BabesList = new ArrayList<Babes>(); //Cписок для Малышек
    public BabesArrayWrapper(String name){
        this.name=name;
    }

    public void addBabes(Babes x){
        BabesList.add(x);
    }

    public String getName(){
        var result = new StringBuilder();
        for(Babes babe : BabesList)
            result.append(babe.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return " ";
    }

    @Override
    public void tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность,уменьшая внимание
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
        x.changeInteres(1);
        x.changeTiredness(1);
        x.changeAttention(-1);
    }

    @Override
    public void seekOut(Character x){
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
        x.changeInteres(1);
    }
    @Override
    public void introduce(Character a,Character b) {
        if (a.getClass() == (BabesList.get(0)).getClass()) {
            for (Babes babe : BabesList) {
                babe.addFriend(b);
                babe.changeTiredness(1);
                babe.changeInteres(1);
            }
            for (Babes babe : BabesList) {
                b.addFriend(babe);
            }
            b.changeInteres(1);
            b.changeTiredness(1);
        } else if (b.getClass() == (BabesList.get(0)).getClass())
        {
            for (Babes babe : BabesList) {
                babe.addFriend(a);
                babe.changeTiredness(1);
                babe.changeInteres(1);
            }
            for (Babes babe : BabesList) {
                a.addFriend(babe);
            }
            a.changeInteres(1);
            a.changeTiredness(1);
        }
        else{
            a.addFriend(b);
            a.changeTiredness(1);
            a.changeInteres(1);

            b.addFriend(a);
            b.changeTiredness(1);
            b.changeInteres(1);
        }
    }

    public void introduce(BabesArrayWrapper a, Character b) {
        for (Babes babe : BabesList) {
            babe.addFriend(b);
            babe.changeTiredness(1);
            babe.changeInteres(1);
        }
        for (Babes babe : BabesList) b.addFriend(babe);
        b.changeInteres(1);
        b.changeTiredness(1);
    }


    @Override
    public String toString() {//Состояние героя (Усталость)
        String str="Каждая из малышек имеет следующее состояние:\n";
        for (Babes babe : BabesList) {
            str+=String.format("Усталость: %d,Интерес: %d,Стыд: %d,Внимание: %d\n",babe.getTiredness(),babe.getInteres(),babe.getShame(),babe.getAttention());
        }
        return str;
    }

    public void setTiredness(int n) {
        for (Babes babe : BabesList) {
            babe.setTiredness(n);
        }
    }

    public void changeTiredness(int n) {
        for (Babes babe : BabesList) {
             babe.setTiredness(babe.getTiredness() + n);
        }
    }


    public void setInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(n);
        }
    }

    public void changeInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(babe.getInteres() + n);
        }
    }

    public void addFriend(Character x){//метод для добавления интерсов
        for (Babes babe : BabesList) {
            babe.FriendList.add(x);
        }
    }

    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : FriendList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }
    @Override
    public void listen() {
    }

    @Override
    public void question(Character x) {
    }

    @Override
    public void write() {
    }
    @Override
    public void wake() {
    }

    }
