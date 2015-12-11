package Continental;

public class Continental {
	
	public static void main(String[] args) throws Exception {
		Solucio joc = new Solucio();
		//Estat inicial
		System.out.println(joc.toString());
		
		//Busquem la solució
		if (joc.trobaSolucio(1)) System.out.println("Solucionat");
		
		//Estat final
		System.out.println(joc.toString());
		System.out.println();
		System.out.println("Llista de moviments");
		System.out.println(joc.toStringMoviments());
	}
	
	//Atributs
	private Taulell taulell;
	private Magatzem_ruta moviments;
	
	//Tipus de caselles
	public static final int BUIT = 0;
	public static final int PLENA = 1;
	public static final int NULA = -1;
	
	//Tipus de direccions
	public static final int AMUNT = 1, AVALL = 2, ESQUERRA = 3, DRETA = 4;
	public static final int [] direccions = {AMUNT,ESQUERRA,AVALL,DRETA};
	
	//Solució
	//public Solucio solucions;
	public static final int [][] solucio = {
			{-1,-1,0,0,0,-1-1},
			{-1,-1,0,0,0,-1-1},
			  {0,0,0,1,0,0,0},
			  {0,0,0,0,0,0,0},
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
	
	//Getters
	public Taulell getTaulell(){return taulell;}
	
	public int getMida(){return mida;}
	
	public int[] getDireccions(){return direccions;}
	
	public boolean casellaValida(int x, int y) {
		if (this.taulell.getContingutPos(x, y) == PLENA) return true;
		else return false;
	}
	
	
	public String toString() {
		String resultat = "";
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (this.taulell.getContingutPos(i, j) == NULA) resultat += "   ";
				else if (this.taulell.getContingutPos(i, j) != NULA) resultat += " " + this.taulell.getContingutPos(i, j) + " ";
			}
			resultat += "\n";
		}
		return resultat;
	}
	
	public String toStringMoviments() {
		if (this.moviments == null) System.out.println("Error");
		return this.moviments.toString();
	}
	
	public boolean afegirMoviment(Moviment m) throws Exception {
		this.taulell.mouFitxa(m,1);
		if (m == null) throw new Exception("No es pot afegir el moviment.");
		//int c = this.moviments.getMag().size();
		//System.out.println((c+1) +". " +  m.toString());
		return this.moviments.afegeixMoviment(m);
	}
	
	public boolean desferMoviment(Moviment m) throws Exception {
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

	public Moviment possibleMoviment(int i, int j, int direccio) {
		Moviment m = null;
		if (direccio == Continental.AMUNT) {
			if (AMUNT == possibleDireccio(i,j,direccio)) {
				Posicio pI = new Posicio(i,j);
				Posicio pE = new Posicio(i-1,j);
				Posicio pF = new Posicio(i-2,j);
				m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == AVALL) {
			if (AVALL == possibleDireccio(i,j,direccio)) {
			Posicio pI = new Posicio(i,j);
			Posicio pE = new Posicio(i+1,j);
			Posicio pF = new Posicio(i+2,j);
			m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == ESQUERRA) {
			if (ESQUERRA == possibleDireccio(i,j,direccio)) {
				Posicio pI = new Posicio(i,j);
				Posicio pE = new Posicio(i,j-1);
				Posicio pF = new Posicio(i,j-2);
				m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == DRETA){ //DRETA
			if (DRETA == possibleDireccio(i,j,direccio)) {
				Posicio pI = new Posicio(i,j);
				Posicio pE = new Posicio(i,j+1);
				Posicio pF = new Posicio(i,j+2);
				m = new Moviment(pI,pE,pF);
			}
		}
		return m;
	}
	
	public int possibleDireccio(int i, int j, int k) {
		if (i < 0 || i > mida-1 || j < 0 || j > mida-1) return -1;
		
		if (k == AMUNT && taulell.getContingutPos(i-1, j) == PLENA && taulell.getContingutPos(i-2, j) == BUIT) return AMUNT;
		else if (k == AVALL && taulell.getContingutPos(i+1, j) == PLENA && taulell.getContingutPos(i+2, j) == BUIT) return AVALL;
		else if (k == ESQUERRA && taulell.getContingutPos(i, j-1) == PLENA && taulell.getContingutPos(i, j-2) == BUIT) return ESQUERRA;
		else if (k == DRETA && taulell.getContingutPos(i, j+1) == PLENA && taulell.getContingutPos(i, j+2) == BUIT) return DRETA;
		
		return 0;
	}
}
