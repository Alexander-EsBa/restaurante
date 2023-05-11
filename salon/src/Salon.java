import java.util.ArrayList;

public class Salon {
    //Atributos
    private ArrayList<Mesa> mesas= new ArrayList<>();

    //Constructor
    public Salon(int numMesas){
        for(int i=0;i<numMesas;i++){
            mesas.add(new Mesa(i+1));
        }
    }

    //Getters and Setters
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    //toString
    @Override
    public String toString() {
        return "Salon{" + "mesas=" + mesas + '}';
    }
}
