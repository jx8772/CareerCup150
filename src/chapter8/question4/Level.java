package chapter8.question4;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots) {
        floor = flr;
        spots = new ParkingSpot[numberSpots];
        int largeSpots = numberSpots / 4;
        int motorcycleSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - motorcycleSpots;
        for (int i = 0; i < numberSpots; i++) {
            VehicleSize sz = VehicleSize.Motorcycle;
            if (i < largeSpots) {
                sz = VehicleSize.Large;
            } else if (i < largeSpots + compactSpots) {
                sz = VehicleSize.Compact;
            }
            int row = i / SPOTS_PER_ROW;
            spots[i] = new ParkingSpot(sz, row, i, this);
        }
    }

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle v) {
        if(availableSpots < v.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(v);
        if(spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, v);
    }

    public boolean parkStartingAtSpot(int spotNumber, Vehicle v) {
        v.clearSpot();
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + v.spotsNeeded; i++) {
            success = success && spots[i].park(v);
        }
        availableSpots -= v.spotsNeeded;
        return success;
    }

    private int findAvailableSpots(Vehicle v) {
        int spotNeeded = v.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitInVehicle(v)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if(spotsFound == spotNeeded) {
                return i - (spotNeeded - 1);
            }
        }
        return -1;
    }

    public void print() {
        int lastRow = -1;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getRow() != lastRow) {
                System.out.println("      ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }

    public void spotFreed() {
        availableSpots++;
    }
}
