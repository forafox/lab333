package task.object;
import task.persons.*;
public abstract class Furniture {
    public static int bookCount=0;
    private Books[] books;
    private final String name;
    public Furniture(String name){
        this.name = name;
    }

    public String getContent() {  //выводим список книг объекта
        var result = new StringBuilder();
        for (var book: books) {
            result.append(book.getNameBook()).append(", ");
            this.PlusBookCount(1);
        }
        return String.format("На и даже под объектом %s лежат книги: "+removeLastChars(""+result,2),this.name);
    }
    private void PlusBookCount(int i) {
        bookCount=getBookCount()+i;
    }
    private void setBookCount(int count) {
        bookCount=count;
    }
    private int getBookCount() {
        return bookCount;
    }
    public void setBooks(Books[] books) {
        this.books = books;
    } //Присваем список книг объекту

    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }
}
