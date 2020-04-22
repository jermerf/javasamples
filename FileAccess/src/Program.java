import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        dummy();
        writeNewFile();

        Egg e = new Egg();
        try {
            while(!e.smashAgainstCounter()) {
                System.out.println("It didn't crack");
            }
        }catch (EggSplatterException egc) {
            System.out.println("Gross, the egg splattered everywhere...");
            return;
        }

        System.out.println("Now put the egg in the pan");
    }

    public static void writeNewFile() {
        String text = "Some words";

        File saveFile = new File("note.txt");

        if(!saveFile.exists()){
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldn't create file");
                e.printStackTrace();
                return;
            }
        }

        try {
            FileWriter fw = new FileWriter(saveFile, true);
            fw.write(text + "\n");
            fw.flush();
            // fw.close(); // closes access to the file

            // The FileWriter and FileReader classes are very low level
            // FileReader fr = new FileReader(saveFile);
            // fr.read();

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hello world");
            bw.newLine();
            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(saveFile));

            String readIn = "";
            String line = br.readLine();

            // line is null when you reach the end of the file
            while(line != null) {
                readIn += line + "\n";
                line = br.readLine();
            }

            br.close();
            System.out.println(readIn);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dummy() {
        tryCatchDemo();
    }

    public static void tryCatchDemo() {
        File badFileName = new File("note*?|\"\\/.txt");

        // Dummy try/catch
        try {
            int x = 0;
            int y = 4 / x;
            // Doesn't happen
            badFileName.createNewFile();
        } catch (ArithmeticException ex) {
            System.out.println("An error occurred, it was math");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("An error occurred, it was files");
        }

        // Intro to TODO
        try {
            int x = 0;
            int y = 4 / x;
            // Doesn't happen
            badFileName.createNewFile();
        } catch (Exception ex) {
            //TODO Fix before release
            System.out.println("Some error, deal with it before release");
        }
    }
}
