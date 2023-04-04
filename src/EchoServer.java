import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started.");

        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server listening on port " + serverSocket.getLocalPort());

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                CharacterPercentage cp = new CharacterPercentage(inputLine);
                double upperPercentage = cp.getUpperCasePercentage();
                double lowerPercentage = cp.getLowerCasePercentage();
                out.println("Percentage of upper and lower case characters in text '" + inputLine + "' is: " + upperPercentage + "% / " + lowerPercentage + "%");
            }

            System.out.println("Connection closed by client: " + clientSocket.getRemoteSocketAddress());
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
