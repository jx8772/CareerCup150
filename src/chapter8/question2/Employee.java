package chapter8.question2;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/29/14
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Employee {
    protected Call currentCall = null;
    protected Rank rank;

    public Employee () {

    }

    public void receiveCall(Call call) {
        currentCall = call;
    }

    public void callFinished() {
        if (currentCall != null) {
            currentCall.disconnect();
            currentCall = null;
        }
        assignNewCall();
    }

    public void escalateAndReassign() {
        if (currentCall != null) {
            currentCall.incrementRank();
            //assign the current call
            CallHandler.getInstance().dispatchCall(currentCall);
            currentCall = null;
        }
        assignNewCall();
    }

    public boolean assignNewCall() {
        if(!isFree()) {
            return false;
        }
        return CallHandler.getInstance().assignCall(this);
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }


}
