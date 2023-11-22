package karma.lab7.task14;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.Scanner;

public class Server {
    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Порт, на котором будет работать сервер
            
            System.out.println("Сервер запущен. Ожидание подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream());
                clients.add(clientWriter);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
            client.flush();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private Scanner clientScanner;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                this.clientScanner = new Scanner(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String nickname = clientScanner.nextLine();

                System.out.println("Пользователь " + nickname + " подключился.");

                while (true) {
                    if (clientScanner.hasNextLine()) {
                        String message = clientScanner.nextLine();
                        System.out.println(nickname + ": " + message);
                        broadcastMessage(nickname + ": " + message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}