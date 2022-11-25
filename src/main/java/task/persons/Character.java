package task.persons;
import task.object.*;

import java.util.ArrayList;

import static task.Main.*;

public abstract class Character implements WorkWithWrapper,Moveable,Joyful {
    private String name;
    private int interest=0;//интерес
    private int tiredness=0;//усталость
    private int attention=0;//Внимание
    private int shame=0;//стыд

    public Character(String name){
        this.name = name;
        this.tiredness=5;
        this.interest=5;
        this.shame=5;
        this.attention=7;
    }
    public Character(String name,int tiredness,int interest,int shame,int attention){
        this.name=name;
        this.tiredness=tiredness;
        this.interest=interest;
        this.shame=shame;
        this.attention=attention;
    }

    ArrayList<Joyful> FunList = new ArrayList<>(); //Cписок для хранения интересов
    ArrayList<Character> FriendList = new ArrayList<>(); //Cписок для хранения имен друзей
    //ArrayList<Work> WorkList = new ArrayList<>(); //Cписок для работы
    private Work[] workList;

    public void addFun(Joyful x){//метод для добавления интерсов
        FunList.add(x);
    }
    public String getFunNameList(){ //Получение списка интересов
        var result = new StringBuilder();
        for(Joyful x : FunList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public void addFriend(Character x){//метод для добавления интерсов
        FriendList.add(x);
    }

    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : FriendList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public void setWork(Work[] workList){//метод для добавления интерсов
        this.workList=(workList);
    }
    public String getWorkList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(var workElement : workList)
            result.append(workElement.getNameWork()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {//Состояние героя (Усталость)
        return String.format(ANSI_RED+"Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d"+ANSI_RESET, this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
    }
//    @Override
//    public String toString() {//Состояние героя (Усталость)
//        return String.format("Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d", this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
//    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

    @Override
    public void wake(){
        changeTiredness(1);
    }

    @Override
    public void tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность
        x.changeInteres(1);
        changeTiredness(1);
        x.changeTiredness(1);
        x.changeAttention(-1);
    }
    @Override
    public void listen(){
        //System.out.println("Слушал");
        changeTiredness(1);
        changeAttention(-1);
    }
    @Override
    public void question(Character x){
        //System.out.println("Распрашивать");
        x.changeTiredness(1);
        x.changeInteres(1);
        changeTiredness(1);
        changeAttention(-1);
        x.changeAttention(-1);
    }
    @Override
    public void write(){
        //System.out.println("Записывал");
        changeTiredness(1);
        changeAttention(-1);
        Books.NOTEBOOK.changeClear_paper(1);
        Books.NOTEBOOK.changeScribbled_paper(1);
    }
    @Override
    public void seekOut(Character x){
        changeTiredness(1);
        x.changeInteres(1);
    }
    @Override
    public void introduce(Character a,Character b){
        a.addFriend(b);
        a.changeTiredness(1);
        a.changeInteres(1);
        b.changeInteres(1);
        b.changeTiredness(1);
        b.addFriend(a);
    }


    public int getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(int n) {
        this.tiredness=n;
    }
    public void changeTiredness(int n){
        this.tiredness =getTiredness()+n;
    }


    public int getAttention() {
        return attention;
    }
    public void setAttention(int n) {
        this.attention=n;
    }
    public void changeAttention(int n){ this.attention=getAttention()+n;}

    public String checkAttention(){ //Степень внимания от значения переменной
        if(getAttention()>=5) return " очень внимательно ";
        else if (getAttention()>=3) return " внимательно ";
        else return " не внимательно ";
    }

    public int getShame() {
        return shame;
    }
    public void setShame(int n) {
        this.shame=n;
    }
    public void changeShame(int n){
        this.shame=getShame()+n;
    }


    public int getInteres() {
        return interest;
    }

    public void setInteres(int n) {
        this.interest=n;
    }

    public void changeInteres(int n) {
        this.interest=getInteres()+n;
    }

    public String checkInteres(){
        return (this.getInteres() > 3) ? " захотел " : " не хотел ";
    }

    @Override
    public void makeHappy(Character x){
        x.changeInteres(1);
        x.changeTiredness(1);
    }
    @Override
    public void move(Character a,Place b){
        b.addObjectOnPlace(this.name);
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
