package Continental;

public class Continental {
	private Taulell taulell;
	private Magatzem_ruta moviments;
	//Tipus de caselles
	public static final int BUIT = 0;
	public static final int PLENA = 1;
	public static final int NULA = -1;
	
	//Tipus de direccions
	public static final int AMUNT = 1, AVALL = 2, ESQUERRA = 3, DRETA = 4;
	public static final int [] direccions = {AMUNT,AVALL,ESQUERRA,DRETA};
	
	//Solució
	public static final int [][] solucio = {
			{-1,-1,0,0,0,-1-1},
			{-1,-1,0,0,0,-1-1},
			  {0,0,0,0,0,0,0},
			  {0,0,0,1,0,0,0},
			  {0,0,0,0,0,0,0},
			{-1,-1,0,0,0,-1-1},
			{-1,-1,0,0,0,-1-1}
	};
	
	//Mida del taulell
	public static final int mida = 7;
	
	public Continental() {
		taulell = new Taulell(mida);
		this.SetContingutPos();
	}
	
	//Omple el taulell
	public void SetContingutPos() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (j == 3 && i == 3) this.taulell.SetContingutPos(i, j, BUIT);
				else if ((i < 2 || i > 4) && (j < 2 || j > 4)) this.taulell.SetContingutPos(i, j, NULA);
				else this.taulell.SetContingutPos(i, j, PLENA);
			}
		}
	}
	
	public boolean casellaValida(int x, int y) {
		if (this.taulell.getContingutPos(x, y) == NULA) return false;
		if (this.taulell.getContingutPos(x, y) == BUIT) return false;
		else return true;
	}
	
	public String toString() {
		String resultat = "";
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (this.taulell.getContingutPos(i, j) == NULA) resultat += "\t ";
				else if (this.taulell.getContingutPos(i, j) != NULA) resultat += " " + this.taulell.getContingutPos(i, j) + "\t ";
			}
			resultat += "\n";
		}
		return resultat;
	}
	
	public boolean afegirMoviment(Moviment m) {
		return this.moviments.afegeixMoviment(m);
	}
	
	public boolean desferMoviment(Moviment m) {
		return this.moviments.desferMoviment(m);
	}
}
