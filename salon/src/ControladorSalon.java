import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorSalon {

    /*ObjectOutputStream out;
    private ArrayList<Mesa> mesas= new ArrayList<>();

    private static final String IP_SERVIDOR = "localhost";
    private static final int PUERTO = 5000;



    public ControladorSalon(){
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
            out.writeObject(mesa.getOrden());
            out.flush();
            out.close();
            servidor.close();
            System.out.println("Orden enviada"+mesa.getOrden().toString());

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
    }*/

    //Atributos
    private Salon salon;
    private Orden ordenTEMP;
    private Hamburguesa hamburguesaTEMP;

    //Constructor
    public ControladorSalon(){;
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
    public void inizializarSalon(int cantidadMesas){
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


}
