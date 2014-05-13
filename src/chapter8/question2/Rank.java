package chapter8.question2;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/29/14
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Rank {
    Responder (0), Manager(1), Director(2);

    private int value;

    private Rank(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
