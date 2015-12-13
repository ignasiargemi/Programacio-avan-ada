package Continental;

public class Continental {
	
	public static void main(String[] args) throws Exception {
		Continental joc = new Continental();
		//Estat inicial
		System.out.println(joc.toString());
		
		//Busquem la solució
		if (joc.busca2Solucions()) System.out.println("Solucionat");
		
		//Estat final
		System.out.println(joc.toString());
		System.out.println();
		System.out.println("Llista de moviments");
		System.out.println(joc.toStringMoviments());
	}
	
	//Tipus de direccions
	public static final int AMUNT = 1, AVALL = 2, ESQUERRA = 3, DRETA = 4;
	public static final int [] direccions = {AMUNT,ESQUERRA,AVALL,DRETA};
	public static final int mida = 7;
	private int contador = 1;

	//Tipus de caselles
	public static final int BUIDA = 0;
	public static final int PLENA = 1;
	public static final int NULA = -1;
	
	private int[][] taulell;
	private Solucio moviments;
	
	public static final int [][] solucio = {
			{-1,-1,0,0,0,-1-1},
			{-1,-1,0,0,0,-1-1},
			  {0,0,0,0,0,0,0},
			  {0,0,0,1,0,0,0},
			  {0,0,0,0,0,0,0},
			{-1,-1,0,0,0,-1-1},
			{-1,-1,0,0,0,-1-1}
	};
	
	
	public Continental() {
		this.taulell = new int[mida][mida];
		this.moviments = new Solucio();
		SetContingutPos();
		
	}
	
	private void SetContingutPos() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (j == 3 && i == 3) this.taulell[i][j] = BUIDA;
				else if ((i < 2 || i > 4) && (j < 2 || j > 4)) this.taulell[i][j] = NULA;
				else this.taulell[i][j] = PLENA;
			}
		}
	}
	
	public String toString() {
		String resultat = "";
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (this.taulell[i][j] == NULA) resultat += "   ";
				else resultat += " " + this.taulell[i][j] + " ";
			}
			resultat += "\n";
		}
		return resultat;
	}
	
	private String toStringMoviments() {
		return moviments.toString();
	}
	
	private boolean busca2Solucions() throws Exception {
		return trobarSolucions(1, 2);
	}
	
	private boolean trobarSolucions(int nivell, int sol_cont) throws Exception {
		if (nivell == 31) {
			if (esSolucio()) {
				if (contador == sol_cont) return true;
				else {
					System.out.println(moviments.toString());
					++contador;
					return false;
				}
			}
		}
		for (int i = 0; i < mida; ++i) { //Files
			for (int j = 0; j < mida; ++j) { //Columnes
				if (casellaValida(i, j)) {
					for(int k =0; k < direccions.length; ++k) { //Direccions
						Moviment m = possibleMoviment(i,j,direccions[k]);
						if (m != null) {
							//Registar moviment
							afegirMoviment(m);
							System.out.println(nivell + " " + m.toString());
							System.out.println(toString());
							//Crida recursiva
							if (trobarSolucions(nivell+1,sol_cont)){
								return true;
							}
							else {
								//desfer moviment i seguir amb la cerca
								System.out.println("Desfaig " + m.toString());
								System.out.println(toString());
								desferMoviment();
							}
						}
					}
				}
			}
		}
		return false;
    }
	
	private void afegirMoviment(Moviment m) throws Exception {
		mouFitxa(m,1);
		moviments.afegirMoviment(m);
	}

	private void desferMoviment() throws Exception {
		Moviment m = moviments.getUltimMoviment();
		System.out.println("ultim "+m.toString());
		mouFitxa(m,2);
		moviments.desferMoviment();
	}

	private Moviment possibleMoviment(int i, int j, int direccio) {
		Moviment m = null;
		if (direccio == Continental.AMUNT) {
			if (AMUNT == possibleDireccio(i,j,direccio)) {
				Coordenada pI = new Coordenada(i,j);
				Coordenada pE = new Coordenada(i-1,j);
				Coordenada pF = new Coordenada(i-2,j);
				m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == AVALL) {
			if (AVALL == possibleDireccio(i,j,direccio)) {
				Coordenada pI = new Coordenada(i,j);
				Coordenada pE = new Coordenada(i+1,j);
				Coordenada pF = new Coordenada(i+2,j);
				m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == ESQUERRA) {
			if (ESQUERRA == possibleDireccio(i,j,direccio)) {
				Coordenada pI = new Coordenada(i,j);
				Coordenada pE = new Coordenada(i,j-1);
				Coordenada pF = new Coordenada(i,j-2);
				m = new Moviment(pI,pE,pF);
			}
		}
		else if (direccio == DRETA){ //DRETA
			if (DRETA == possibleDireccio(i,j,direccio)) {
				Coordenada pI = new Coordenada(i,j);
				Coordenada pE = new Coordenada(i,j+1);
				Coordenada pF = new Coordenada(i,j+2);
				m = new Moviment(pI,pE,pF);
			}
		}
		return m;
	}
	
	private int possibleDireccio(int i, int j, int k) {
		if (i < 0 || i > mida-1 || j < 0 || j > mida-1) return NULA;
		
		if (k == AMUNT && getContingutPos(i-1, j) == PLENA && getContingutPos(i-2, j) == BUIDA) return AMUNT;
		else if (k == AVALL && getContingutPos(i+1, j) == PLENA && getContingutPos(i+2, j) == BUIDA) return AVALL;
		else if (k == ESQUERRA && getContingutPos(i, j-1) == PLENA && getContingutPos(i, j-2) == BUIDA) return ESQUERRA;
		else if (k == DRETA && getContingutPos(i, j+1) == PLENA && getContingutPos(i, j+2) == BUIDA) return DRETA;
		
		return 0;
	}
	
	private int getContingutPos(int i, int j) {
		if (i < 0 || i >= mida || j < 0 || j >= mida) return NULA;
		else return taulell[i][j];
	}

	private boolean casellaValida(int x, int y) {
		if (taulell[x][y] == PLENA) return true;
		else return false;
	}
	
	private boolean esSolucio() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (taulell[i][j] != solucio[i][j]) return false;
			}
		}
		return true;
	}
	
	private void mouFitxa(Moviment m, int accio) throws Exception {
		if (m == null) throw new Exception("No es pot moure cap fitxa");
		if (accio == 1) {//Afegeix moviment
			taulell[m.getPosIncial().getPosX()][m.getPosIncial().getPosY()] = BUIDA;
			taulell[m.getPosEliminada().getPosX()][m.getPosEliminada().getPosY()] = BUIDA;
			taulell[m.getPosFinal().getPosX()][m.getPosFinal().getPosY()] = PLENA;
		}
		else if (accio == 2){//Desfer moviemnt
			taulell[m.getPosIncial().getPosX()][m.getPosIncial().getPosY()] = PLENA;
			taulell[m.getPosEliminada().getPosX()][m.getPosEliminada().getPosY()] = PLENA;
			taulell[m.getPosFinal().getPosX()][m.getPosFinal().getPosY()] = BUIDA;
		}
	}
}
