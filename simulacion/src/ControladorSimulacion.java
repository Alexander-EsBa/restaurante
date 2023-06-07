import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ControladorSimulacion {
    //Atributos Socket
    Socket cliente;
    ObjectOutputStream output;
    final int PUERTO = 1111;
    final String IP = "localhost";

    //Atributos
    private ArrayList<Orden> ordenes;

    //Constructor
    public ControladorSimulacion() {
        ordenes = new ArrayList<Orden>();
    }

    //Metodos
    public void enviarOrdenes(){
        try {
            cliente = new Socket(IP, PUERTO);
            output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(ordenes);
            output.flush();
            output.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void simularOrdenes(int cantidadMesas){
        for (int i = 0; i < cantidadMesas; i++) {
            generarOrden(i + 1);
        }
        enviarOrdenes();
    }

    public void generarOrden(int mesa){
        Orden orden = new Orden(mesa);
        agregarHamburguesas(orden);
    }

    public void agregarHamburguesas(Orden orden){
        HamburguesasFactory hamburguesasFactory = new HamburguesasFactory();
        Random rand = new Random();
        int cantidad = rand.nextInt(5) + 1;
        for (int i = 0; i < cantidad; i++) {
            int tipo = rand.nextInt(1, 6);
            Hamburguesa hamburguesa = hamburguesasFactory.crearHamburguesa(tipo);
            orden.agregarHamburguesa(hamburguesa);
        }
        agregarOrden(orden);
    }

    public void agregarOrden(Orden orden){
        ordenes.add(orden);
    }
}
