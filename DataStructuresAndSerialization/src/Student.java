import java.util.Random;

public class Student {
    String name;
    int awesomeness;

    public Student(String name){
        this.name = name;
        awesomeness = 1+new Random().nextInt(100);
    }
}
