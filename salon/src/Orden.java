import java.io.Serializable;
import java.util.ArrayList;

public class Orden implements Serializable {
    //Atributos
    private boolean lista;
    private int precioTotal;
    private int mesa;
    private ArrayList<Hamburguesa> hamburguesas;

    //Constructor
    public Orden(int mesa){
        this.lista = false;
        this.precioTotal = 0;
        this.mesa = mesa;
        this.hamburguesas = new ArrayList<>();
    }

    //Getters and Setters
    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
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

    //Metodos
    public void agregarHamburguesa(int hamburguesa){
        HamburguesasFactory factory = new HamburguesasFactory();
        Hamburguesa hamburguesaNueva = factory.crearHamburguesa(hamburguesa);
        this.hamburguesas.add(hamburguesaNueva);
        this.precioTotal += hamburguesaNueva.getPrecio();
    }

    //toString
    @Override
    public String toString() {
        String cadena = "";
        cadena += "MESA: " + mesa + "\n\n";
        for (Hamburguesa hamburguesa : hamburguesas) {
            cadena += hamburguesa + "\n";
        }
        cadena += "Total: ₡" + precioTotal + "\n";
        cadena += "Lista: " + lista;
        return cadena;
    }
}
