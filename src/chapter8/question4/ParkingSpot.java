package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize size, int r, int sn, Level l) {
        spotSize = size;
        row = r;
        spotNumber = sn;
        level = l;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitInVehicle(Vehicle v) {
        return vehicle == null && v.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!canFitInVehicle(v))
            return false;
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public void removeVehicle() {
        vehicle = null;
        level.spotFreed();
    }

    public int getRow () {
        return row;
    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.Compact)
                System.out.println("c");
            else if (spotSize == VehicleSize.Large)
                System.out.println("l");
            else if (spotSize == VehicleSize.Motorcycle)
                System.out.println("m");
        } else {
            vehicle.print();
        }
    }
}
