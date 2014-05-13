package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot () {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(v)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println();
        }
    }
}
