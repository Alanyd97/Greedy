import java.util.ArrayList;
import java.util.Arrays;

public class Dia {
    private ArrayList<Familia> familias;
    private final static int capacidad = 340;
    private int capacidadActual;
    private int totalFamilias;
    private int cantFamilias;
    private int id;

    public Dia(int a){
        familias = new ArrayList<>();
        id=a;
        capacidadActual = capacidad;
        totalFamilias = 0;
        cantFamilias = 0;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public boolean addFamilia(Familia f){
        if (capacidadActual(f.miembros())){
            totalFamilias = totalFamilias + f.miembros();
            cantFamilias++;
            familias.add(f);
            f.setDesignado(f.diaPreferido());
            setCapacidadActual(getCapacidadActual() - f.miembros());
            return true;
        }else{
            return false;
        }
    }

    public int getCantFamilias(){return cantFamilias;}

    public int getTotalFamilias(){return totalFamilias;}

    public boolean capacidadActual(int cap){
        return capacidadActual >= cap;
    }
    @Override
    public String toString() {
        return "Capacidad=" + capacidadActual + ", cant fam=" + familias.size();
    }
}
