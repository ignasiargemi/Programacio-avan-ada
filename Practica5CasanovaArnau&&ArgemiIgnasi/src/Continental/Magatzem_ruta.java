package Continental;

import java.util.ArrayList;

public class Magatzem_ruta {
	
	private ArrayList<Moviment> moviments;
	
	public Magatzem_ruta() {
		this.moviments = new ArrayList<Moviment>();
	}
	
	public ArrayList<Moviment> getMag(){return moviments;}
	
	public boolean afegeixMoviment(Moviment m) {
		if (this.moviments.add(m)) return true;
		else return false;
	}
	
	public boolean desferMoviment(Moviment m) {
		if (this.moviments.remove(m)) return true;
		else return false;
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < this.moviments.size();++i) {
			res += (i+1) + ". " + this.moviments.get(i).toString() + "\n";
		}
		return res;
	}

}
