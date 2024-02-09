import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        TcpServer tcpServer = new TcpServer();
        DbFunctions dbFunctions = new DbFunctions();

        int portNumber = 9999;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server başlatıldı. Port: " + portNumber);

            while (true) {
                System.out.println("Bağlantı bekleniyor...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Bağlantı kabul edildi: " + clientSocket);

                tcpServer.handleClient(clientSocket, dbFunctions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
