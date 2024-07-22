import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Старт сервера ");
        int port = 8088;

        try (ServerSocket serverSocket = new ServerSocket(port)){
        while (true) {
                try(Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.printf("New connection accepted Port: %d. Write your name: %n", clientSocket.getPort());
                final String name = in.readLine();
                System.out.println(name);

                out.println(String.format("Hi %s, Are you child? (yes/no)", name));
                final String answer = in.readLine();

                if(answer.equalsIgnoreCase("yes")){
                    out.println(String.format("Welcome to the kids area, %s! Let's play!!", name));
                }else {out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!!!", name));
                }

                out.println("How is your mood? (good/bad)");
                final String newQuestion = in.readLine();
                    if(newQuestion.equalsIgnoreCase("good")){
                        out.println(String.format("Great! I'm glad to hear that!"));
                    }else {out.println(String.format("I hope you feel better!"));
                    }

            } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}