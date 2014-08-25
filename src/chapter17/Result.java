package chapter17;

/**
 * Created by xiangji on 8/25/14.
 */
public class Result {
    public int realHits;
    public int pseudoHits;

    public Result(){
        realHits = 0;
        pseudoHits = 0;
    }

    public String toString(){
        return "realHits: " + realHits + "; pseudoHits: " + pseudoHits;
    }
}
