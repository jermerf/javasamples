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

    //Static functions can only access static variables
    public static double getTotalCharge() {
        // charge isn't static, so this static function can't see it
        // System.out.println(charge);
        return totalCharge;
    }

}
