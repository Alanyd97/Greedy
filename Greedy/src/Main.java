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
		Greedy g = new Greedy(familias);
		g.entregable(familias.iterator());
	}



}
