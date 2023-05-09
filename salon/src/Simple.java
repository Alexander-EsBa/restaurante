public class Simple extends Hamburguesa{
    //Constructor
    public Simple(){
        super("Simple", 0);
        construir();
        definirPrecio();
    }

    //Metodos
    public void construir(){
        this.agregarIngrediente(1);
        this.agregarIngrediente(2);
    }
}
