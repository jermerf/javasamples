import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {
    public static final int LISTEN_PORT = 8888;
    private ServerSocket server;

    public SimpleSocketServer(){
        try {
            server = new ServerSocket(LISTEN_PORT);
            System.out.println("Server listening on port " + LISTEN_PORT);
            Socket clientSock = server.accept();
            DataInputStream dataIn = new DataInputStream(clientSock.getInputStream());
            int receivedValue = 0;
            while (receivedValue >= 0) {
                receivedValue = dataIn.readInt();
                System.out.println("Received int: " + receivedValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
