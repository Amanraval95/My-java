import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server implements Runnable {
    private static final String QUIT = "/quit";
    private static final String RENAME = "/rename";

    private ArrayList<ClientHandler> Connection = new ArrayList<>();

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(1010);
            System.out.println("Server is Running...");

            while (true) {
                Socket client = serverSocket.accept();
                ClientHandler handler = new ClientHandler(client);

                Connection.add(handler);
                System.out.println("joined");
                Thread ClientThread = new Thread(new ClientHandler(client));
                ClientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        private Socket CLIENT;
        private BufferedReader in;
        private PrintWriter out;
        private String ClientName;
        private String message;

        public ClientHandler(Socket client) {
            this.CLIENT = client;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(CLIENT.getInputStream()));
                out = new PrintWriter(CLIENT.getOutputStream(), true);
                out.println("Enther Your Name");
                ClientName = in.readLine();
                System.out.println(ClientName + " Has Joined!");

                // while (true) {

                // }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        server sc = new server();
        Thread serverThread = new Thread(sc);
        serverThread.start();
    }

}
