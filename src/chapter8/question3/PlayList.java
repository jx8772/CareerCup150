package chapter8.question3;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/31/14
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayList {
    private Song currentSong;
    private Queue<Song> queue;
    public PlayList(Queue<Song> q) {
        this.queue = q;
    }

    public void PlayNextSong() {
        currentSong = queue.poll();
    }

    public Song getNextSong() {
        return queue.peek();
    }

    public void addSong (Song s) {
        queue.add(s);
    }
}
