public class MainProgram {
    public static void main(String[] args) {

        // Why we need classes/objects
        String eName = "Edison";
        int eAge = 4;
        double eWeight = 13.4;

        String tesName = "Tesla";
        int tesAge = 7;
        double tesWeight = 6.9;

        // Object WITHOUT constructor
        Cat ncEdison = new Cat();
        ncEdison.name = "Edison";
        ncEdison.age = 4;
        ncEdison.weight = 13.4;
        ncEdison.printDescription();

        // Object WITH constructor
        Cat cTesla = new Cat("Tesla", 7, 6.9);
        Cat cSpotify = new Cat("Spotify", 8, 3.4);

        cTesla.printDescription();
        cSpotify.printDescription();

        Cat mystery = new Cat();
        mystery.printDescription();

        Dog fido = new Dog("Fido", 15, 30);
//        Dog frodo = new Dog(); // No default constructor for Dog()

//        System.out.println(fido.weight); // Is private

        Journal diary = new Journal();
        diary.append("Today Tesla was evil");
        diary.append("Today Edison was asleep");
        String theWords = diary.getWords();
        theWords = "_deleted by timmy";

        // Static
        ElectricCharge blanket = new ElectricCharge(7);
        ElectricCharge pants = new ElectricCharge(2);
        ElectricCharge pyjamas = new ElectricCharge(5);
        ElectricCharge socks = new ElectricCharge(4);

        System.out.println("The total Charge is: " + ElectricCharge.getTotalCharge());

    }
}
