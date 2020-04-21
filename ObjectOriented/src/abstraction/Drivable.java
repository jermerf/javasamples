package abstraction;

public interface Drivable {
    void accelerate(double v);
    void steer(double ang);
    void stop();
    double getSpeed();
}
