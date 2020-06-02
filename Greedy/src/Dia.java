import java.util.ArrayList;
import java.util.Arrays;

public class Dia {
    private ArrayList<Familia> familias;
    private final static int capacidad = 340;
    private int capacidadActual;
    private int cantFamilias;
    private int bono;
    private int cantMiembros;

    public Dia(){
        familias = new ArrayList<>();
        bono=0;
        capacidadActual = capacidad;
        cantFamilias = 0;
        cantMiembros = 0;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public void addFamilia(Familia f){
        if (capacidadActual(f.miembros())){
            cantMiembros = cantMiembros + f.miembros();
            cantFamilias++;
            familias.add(f);
            f.setDesignado(f.diaPreferido());
            if (f.getIndiceDesignado() != 0){
                bono = bono + 25 +(10*f.miembros()) + (5 *f.getIndiceDesignado() );
            }
            setCapacidadActual(getCapacidadActual() - f.miembros());
        }
    }

    public int getBono() {return this.bono;}

    public int getCantFamilias(){return cantFamilias;}

    public boolean capacidadActual(int cap){
        return capacidadActual >= cap;
    }
    @Override
    public String toString() {
        return "Capacidad=" + capacidadActual + ", cant fam=" + this.cantMiembros;
    }
}
