package superserial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable {
    String name;
    List<Story> works;

    public Author(String name) {
        this.name = name;
        this.works = new ArrayList<>();
    }
}
