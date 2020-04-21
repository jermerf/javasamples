package abstraction;

public class Car implements Drivable{
    private String engineModel;
    private double engineVolume;
    private int cylinders;


    @Override
    public void accelerate(double v) {
        System.out.println("The tires roar as the speed changes by " + v);
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
