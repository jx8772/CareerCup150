package chapter8.question5;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int userId;
    private String details;
    private int accountType;

    public void renewMembership() {}

    public User(int id, String details, int accountType) {
        userId = id;
        this.details = details;
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        userId = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
