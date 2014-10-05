package chapter10.Question2;
import java.util.ArrayList;

/**
 * Created by xiangji on 10/1/14.
 */
public class People {
    public ArrayList<Integer> friendsId = new ArrayList<Integer>();
    public int id;

    public People(int id){
        this.id = id;
    }

    public void addFriend(int id){
        friendsId.add(id);
    }
}
