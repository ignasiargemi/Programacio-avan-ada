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
	//public Solucio solucions;
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
		this.moviments = new Magatzem_ruta();
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
	
	//Getter
	public Taulell getTaulell(){return taulell;}
	
	public boolean casellaValida(int x, int y) {
		if (this.taulell.getContingutPos(x, y) == NULA) return false;
		if (this.taulell.getContingutPos(x, y) == BUIT) return false;
		else return true;
	}
	
	public int possibleDireccio(int i, int j) {
		if (i < 0 || i > mida-1 || j < 0 || j > mida-1) return -1;
		if (taulell.getContingutPos(i-1, j) == PLENA && taulell.getContingutPos(i-2, j) == BUIT) return AMUNT;
		if (taulell.getContingutPos(i+1, j) == PLENA && taulell.getContingutPos(i+2, j) == BUIT) return AVALL;
		if (taulell.getContingutPos(i, j-1) == PLENA && taulell.getContingutPos(i, j-2) == BUIT) return ESQUERRA;
		if (taulell.getContingutPos(i, j+1) == PLENA && taulell.getContingutPos(i, j+2) == BUIT) return DRETA;
		return 0;
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
	
	public String toStringMoviments() {
		if (this.moviments == null) System.out.println("Error");
		return this.moviments.toString();
	}
	
	public boolean afegirMoviment(int direccio, int i, int j) throws Exception {
		Moviment m = null;
		if (direccio == AMUNT) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i-1,j);
			Posicio pF = new Posicio(i-2,j);
			m = new Moviment(pI,pF,pE);
		}
		else if (direccio == AVALL) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i+1,j);
			Posicio pF = new Posicio(i+2,j);
			m = new Moviment(pI,pF,pE);
		}
		else if (direccio == ESQUERRA) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i,j-1);
			Posicio pF = new Posicio(i,j-2);
			m = new Moviment(pI,pF,pE);
		}
		else { //DRETA
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i,j+1);
			Posicio pF = new Posicio(i,j+2);
			m = new Moviment(pI,pF,pE);
		}
		this.taulell.mouFitxa(m,1);
		if (m == null) throw new Exception("No es pot afegir el moviment.");
		int c = this.moviments.getMag().size();
		//System.out.println((c+1) +". " +  m.toString());
		return this.moviments.afegeixMoviment(m);
	}
	
	public boolean desferMoviment(int direccio, int i, int j) throws Exception {
		Moviment m = null;
		if (direccio == AMUNT) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i-1,j);
			Posicio pF = new Posicio(i-2,j);
			m = new Moviment(pI,pF,pE);
		}
		else if (direccio == AVALL) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i+1,j);
			Posicio pF = new Posicio(i+2,j);
			m = new Moviment(pI,pF,pE);
		}
		else if (direccio == ESQUERRA) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i,j-1);
			Posicio pF = new Posicio(i,j-2);
			m = new Moviment(pI,pF,pE);
		}
		else { //DRETA
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i,j+1);
			Posicio pF = new Posicio(i,j+2);
			m = new Moviment(pI,pF,pE);
		}
		this.taulell.mouFitxa(m,2);
		return this.moviments.desferMoviment(m);
	}
	
	public boolean esSolucio() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (this.taulell.getContingutPos(i, j) != solucio[i][j]) return false;
			}
		}
		return true;
	}
}
