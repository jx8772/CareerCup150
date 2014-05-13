package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Motorcycle extends Vehicle{
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    public void print() {
        System.out.println("M");
    }
}
