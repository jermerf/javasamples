package abstraction;

public class Boat implements Drivable{
    private double vehicleLength;
    private double dryVolumeDisplacement;
    private double engineHp;

    @Override
    public void accelerate(double v) {
        System.out.println("The boat lunges as the speed changes by " + v + " and splashes.");
    }

    @Override
    public void steer(double ang) {

    }

    @Override
    public void stop() {

    }

    @Override
    public double getSpeed() {
        return 0;
    }
}
