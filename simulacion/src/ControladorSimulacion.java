import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControladorSimulacion {
    //Atributos
    Socket cliente;
    ObjectOutputStream output;
    final int PUERTO = 1111;
    final String IP = "localhost";

    //Constructor
    public ControladorSimulacion() {

    }

    //Metodos
    public void enviarOrden(Orden orden){
        try {
            cliente = new Socket(IP, PUERTO);
            output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(orden);
            output.flush();
            output.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
