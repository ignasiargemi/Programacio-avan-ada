package Continental;

import java.util.ArrayList;

public class Magatzem_ruta {
	
	private ArrayList<Moviment> moviments;
	
	public Magatzem_ruta() {
		this.moviments = new ArrayList<Moviment>();
	}
	
	public boolean afegeixMoviment(Moviment m) {
		if (this.moviments.add(m)) return true;
		else return false;
	}
	
	public boolean desferMoviment(Moviment m) {
		if (this.moviments.remove(m)) return true;
		else return false;
	}

}
