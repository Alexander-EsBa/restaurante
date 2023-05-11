import java.io.Serializable;

public class Garden extends Hamburguesa implements Serializable {
    //Constructor
    public Garden() {
        super("Garden", 0);
        construir();
        definirPrecio();
    }

    //Metodos
    public void construir() {
        this.agregarIngrediente(1);
        this.agregarIngrediente(2);
        this.agregarIngrediente(10);
        this.agregarIngrediente(7);
        this.agregarIngrediente(3);
        this.agregarIngrediente(6);
    }
}
