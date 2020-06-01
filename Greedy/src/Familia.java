
import java.util.Arrays;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 4 dias preferidos */
public class Familia implements  Comparable<Familia>{

	private int id;
	private int miembros;
	private int[] diasPreferidos;
	private int preferido=0;
	private int designado;
	private int indiceDesignado;
	public Familia(int id, int miembros, int... diasPreferidos) {
		this.id = id;
		this.miembros = miembros;
		this.diasPreferidos = diasPreferidos;
		this.indiceDesignado = 0;
	}

	public int getDesignado(){
		return designado;
	}

	public void setDesignado(int a){
		designado = a;
		if (preferenciaEn(0) == designado){
			setIndiceDesignado(0);
		}else{
			for (int i = 0; i < diasPreferidos.length; i++) {
				if (preferenciaEn(i) == designado){
					setIndiceDesignado(i);
					break;
				}
			}
		}
	}

	public int getIndiceDesignado() {
		return this.indiceDesignado;
	}

	public void setIndiceDesignado(int index){
		this.indiceDesignado = index;
	}

	public int getPreferido() { return preferido; }

	public void setPreferido() {
		if (preferido + 1 <= diasPreferidos.length -1)
			this.preferido++;
		else {
			preferido=-1;
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	/* Id de la familia */
	public int getId() {
		return id;
	}


	/* Retorna la cantidad de miembros de la familia. */
	public int miembros() {
		return miembros;
	}

	
	/* Dado un indice entre 0 y 4, retorna el d�a preferido por la familia para ese indice. */
	public int preferenciaEn(int indice) {
		return this.diasPreferidos[indice];
	}
	
	/* Retorna el dia preferido de la familia */
	public int diaPreferido(){
		return preferenciaEn(preferido);
	}
	
	/* Dado un dia pasado por parametro, indica el orden de ese dia en el top 5 de preferencias.
	Si el dia no forma parte de las preferencias del usuario, se retorna -1. */ 
	public int indiceDePreferencia(int dia) {
		for (int indice = 0; indice < diasPreferidos.length; indice++)
			if (dia == diasPreferidos[indice])
				return indice;
		return -1;
	}

	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos);
	}

	@Override
	public int compareTo(Familia o) {
		return Integer.compare(o.miembros(), this.miembros());
	}
}
