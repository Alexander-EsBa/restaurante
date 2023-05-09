public class HamburguesasFactory {
    //Constructor
    public HamburguesasFactory(){
    }

    //Metodo Factory
    public Hamburguesa crearHamburguesa(int hamburguesa){
        switch (hamburguesa) {
            case 1:
                return new Simple();
            case 2:
                return new ClubHouse();
            case 3:
                return new Western();
            case 4:
                return new Garden();
            case 5:
                return new Original();
            default:
                return null;
        }
    }
}
