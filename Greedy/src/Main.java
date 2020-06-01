import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	static Dia[]  arDias = new Dia[100];
	public static void main(String... args) {
		CSVReader reader = new CSVReader("./data/familias.csv");
		ArrayList<Familia> familias = reader.read();
		Collections.sort(familias);
		for (Familia fam : familias) {
			System.out.println(fam);
		}
		inicializarArreglo();
		Greedy g = new Greedy();
		g.agregarFamilias(familias.iterator());
	}

	private static void inicializarArreglo(){
		for (int i = 0; i < arDias.length; i++) {
			arDias[i] = new Dia(i);
		}
	}

	private static class Greedy{
		private ArrayList<Familia> sinDesignarAux;
		private int designados;

		private int bono;
		public Greedy(){
			sinDesignarAux = new ArrayList<Familia>();
			bono = 0;
			designados = 0;
		}

		public int bono(){ return this.bono();}

		public void agregarFamilias(Iterator<Familia> iFamilias){
			ArrayList<Familia> sinDesignar = new ArrayList<Familia>();
			if (solucion(iFamilias)){
				while (iFamilias.hasNext()){
					Familia a = iFamilias.next();
					if (a.getId() == 4846){
						System.out.println("pref de: "+ (a.diaPreferido()-1));
					}
					if (!arDias[a.diaPreferido()-1].addFamilia(a)){
						a.setPreferido();
						sinDesignar.add(a);
					}else{
						designados++;
					}
				}
				System.out.println("Designados: "+designados);
				debug(sinDesignar);
				agregarFamilias(sinDesignar.iterator());
			}
			int totalFam = 0;
			int cantFam = 0;
			for (Dia a : arDias){
				totalFam = totalFam + a.getCantFamilias();
			}
			System.out.println("Total de familias: "+ totalFam);
			calcularBono(sinDesignarAux);
		}

		private void calcularBono(ArrayList<Familia> a){
			for (Familia b: a){
				bono =  bono + 25 + (10 * b.miembros()) + (5 * b.getDesignado());
			}
			System.out.println("bono: "+bono);
		}

		private boolean solucion(Iterator<Familia> iFamilias){
			return iFamilias.hasNext();

		}

		private void debug(ArrayList<Familia> a){
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			try{
				System.out.println("sin designar: "+a.size());
				char z = entrada.readLine().charAt(0);
				if (z >= 'z'){
					System.out.println(a.get(1));
					System.out.println("Indice: "+a.get(1).getPreferido());
					System.out.println(arDias[4].getCapacidadActual());
					System.out.println(arDias[46].getCapacidadActual());
					System.out.println(arDias[32].getCapacidadActual());
					System.out.println(arDias[25].getCapacidadActual());
					System.out.println(arDias[11].getCapacidadActual());
					System.out.println(arDias[59].getCapacidadActual());
					System.out.println(arDias[65].getCapacidadActual());
					System.out.println(arDias[0].getCapacidadActual());
					arDias[4].getCapacidadActual();
					arDias[11].getCapacidadActual();
				}
			}catch (Exception e){
				System.out.println(e);
			}
		}
	}
}
