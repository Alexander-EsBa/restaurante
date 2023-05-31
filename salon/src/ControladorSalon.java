/*import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;*/

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControladorSalon extends Thread {
    //Atributos
    Socket cliente;
    ServerSocket servidor;
    ObjectOutputStream output;
    ObjectInputStream input;
    final int PUERTO_ENTRADA = 1111;
    final int PUERTO_SALIDA = 2222;
    final String IP = "localhost";

    Salon salon;

    //Constructor
    public ControladorSalon() {
        start();
    }

    //Metodos
    public void run(){
        abrirConexion();
    }

    public void abrirConexion(){
        try {
            while (true){
                servidor = new ServerSocket(PUERTO_ENTRADA);
                cliente = servidor.accept();
                input = new ObjectInputStream(cliente.getInputStream());
                Object receivedObject = input.readObject();
                if (receivedObject instanceof Orden) {
                    enviarOrden((Orden) receivedObject);
                } else if (receivedObject instanceof Integer) {
                    System.out.println("Recibido" + receivedObject);
                    resetMesa((int) receivedObject);
                }

                input.close();
                cliente.close();
                servidor.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enviarOrden(Orden orden){
        try {
            cliente = new Socket(IP, PUERTO_SALIDA);
            output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(orden);
            output.flush();
            output.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void resetMesa(int mesa){
        for (int i = 0; i < salon.getMesas().size(); i++) {
            if (salon.getMesas().get(i).getNumero() == mesa){
                salon.getMesas().get(i).setOcupada(false);
                salon.getMesas().get(i).getOrden().resetearOrden();
            }
        }
    }








/*    Socket cliente;
    ServerSocket server;
    ObjectOutputStream output;
    ObjectInputStream input;
    private Salon salon;
    private Orden ordenTEMP;
    private Hamburguesa hamburguesaTEMP;
    private static final String IP_SERVIDOR = "localhost";
    private static final int PUERTO = 5000;

    //Constructor
    public ControladorSalon(){
//        conectar();
    }

    //Getters y Setters
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Orden getOrdenTEMP() {
        return ordenTEMP;
    }

    public void setOrdenTEMP(Orden ordenTEMP) {
        this.ordenTEMP = ordenTEMP;
    }

    public Hamburguesa getHamburguesaTEMP() {
        return hamburguesaTEMP;
    }

    public void setHamburguesaTEMP(Hamburguesa hamburguesaTEMP) {
        this.hamburguesaTEMP = hamburguesaTEMP;
    }

    //Metodos
    public void inicializarSalon(int cantidadMesas){
        salon = new Salon(cantidadMesas);
    }

    public void iniciarOrden(int mesa){
        this.ordenTEMP = new Orden(mesa);
    }

    public void elegirHamburguesa(int tipo){
        HamburguesasFactory factory = new HamburguesasFactory();
        this.hamburguesaTEMP = factory.crearHamburguesa(tipo);
    }

    public void agregarIngrediente(int ingrediente){
        this.hamburguesaTEMP.agregarIngrediente(ingrediente);
    }

    public void agregarHamburguesa(){
        this.ordenTEMP.agregarHamburguesa(this.hamburguesaTEMP);
        this.hamburguesaTEMP = null;
    }

    public void agregarOrden(){
        this.salon.getMesas().get(this.ordenTEMP.getMesa()-1).setOrden(this.ordenTEMP);
        this.ordenTEMP = null;
    }

    public void enviarOrden(int mesa){
        try {
            cliente = new Socket(IP_SERVIDOR, PUERTO);
            output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(this.salon.getMesas().get(mesa-1).getOrden());
            output.flush();
            output.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    *//*public void enviarOrden(Mesa mesa) {
        try {
            Socket servidor = new Socket(IP_SERVIDOR, PUERTO);
            System.out.println("Conectado al servidor " + servidor.getInetAddress());
            output = new ObjectOutputStream(servidor.getOutputStream());
            // Enviar la orden al servidor de la cocina
            output.writeObject(mesa.getOrden());
            output.flush();
            output.close();
            servidor.close();
            System.out.println("Orden enviada"+mesa.getOrden().toString());

            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al enviar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    }*/
}
