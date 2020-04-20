public class Cat {
    String name = "Unknown";
    int age = 0;
    double weight = 6.7;

    // Default constructor
    public Cat(){
        this("Unknown", -1, 3.1415926);
    }

    //Cat(String, int, double)
    public Cat(String newName, int newAge, double newWeight){
        this.name = newName;
        this.age = newAge;
        this.weight = newWeight;
        System.out.println("Announcing, the creating of a kitty!");
    }

    public void printDescription(){
        System.out.println("This cat is name " + name + " and they are " + age
                + " years old and weighs " + weight);
    }

}
