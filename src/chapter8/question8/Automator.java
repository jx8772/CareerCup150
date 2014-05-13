package chapter8.question8;
import CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class Automator {
    private Player[] players;
    private Player lastPlayer = null;
    public ArrayList<Location> remainingMoves = new ArrayList<Location>();
    private static Automator instance;

    private Automator() {
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Location loc = new Location(i,j);
                remainingMoves.add(loc);
            }
        }
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
        lastPlayer = players[1];
    }

    public static Automator getInstance() {
        if(instance == null) {
            instance = new Automator();
        }
        return instance;
    }

    public void initialize(Player[] players) {
        players = players;
        lastPlayer = players[1];
    }

    public void shuffle() {
        for(int i = 0; i < remainingMoves.size(); i++) {
            int t = AssortedMethods.randomIntInRange(i, remainingMoves.size()-1);
            Location other = remainingMoves.get(t);
            Location current = remainingMoves.get(i);
            remainingMoves.set(t, current);
            remainingMoves.set(i, other);
        }
    }

    public void removeLocation(int r, int c) {
        for(int i = 0; i < remainingMoves.size(); i++) {
            Location loc = remainingMoves.get(i);
            if(loc.isSameAs(r,c)) {
                remainingMoves.remove(i);
            }
        }
    }

    public Location getLocation(int i) {
        return remainingMoves.get(i);
    }

    public boolean playRandom() {
        Board board = Game.getInstance().getBoard();
        shuffle();
        lastPlayer = lastPlayer == players[0] ? players[1] : players[0];
        String color = lastPlayer.getColor().toString();
        for(int i = 0; i < remainingMoves.size(); i++) {
            Location loc = remainingMoves.get(i);
            boolean success = lastPlayer.playPiece(loc.getRow(), loc.getColumn());
            if(success) {
                System.out.println("Success: " + color + " move at (" + loc.getRow() + ", " + loc.getColumn() + ")");
                board.printBoard();
                printScores();
                return true;
            }
        }
        System.out.println("Game over. No moves found for " + color);
        return false;
    }

    public boolean isOver() {
        if (players[0].getScore() == 0 || players[1].getScore() == 0) {
            return true;
        }
        return false;
    }

    public void printScores() {
        System.out.println("Score: " + players[0].getColor().toString() + ": " + players[0].getScore() + ", " + players[1].getColor().toString() + ": " + players[1].getScore());
    }
}
