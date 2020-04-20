public class ElectricCharge {
    private static double totalCharge = 0;
    private double charge;

    public ElectricCharge(double charge){
        this.charge = charge;
        totalCharge += charge;
    }


    public double getCharge() {
        return charge;
    }

    public static double getTotalCharge() {
        return totalCharge;
    }

}
