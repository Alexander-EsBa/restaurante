import java.io.Serializable;

public class Mesa implements Serializable {
    //Atributos
    private int numero;
    private Orden orden;
    private boolean ocupada;

    //Constructor
    public Mesa(int numero) {
        this.numero = numero;
        this.orden = new Orden(numero);
        this.ocupada = false;
    }

    //Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    //toString
    @Override
    public String toString() {
        return orden.toString();
    }
}
