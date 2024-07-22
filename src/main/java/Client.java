import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8088;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
           Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваше имя:");
            String user = scanner.nextLine();
            out.println(user);


            String question = in.readLine();
            System.out.println(question);
            String answer = scanner.nextLine(); // Ответ клиента
            out.println(answer);
            question = in.readLine(); // Сообщение от сервера
            System.out.println(question);

            String NewQuestion = in.readLine();
            System.out.println(NewQuestion);
            String NewAnswer = scanner.nextLine(); // Ответ клиента
            out.println(NewAnswer);
            NewQuestion= in.readLine(); // Сообщение от сервера
            System.out.println(NewQuestion);
        }


        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
