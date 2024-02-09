import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpServer {

    public void handleClient(Socket clientSocket, DbFunctions dbFunctions) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String line = reader.readLine();
            System.out.println("Gelen veri: " + line);

            CCMesajiIsleyici ccMesajiIsleyici = new CCMesajiIsleyici();
            ccMesajiIsleyici.isle(line);

            /* Veriyi database'e ekle
            dbFunctions.insert_row(dbFunctions.connect_to_db(), "cihaz", line)*/;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
