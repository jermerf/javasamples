import java.util.Random;

public class Egg {
    private boolean cracked = false;

    public boolean smashAgainstCounter() throws EggSplatterException {
        Random rnd = new Random();
        if(rnd.nextBoolean()) {
            cracked = true;
            if(rnd.nextDouble() < 0.25) {
                throw new EggSplatterException();
            }
        }else {
            cracked = false;
        }
        return cracked;
    }
}
