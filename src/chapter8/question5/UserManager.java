package chapter8.question5;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType) {
        if(users.containsKey(id)) {
            return null;
        }
        User user = new User(id, details, accountType);
        users.put(id, user);
        return user;
    }

    public boolean remove(User u) {
        return remove(u.getUserId());
    }

    public boolean remove(int id) {
        if(!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }

    public User find(int id) {
        return users.get(id);
    }
}
