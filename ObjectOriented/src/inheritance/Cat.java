package inheritance;

public class Cat {
    private int age;
    private double weight;
    private double fluffitude;

    public Cat(int age, double weight){
        this.age = age;
        this.weight = weight;
        this.fluffitude = 1;
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

    public double getFluffitude() {
        return fluffitude;
    }

    public void setFluffitude(double fluffitude) {
        this.fluffitude = fluffitude;
    }

    public void describe(){
        System.out.println("This cat is "
                + this.age + " years old, "
                + this.weight + "lbs and has a fluffitude of "
                + this.fluffitude);
    }
}

