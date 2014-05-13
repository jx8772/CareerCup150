package chapter8.question5;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Library {
    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details) {
        if(books.containsKey(id))
            return null;
        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean remove(Book b) {
        return remove(b.getBookId());
    }

    public boolean remove(int id) {
        if(!books.containsKey(id))
            return false;
        books.remove(id);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }
}
