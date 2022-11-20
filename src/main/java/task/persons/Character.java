package task.persons;
import task.object.*;

import java.util.ArrayList;

import static task.Main.*;

public abstract class Character implements Tiredness,Attention,Shame,Interes,WorkWithWrapper{
    private final String name;
    private int interest=3;//интерес
    private int tiredness=3;//усталость
    private int attention=10;//Внимание
    private int shame=3;//стыд

    public Character(String name){
        this.name = name;
    }
    public Character(String name,int interest){this.name=name;this.interest=interest;}

    ArrayList<Fun> FunList = new ArrayList<>(); //Cписок для хранения интересов
    ArrayList<Character> FriendList = new ArrayList<>(); //Cписок для хранения имен друзей
    //ArrayList<Work> WorkList = new ArrayList<>(); //Cписок для работы
    private Work[] workList;
    public void addFun(Fun x){//метод для добавления интерсов
        FunList.add(x);
    }
    public String getFunNameList(){ //Получение списка интересов
        var result = new StringBuilder();
        for(Fun x : FunList)
            result.append(x.getName()).append(", ");
        return String.format(removeLastChars(""+result,2));
    }

    public void addFriend(Character x){//метод для добавления интерсов
        FriendList.add(x);
    }
    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : FriendList)
            result.append(x.getName()).append(", ");
        return String.format(removeLastChars(""+result,2));
    }

    public void setWork(Work[] workList){//метод для добавления интерсов
        this.workList=(workList);
    }
    public String getWorkList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(var workElement : workList)
            result.append(workElement.getNameWork()).append(", ");
        return String.format(removeLastChars(""+result,2));
    }

    public String getName(){
        return this.name;
    }

//    @Override
//    public String toString() {//Состояние героя (Усталость)
//        return String.format(ANSI_RED+"Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d"+ANSI_RESET, this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
//    }
    @Override
    public String toString() {//Состояние героя (Усталость)
        return String.format("Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d", this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

    public void Wake(){
        plusTiredness(1);
    }
    @Override
    public void Tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность
        x.plusInteres(1);
        plusTiredness(1);
        x.plusTiredness(1);
        x.PlusAttention(-1);
    }
    public void Listen(){
        //System.out.println("Слушал");
        plusTiredness(1);
        PlusAttention(-1);
    }
    public void Question(Character x){
        //System.out.println("Распрашивать");
        x.plusTiredness(1);
        x.plusInteres(1);
        plusTiredness(1);
        PlusAttention(-1);
        x.PlusAttention(-1);
    }
    public void Write(){
        //System.out.println("Записывал");
        plusTiredness(1);
        PlusAttention(-1);
        Books.NOTEBOOK.MinusClear_paper(1);
        Books.NOTEBOOK.PlusScribbled_paper(1);
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
    @Override
    public int getTiredness() {
        return this.tiredness;
    }
    @Override
    public void setTiredness(int n) {
        this.tiredness = n;
    }

    @Override
    public int getAttention() {
        return attention;
    }
    @Override
    public void setAttention(int n) {
        this.attention=n;
    }
    @Override
    public String CheckAttention(){ //Степень внимания от значения переменной
        if(getAttention()>=5) return " очень внимательно";
        else if (getAttention()>=3) return " внимательно";
        else return " не внимательно";
    }
    @Override
    public int getShame() {
        return shame;
    }
    @Override
    public void setShame(int n) {
        this.shame=n;
    }


    @Override
    public int getInteres() {
        return interest;
    }
    @Override
    public void setInteres(int n) {
        this.interest=n;
    }
    @Override
    public String checkInteres(){
        return (this.getInteres() > 3) ? " захотел" : " не хотел";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character that = (Character) o;

         return ((name==that.name)&&(interest==that.interest));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + interest;
        return result;
    }
}
