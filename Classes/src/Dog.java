import java.util.Date;
import java.util.Scanner;

public class Dog {
    private String name = "Unknown";
    private int age = 0;
    private double weight = 6.7;
    private Date created = new Date();

    public Dog(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
        new Scanner(System)
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
