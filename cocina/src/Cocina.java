import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Cocina {

    private static final int PUERTO = 5000;
    private static List<Socket> clientes = new ArrayList<>();

    Cocina(){
        abrirConexion();
    }

    public void abrirConexion() {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("CocinaServidor iniciado en el puerto " + PUERTO);

            while (true) {
                Socket cliente = servidor.accept();
                clientes.add(cliente);
                System.out.println("Se ha conectado un nuevo cliente desde " + cliente.getInetAddress());

                // Manejar la orden recibida del cliente
                Orden orden = recibirOrden(cliente);
                System.out.println("Se ha recibido una nueva orden: " + orden);

                // Notificar al salón que la orden ha sido recibida
                notificarSalon("Se ha recibido la orden: " + orden);

                // Cerrar la conexión con el cliente
                cliente.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private Orden recibirOrden(Socket cliente) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
        // Recibir la orden del salón del restaurante
        Orden orden = (Orden) in.readObject();
        return orden;
    }

    private static void notificarSalon(String mensaje) throws IOException {
        for (Socket cliente : clientes) {
            cliente.getOutputStream().write(mensaje.getBytes());
        }
    }
}