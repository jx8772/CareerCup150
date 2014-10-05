package chapter10.Question2;
import java.util.HashMap;

/**
 * Created by xiangji on 10/1/14.
 */
public class Machine {
    public HashMap<Integer, People> map = new HashMap<Integer, People>();
    public int machineId;

    public Machine(int id){
        this.machineId = id;
    }

    public People getPeopleWithId(int id){
        return map.get(id);
    }
}
