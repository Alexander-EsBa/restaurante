public class IngredientesFactory {
    //Constructor
    public IngredientesFactory() {
    }

    //Metodo Factory
    public Ingrediente crearIngrediente(int ingrediente){
        switch (ingrediente) {
            case 1:
                return new Pan();
            case 2:
                return new Torta();
            case 3:
                return new Queso();
            case 4:
                return new Lechuga();
            case 5:
                return new Tomate();
            case 6:
                return new Cebolla();
            case 7:
                return new Pepinillos();
            case 8:
                return new Aguacate();
            case 9:
                return new Tocino();
            case 10:
                return new Hongos();
            case 11:
                return new Huevo();
            default:
                return null;
        }
    }

    public Ingrediente getIngrediente(int i) {
        return crearIngrediente(i);
    }
}
