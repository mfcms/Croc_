package karma.lab7.task14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    private String nickname;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(String nickname) {
        this.nickname = nickname;
    }

    public void start() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Соединение с сервером установлено.");

            writer.println(nickname);

            Thread readerThread = new Thread(new ServerListener());
            readerThread.start();

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = consoleReader.readLine()) != null) {
                writer.println(message);
            }

            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerListener implements Runnable {
        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите ваш никнейм: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String nickname = consoleReader.readLine();
            Client client = new Client(nickname);
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
