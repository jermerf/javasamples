package inheritance;

public class SiberianTiger extends Tiger{
    private double minTemperatureTollerance = -20.23;

    public SiberianTiger(int age, double weight, int stripes) {
        super(age, weight, stripes);
    }

    public double getMinTemperatureTollerance() {
        return minTemperatureTollerance;
    }

    @Override
    public String toString() {
        return "I am a siberian tiger";
    }
}
