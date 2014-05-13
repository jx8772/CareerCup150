package chapter8.question7;
import java.util.HashMap;
import java.util.Date;

public class UserManager {
    private static UserManager instance;
    private HashMap<Integer, User> userById = new HashMap<Integer, User>();
    private HashMap<String, User> userByAccountName = new HashMap<String, User>();
    private HashMap<Integer, User> onlineUsers = new HashMap<Integer, User>();

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(User fromUser, String toAccountName) {
        User toUser = userByAccountName.get(toAccountName);
        AddRequest req = new AddRequest(fromUser, toUser, new Date());
        fromUser.sentAddRequest(req);
        toUser.receivedAddRequest(req);
    }

    public void approveAddRequest(AddRequest req) {
        req.status = RequestStatus.Accepted;
        User from = req.getFromUser();
        User to = req.getToUser();
        from.addContact(to);
        to.addContact(from);
    }

    public void rejectAddRequest(AddRequest req) {
        req.status = RequestStatus.Rejected;
        User from = req.getFromUser();
        User to = req.getToUser();
        from.removeAddRequest(req);
        to.removeAddRequest(req);
    }

    public void userSignedOn(String accountName) {
        User user = userByAccountName.get(accountName);
        if(user != null) {
            user.setStatus(new UserStatus("", UserStatusType.Available));
            onlineUsers.put(user.getId(), user);
        }
    }

    public void userSignedOff(String accountName) {
        User user = userByAccountName.get(accountName);
        if(user != null) {
            user.setStatus(new UserStatus("", UserStatusType.Offline));
            onlineUsers.remove(user.getId());
        }
    }
}
