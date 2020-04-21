package abstraction;

public class VehicleDriver {
    private Drivable vehicle;

    public VehicleDriver(Drivable vehicle){
        this.vehicle = vehicle;
    }

    public void vacation(){
        vehicle.accelerate(80.3); // IN a 70 zone, le gasp!
        vehicle.steer(93);
        vehicle.stop();
    }

}
