import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMain {

    public static void main(String[] args) {

        int num = 42;
        boolean isIt = true;
        String name = "Jermaine \"Danger\" Francoeur";
        System.out.println(name);

        String moreWords = "First line\nSecondLine";
        System.out.println(moreWords);

        String aTab = "Start Tab->\t<-Tab";
        System.out.println(aTab);

        System.out.println("abcedf\b\b\b");

        System.out.println("Special mac char: \u2318");

        String catName = "    Tesla, destroyer of Furniture   ";

        System.out.println(catName.toUpperCase());

        System.out.println("]" + catName.trim() + "[");

        String piece = catName.substring(10, 20);
        System.out.println(piece);

        String[] parts = catName.trim().split(" ");
        System.out.println(parts[3]);

        String fName = "Edison";
        String lName = "Yang";

        String concatenated = fName + " " + lName;
        System.out.println(concatenated);
        System.out.println("There are " + concatenated.length() + " letters");

        char firstLetter = fName.charAt(0);
        System.out.println("First letter: " + firstLetter);

        char letterE = 'E';


        // --- Conversion Prcedence

        int inti = 10;
        float floati = 10.5f;
        double doubli = 3.14;

        float ipf = inti + floati;
        double ipd = inti + doubli;
        double fpd = floati + doubli;

        int ipfcast = (int)(inti + floati);
        int ipdcast = (int)(inti + doubli);
        float fpdcast = (float)(floati + doubli);

        String strAlwaysWin = "Anything+String=String";

        String ips = inti + " words";
        String fps = floati + " words";
        String dps = doubli + " words";

        // Let's go crazy
        List<String> list = new ArrayList<>();

        String listps = list + " words";

        System.out.println(listps);

        SuperList sl = new SuperList();

        String superlistps = sl + " words";

        System.out.println(superlistps);

    }
}
