public class Mesa {

    Orden orden;
    int id;

    Mesa(int _id){
        this.orden = new Orden();
        id=_id;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
