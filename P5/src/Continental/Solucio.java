package Continental;

import java.util.ArrayList;

public class Solucio {

	private ArrayList<Moviment> moviments;
	
	
	public Solucio() {
		this.moviments = new ArrayList<Moviment>();
	}
	
	public boolean afegirMoviment(Moviment m) {
		return this.moviments.add(m);
	}
	
	public void desferMoviment() {
		this.moviments.remove(this.moviments.size()-1);
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < this.moviments.size(); ++i) {
			res += this.moviments.get(i).toString() + "\n";
		}
		return res;
	}
}
