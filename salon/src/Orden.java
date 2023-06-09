import java.io.Serializable;
import java.util.ArrayList;

public class Orden implements Serializable {
    //Atributos
    private boolean estado;
    private int precioTotal;
    private int mesa;
    private ArrayList<Hamburguesa> hamburguesas;

    public boolean estaAgregado = false;

    //Constructor
    public Orden(int mesa) {
        this.estado = false;
        this.precioTotal = 0;
        this.mesa = mesa;
        this.hamburguesas = new ArrayList<>();
    }

    //Getters and Setters
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList<Hamburguesa> getHamburguesas() {
        return hamburguesas;
    }

    public void setHamburguesas(ArrayList<Hamburguesa> hamburguesas) {
        this.hamburguesas = hamburguesas;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    //Metodos
    public void agregarHamburguesa(Hamburguesa hamburguesa) {
        this.hamburguesas.add(hamburguesa);
        this.precioTotal += hamburguesa.getPrecio();
    }

    //toString
    @Override
    public String toString() {
        String cadena = "";
        for (Hamburguesa hamburguesa : hamburguesas) {
            cadena += hamburguesa + "\n";
        }
        cadena += "Orden Lista: " + estado;
        cadena += "\nPrecio Total: " + precioTotal;
        return cadena;
    }

    public void resetearOrden(){
        this.estado = false;
        this.precioTotal = 0;
        this.hamburguesas = new ArrayList<>();
    }
}
