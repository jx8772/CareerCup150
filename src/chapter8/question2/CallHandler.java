package chapter8.question2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/29/14
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CallHandler {
    private static CallHandler instance;
    private final int LEVELS = 3;
    private final int NUM_RESPONDENTS = 8;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;
    //list of employees by level
    ArrayList<ArrayList<Employee>> employeeLevels;
    ArrayList<ArrayList<Call>> callQueues;

    public static CallHandler getInstance() {
        if (instance == null) {
            instance = new CallHandler();
        }
        return instance;
    }

    public CallHandler() {
        employeeLevels = new ArrayList<ArrayList<Employee>>(LEVELS);
        callQueues = new ArrayList<ArrayList<Call>>(LEVELS);

        ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
        for (int i = 0; i < NUM_RESPONDENTS; i++) {
            respondents.add(new Respondent());
        }
        employeeLevels.add(respondents);

        ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
        managers.add(new Manager());
        employeeLevels.add(managers);

        ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
        directors.add(new Director());
        employeeLevels.add(directors);
    }

    public boolean assignCall(Employee emp) {
        //get the highest rank this employee can serve
        for (int rank = emp.getRank().getValue(); rank >= 0; rank--) {
            ArrayList<Call> queue = callQueues.get(rank);

            if(queue.size() > 0) {
                Call call = queue.remove(0);
                if (call != null) {
                    //receive call
                    return true;
                }
            }
        }
        return false;
    }

    public Employee setHandlerForCall(Call call) {
        for (int level = call.getRank().getValue(); level < LEVELS; level++) {
            ArrayList<Employee> employeeLevel = employeeLevels.get(level);
            for (Employee e : employeeLevel) {
                if (e.isFree())
                    return e;
            }
        }
        return null;
    }

    public void dispatchCall (Call call) {
        Employee e = setHandlerForCall(call);
        if(e != null) {
            e.receiveCall(call);
            call.setHandler(e);
        } else {
            call.reply("please wait for the next free employee");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    public void dispatchCaller (Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

}
