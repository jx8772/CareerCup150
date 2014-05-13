package chapter8.question4;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded () {
        return spotsNeeded;
    }

    public VehicleSize getSize () {
        return size;
    }

    public void parkInSpot(ParkingSpot p) {
        parkingSpots.add(p);
    }

    public void clearSpot() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            //parkingSpots.get(i)
        }
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public abstract void print();
}
