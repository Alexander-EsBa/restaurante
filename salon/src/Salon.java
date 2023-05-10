import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Salon {
    ObjectOutputStream out;
    private ArrayList<Mesa> mesas= new ArrayList<>();

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
    public void enviarOrden(Mesa mesa) {
        try {
            Socket servidor = new Socket(IP_SERVIDOR, PUERTO);
            System.out.println("Conectado al servidor " + servidor.getInetAddress());
            out = new ObjectOutputStream(servidor.getOutputStream());
            // Enviar la orden al servidor de la cocina
            out.writeObject(mesa.orden);
            out.flush();
            out.close();
            servidor.close();
            System.out.println("Orden enviada"+mesa.orden.toString());

            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al enviar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarMesas(int cantidadMesas){
        for(int i=0; i<cantidadMesas; i++){
            mesas.add(new Mesa(i+1));
        }

    }

    public void agregarOrden(int mesa, Orden orden){
        mesas.get(mesa-1).setOrden(orden);
    }



}
