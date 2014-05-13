package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    public void print() {
        System.out.println("C");
    }
}
