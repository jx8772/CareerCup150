package chapter8.question8;

public class Test {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.getBoard().initialize();
        Automator automator = Automator.getInstance();

        while(!automator.isOver() && automator.playRandom()) {

        }
        automator.printScores();
    }
}
