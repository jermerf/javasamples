import java.util.Scanner;

public class AgeSwitch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What subscription tier are you?");
        int tier = input.nextInt();

            /* Subscription service with 3 tiers:
            Tier1: Complimentary keychain

            Tier 2: Everything from Tier1
            Complimentary tShirt
            Water bottle

            Tier 3: Everything from Tier2
            Signed copy of "Code" by Jermionee Granger
            Season pass to Jermaine's Basement

            // This is an example of fall-through, where there is no break; so
            // in case 3 for example, after the two messages are printed, the
            // code "falls-through" to case 2, and so on.
            */
        switch (tier) {
            case 3:
                System.out.println("You receive a Signed pile of paper");
                System.out.println("You receive a Season pass to education");
            case 2:
                System.out.println("You receive a tshirt");
                System.out.println("You receive a waterbottle");

            case 1:
                System.out.println("You receive a Keychain");

        }


    }

}
