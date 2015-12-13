package Continental;
import java.util.ArrayList;

public class Solucio {
	//Llista de moviments
    private ArrayList<Moviment> moviments;

    //Creadora
	public Solucio(){
		this.moviments = new ArrayList<Moviment>();
	}
    
	//Afegeix el moviment a la llista
	public void ferMoviment(int x, int y, int novaX, int novaY) {
    	int menjaX = (x + novaX) / 2;
    	int menjaY = (y + novaY) / 2;
		moviments.add(new Moviment(new Coordenada(x,y), new Coordenada(novaX,novaY), new Coordenada(menjaX,menjaY)));
	}
	
	//Esborra l'últim moviments de la llista
	public Moviment desferUltimMoviment() throws Exception{
		if (moviments.isEmpty()) throw new Exception ("no hi ha cap moviment");
		Moviment m = moviments.get(moviments.size()-1);
		moviments.remove(m);
		return m;
	}
	
	//To String
	public String toString() {
		String res = "";
		for (int i = 0; i < this.moviments.size(); ++i) {
			res += (i+1)+ ". " + this.moviments.get(i).toString() + "\n";
		}
		return res;
	}
}
