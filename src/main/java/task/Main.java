package task;


import task.persons.*;
import task.object.*;
import task.persons.Character;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        //Babes babes = new Babes();
        Table table = new Table();
        BabesArrayWrapper babesArrayWrapper = new BabesArrayWrapper();
        Bed bed = new Bed();
        Books Harry_Potter = Books.HARRY_POTTER;
        Books War_and_Piece = Books.WAR_AND_PIECE;
        Books Coloring_book = Books.COLORING_BOOK;
        Znayka.getInstance().addFun(new Watermelon());
        Solomka.getInstance().setWork(new Work[]{Work.FRUIT_GROWING,Work.VEGETABLES_GROWING});

        Population population = new Population(Znayka.getInstance(), Solomka.getInstance(), babesArrayWrapper);

        System.out.println("Действующие лица: ");
        for (Character person : population) {
            System.out.println(person.getName()+" "+person.toString());
        }
        System.out.println("Знайка машет рукой");
        Znayka.getInstance().Wake();
        System.out.println(Znayka.getInstance().toString());

        System.out.println("Ему" + Znayka.getInstance().checkShame() + "признаться, что ");
        table.setBooks(new Books[]{Harry_Potter, War_and_Piece});
        bed.setBooks(new Books[]{Coloring_book});
        System.out.println(table.getContent() + " и " + bed.getContent());

        System.out.println("Знайку,конечно,заинтересовали " + Znayka.getInstance().getFunNameList());

        System.out.println("Малышки рассказали ему про Соломку");
        babesArrayWrapper.introduce(babesArrayWrapper,Znayka.getInstance());
        babesArrayWrapper.Tell(Znayka.getInstance());
        System.out.println("Знайка "+Znayka.getInstance().checkInteres()+" познакомиться с ней");
        System.out.println(Znayka.getInstance().toString());
        System.out.println(babesArrayWrapper.toString());

        System.out.println("Малышки разыскали Соломку");
        babesArrayWrapper.introduce(babesArrayWrapper,Solomka.getInstance());
        babesArrayWrapper.SeekOut(Solomka.getInstance());
        System.out.println(Solomka.getInstance().toString());
        System.out.println(babesArrayWrapper.toString());

        System.out.println("и познакомили её со Знайкой");
        babesArrayWrapper.introduce(Znayka.getInstance(),Solomka.getInstance());
        System.out.println("Друзья знайки : "+Znayka.getInstance().getFriendList());
        System.out.println("Друзья соломки : "+Solomka.getInstance().getFriendList());

        System.out.println("Знайка стал её распрашивать"); //добавить незнание
        Znayka.getInstance().Question(Solomka.getInstance());
        System.out.println("обо всем, что его интересовало("+Znayka.getInstance().getFunNameList()+")");
        System.out.println(Solomka.getInstance().toString());
        System.out.println(Znayka.getInstance().toString());

        System.out.println("Соломка рассказала о своей работе : "+ Solomka.getInstance().getWorkList());
        Solomka.getInstance().Tell(Znayka.getInstance());
        System.out.println(Znayka.getInstance().toString());
        System.out.println(Solomka.getInstance().toString());


        System.out.println("Знайка"+Znayka.getInstance().CheckAttention()+"Слушал");
        Znayka.getInstance().Listen();
        System.out.println(Znayka.getInstance().toString());

        System.out.println("И даже записывал");
        Znayka.getInstance().Write();
        System.out.println("в свою маленькую "+Books.NOTEBOOK.getNameBook());
        System.out.println(Znayka.getInstance().toString());

//        System.out.println(Znayka.getInstance().equals(znayka1)+"Equals");
//        System.out.println(znayka.hashCode());
//        System.out.println(znayka1.hashCode());
}
}
