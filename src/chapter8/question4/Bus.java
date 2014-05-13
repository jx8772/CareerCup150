package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    public void print() {
        System.out.println("B");
    }
}
