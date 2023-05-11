public class MainSalon {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(1);
        mesa.inciarOrden();
        mesa.getOrden().agregarHamburguesa(1);
        mesa.getOrden().agregarHamburguesa(2);
        mesa.getOrden().agregarHamburguesa(3);
        mesa.getOrden().agregarHamburguesa(4);
        mesa.getOrden().agregarHamburguesa(5);
        System.out.println(mesa);
    }
}
