package chapter8.question5;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    private Display display;
    private User activeUser;
    private Book activeBook;

    public OnlineReaderSystem () {
        library = new Library();
        userManager = new UserManager();
        display = new Display();
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay() {
        return display;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public void setActiveBook(Book b) {
        activeBook = b;
        display.displayBook(b);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User u) {
        activeUser = u;
        display.displayUser(u);
    }
}
