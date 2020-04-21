package abstraction;

public class Plane implements Drivable{
    private double vehicleLength;
    private double wingLength;
    private boolean isTurboprop;

    @Override
    public void accelerate(double v) {
        System.out.println("The engines rev as the speed changes by " + v + " and plane pitches in response");
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
