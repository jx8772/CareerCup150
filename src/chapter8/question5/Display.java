package chapter8.question5;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void refreshUsername(){}
    public void refreshTitle() {}
    public void refreshDetails() {}
    public void refreshPage() {}
    public void forwardPage() {
        pageNumber++;
        refreshPage();
    }
    public void backwardPage() {
        if(pageNumber == 0)
            return;
        pageNumber--;
        refreshPage();
    }
}
