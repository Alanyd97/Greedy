import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Greedy {
    private Billetes b;
    private Reuniones reuniones;
    public Greedy(){
        b=new Billetes();
        reuniones = new Reuniones();
    }
    public void billetesResultado(int retiro){
        b.cajeroAutomatico(retiro);
    }
    public void reunionesResultado(){
       HashMap<Integer, Integer> r = reuniones.reunionesResultado();
       for (Map.Entry<Integer, Integer> mapa: r.entrySet()){
           System.out.println("Hora de inicio: "+mapa.getKey()+"  Hora de fin: "+mapa.getValue());
       }
    }


    private class Billetes{

        //Solo para billetes tp4.1
        private ArrayList<Integer> billetes;
        public Billetes(){
            //Para el problema de los biletes
            billetes = new ArrayList<>();
            billetes.add(100);
            billetes.add(50);
            billetes.add(25);
            billetes.add(10);
            billetes.add(5);
            billetes.add(1);
            for (Integer i: billetes
                 ) {
                System.out.print(i+" |");
            }
            System.out.println("  ");
        }
        //Problema de los billetes tp4.1

        protected void cajeroAutomatico(int retiro){
            HashMap<Integer, Integer> billetesResultado = new HashMap<Integer, Integer>();
            int billete = 0;
            int sumaTotal = 0;
            int resto = retiro;
            while ((!this.solucion(retiro, sumaTotal))){
                billete = seleccionar(billetes, resto);
                sumaTotal = sumaTotal + billete;
                resto = resto - billete;
                if (billetesResultado.containsKey(billete)){
                    Integer n = billetesResultado.get(billete);
                    billetesResultado.replace(billete, n, n+1);
                }else{
                    billetesResultado.put(billete, 1);
                }
            }
            System.out.println("Retiro---> "+retiro);
            for (Map.Entry<Integer, Integer> mapa: billetesResultado.entrySet()){
                System.out.println("Billete: "+ mapa.getKey()+ "  Cantidad: "+ mapa.getValue());
            }
        }

        private boolean solucion(int retiro, int suma){
            return retiro == suma;
        }

        private int seleccionar(ArrayList<Integer> a, int suma){
           for (Integer i: a){
               if (i <= suma){
                   return i;
               }
           }
            return -1;
        }

    }

    private class Reuniones{
        private HashMap<Integer, Integer> reuniones = new HashMap<Integer, Integer>();
        public Reuniones(){
            reuniones.put(9,11);
            reuniones.put(10,14);
            reuniones.put(12,13);
            reuniones.put(14,16);
            reuniones.put(15,20);
            reuniones.put(16,19);
            reuniones.put(19,20);
            reuniones.put(20,21);
        }

        protected HashMap<Integer, Integer> reunionesResultado(){
            HashMap<Integer, Integer> resultado = new HashMap<>();

            System.out.println(tPrimero(0, resultado)+" <");
            return resultado;
        }

        private Integer tPrimero(int inicio,HashMap<Integer, Integer> resultado){
            Iterator horaFin = reuniones.values().iterator();

            if (resultado.isEmpty()){
                Integer menor = 300;
                Integer key = 0;
                while (horaFin.hasNext()){
                    Integer actual = (Integer) horaFin.next();
                    if (actual < menor){
                        menor = actual;
                    }
                }
                //ta mal
                return reuniones.size();
            }else{
                return 0;
            }

        }






    }




}
