package superserial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialProgram {
    public static void main(String[] args) {
        Author tesla = new Author("Tesla");
        Author edison = new Author("Edison");

        tesla.works.add(new Story());
        tesla.works.add(new Story());
        edison.works.add(new Story());
        edison.works.add(new Story());
        edison.works.add(new Story());
        edison.works.add(new Story());

        // Writing Objects to file
        PersistentData data = new PersistentData();
        data.clients = Arrays.asList(tesla, edison);
        try{
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("clients.dat", false));
            output.writeObject(data);
            output.flush();
            output.close();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        // Reading objects from file
        PersistentData loadedData = null;
        try{
            ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("clients.dat"));
            loadedData = (PersistentData) input.readObject();
            input.close();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
