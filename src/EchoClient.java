import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket echoSocket = new Socket("localhost", 12345);
        System.out.println("Connected to server: " + echoSocket.getRemoteSocketAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.print("Enter text (or 'exit' to quit): ");
            userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                break;
            }

            if (userInput.startsWith("calculate:")) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Response from server: " + response);
            } else {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Echo from server: " + response);
            }
        }

        in.close();
        out.close();
        echoSocket.close();
    }
}
