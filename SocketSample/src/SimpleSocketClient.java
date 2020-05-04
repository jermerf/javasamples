import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleSocketClient {
    private Socket sock;

    public SimpleSocketClient(){
        try {
            Scanner input = new Scanner(System.in);
            sock = new Socket("127.0.0.1", 8888);
            DataOutputStream dataOut = new DataOutputStream(sock.getOutputStream());
            int numToSend = 0;
            while (numToSend >= 0) {
                System.out.println("Enter a number: ");
                numToSend = input.nextInt();
                dataOut.writeInt(numToSend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
