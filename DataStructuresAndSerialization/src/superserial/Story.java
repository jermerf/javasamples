package superserial;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;

public class Story implements Serializable {

    String text;
    Date writtenOn;

    public Story() {
        this.text = randomString();
        writtenOn = new Date();
    }


    public static String randomString() {
        byte[] array = new byte[10]; // length is bounded by 10
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}
