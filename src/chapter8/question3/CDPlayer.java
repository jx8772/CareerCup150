package chapter8.question3;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/31/14
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CDPlayer {
    private PlayList p;
    private CD c;

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }

    public PlayList getPlaylist() {
        return p;
    }

    public void setPlaylist(PlayList p) {
        this.p = p;
    }

    public CDPlayer (CD c) {
        this.c = c;
    }

    public CDPlayer (PlayList p) {
        this.p = p;
    }

    public void playNextSong () {
        p.PlayNextSong();
    }

}
