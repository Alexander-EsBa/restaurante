import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Salon {

    private static final String IP_SERVIDOR = "localhost";
    private static final int PUERTO = 5000;

    public Salon(){
        conectar();
    }

    public void conectar(){
        try {
            Socket servidor = new Socket(IP_SERVIDOR, PUERTO);
            System.out.println("Conectado al servidor " + servidor.getInetAddress());

            // Pedir la orden al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la orden: ");
            String orden = scanner.nextLine();

            // Enviar la orden al servidor
            servidor.getOutputStream().write(orden.getBytes());

            // Esperar la respuesta del servidor
            byte[] buffer = new byte[1024];
            int numBytes = servidor.getInputStream().read(buffer);
            String respuesta = new String(buffer, 0, numBytes);
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar la conexión con el servidor
            servidor.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
