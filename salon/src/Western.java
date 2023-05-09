public class Western extends Hamburguesa{
    //Constructor
    public Western(){
        super("Western", 0);
        construir();
        definirPrecio();
    }

    //Metodos
    public void construir(){
        this.agregarIngrediente(1);
        this.agregarIngrediente(2);
        this.agregarIngrediente(9);
        this.agregarIngrediente(11);
        this.agregarIngrediente(3);
        this.agregarIngrediente(6);
    }
}
