package chapter8.question3;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/31/14
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private PlayList playList;
    private boolean activated = false;

    public JukeBox (CDPlayer cdPlayer, User user, Set<CD> cdCollection, PlayList pl) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.playList = pl;
    }

    public void playNextSong() {
        if (activated == false) {
            System.out.println("please insert coin");
            return;
        } else {
            playList.PlayNextSong();
            activated = false;
        }
    }

    public boolean insertCoin() {
        if(activated == false) {
            activated = true;
            return true;
        } else
            return true;
    }
}
