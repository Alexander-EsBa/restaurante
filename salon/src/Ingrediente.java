public class Ingrediente {
    //Atributos
    private String nombre;
    private int precio;

    //Constructor
    public Ingrediente(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
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

    //toString
    @Override
    public String toString() {
        return nombre + " (₡" + precio + ")";
    }
}
