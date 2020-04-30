import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorProgram {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
          new Student("Andrew"),  // 3
          new Student("Aaron"),   // 4
          new Student("Chelsey"), // 5
          new Student("Hannah"),  // 1
          new Student("$pender")  // 2
        );

        students.sort(new StudentComparator());


    }
}
