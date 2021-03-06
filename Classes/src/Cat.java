public class Cat {
    static int catCount = 0;
    // Member variables/members
    String name = "Unknown";
    int age = 0;
    double weight = 6.7;

    // Default constructor
    public Cat(){
        this("Unknown", -1, 3.1415926);
    }

    //Alternate constructor with signature Cat(String, int, double)
    public Cat(String newName, int newAge, double newWeight){
        this.name = newName;
        this.age = newAge;
        this.weight = newWeight;
        catCount++;
        System.out.println("Announcing, the creating of a kitty!");
    }

    // member function/method
    public void printDescription(){
        System.out.println("This cat's name is " + this.name + " and they are " + this.age
                + " years old and weighs " + this.weight);
    }

}
