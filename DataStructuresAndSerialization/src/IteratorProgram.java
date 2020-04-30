import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorProgram {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        // Slow
        students.add("Andrew");
        students.add("Aaron");
        //Fast
        students.addAll(Arrays.asList("Chelsey", "Hannah", "Spencer"));
        //What I should have done
        students = Arrays.asList("Andrew","Aaron","Chelsey", "Hannah", "Spencer");

        // Normal, with a for loop
        for(int i=0; i<students.size(); i++) {
            System.out.println(students.get(i));
        }

        // Better, with a foreach loop
        for(String el : students) {
            System.out.println(el);
        }

        // Iterator way
        Iterator<String> iterator = students.iterator();

        while(iterator.hasNext()) {
            String stu = iterator.next();
        }
    }
}
