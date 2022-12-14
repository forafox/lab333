package task;


import task.persons.*;
import task.object.*;
import task.persons.Character;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {

        BabesArrayWrapper babesArrayWrapper=new BabesArrayWrapper("Малышки");
        Babes babeOne = new Babes("Кнопочка");
        Babes babeTwo = new Babes("Синеглазка");
        Babes babeThree = new Babes("Ромашка");
        babesArrayWrapper.addBabes(babeTwo);
        babesArrayWrapper.addBabes(babeThree);
        babesArrayWrapper.addBabes(babeOne);
        Table table = new Table();
        Bed bed = new Bed();
        Books Harry_Potter = Books.HARRY_POTTER;
        Books War_and_Piece = Books.WAR_AND_PIECE;
        Books Coloring_book = Books.COLORING_BOOK;
        Znayka.getInstance().addFun(new Watermelon());
        Solomka.getInstance().setWork(new Work[]{Work.FRUIT_GROWING,Work.VEGETABLES_GROWING});

        Population population = new Population(Znayka.getInstance(), Solomka.getInstance(),babeOne,babeTwo,babeThree);

        System.out.println("Действующие лица: ");
        for (Character person : population) {
            System.out.println(person.getName()+" "+person.toString());
        }
        System.out.println("Знайка машет рукой");
        Znayka.getInstance().wake();
        System.out.println(Znayka.getInstance().toString());

        System.out.println("Ему" + Znayka.getInstance().checkShame() + "признаться, что ");
        table.setBooks(new Books[]{Harry_Potter, War_and_Piece});
        bed.setBooks(new Books[]{Coloring_book});
        System.out.println(table.getContent() + " и " + bed.getContent());

        System.out.println("Знайку,конечно,заинтересовали " + Znayka.getInstance().getFunNameList());

        System.out.println("Малышки рассказали ему про Соломку");
        babesArrayWrapper.introduce(babesArrayWrapper,Znayka.getInstance());
        babesArrayWrapper.tell(Znayka.getInstance());
        System.out.println("Знайка "+Znayka.getInstance().checkInteres()+" познакомиться с ней");
        System.out.println(Znayka.getInstance().toString());
        System.out.println(babesArrayWrapper.toString());

        System.out.println("Малышки разыскали Соломку");
        babesArrayWrapper.introduce(babesArrayWrapper,Solomka.getInstance());
        babesArrayWrapper.seekOut(Solomka.getInstance());
        System.out.println(Solomka.getInstance().toString());
        System.out.println(babesArrayWrapper.toString());


        System.out.println("и познакомили её со Знайкой");
        babesArrayWrapper.introduce(Znayka.getInstance(),Solomka.getInstance());
        System.out.println("Друзья знайки : "+Znayka.getInstance().getFriendList());
        System.out.println("Друзья соломки : "+Solomka.getInstance().getFriendList());

        System.out.println("Знайка стал её распрашивать"); //добавить незнание
        Znayka.getInstance().question(Solomka.getInstance());
        System.out.println("обо всем, что его интересовало("+Znayka.getInstance().getFunNameList()+")");
        System.out.println(Solomka.getInstance().toString());
        System.out.println(Znayka.getInstance().toString());

        System.out.println("Соломка рассказала о своей работе : "+ Solomka.getInstance().getWorkList());
        Solomka.getInstance().tell(Znayka.getInstance());
        System.out.println(Znayka.getInstance().toString());
        System.out.println(Solomka.getInstance().toString());


        System.out.println("Знайка"+Znayka.getInstance().checkAttention()+"Слушал");
        Znayka.getInstance().listen();
        System.out.println(Znayka.getInstance().toString());

        System.out.println("И даже записывал");
        Znayka.getInstance().write();
        System.out.println("в свою маленькую "+Books.NOTEBOOK.getNameBook());
        System.out.println(Znayka.getInstance().toString());
}
}
