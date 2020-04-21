package ecapsulation;

import java.util.Random;

public class Access {
    private long secretToken;
    private String identifier;

    public Access(String identifier){
        this.identifier = identifier;
        Random rnd = new Random();
        secretToken = rnd.nextLong();
    }

    public boolean validateToken(long test) {
        return secretToken == test;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
