import java.io.Serializable;
import java.util.ArrayList;

public class Hamburguesa implements Serializable {
    //Atributos
    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes;

    //Constructor
    public Hamburguesa(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = new ArrayList<>();
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    //Metodos
    public void agregarIngrediente(int ingrediente) {
        IngredientesFactory factory = new IngredientesFactory();
        this.ingredientes.add(factory.crearIngrediente(ingrediente));
    }

    public void definirPrecio() {
        for (Ingrediente ingrediente : ingredientes) {
            this.precio += ingrediente.getPrecio();
        }
    }

    //toString
    @Override
    public String toString() {
        String cadena = nombre + " (₡" + precio + ")\n";
        for (Ingrediente ingrediente : ingredientes) {
            cadena += "\t" + ingrediente + "\n";
        }
        return cadena;
    }
}
