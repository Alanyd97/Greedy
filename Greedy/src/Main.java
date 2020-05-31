import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	static Dia[]  arDias = new Dia[100];
	public static void main(String... args) {
		CSVReader reader = new CSVReader("./data/familias.csv");
		
		ArrayList<Familia> familias = reader.read();
		inicializarArreglo();
		Greedy g = new Greedy(familias);
		g.agregarFamilias();
	}

	private static void inicializarArreglo(){
		for (int i = 0; i < arDias.length; i++) {
			arDias[i] = new Dia(i);
		}
	}

	private static class Greedy{
		private Iterator<Familia> iFamilias;
		private ArrayList<Familia> sinDesignar;
		private ArrayList<Familia> sinDesignarAux;

		private int bono;
		public Greedy(ArrayList<Familia> a){
			iFamilias = a.iterator();
			sinDesignar = new ArrayList<Familia>();
			sinDesignarAux = new ArrayList<Familia>();
			bono = 0;
		}

		public int bono(){ return this.bono();}
		public void agregarFamilias(){
			Iterator<Familia> aux = iFamilias;
			if (solucion()){
				while (aux.hasNext()){
					Familia a = aux.next();
					System.out.println(a+"  pref: "+a.diaPreferido());
					if (!arDias[a.diaPreferido()-1].addFamilia(a)){
						a.setPreferido();
						sinDesignar.add(a);
					}
				}
				if(sinDesignarAux.size() == 0){
					sinDesignarAux.addAll(sinDesignar);
				}
				iFamilias = sinDesignar.iterator();
				sinDesignar.removeAll(sinDesignar);
				//debug(sinDesignar);
				agregarFamilias();
			}
			for (Dia a : arDias){
				System.out.println("Sin design :"+a);
			}

			calcularBono(sinDesignarAux);
		}

		private void calcularBono(ArrayList<Familia> a){
			System.out.println("asd");
			for (Familia b: a){
				bono =  bono + 25 + (10 * b.miembros()) + (5 * b.getDesignado());
			}
			System.out.println("bono: "+bono);
		}
		private boolean solucion(){
			return iFamilias.hasNext();

		}

		private void debug(ArrayList<Familia> a){
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			try{
				for (Familia f: a
					 ) {
					System.out.println(f.getId()+"  pref:"+f.diaPreferido());
				}
				String z = entrada.readLine();
			}catch (Exception e){
				System.out.println(e);
			}
		}
	}
}
