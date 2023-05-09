public class Original extends Hamburguesa{
    //Constructor
    public Original(){
        super("Original", 0);
        construir();
        definirPrecio();
    }

    //Metodos
    public void construir(){
        this.agregarIngrediente(1);
        this.agregarIngrediente(2);
        this.agregarIngrediente(3);
        this.agregarIngrediente(5);
        this.agregarIngrediente(4);
        this.agregarIngrediente(8);
    }
}