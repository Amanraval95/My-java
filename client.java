import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class client {
    private String ClientName;
    private String message;
    private BufferedReader in;
    private PrintWriter out;

    public void StartClient() {
        try {
            Socket CLIENT = new Socket("localhost", 1010);
            BufferedReader in = new BufferedReader(new InputStreamReader(CLIENT.getInputStream()));
            Scanner get = new Scanner(System.in);

            System.out.println(in.readLine());

            ClientName = get.nextLine();
            out.println(ClientName);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        client call = new client();
        call.StartClient();
    }

}