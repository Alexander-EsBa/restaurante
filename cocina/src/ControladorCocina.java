import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;*/
public class ControladorCocina extends Thread {
    //Atributos Socket
    Socket cliente;
    ServerSocket servidor;
    ObjectInputStream input;
    ObjectOutputStream output;
    final int PUERTO = 2222;

    int PUERTO_SALIDA = 1111;

    JFrame frame = new JFrame();

    //Atributos Ordenes
    ArrayList<Orden> ordenes = new ArrayList<>();

    //Constructor
    public ControladorCocina() {
        start();
    }

    //Metodos
    public void run(){
        abrirConexion();
    }

    public void abrirConexion(){
        try {
            while (true){
                servidor = new ServerSocket(PUERTO);
                cliente = servidor.accept();
                input = new ObjectInputStream(cliente.getInputStream());
                ordenes.add((Orden) input.readObject());
                System.out.println(ordenes);
                input.close();
                cliente.close();
                servidor.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void enviarOrden(int orden){
        try {
            cliente = new Socket("localhost", PUERTO_SALIDA);
            output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(orden);
            output.flush();
            output.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }




















    /*Socket cliente;
    ServerSocket server;
    ObjectInputStream input;
    ObjectOutputStream output;
    private Orden orden;
    private Factura factura;
    private static final int PUERTO = 5000;
    private static List<Socket> clientes = new ArrayList<>();

    //Constructor
    public ControladorCocina() {
//        abrirConexion();
    }

    //Getters y Setters
    *//*public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }*//*

    //Metodos
    public void recibirOrden() {
        try {
            server = new ServerSocket(PUERTO);
            cliente = server.accept();
            input = new ObjectInputStream(cliente.getInputStream());
            orden = (Orden) input.readObject();
            input.close();
            cliente.close();
            server.close();
            Factura factura = new Factura(orden);
            this.factura = factura;
            System.out.println(factura);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    *//*public void abrirConexion() {
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
    }*/
}