package chapter10.Question2;
import java.util.HashMap;

/**
 * Problem: How would you design the data structures for a very large social network
 *like Facebook or Linkedin? Describe how you would design an algorithm to show
 *the connection, or path, between two people (e.g., Me -> Bob -> Susan -> Jason
 *-> You).
 * Created by xiangji on 10/1/14.
 */
public class Server {
    public HashMap<Integer, Machine> machineIdToMachineMap = new HashMap<Integer, Machine>();
    public HashMap<Integer, Integer> peopleToMachineMap = new HashMap<Integer, Integer>();

    public People getPeopleWithId(int id){
        Integer machineId = peopleToMachineMap.get(id);
        if(machineId == null){
            return null;
        }

        Machine m = machineIdToMachineMap.get(machineId);
        if(m == null){
            return null;
        }

        People p = m.getPeopleWithId(id);
        if(p == null){
            return null;
        }

        return p;
    }
}


