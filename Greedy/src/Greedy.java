import java.util.ArrayList;
import java.util.Iterator;

public class Greedy {
    private ArrayList<Familia> familias;
    private int bono;
    private Dia[] dias;
    public  Greedy(ArrayList<Familia> a){
        familias= new ArrayList<Familia>();
        familias.addAll(a);
        dias = new Dia[100];
        bono = 0;
        inicializarArreglo();
    }

    private Dia[] inicializarArreglo(){
        for (int i = 0; i < dias.length; i++) {
            dias[i] = new Dia();
        }
        return dias;
    }

    public void entregable(Iterator<Familia> iFam){
        if (iFam.hasNext()){
            while (iFam.hasNext()){
                Familia a = iFam.next();
                designar(a);
            }
        }
        debug();
    }

    private void debug(){
        int iterador =0;
        int ite =0;
        for (Dia a: dias) {
            iterador=iterador + a.getCantFamilias();
            bono = bono + a.getBono();
            ite++;
            if(a.getCapacidadActual() == 0){
                System.out.println(a+"  ite: "+ite);
            }
        }
        System.out.println("familias designadas: "+ iterador+"  bono: "+bono);
    }

    private void designar(Familia a){
        int diaPref = a.diaPreferido()-1;
        if (dias[diaPref].capacidadActual(a.miembros())){
            dias[diaPref].addFamilia(a);
        }else{
            dias[getMejorDia(a)].addFamilia(a);
        }
    }

    private int getMejorDia(Familia a){
        int mejorDia = 0;
        for (int i = 0; i < 8; i++) {
            if (dias[a.diaPreferido()-1].getCapacidadActual() >= a.miembros()){
                mejorDia = a.diaPreferido()-1;
            }else{
                a.setPreferido();
            }
        }
        return mejorDia;
    }



}
