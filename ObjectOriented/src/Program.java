import abstraction.Car;
import abstraction.Drivable;
import abstraction.Plane;
import abstraction.VehicleDriver;
import abstraction.window.Window;
import ecapsulation.Access;
import inheritance.Cat;
import inheritance.SiberianTiger;
import inheritance.Tiger;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //Encapsulation
        Access keycard = new Access("Secret Lab");

        if(keycard.validateToken(2938472937235l)) {
            System.out.println("Access granted");
        }else{
            System.out.println("Access denied");
        }

        // Inheritance
        Cat tesla = new Cat(7, 6.9);
        Tiger tony = new Tiger(68, 300, 18);
        SiberianTiger saba = new SiberianTiger(9, 400, 30);

        tesla.describe();
        groom(tesla);
        //dangerGroom(tesla); // Tesla aint no tiger
        tesla.describe();

        tony.describe();
        groom(tony);
        dangerGroom(tony);
        tony.describe();

        saba.describe();
        groom(saba);
        dangerGroom(saba);
        saba.describe();

        System.out.println(saba);

        // Abstraction
        Drivable vehicle = new Plane();
        VehicleDriver amy = new VehicleDriver(vehicle);
        amy.vacation();

        //Combine it all
        Window win = new Window("Hello world!");
    }

    // Polymorphism
    public static void groom(Cat kitty) {
        kitty.setFluffitude(kitty.getFluffitude() * 0.5);
    }


    // Polymorphism
    public static void dangerGroom(Tiger kitty) {
        kitty.setFluffitude(kitty.getFluffitude() * 0.25);
    }

}
