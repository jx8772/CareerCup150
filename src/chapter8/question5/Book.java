package chapter8.question5;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private int bookId;
    private String details;

    public Book(int id, String details) {
        this.bookId = id;
        this.details = details;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        bookId = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
